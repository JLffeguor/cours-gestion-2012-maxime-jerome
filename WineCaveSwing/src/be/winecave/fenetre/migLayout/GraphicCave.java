package be.winecave.fenetre.migLayout;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;


public class GraphicCave extends PanelHelper {
	
	int x;
	int y;
	boolean rondVide = true;
	JLabel[][] rond = new JLabel[10][10] ;

	
	public GraphicCave() {
		super(new MigLayout("","",""));
		System.out.println("bonjour");
	   
		for(x=0; x<10 ; x++){
			for(y=0; y<10 ; y++){
				System.out.println("bonjour"+ x + " " + y);
				rond[x][y] = new JLabel();
				rond[x][y].setIcon(new ImageIcon(GraphicCave.class.getResource("/images/rondVide.png")));
//				rond[x][y].addMouseListener(new MouseAdapter(){
//					//clic de la souris
//					public void mouseClicked(MouseEvent e) {
//						if(rondVide == true) {
//							rond[x][y].setIcon(new ImageIcon(GraphicCave.class.getResource("/images/rondVert.png")));
//							rondVide = false;
//						}
//						else {
//							rond[x][y].setIcon(new ImageIcon(GraphicCave.class.getResource("/images/rondVide.png")));
//							rondVide = true;
//						}
//						System.out.println("je suis " + x + " " + y);
//					}
//				});
				this.add(rond[x][y]);
				rond[x][y].addMouseListener(this);
		   }
		   
	   }

	}
	
	public void actionPerformed (ActionEvent a) {
		 
		if(a.getActionCommand().equals("1"))
		  {
		  //traitement pour le bouton 1
		  }
		 
		}

}
