package be.winecave.fenetre;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class PanneauVin extends JPanel {
	private static final long serialVersionUID = 1L;
	
	Border border2 = LineBorder.createGrayLineBorder();

	boolean rondVide = true;
	private JLabel lblH_A;
	private JLabel lblH_B;
	private JLabel lblH_C;
	private JLabel lblH_D;
	private JLabel lblH_E;
	private JLabel lblH_F;
	private JLabel lblH_G;
	private JLabel lblH_H;
	private JLabel lblH_I;
	private JLabel lblH_J;
	private JLabel lblV_A;
	private JLabel lblV_B;
	private JLabel lblV_C;
	private JLabel lblV_D;
	private JLabel lblV_E;
	private JLabel lblV_F;
	private JLabel lblV_G;
	private JLabel lblV_H;
	private JLabel lblV_I;
	private JLabel lblV_J;
	private JLabel lblAA;
	private JLabel lblAB;
	private JLabel lblAC;
	private JLabel lblAD;
	private JLabel lblAE;
	private JLabel lblAF;
	private JLabel lblAG;
	private JLabel lblAH;
	private JLabel lblAI;
	private JLabel lblAJ;
	private JLabel lblBA;
	private JLabel lblBB;
	private JLabel lblBC;
	private JLabel lblBD;
	private JLabel lblBE;
	private JLabel lblBF;
	private JLabel lblBG;
	private JLabel lblBH;
	private JLabel lblBI;
	private JLabel lblBJ;
	
	
	public PanneauVin() {
		setLayout(null);
		add(getLblH_A());
		add(getLblH_B());
		add(getLblH_C());
		add(getLblH_D());
		add(getLblH_E());
		add(getLblH_F());
		add(getLblH_G());
		add(getLblH_H());
		add(getLblH_I());
		add(getLblH_J());
		add(getLblV_A());
		add(getLblV_B());
		add(getLblV_C());
		add(getLblV_D());
		add(getLblV_E());
		add(getLblV_F());
		add(getLblV_G());
		add(getLblV_H());
		add(getLblV_I());
		add(getLblV_J());
		add(getLblAA());
		add(getLblAB());
		add(getLblAC());
		add(getLblAD());
		add(getLblAE());
		add(getLblAF());
		add(getLblAG());
		add(getLblAH());
		add(getLblAI());
		add(getLblAJ());
		add(getLblBA());
		add(getLblBB());
		add(getLblBC());
		add(getLblBD());
		add(getLblBE());
		add(getLblBF());
		add(getLblBG());
		add(getLblBH());
		add(getLblBI());
		add(getLblBJ());
	}
	
	/******************** A -> J  Honrizontal *********************/
	
	private JLabel getLblH_A() {
		if (lblH_A == null) {
			lblH_A = new JLabel("A");
			lblH_A.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblH_A.setHorizontalAlignment(SwingConstants.CENTER);
			lblH_A.setBounds(45, 20, 23, 23);
		}
		return lblH_A;
	}
	private JLabel getLblH_B() {
		if (lblH_B == null) {
			lblH_B = new JLabel("B");
			lblH_B.setBounds(70, 20, 23, 23);
			lblH_B.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblH_B.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblH_B;
	}
	private JLabel getLblH_C() {
		if (lblH_C == null) {
			lblH_C = new JLabel("C");
			lblH_C.setBounds(95, 20, 23, 23);
			lblH_C.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblH_C.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblH_C;
	}
	private JLabel getLblH_D() {
		if (lblH_D == null) {
			lblH_D = new JLabel("D");
			lblH_D.setBounds(120, 20, 23, 23);
			lblH_D.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblH_D.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblH_D;
	}
	private JLabel getLblH_E() {
		if (lblH_E == null) {
			lblH_E = new JLabel("E");
			lblH_E.setBounds(145, 20, 23, 23);
			lblH_E.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblH_E.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblH_E;
	}
	private JLabel getLblH_F() {
		if (lblH_F == null) {
			lblH_F = new JLabel("F");
			lblH_F.setBounds(170, 20, 23, 23);
			lblH_F.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblH_F.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblH_F;
	}
	private JLabel getLblH_G() {
		if (lblH_G == null) {
			lblH_G = new JLabel("G");
			lblH_G.setBounds(195, 20, 23, 23);
			lblH_G.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblH_G.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblH_G;
	}
	private JLabel getLblH_H() {
		if (lblH_H == null) {
			lblH_H = new JLabel("H");
			lblH_H.setBounds(220, 20, 23, 23);
			lblH_H.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblH_H.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblH_H;
	}
	private JLabel getLblH_I() {
		if (lblH_I == null) {
			lblH_I = new JLabel("I");
			lblH_I.setBounds(245, 20, 23, 23);
			lblH_I.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblH_I.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblH_I;
	}
	private JLabel getLblH_J() {
		if (lblH_J == null) {
			lblH_J = new JLabel("J");
			lblH_J.setBounds(270, 20, 23, 23);
			lblH_J.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblH_J.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblH_J;
	}
	
	
	/******************** A -> J Vertical *********************/
	
	private JLabel getLblV_A() {
		if (lblV_A == null) {
			lblV_A = new JLabel("A");
			lblV_A.setBounds(20, 45, 23, 23);
			lblV_A.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblV_A.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblV_A;
	}
	private JLabel getLblV_B() {
		if (lblV_B == null) {
			lblV_B = new JLabel("B");
			lblV_B.setBounds(20, 70, 23, 23);
			lblV_B.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblV_B.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblV_B;
	}
	private JLabel getLblV_C() {
		if (lblV_C == null) {
			lblV_C = new JLabel("C");
			lblV_C.setBounds(20, 95, 23, 23);
			lblV_C.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblV_C.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblV_C;
	}
	private JLabel getLblV_D() {
		if (lblV_D == null) {
			lblV_D = new JLabel("D");
			lblV_D.setBounds(20, 120, 23, 23);
			lblV_D.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblV_D.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblV_D;
	}
	private JLabel getLblV_E() {
		if (lblV_E == null) {
			lblV_E = new JLabel("E");
			lblV_E.setBounds(20, 145, 23, 23);
			lblV_E.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblV_E.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblV_E;
	}
	private JLabel getLblV_F() {
		if (lblV_F == null) {
			lblV_F = new JLabel("F");
			lblV_F.setBounds(20, 170, 23, 23);
			lblV_F.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblV_F.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblV_F;
	}
	private JLabel getLblV_G() {
		if (lblV_G == null) {
			lblV_G = new JLabel("G");
			lblV_G.setBounds(20, 195, 23, 23);
			lblV_G.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblV_G.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblV_G;
	}
	private JLabel getLblV_H() {
		if (lblV_H == null) {
			lblV_H = new JLabel("H");
			lblV_H.setBounds(20, 220, 23, 23);
			lblV_H.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblV_H.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblV_H;
	}
	private JLabel getLblV_I() {
		if (lblV_I == null) {
			lblV_I = new JLabel("I");
			lblV_I.setBounds(20, 245, 23, 23);
			lblV_I.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblV_I.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblV_I;
	}
	private JLabel getLblV_J() {
		if (lblV_J == null) {
			lblV_J = new JLabel("J");
			lblV_J.setBounds(20, 270, 23, 23);
			lblV_J.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblV_J.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblV_J;
	}
	
	/******************** AA -> AJ *********************/

	private JLabel getLblAA() {
		if (lblAA == null) {
			lblAA = new JLabel("");
			lblAA.setBounds(45, 45, 23, 23);
			lblAA.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
			//Pour avoir le pointeur sous forme de main
			lblAA.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblAA.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					if(rondVide == true) {
						lblAA.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVert.png")));
						rondVide = false;
					}
					else {
						lblAA.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
						rondVide = true;
					}
				}
			});
		}
		return lblAA;
	}
	private JLabel getLblAB() {
		if (lblAB == null) {
			lblAB = new JLabel("");
			lblAB.setBounds(70, 45, 23, 23);
			lblAB.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
			//Pour avoir le pointeur sous forme de main
			lblAB.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblAB.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					if(rondVide == true) {
						lblAB.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVert.png")));
						rondVide = false;
					}
					else {
						lblAB.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
						rondVide = true;
					}
				}
			});
		}
		return lblAB;
	}
	private JLabel getLblAC() {
		if (lblAC == null) {
			lblAC = new JLabel("");
			lblAC.setBounds(95, 45, 23, 23);
			lblAC.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
			//Pour avoir le pointeur sous forme de main
			lblAC.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblAC.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					if(rondVide == true) {
						lblAC.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVert.png")));
						rondVide = false;
					}
					else {
						lblAC.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
						rondVide = true;
					}
				}
			});
		}
		return lblAC;
	}
	private JLabel getLblAD() {
		if (lblAD == null) {
			lblAD = new JLabel("");
			lblAD.setBounds(120, 45, 23, 23);
			lblAD.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
			//Pour avoir le pointeur sous forme de main
			lblAD.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblAD.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					if(rondVide == true) {
						lblAD.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVert.png")));
						rondVide = false;
					}
					else {
						lblAD.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
						rondVide = true;
					}
				}
			});
		}
		return lblAD;
	}
	private JLabel getLblAE() {
		if (lblAE == null) {
			lblAE = new JLabel("");
			lblAE.setBounds(145, 45, 23, 23);
			lblAE.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
			//Pour avoir le pointeur sous forme de main
			lblAE.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblAE.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					if(rondVide == true) {
						lblAE.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVert.png")));
						rondVide = false;
					}
					else {
						lblAE.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
						rondVide = true;
					}
				}
			});
		}
		return lblAE;
	}
	private JLabel getLblAF() {
		if (lblAF == null) {
			lblAF = new JLabel("");
			lblAF.setBounds(170, 45, 23, 23);
			lblAF.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
			//Pour avoir le pointeur sous forme de main
			lblAF.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblAF.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					if(rondVide == true) {
						lblAF.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVert.png")));
						rondVide = false;
					}
					else {
						lblAF.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
						rondVide = true;
					}
				}
			});
		}
		return lblAF;
	}
	private JLabel getLblAG() {
		if (lblAG == null) {
			lblAG = new JLabel("");
			lblAG.setBounds(195, 45, 23, 23);
			lblAG.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
			//Pour avoir le pointeur sous forme de main
			lblAG.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblAG.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					if(rondVide == true) {
						lblAG.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVert.png")));
						rondVide = false;
					}
					else {
						lblAG.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
						rondVide = true;
					}
				}
			});
		}
		return lblAG;
	}
	private JLabel getLblAH() {
		if (lblAH == null) {
			lblAH = new JLabel("");
			lblAH.setBounds(220, 45, 23, 23);
			lblAH.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
			//Pour avoir le pointeur sous forme de main
			lblAH.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblAH.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					if(rondVide == true) {
						lblAH.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVert.png")));
						rondVide = false;
					}
					else {
						lblAH.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
						rondVide = true;
					}
				}
			});
		}
		return lblAH;
	}
	private JLabel getLblAI() {
		if (lblAI == null) {
			lblAI = new JLabel("");
			lblAI.setBounds(245, 45, 23, 23);
			lblAI.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
			//Pour avoir le pointeur sous forme de main
			lblAI.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblAI.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					if(rondVide == true) {
						lblAI.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVert.png")));
						rondVide = false;
					}
					else {
						lblAI.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
						rondVide = true;
					}
				}
			});
		}
		return lblAI;
	}
	private JLabel getLblAJ() {
		if (lblAJ == null) {
			lblAJ = new JLabel("");
			lblAJ.setBounds(270, 45, 23, 23);
			lblAJ.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
			//Pour avoir le pointeur sous forme de main
			lblAJ.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblAJ.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					if(rondVide == true) {
						lblAJ.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVert.png")));
						rondVide = false;
					}
					else {
						lblAJ.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
						rondVide = true;
					}
				}
			});
		}
		return lblAJ;
	}
	
	/******************** BA -> BJ *********************/
	
	private JLabel getLblBA() {
		if (lblBA == null) {
			lblBA = new JLabel("");
			lblBA.setBounds(45, 70, 23, 23);
			lblBA.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
			//Pour avoir le pointeur sous forme de main
			lblBA.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblBA.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					if(rondVide == true) {
						lblBA.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVert.png")));
						rondVide = false;
					}
					else {
						lblBA.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
						rondVide = true;
					}
				}
			});
		}
		return lblBA;
	}
	private JLabel getLblBB() {
		if (lblBB == null) {
			lblBB = new JLabel("");
			lblBB.setBounds(70, 70, 23, 23);
			lblBB.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
			//Pour avoir le pointeur sous forme de main
			lblBB.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblBB.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					if(rondVide == true) {
						lblBB.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVert.png")));
						rondVide = false;
					}
					else {
						lblBB.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
						rondVide = true;
					}
				}
			});
		}
		return lblBB;
	}
	private JLabel getLblBC() {
		if (lblBC == null) {
			lblBC = new JLabel("");
			lblBC.setBounds(95, 70, 23, 23);
			lblBC.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
			//Pour avoir le pointeur sous forme de main
			lblBC.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblBC.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					if(rondVide == true) {
						lblBC.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVert.png")));
						rondVide = false;
					}
					else {
						lblBC.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
						rondVide = true;
					}
				}
			});
		}
		return lblBC;
	}
	private JLabel getLblBD() {
		if (lblBD == null) {
			lblBD = new JLabel("");
			lblBD.setBounds(120, 70, 23, 23);
			lblBD.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
			//Pour avoir le pointeur sous forme de main
			lblBD.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblBD.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					if(rondVide == true) {
						lblBD.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVert.png")));
						rondVide = false;
					}
					else {
						lblBD.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
						rondVide = true;
					}
				}
			});
		}
		return lblBD;
	}
	private JLabel getLblBE() {
		if (lblBE == null) {
			lblBE = new JLabel("");
			lblBE.setBounds(145, 70, 23, 23);
			lblBE.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
			//Pour avoir le pointeur sous forme de main
			lblBE.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblBE.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					if(rondVide == true) {
						lblBE.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVert.png")));
						rondVide = false;
					}
					else {
						lblBE.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
						rondVide = true;
					}
				}
			});
		}
		return lblBE;
	}
	private JLabel getLblBF() {
		if (lblBF == null) {
			lblBF = new JLabel("");
			lblBF.setBounds(170, 70, 23, 23);
			lblBF.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
			//Pour avoir le pointeur sous forme de main
			lblBF.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblBF.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					if(rondVide == true) {
						lblBF.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVert.png")));
						rondVide = false;
					}
					else {
						lblBF.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
						rondVide = true;
					}
				}
			});
		}
		return lblBF;
	}
	private JLabel getLblBG() {
		if (lblBG == null) {
			lblBG = new JLabel("");
			lblBG.setBounds(195, 70, 23, 23);
			lblBG.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
			//Pour avoir le pointeur sous forme de main
			lblBG.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblBG.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					if(rondVide == true) {
						lblBG.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVert.png")));
						rondVide = false;
					}
					else {
						lblBG.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
						rondVide = true;
					}
				}
			});
		}
		return lblBG;
	}
	private JLabel getLblBH() {
		if (lblBH == null) {
			lblBH = new JLabel("");
			lblBH.setBounds(220, 70, 23, 23);
			lblBH.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
			//Pour avoir le pointeur sous forme de main
			lblBH.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblBH.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					if(rondVide == true) {
						lblBH.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVert.png")));
						rondVide = false;
					}
					else {
						lblBH.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
						rondVide = true;
					}
				}
			});
		}
		return lblBH;
	}
	private JLabel getLblBI() {
		if (lblBI == null) {
			lblBI = new JLabel("");
			lblBI.setBounds(245, 70, 23, 23);
			lblBI.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
			//Pour avoir le pointeur sous forme de main
			lblBI.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblBI.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					if(rondVide == true) {
						lblBI.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVert.png")));
						rondVide = false;
					}
					else {
						lblBI.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
						rondVide = true;
					}
				}
			});
		}
		return lblBI;
	}
	private JLabel getLblBJ() {
		if (lblBJ == null) {
			lblBJ = new JLabel("");
			lblBJ.setBounds(270, 70, 23, 23);
			lblBJ.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
			//Pour avoir le pointeur sous forme de main
			lblBJ.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblBJ.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					if(rondVide == true) {
						lblBJ.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVert.png")));
						rondVide = false;
					}
					else {
						lblBJ.setIcon(new ImageIcon(PanneauVin.class.getResource("/images/rondVide.png")));
						rondVide = true;
					}
				}
			});
		}
		return lblBJ;
	}
}
