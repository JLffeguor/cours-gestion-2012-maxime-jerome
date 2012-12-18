package be.winecave.fenetre;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	Border border = LineBorder.createBlackLineBorder();
	Border border2 = LineBorder.createGrayLineBorder();
	
	private JPanel contentPane;
	private JPanel mainPanel;
	private JLabel lblInformations;
	private JLabel lblEmplacements;
	private JLabel lblAchatsconso;
	private JLabel lblDegustation;
	private JLabel lblIllustration;
	private JLabel lblBandeau;
	private JButton btnAnnuler;
	private JButton btnEnregistrer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Nouveau Vin (*)");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/vin.jpg")));
		contentPane.add(getLblBandeau());
		contentPane.add(getLblInformations());
		contentPane.add(getLblEmplacements());
		contentPane.add(getLblAchatsconso());
		contentPane.add(getLblDegustation());
		contentPane.add(getLblIllustration());
		contentPane.add(getBtnAnnuler());
		contentPane.add(getBtnEnregistrer());
		contentPane.add(getMainPanel());
	}
	
	//************* Bandeau gris ******************//
	
	private JLabel getLblBandeau() {
		if (lblBandeau == null) {
			lblBandeau = new JLabel("");
			lblBandeau.setOpaque(true);
			lblBandeau.setBackground(Color.GRAY);
			lblBandeau.setBounds(0, 0, 494, 32);
		}
		return lblBandeau;
	}


	
	//************* Label Cliquable ******************//
	
	private JLabel getLblInformations() {
		if (lblInformations == null) {
			lblInformations = new JLabel("Informations");
			lblInformations.setHorizontalAlignment(SwingConstants.CENTER);
			lblInformations.setBorder(border);
			lblInformations.setOpaque(true);
			lblInformations.setBackground(Color.ORANGE);
			lblInformations.setBounds(10, 43, 95, 24);
			//Pour avoir le pointeur sous forme de main
			lblInformations.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblInformations.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					lblInformations.setBackground(Color.ORANGE);
					lblEmplacements.setBackground(Color.CYAN);
					lblAchatsconso.setBackground(Color.CYAN);
					lblDegustation.setBackground(Color.CYAN);
					lblIllustration.setBackground(Color.CYAN);
					lblInformations.setBorder(border);
					lblEmplacements.setBorder(border2);
					lblAchatsconso.setBorder(border2);
					lblDegustation.setBorder(border2);
					lblIllustration.setBorder(border2);
					contentPane.remove(mainPanel);
					mainPanel = new EditWine();
					contentPane.add(mainPanel);
					repaint();
				}
			});
		}
		return lblInformations;
	}
	private JLabel getLblEmplacements() {
		if (lblEmplacements == null) {
			lblEmplacements = new JLabel("Emplacements");
			lblEmplacements.setHorizontalAlignment(SwingConstants.CENTER);
			lblEmplacements.setBorder(border2);
			lblEmplacements.setOpaque(true);
			lblEmplacements.setBackground(Color.CYAN);
			lblEmplacements.setBounds(105, 43, 95, 24);
			//Pour avoir le pointeur sous forme de main
			lblEmplacements.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblEmplacements.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					lblInformations.setBackground(Color.CYAN);
					lblEmplacements.setBackground(Color.ORANGE);
					lblAchatsconso.setBackground(Color.CYAN);
					lblDegustation.setBackground(Color.CYAN);
					lblIllustration.setBackground(Color.CYAN);
					lblInformations.setBorder(border2);
					lblEmplacements.setBorder(border);
					lblAchatsconso.setBorder(border2);
					lblDegustation.setBorder(border2);
					lblIllustration.setBorder(border2);
					contentPane.remove(mainPanel);
					mainPanel = new Emplacements();
					contentPane.add(mainPanel);
					repaint();
				}
			});
		}
		return lblEmplacements;
	}
	
	private JLabel getLblAchatsconso() {
		if (lblAchatsconso == null) {
			lblAchatsconso = new JLabel("Achats-Conso");
			lblAchatsconso.setHorizontalAlignment(SwingConstants.CENTER);
			lblAchatsconso.setBorder(border2);
			lblAchatsconso.setOpaque(true);
			lblAchatsconso.setBackground(Color.CYAN);
			lblAchatsconso.setBounds(200, 43, 95, 24);
			//Pour avoir le pointeur sous forme de main
			lblAchatsconso.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblAchatsconso.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					lblInformations.setBackground(Color.CYAN);
					lblEmplacements.setBackground(Color.CYAN);
					lblAchatsconso.setBackground(Color.ORANGE);
					lblDegustation.setBackground(Color.CYAN);
					lblIllustration.setBackground(Color.CYAN);
					lblInformations.setBorder(border2);
					lblEmplacements.setBorder(border2);
					lblAchatsconso.setBorder(border);
					lblDegustation.setBorder(border2);
					lblIllustration.setBorder(border2);
				}
			});
		}
		return lblAchatsconso;
	}
	private JLabel getLblDegustation() {
		if (lblDegustation == null) {
			lblDegustation = new JLabel("D\u00E9gustation");
			lblDegustation.setHorizontalAlignment(SwingConstants.CENTER);
			lblDegustation.setBorder(border2);
			lblDegustation.setOpaque(true);
			lblDegustation.setBackground(Color.CYAN);
			lblDegustation.setBounds(295, 43, 95, 24);
			//Pour avoir le pointeur sous forme de main
			lblDegustation.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblDegustation.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					lblInformations.setBackground(Color.CYAN);
					lblEmplacements.setBackground(Color.CYAN);
					lblAchatsconso.setBackground(Color.CYAN);
					lblDegustation.setBackground(Color.ORANGE);
					lblIllustration.setBackground(Color.CYAN);
					lblInformations.setBorder(border2);
					lblEmplacements.setBorder(border2);
					lblAchatsconso.setBorder(border2);
					lblDegustation.setBorder(border);
					lblIllustration.setBorder(border2);
				}
			});
		}
		return lblDegustation;
	}
	private JLabel getLblIllustration() {
		if (lblIllustration == null) {
			lblIllustration = new JLabel("Illustration");
			lblIllustration.setHorizontalAlignment(SwingConstants.CENTER);
			lblIllustration.setBorder(border2);
			lblIllustration.setOpaque(true);
			lblIllustration.setBackground(Color.CYAN);
			lblIllustration.setBounds(390, 43, 95, 24);
			//Pour avoir le pointeur sous forme de main
			lblIllustration.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblIllustration.addMouseListener(new MouseAdapter(){
				//clic de la souris
				public void mouseClicked(MouseEvent e) {
					lblInformations.setBackground(Color.CYAN);
					lblEmplacements.setBackground(Color.CYAN);
					lblAchatsconso.setBackground(Color.CYAN);
					lblDegustation.setBackground(Color.CYAN);
					lblIllustration.setBackground(Color.ORANGE);
					lblInformations.setBorder(border2);
					lblEmplacements.setBorder(border2);
					lblAchatsconso.setBorder(border2);
					lblDegustation.setBorder(border2);
					lblIllustration.setBorder(border);
				}
			});
		}
		return lblIllustration;
	}
	
	//************* Boutons ******************//
	
	private JButton getBtnAnnuler() {
		if (btnAnnuler == null) {
			btnAnnuler = new JButton("Annuler");
			btnAnnuler.setBounds(275, 633, 100, 23);
		}
		return btnAnnuler;
	}
	private JButton getBtnEnregistrer() {
		if (btnEnregistrer == null) {
			btnEnregistrer = new JButton("Enregistrer");
			btnEnregistrer.setBounds(125, 633, 100, 23);
		}
		return btnEnregistrer;
	}
	
	
	private JPanel getMainPanel() {
		if (mainPanel == null) {
			mainPanel = new EditWine();
		}
		return mainPanel;
	}
	
}

