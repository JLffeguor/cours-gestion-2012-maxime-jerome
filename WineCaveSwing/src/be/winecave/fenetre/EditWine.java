package be.winecave.fenetre;

import java.awt.Color;
import java.text.ParseException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import be.winecave.model.PaysViticole;

public class EditWine extends JPanel {
	private static final long serialVersionUID = 1L;
	
	Border border = LineBorder.createBlackLineBorder();
	Border border2 = LineBorder.createGrayLineBorder();
	
	String[] producteur = {" (vide)", "Alain Peytel", "Altos", "Andre Chalandon", "etc..."};
	
	List<PaysViticole> pays = MainWindow.getConnector().getPaysViticoleRepository().findAll();
	
	String[] region = {" (vide)", "Alsace", "Autres", "Barolo", "Barossa", "Barossa Valley", "Beaujolais", "Bordeaux", "Bordeaux (Médoc)", "Bourgogne",
			"California", "Castilla Y Leon", "Champagne", "Corse", "Jura/Savoie", "Languedoc-Roussillon", "Murcie", "Provence", "Rhône", "Sud-Ouest",
			"Vallée de la Loire", "Vénétie"};
	
	String[] appellation = {" (vide)", "etc..."};
	
	String[] cepage = {" (vide)", "etc..."};
	
	String[] cuvee = {" (vide)", "etc..."};
	
	String[] categorie = {" (vide)", "etc..."};
	
	String[] couleur = {"Rouge", "Blanc", "Rosé", "Champagne", "Liquoreux", "Autre"};
	
	String[] classement = {" (vide)", "etc..."};
	
	String[] bouteille = {" (vide)", "etc..."};
	
	private JTextField txtReference;
	private JTextField txtNomVin;
	private JComboBox<?> comboBoxProducteur;
	private JLabel lblMillesime;
	private JLabel lblReference;
	private JLabel lblNom;
	private JLabel lblProducteur;
	private JSeparator separator;
	private JLabel lblAutresInformations;
	private JComboBox<?> comboBoxPays;
	private JLabel lblPays;
	private JComboBox<?> comboBoxRegion;
	private JLabel lblRegion;
	private JComboBox<?> comboBoxAppellation;
	private JLabel lblAppellation;
	private JComboBox<?> comboBoxCepage;
	private JLabel lblCepage;
	private JLabel lblCuvee;
	private JSeparator separator_1;
	private JLabel lblClassification;
	private JComboBox<?> comboBoxCategorie;
	private JComboBox<?> comboBoxCouleur;
	private JComboBox<?> comboBoxClassement;
	private JComboBox<?> comboBoxBouteille;
	private JLabel lblCategorie;
	private JLabel lblCouleur;
	private JLabel lblClassement;
	private JLabel lblBouteille;
	private JSeparator separator_2;
	private JLabel lblconservation;
	private JTextField txtCuvee;
	private JFormattedTextField fTxtBoireDe;
	private JFormattedTextField fTxtBoireA;
	private JFormattedTextField fTxtApogeeDe;
	private JFormattedTextField fTxtApogeeA;
	private JLabel lblBoireDe;
	private JLabel lblBoireA;
	private JLabel lblApogeeDe;
	private JLabel lblApogeeA;
	private JFormattedTextField fTxtMillesime;
	private JFormattedTextField fTxtPrixAchat;
	private JFormattedTextField fTxtEstimation;
	private JFormattedTextField fTxtDegre;
	private JFormattedTextField fTxtTempDe;
	private JFormattedTextField fTxtTempA;
	private JLabel lblPrixDachat;
	private JLabel lblEstimation;
	private JLabel lblDegre;
	private JLabel lblTempDe;
	private JLabel lblTempA;
	private JTextArea txtAreaCommentaire;
	private JLabel lblCommentaire;

	/**
	 * Create the panel.
	 */
	public EditWine() {
		setLayout(null);
		setBounds(5, 55, 484, 567);
		setBorder(border2);
		add(getTxtReference());
		add(getFTxtMillesime());
		add(getTxtNomVin());
		add(getTxtCuvee());
		add(getFTxtBoireDe());
		add(getFTxtBoireA());
		add(getFTxtApogeeDe());
		add(getFTxtApogeeA());
		add(getFTxtPrixAchat());
		add(getFTxtEstimation());
		add(getFTxtDegre());
		add(getFTxtTempDe());
		add(getFTxtTempA());
		add(getTxtAreaCommentaire());
		add(getComboBoxProducteur());
		add(getComboBoxPays());
		add(getComboBoxRegion());
		add(getComboBoxAppellation());
		add(getComboBoxCepage());
		add(getComboBoxCategorie());
		add(getComboBoxCouleur());
		add(getComboBoxClassement());
		add(getComboBoxBouteille());
		add(getLblMillesime());
		add(getLblReference());
		add(getLblNom());
		add(getLblProducteur());
		add(getSeparator());
		add(getLblAutresInformations());
		add(getLblPays());
		add(getLblRegion());
		add(getLblAppellation());
		add(getLblCepage());
		add(getLblCuvee());
		add(getSeparator_1());
		add(getLblClassification());
		add(getLblCategorie());
		add(getLblCouleur());
		add(getLblClassement());
		add(getLblBouteille());
		add(getSeparator_2());
		add(getLblconservation());
		add(getLblBoireDe());
		add(getLblBoireA());
		add(getLblApogeeDe());
		add(getLblApogeeA());
		add(getLblPrixDachat());
		add(getLblEstimation());
		add(getLblDegre());
		add(getLblTempDe());
		add(getLblTempA());
		add(getLblCommentaire());
	}
	
	//************* TextField ******************//
	
	/**
	 * TextField Référence
	 */
	public JTextField getTxtReference() {
		if (txtReference == null) {
			txtReference = new JTextField();
			txtReference.setBounds(100, 57, 120, 20);
			txtReference.setColumns(10);
		}
		return txtReference;
	}
	/**
	 * FormattedTextField Millésime
	 */
	public JFormattedTextField getFTxtMillesime() {
		if (fTxtMillesime == null) {
			try {
				MaskFormatter mask = new MaskFormatter("####");
				fTxtMillesime = new JFormattedTextField(mask);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fTxtMillesime.setBounds(309, 57, 40, 20);
		}
		return fTxtMillesime;
	}
	/**
	 * TextField Nom
	 */
	public JTextField getTxtNomVin() {
		if (txtNomVin == null) {
			txtNomVin = new JTextField();
			txtNomVin.setBounds(100, 88, 338, 20);
			txtNomVin.setColumns(10);
		}
		return txtNomVin;
	}
	/**
	 * TextField Cuvée
	 */
	public JTextField getTxtCuvee() {
		if (txtCuvee == null) {
			txtCuvee = new JTextField();
			txtCuvee.setBounds(300, 247, 139, 20);
			txtCuvee.setColumns(10);
		}
		return txtCuvee;
	}
	/**
	 * FormattedTextField Boire de 
	 */
	public JFormattedTextField getFTxtBoireDe() {
		if (fTxtBoireDe == null) {
			try {
				MaskFormatter mask = new MaskFormatter("####");
				fTxtBoireDe = new JFormattedTextField(mask);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fTxtBoireDe.setBounds(100, 417, 40, 20);
		}
		return fTxtBoireDe;
	}
	/**
	 * FormattedTextField Boire à 
	 */
	public JFormattedTextField getFTxtBoireA() {
		if (fTxtBoireA == null) {
			try {
				MaskFormatter mask = new MaskFormatter("####");
				fTxtBoireA = new JFormattedTextField(mask);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fTxtBoireA.setBounds(190, 417, 40, 20);
		}
		return fTxtBoireA;
	}
	/**
	 * FormattedTextField Apogée de 
	 */
	public JFormattedTextField getFTxtApogeeDe() {
		if (fTxtApogeeDe == null) {
			try {
				MaskFormatter mask = new MaskFormatter("####");
				fTxtApogeeDe = new JFormattedTextField(mask);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fTxtApogeeDe.setBounds(309, 417, 40, 20);
		}
		return fTxtApogeeDe;
	}
	/**
	 * FormattedTextField Apogée à 
	 */
	public JFormattedTextField getFTxtApogeeA() {
		if (fTxtApogeeA == null) {
			try {
				MaskFormatter mask = new MaskFormatter("####");
				fTxtApogeeA = new JFormattedTextField(mask);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fTxtApogeeA.setBounds(390, 417, 40, 20);
		}
		return fTxtApogeeA;
	}
	/**
	 * FormattedTextField Prixd'achat
	 */
	public JFormattedTextField getFTxtPrixAchat() {
		if (fTxtPrixAchat == null) {
			try {
				MaskFormatter mask = new MaskFormatter("*******");
				mask.setValidCharacters("1234567890,.");
				fTxtPrixAchat = new JFormattedTextField(mask);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fTxtPrixAchat.setBounds(100, 448, 50, 20);
		}
		return fTxtPrixAchat;
	}
	/**
	 * FormattedTextField Estimation
	 */
	public JFormattedTextField getFTxtEstimation() {
		if (fTxtEstimation == null) {
			try {
				MaskFormatter mask = new MaskFormatter("*******");
				mask.setValidCharacters("1234567890.");
				fTxtEstimation = new JFormattedTextField(mask);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fTxtEstimation.setBounds(214, 448, 50, 20);
		}
		return fTxtEstimation;
	}
	/**
	 * FormattedTextField Degré
	 */
	public JFormattedTextField getFTxtDegre() {
		if (fTxtDegre == null) {
			try {
				MaskFormatter mask = new MaskFormatter("****");
				mask.setValidCharacters("1234567890.");
				fTxtDegre = new JFormattedTextField(mask);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fTxtDegre.setBounds(309, 448, 40, 20);
		}
		return fTxtDegre;
	}
	/**
	 * FormattedTextField Température de
	 */
	public JFormattedTextField getFTxtTempDe() {
		if (fTxtTempDe == null) {
			try {
				MaskFormatter mask = new MaskFormatter("##");
				fTxtTempDe = new JFormattedTextField(mask);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fTxtTempDe.setBounds(378, 448, 25, 20);
		}
		return fTxtTempDe;
	}
	/**
	 * FormattedTextField Température de
	 */
	public JFormattedTextField getFTxtTempA() {
		if (fTxtTempA == null) {
			try {
				MaskFormatter mask = new MaskFormatter("##");
				fTxtTempA = new JFormattedTextField(mask);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fTxtTempA.setBounds(426, 448, 25, 20);
		}
		return fTxtTempA;
	}
	/**
	 * TextArea Commentaire
	 */
	public JTextArea getTxtAreaCommentaire() {
		if (txtAreaCommentaire == null) {
			txtAreaCommentaire = new JTextArea();
			txtAreaCommentaire.setBorder(border2);
			txtAreaCommentaire.setLineWrap(true);
			txtAreaCommentaire.setWrapStyleWord(true);
			txtAreaCommentaire.setBounds(105, 479, 346, 38);
		}
		return txtAreaCommentaire;
	}
	
	//************* ComboBox ******************//
	
	/**
	 * ComboBox Producteur
	 */
	public JComboBox<?> getComboBoxProducteur() {
		if (comboBoxProducteur == null) {
			comboBoxProducteur = new JComboBox<Object>(producteur);
			comboBoxProducteur.setEditable(true);
			comboBoxProducteur.setBounds(100, 119, 338, 20);
			AutoCompleteDecorator.decorate(comboBoxProducteur);
		}
		return comboBoxProducteur;
	}
	/**
	 * ComboBox Pays
	 */
	public JComboBox<?> getComboBoxPays() {
		if (comboBoxPays == null) {
			pays.add(0 ,new PaysViticole(" (vide) "));
			comboBoxPays = new JComboBox<Object>(pays.toArray());
			comboBoxPays.setEditable(true);
			comboBoxPays.setBounds(100, 185, 130, 20);
			AutoCompleteDecorator.decorate(comboBoxPays);
		}
		return comboBoxPays;
	}
	/**
	 * ComboBox Région
	 */
	public JComboBox<?> getComboBoxRegion() {
		if (comboBoxRegion == null) {
			comboBoxRegion = new JComboBox<Object>(region);
			comboBoxRegion.setEditable(true);
			comboBoxRegion.setBounds(300, 185, 139, 20);
			AutoCompleteDecorator.decorate(comboBoxRegion);
		}
		return comboBoxRegion;
	}
	/**
	 * ComboBox Appellation
	 */
	public JComboBox<?> getComboBoxAppellation() {
		if (comboBoxAppellation == null) {
			comboBoxAppellation = new JComboBox<Object>(appellation);
			comboBoxAppellation.setEditable(true);
			comboBoxAppellation.setBounds(100, 216, 338, 20);
			AutoCompleteDecorator.decorate(comboBoxAppellation);
		}
		return comboBoxAppellation;
	}
	/**
	 * ComboBox Cépage
	 */
	public JComboBox<?> getComboBoxCepage() {
		if (comboBoxCepage == null) {
			comboBoxCepage = new JComboBox<Object>(cepage);
			comboBoxCepage.setEditable(true);
			comboBoxCepage.setBounds(100, 247, 130, 20);
			AutoCompleteDecorator.decorate(comboBoxCepage);
		}
		return comboBoxCepage;
	}
	/**
	 * ComboBox Catégorie
	 */
	public JComboBox<?> getComboBoxCategorie() {
		if (comboBoxCategorie == null) {
			comboBoxCategorie = new JComboBox<Object>(categorie);
			comboBoxCategorie.setEditable(true);
			comboBoxCategorie.setBounds(100, 315, 130, 20);
			AutoCompleteDecorator.decorate(comboBoxCategorie);
		}
		return comboBoxCategorie;
	}
	/**
	 * ComboBox Couleur
	 */
	public JComboBox<?> getComboBoxCouleur() {
		if (comboBoxCouleur == null) {
			comboBoxCouleur = new JComboBox<Object>(couleur);
			comboBoxCouleur.setEditable(false);
			comboBoxCouleur.setBounds(300, 315, 130, 20);
			AutoCompleteDecorator.decorate(comboBoxCouleur);
		}
		return comboBoxCouleur;
	}
	/**
	 * ComboBox Classement
	 */
	public JComboBox<?> getComboBoxClassement() {
		if (comboBoxClassement == null) {
			comboBoxClassement = new JComboBox<Object>(classement);
			comboBoxClassement.setEditable(true);
			comboBoxClassement.setBounds(100, 345, 130, 20);
			AutoCompleteDecorator.decorate(comboBoxClassement);
		}
		return comboBoxClassement;
	}
	/**
	 * ComboBox Bouteille
	 */
	public JComboBox<?> getComboBoxBouteille() {
		if (comboBoxBouteille == null) {
			comboBoxBouteille = new JComboBox<Object>(bouteille);
			comboBoxBouteille.setEditable(true);
			comboBoxBouteille.setBounds(300, 345, 130, 20);
			AutoCompleteDecorator.decorate(comboBoxBouteille);
		}
		return comboBoxBouteille;
	}
	
	
	//************* Label ******************//
	
	/**
	 * Label Millésime
	 */
	private JLabel getLblMillesime() {
		if (lblMillesime == null) {
			lblMillesime = new JLabel("Mill\u00E9sime");
			lblMillesime.setBounds(250, 60, 56, 14);
		}
		return lblMillesime;
	}
	/**
	 * Label Référence
	 */
	private JLabel getLblReference() {
		if (lblReference == null) {
			lblReference = new JLabel("R\u00E9f\u00E9rence");
			lblReference.setBounds(25, 60, 66, 14);
		}
		return lblReference;
	}
	/**
	 * Label Nom
	 */
	private JLabel getLblNom() {
		if (lblNom == null) {
			lblNom = new JLabel("Nom");
			lblNom.setBounds(25, 91, 66, 14);
		}
		return lblNom;
	}
	/**
	 * Label Producteur
	 */
	private JLabel getLblProducteur() {
		if (lblProducteur == null) {
			lblProducteur = new JLabel("Producteur");
			lblProducteur.setBounds(25, 122, 66, 14);
		}
		return lblProducteur;
	}
	/**
	 * Label Pays
	 */
	private JLabel getLblPays() {
		if (lblPays == null) {
			lblPays = new JLabel("Pays");
			lblPays.setBounds(25, 188, 46, 14);
		}
		return lblPays;
	}
	/**
	 * Label Région
	 */
	private JLabel getLblRegion() {
		if (lblRegion == null) {
			lblRegion = new JLabel("R\u00E9gion");
			lblRegion.setBounds(245, 188, 46, 14);
		}
		return lblRegion;
	}
	/**
	 * Label Appellation
	 */
	private JLabel getLblAppellation() {
		if (lblAppellation == null) {
			lblAppellation = new JLabel("Appellation");
			lblAppellation.setBounds(25, 219, 66, 14);
		}
		return lblAppellation;
	}
	/**
	 * Label Cépage
	 */
	private JLabel getLblCepage() {
		if (lblCepage == null) {
			lblCepage = new JLabel("C\u00E9page");
			lblCepage.setBounds(25, 250, 46, 14);
		}
		return lblCepage;
	}
	/**
	 * Label Cuvée
	 */
	private JLabel getLblCuvee() {
		if (lblCuvee == null) {
			lblCuvee = new JLabel("Cuv\u00E9e");
			lblCuvee.setBounds(245, 250, 46, 14);
		}
		return lblCuvee;
	}
	/**
	 * Label Catégorie
	 */
	private JLabel getLblCategorie() {
		if (lblCategorie == null) {
			lblCategorie = new JLabel("Cat\u00E9gorie");
			lblCategorie.setBounds(25, 318, 66, 14);
		}
		return lblCategorie;
	}
	/**
	 * Label Couleur
	 */
	private JLabel getLblCouleur() {
		if (lblCouleur == null) {
			lblCouleur = new JLabel("Couleur");
			lblCouleur.setBounds(245, 318, 52, 14);
		}
		return lblCouleur;
	}
	/**
	 * Label Classement
	 */
	private JLabel getLblClassement() {
		if (lblClassement == null) {
			lblClassement = new JLabel("Classement");
			lblClassement.setBounds(25, 348, 79, 14);
		}
		return lblClassement;
	}
	/**
	 * Label Bouteille
	 */
	private JLabel getLblBouteille() {
		if (lblBouteille == null) {
			lblBouteille = new JLabel("Bouteille");
			lblBouteille.setBounds(245, 348, 56, 14);
		}
		return lblBouteille;
	}
	/**
	 * Label Boire de
	 */
	private JLabel getLblBoireDe() {
		if (lblBoireDe == null) {
			lblBoireDe = new JLabel("Boire de");
			lblBoireDe.setBounds(25, 420, 66, 14);
		}
		return lblBoireDe;
	}
	/**
	 * Label Boire à
	 */
	private JLabel getLblBoireA() {
		if (lblBoireA == null) {
			lblBoireA = new JLabel("à");
			lblBoireA.setBounds(164, 420, 16, 14);
		}
		return lblBoireA;
	}
	/**
	 * Label Apogée de
	 */
	private JLabel getLblApogeeDe() {
		if (lblApogeeDe == null) {
			lblApogeeDe = new JLabel("Apogée de");
			lblApogeeDe.setBounds(240, 420, 66, 14);
		}
		return lblApogeeDe;
	}
	/**
	 * Label Apogée à
	 */
	private JLabel getLblApogeeA() {
		if (lblApogeeA == null) {
			lblApogeeA = new JLabel("à");
			lblApogeeA.setBounds(368, 420, 22, 14);
		}
		return lblApogeeA;
	}
	/**
	 * Label Prix d'achat
	 */
	private JLabel getLblPrixDachat() {
		if (lblPrixDachat == null) {
			lblPrixDachat = new JLabel("Prix d'achat");
			lblPrixDachat.setBounds(25, 451, 80, 14);
		}
		return lblPrixDachat;
	}
	/**
	 * Label Estimation
	 */
	private JLabel getLblEstimation() {
		if (lblEstimation == null) {
			lblEstimation = new JLabel("Estimation");
			lblEstimation.setBounds(154, 451, 66, 14);
		}
		return lblEstimation;
	}
	/**
	 * Label Degré
	 */
	private JLabel getLblDegre() {
		if (lblDegre == null) {
			lblDegre = new JLabel("Degré");
			lblDegre.setBounds(270, 451, 46, 14);
		}
		return lblDegre;
	}
	/**
	 * Label Température de
	 */
	private JLabel getLblTempDe() {
		if (lblTempDe == null) {
			lblTempDe = new JLabel("T°");
			lblTempDe.setBounds(357, 451, 22, 14);
		}
		return lblTempDe;
	}
	/**
	 * Label Température à
	 */
	private JLabel getLblTempA() {
		if (lblTempA == null) {
			lblTempA = new JLabel("à");
			lblTempA.setBounds(414, 451, 16, 14);
		}
		return lblTempA;
	}
	/**
	 * Label Commentaire
	 */
	private JLabel getLblCommentaire() {
		if (lblCommentaire == null) {
			lblCommentaire = new JLabel("Commentaire");
			lblCommentaire.setBounds(25, 476, 80, 14);
		}
		return lblCommentaire;
	}
	/**
	 * Label Autres Informations (séparateur)
	 */
	private JLabel getLblAutresInformations() {
		if (lblAutresInformations == null) {
			lblAutresInformations = new JLabel("Autres informations");
			lblAutresInformations.setForeground(Color.GRAY);
			lblAutresInformations.setBounds(10, 150, 129, 14);
		}
		return lblAutresInformations;
	}
	/**
	 * Label Classification (séparateur)
	 */
	private JLabel getLblClassification() {
		if (lblClassification == null) {
			lblClassification = new JLabel("Classification");
			lblClassification.setForeground(Color.GRAY);
			lblClassification.setBounds(10, 280, 94, 14);
		}
		return lblClassification;
	}
	/**
	 * Label Conservation, prix et associations (séparateur)
	 */
	private JLabel getLblconservation() {
		if (lblconservation == null) {
			lblconservation = new JLabel("Conservation, prix et associations");
			lblconservation.setForeground(Color.GRAY);
			lblconservation.setBounds(10, 378, 220, 14);
		}
		return lblconservation;
	}
	
	//************* Séparateur ******************//
	
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 165, 474, 2);
		}
		return separator;
	}

	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setBounds(10, 295, 474, 2);
		}
		return separator_1;
	}
	
	private JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
			separator_2.setBounds(10, 393, 474, 2);
		}
		return separator_2;
	}
}

