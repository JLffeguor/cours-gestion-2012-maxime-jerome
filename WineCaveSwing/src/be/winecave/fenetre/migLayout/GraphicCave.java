package be.winecave.fenetre.migLayout;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;


public class GraphicCave extends PanelHelper {
	
	private int max_x = 8;
	private int max_y = 10;
	
	JFrame vinPopup;

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
		TimerBeforeShowPopup timer;
		
		public Rond(int x,int y) {
			this.x = x;
			this.y = y;
			vinPopup = new JFrame("popup");
			vinPopup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			
			
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
					//affiche le vin dans un cadre
					timer = new TimerBeforeShowPopup(1);
					System.out.println("Je suis dans le rond aux coordonnée " + e.getComponent());			
				}
				//sortie de la zone survolée par la souris
				public void mouseExited(MouseEvent e) {
					//ne plus afficher le cadre
					System.out.println("Je sort du rond aux coordonnées " + e.getComponent());
					vinPopup.setVisible(false);
					timer.StopTimer();
				}
			});
		}
		
		//timer pour afficher le popup
		public class TimerBeforeShowPopup {
			Timer timer;

			public TimerBeforeShowPopup(int seconds) {
				timer = new Timer();
				timer.schedule(new ShowPopupNow(), seconds * 1000);
			}

			class ShowPopupNow extends TimerTask {
				public void run() {
					System.out.println("Time's up!");
					showpopup(getScreenPosition());
				}
			}
			
			public void StopTimer() {
				timer.cancel();
			}

		}
		
		public Point getScreenPosition() {
			Point locationOnScreen = this.getLocationOnScreen();
			locationOnScreen.x = locationOnScreen.x + 15;
			locationOnScreen.y = locationOnScreen.y + this.getHeight();
			return locationOnScreen;
			//return this.getLocationOnScreen();
		}
		
		public void showpopup(Point pointLocation) { 
			//TODO ajouter el vin au contenu de le popup
			//TODO afficher un message s'il n'y a pas de vin dans cette place ou ne pas afficher de popup du tout
			vinPopup.setVisible(false);
			JLabel textLabel = new JLabel("info: ceci est un vin"); 
			textLabel.setPreferredSize(new Dimension(50, 100)); 
			vinPopup.getContentPane().add(textLabel, BorderLayout.CENTER);
			vinPopup.setLocation(pointLocation);
			vinPopup.pack();
			vinPopup.revalidate();
			vinPopup.setVisible(true); 
		}

		@Override
		public String toString() {
			return "coordonnée : (" + x + ", " + y + ")";
		}
	}

}
