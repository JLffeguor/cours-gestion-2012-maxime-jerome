package be.winecave.fenetre.migLayout;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;
import be.winecave.model.Bouteille;
import be.winecave.model.Categorie;
import be.winecave.model.Classement;
import be.winecave.model.Couleur;
import be.winecave.model.PaysViticole;
import be.winecave.model.Region;
import be.winecave.model.Vin;

@SuppressWarnings("serial")
public class EditWinePanel extends PanelHelper{
	
	private JTextField jtfReference = createTextField("");
	private JTextField jtfNom = createTextField("");
	private JComboBox<String> comboProducteur = new EditableUnselectedJCombobox<>(getGuiConnector().getVinRepository().findAllProducteur());
	private JComboBox<PaysViticole> comboPays = new UnselectedJCombobox<>(getGuiConnector().getPaysViticoleRepository().findAll());
	private DisabledJCombobox<Region> comboRegion = new DisabledJCombobox<>();
	private JComboBox<String> comboAppellation = new EditableUnselectedJCombobox<>();
	private JTextField jtfCepage = createTextField("");
	private JComboBox<Categorie> comboCategorie = new UnselectedJCombobox<>(getGuiConnector().getCategorieRepository().findAll());
	private JComboBox<Couleur> comboCouleur = new UnselectedJCombobox<>(getGuiConnector().getCouleurRepository().findAll());
	private JComboBox<Classement> comboClassement = new UnselectedJCombobox<>(getGuiConnector().getClassementRepository().findAll());
	private JComboBox<Bouteille> comboBouteille = new UnselectedJCombobox<>(getGuiConnector().getBouteilleRepository().findAll());
	private JTextField jtfCuvee = createTextField("");
	private JFormattedTextField jtfBoireDe = new SimpleJFormattedTextField("####");
	private JFormattedTextField jtfBoireA = new SimpleJFormattedTextField("####");
	private JFormattedTextField jtfApogeeDe = new SimpleJFormattedTextField("####");
	private JFormattedTextField jtfApogeeA = new SimpleJFormattedTextField("####");
	private JFormattedTextField jtfMillesime = new SimpleJFormattedTextField("####");
	private JFormattedTextField jtfPrixAchat = new SimpleJFormattedTextField("******","1234567890.,");
	private JFormattedTextField jtfEstimation = new SimpleJFormattedTextField("*****","1234567890.,");
	private JFormattedTextField jtfDegre = new SimpleJFormattedTextField("**","1234567890.");
	private JFormattedTextField jtfTempDe = new SimpleJFormattedTextField("##");
	private JFormattedTextField jtfTempA = new SimpleJFormattedTextField("##");
	private JTextArea jtaCommentaire = createTextArea("", 0, 0);
	
	public EditWinePanel() {
		super(new MigLayout("","[pref!][grow 50,fill][pref!][grow 50,fill]","[grow, fill]"));
		System.out.println(SwingUtilities.isEventDispatchThread());
		this.add(createLabel("Reference"), "");
		this.add(jtfReference, "");
		this.add(createLabel("Millesime"), "");
		this.add(jtfMillesime, "width 20:50:50, wrap");
		this.add(createLabel("Nom"), "");//span merge cells
		this.add(jtfNom, "span, growx");
		this.add(createLabel("Producteur"), "");//span merge cells
		this.add(comboProducteur, "span, growx");

		addSeparator(this, "Autres informations");

		this.add(createLabel("Pays"), "");
//		comboPays.addActionListener(new ActionListener() {
//			
//			@SuppressWarnings("unchecked")
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println(SwingUtilities.isEventDispatchThread());
//				System.out.println("i select  " + ((JComboBox<PaysViticole>)e.getSource()).getSelectedItem().toString());
//				comboRegion.enableWithData(((PaysViticole) comboPays.getSelectedItem()).getRegionsEnfant());
//				comboRegion.setSelectedIndex(-1);
//			}
//
//		});
		
		comboPays.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent  e) {
				if(comboPays.getSelectedItem() != null) {
					System.out.println(SwingUtilities.isEventDispatchThread());
					System.out.println("i select  " + ((PaysViticole) comboPays.getSelectedItem()).toString());
					comboRegion.enableWithData(((PaysViticole) comboPays.getSelectedItem()).getRegionsEnfant());
				}
				comboRegion.setSelectedIndex(-1);
			}

		});

		this.add(comboPays, "");
		this.add(createLabel("Region"), "");
		this.add(comboRegion, "wrap");
		this.add(createLabel("Appelation"), "");
		this.add(comboAppellation, "span , growx, wrap");
		this.add(createLabel("Cépage"));
		this.add(jtfCepage,"");
		this.add(createLabel("Cuvée"));
		this.add(createTextField(""),"wrap");//TODO mettre jtfCuvée
		
		addSeparator(this, "Classification");
		
		this.add(createLabel("Catégorie"));
		this.add(comboCategorie);
		this.add(createLabel("Couleur"));
		this.add(comboCouleur,"wrap");
		this.add(createLabel("Classement"));
		this.add(comboClassement);
		this.add(createLabel("Bouteille"));
		this.add(comboBouteille,"wrap");
		
		addSeparator(this, "Conservation, prix et associations");
		
		//le pus simple ici est de remettre un panel qui prendra toute la place pour pouvoir appliquer des contraintes spécifique
		JPanel jpConservationLine1 = new JPanel(new MigLayout("","[pref!][grow ,fill][pref!][grow ,fill][pref!][grow ,fill][pref!][grow ,fill]","[grow, fill]"));
		jpConservationLine1.add(createLabel("Boire de "));
		jpConservationLine1.add(jtfBoireDe);
		jpConservationLine1.add(createLabel(" à "));
		jpConservationLine1.add(jtfBoireA);
		jpConservationLine1.add(createLabel("Apogée de "));
		jpConservationLine1.add(jtfApogeeDe);
		jpConservationLine1.add(createLabel(" à "));
		jpConservationLine1.add(jtfApogeeA);
		//et on l'ajoute au panel principale
		this.add(jpConservationLine1,"span, grow, wrap");
		
		//le pus simple ici est de remettre un panel qui prendra toute la place pour pouvoir appliquer des contraintes spécifique
		JPanel jpConservationLine2 = new JPanel(new MigLayout("","[pref!][grow ,fill][pref!][grow ,fill][pref!][grow ,fill][pref!][grow ,fill][pref!][grow ,fill]","[grow, fill]"));
		jpConservationLine2.add(createLabel("Prix d'acquistion"));
		jpConservationLine2.add(jtfPrixAchat);
		jpConservationLine2.add(createLabel("Estimation"));
		jpConservationLine2.add(jtfEstimation);
		jpConservationLine2.add(createLabel("Degré"));
		jpConservationLine2.add(jtfDegre);
		jpConservationLine2.add(createLabel("T°"));
		jpConservationLine2.add(jtfTempA);
		jpConservationLine2.add(createLabel("à"));
		jpConservationLine2.add(jtfTempDe);
		//et on l'ajoute au panel principale
		this.add(jpConservationLine2,"span, grow, wrap");
		
		//panel spécifique pour les comentaires pour que la zone de saisie puisse grandir en hauteur
		this.add(createLabel("Commentaire"));
		this.add(createTextAreaScroll("", 10, 50, false),"span , grow, wrap");
	}

	void saveData() {
		System.out.println(this.getClass() + " saveData()" + SwingUtilities.isEventDispatchThread());
		Vin vin = new Vin();
		vin.setNom(jtfNom.getText());
		vin.setMillesime(jtfMillesime.getText());
		vin.setProducteur((String) comboProducteur.getSelectedItem());//TODO an exception is throwed when no item is selected . find solution
		if(!jtfDegre.getText().trim().isEmpty()) {
			vin.setDegre(Double.parseDouble(jtfDegre.getText()));
		}
		vin.setCuvee(jtfCuvee.getText());
		vin.setCepage(jtfCepage.getText());
		vin.setCommentaire(jtaCommentaire.getText());

		getGuiConnector().setCurrentVin(
				getGuiConnector().getVinService().creerVin(
						(Region) comboRegion.getSelectedItem(), 
						(Categorie)comboCategorie.getSelectedItem(), 
						(Couleur)comboCouleur.getSelectedItem(), 
						(Bouteille)comboBouteille.getSelectedItem(), 
						(Classement)comboClassement.getSelectedItem(),
						jtfBoireDe.getText(), jtfBoireA.getText(), jtfApogeeDe.getText(), jtfApogeeA.getText(), !jtfTempDe.getText().trim().isEmpty()?Double.parseDouble(jtfTempDe.getText()):0.0d, !jtfTempA.getText().trim().isEmpty()?Double.parseDouble(jtfTempA.getText()):0.0d,//TODO an exception is throwed when field empty . find solution
						vin
						)
		);
		
	}
	
	void clearData() {
		jtfReference.setText("");
		jtfNom.setText("");
		comboProducteur.setSelectedIndex(-1);
		comboPays.setSelectedIndex(-1);
		comboRegion.setSelectedIndex(-1);
		comboAppellation.setSelectedIndex(-1);
		jtfCepage.setText("");
		comboCategorie.setSelectedIndex(-1);
		comboCouleur.setSelectedIndex(-1);
		comboClassement.setSelectedIndex(-1);
		comboBouteille.setSelectedIndex(-1);
		jtfCuvee.setText(""); //Le champs cuvée ne se vide pas.... 
		jtfBoireDe.setText("");
		jtfBoireA.setText("");
		jtfApogeeDe.setText("");
		jtfApogeeA.setText("");
		jtfMillesime.setText("");
		jtfMillesime.setText("");
		jtfPrixAchat.setText("");
		jtfEstimation.setText("");
		jtfDegre.setText("");
		jtfTempDe.setText("");
		jtfTempA.setText("");
		jtaCommentaire.setText("");
	}

}
