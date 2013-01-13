package be.winecave.fenetre.migLayout;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;


public class GraphicCave extends PanelHelper {
	
	private int max_x = 8;
	private int max_y = 10;
	

	boolean rondVide = true;
	Rond[][] rond = new Rond[max_x+1][max_y+1] ;

	
	public GraphicCave() {
		super(new MigLayout("","",""));
	   
		for(int y=max_y; y != 0 ; y--){//pour avoir les coordonnées comme un graphe mathematique : (0,0) en bas à gauche
			for(int x=0; x != max_x+1 ; x++){// "!=" plutot que "<" car cela est plus rapide en javascript , j'espère que c'est la même chsoe en java ^^//TODO tester la véracité de ceci
				rond[x][y] = new Rond(x, y);
				this.add(rond[x][y],x==max_x?"wrap":"");//on revient à al ligne lorsque l'on arrive au amx de l'abscisse
		   }
		   
	   }
	}
	
	class Rond extends JLabel{
		int x;
		int y;
		boolean b = false;//pour vérifier si le rond est plein ou vide
		
		public Rond(int x,int y) {
			this.x = x;
			this.y = y;
			this.setIcon(new ImageIcon(GraphicCave.class.getResource("/images/rondVide.png")));
			this.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					System.out.println(e.getComponent());
					if(b == false){//si rond vide
						setIcon(new ImageIcon(GraphicCave.class.getResource("/images/rondVert.png")));//on le remplit
						b = true;
					}
					else{//sinon il est plein, donc...
						setIcon(new ImageIcon(GraphicCave.class.getResource("/images/rondVide.png")));//...on le vide
						b = false;
					}
				}
				//survol de la souris
				public void mouseEntered(MouseEvent e) {
					//afficher le vin dans un cadre
					System.out.println("Je suis dans le rond aux coordonnée " + e.getComponent());
				}
				//sortie de la zone survolée par la souris
				public void mouseExited(MouseEvent e) {
					//ne plus afficher le cadre
					System.out.println("Je sort du rond aux coordonnées " + e.getComponent());
				}
			});
		}
		
		@Override
		public String toString() {
			return "coordonnée : (" + x + ", " + y + ")";
		}
	}

}
