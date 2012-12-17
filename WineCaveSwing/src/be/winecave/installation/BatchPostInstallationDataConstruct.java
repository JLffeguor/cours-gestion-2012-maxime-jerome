package be.winecave.installation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import be.winecave.model.Pays;
import be.winecave.model.Region;
import be.winecave.model.RegionViticole;

public class BatchPostInstallationDataConstruct {
	
	private static PostInstallationPays paysPostInstallationData = new PostInstallationPays(new ArrayList<Pays>());

	public static void addPays(String nom,Map<String, String[]> regionEtSousRegion){
		Pays pays = new Pays(nom);
		RegionViticole region = null;
		
		for (String nomRegion : regionEtSousRegion.keySet()) {
			region = new RegionViticole(nomRegion);
			
			for (String nomSousRegion : regionEtSousRegion.get(nomRegion)) {
				region.getSousRegionsViticole().add(new RegionViticole(nomSousRegion));
			}
			
			pays.getRegions().add(region);
		}
		
		paysPostInstallationData.getData().add(pays);
	}
	
	public static HashMap<String, String[]> getNewRegionMap() {
		return new HashMap<>();
	}
	
	public static HashMap<String, String[]> ajoutRegionAvecSousRegion(String nomRegion,
															String[] sousRegions,
															HashMap<String, String[]> RegionMap) {
		RegionMap.put(nomRegion, sousRegions);
		
		return RegionMap;
	}
	
	public static void main(String[] args) {
	
	////Afrique
	addPays("Afrique du Sud", getNewRegionMap());
	addPays("Maroc",getNewRegionMap());
	addPays("Tunisie",getNewRegionMap());
	
	////Ameriques
	addPays("Argentine",getNewRegionMap());
	addPays("Bresil",getNewRegionMap());
	addPays("Bolivie",getNewRegionMap());
	addPays("Canada",getNewRegionMap());
	addPays("Chili",getNewRegionMap());
	addPays("États-Unis",getNewRegionMap());
	addPays("Mexique",getNewRegionMap());
	addPays("Perou",getNewRegionMap());
	addPays("Uruguay",getNewRegionMap());
	addPays("Vénézuela",getNewRegionMap());
	
	////Asie
	addPays("Chine",getNewRegionMap());
	addPays("Coree du Sud",getNewRegionMap());
	addPays("Inde",getNewRegionMap());
	addPays("Japon",getNewRegionMap());
	
	////Europe occidentale , centrale
	addPays("Allemagne",getNewRegionMap());
	addPays("Autriche",getNewRegionMap());
	addPays("Bosnie",getNewRegionMap());
	addPays("Bulgarie",getNewRegionMap());
	addPays("Chypre",getNewRegionMap());
	addPays("Croatie",getNewRegionMap());
	addPays("Espagne",getNewRegionMap());
	addPays("France",ajoutRegionAvecSousRegion("vallée du Rhône", new String[]{},
			 ajoutRegionAvecSousRegion("vallée de la Loire", new String[]{"Pays nantais", 
															  "Anjou",
															  "Touraine",
															  "Centre"},
			 ajoutRegionAvecSousRegion("Sud-Ouest", new String[]{"Aquitaine",
													 "Midi-Pyrénées"},
		   	 ajoutRegionAvecSousRegion("Savoie", new String[]{},
			 ajoutRegionAvecSousRegion("Provence", new String[]{},
			 ajoutRegionAvecSousRegion("Languedoc-Roussillon", new String[]{"coteaux du Languedoc", 
																"plaine du Languedoc", 
																"coteaux de l'Aude",
																"Roussillon"},
			 ajoutRegionAvecSousRegion("Jura", new String[]{},
			 ajoutRegionAvecSousRegion("Corse", new String[]{},
			 ajoutRegionAvecSousRegion("Champagne", new String[]{"côte des blancs",
													 "côte des Bars",
													 "montagne de Reims",
													 "vallée de la Marne"},
			 ajoutRegionAvecSousRegion("Bourgogne", new String[]{"Beaujolais",
													 "Bugey",
													 "Chablis",
													 "(Côte d'Or) Côte de Nuits",
													 "(Côte d'Or) Côte de Beaune",
													 "Mâconnais"},
			 ajoutRegionAvecSousRegion("Bordeaux", new String[]{"Blayais",
					 								"Bourgeais",
					 								"Graves",
													"Entre-deux-Mers",
													"Libournais",
													"Médoc",
													"Sauternais"}, 
	         ajoutRegionAvecSousRegion("Alsace et Lorraine", new String[]{},getNewRegionMap())
	         )
	         )
	         )
	         )
	         )
	         )
	         )
	         )
	         )
	         )
	         )
	);
	addPays("Grèce",getNewRegionMap());
	addPays("Hongrie",getNewRegionMap());
	addPays("Italie",getNewRegionMap());
	addPays("Luxembourg",getNewRegionMap());
	addPays("Malte",getNewRegionMap());
	addPays("Portugal",getNewRegionMap());
	addPays("République tchèque",getNewRegionMap());
	addPays("République de Macédoine",getNewRegionMap());
	addPays("Roumanie",getNewRegionMap());
	addPays("Royaume-Uni",getNewRegionMap());
	addPays("Slovaquie",getNewRegionMap());
	addPays("Slovenie",getNewRegionMap());
	addPays("Suisse",getNewRegionMap());
	
	////Europe orientale , Asie occidentale , Proche/Moyen-Orient
	
	addPays("Afghanistan",getNewRegionMap());
	addPays("Arménie",getNewRegionMap());
	addPays("Azerbaïdjan",getNewRegionMap());
	addPays("Jordanie",getNewRegionMap());
	addPays("Georgie",getNewRegionMap());
	addPays("Israël",getNewRegionMap());
	addPays("Irak",getNewRegionMap());
	addPays("Iran",getNewRegionMap());
	addPays("Kazakhstan",getNewRegionMap());
	addPays("Kirghizistan",getNewRegionMap());
	addPays("Liban",getNewRegionMap());
	addPays("Moldavie",getNewRegionMap());
	addPays("Ouzbekistan",getNewRegionMap());
	addPays("Russie",getNewRegionMap());
	addPays("Syrie",getNewRegionMap());
	addPays("Tadjikistan",getNewRegionMap());
	addPays("Turkie",getNewRegionMap());
	addPays("Turkménistan",getNewRegionMap());
	addPays("Ukraine",getNewRegionMap());
	addPays("Yémen",getNewRegionMap());
	
	////Océanie
	addPays("Australie",getNewRegionMap());
	addPays("Nouvelle Zelande",getNewRegionMap());
	
	menu.getAppellation().add("(Vide)");
	menu.getAppellation().add("Ajaccio");
	menu.getAppellation().add("Aloxe-corton");
	menu.getAppellation().add("Alsace");
	menu.getAppellation().add("Alsace \"edelzwicker\"");
	menu.getAppellation().add("Alsace \"gentil\"");
	menu.getAppellation().add("Alsace (chasselas)");
	menu.getAppellation().add("Alsace (gewurztraminer)");
	menu.getAppellation().add("Alsace (muscat)");
	menu.getAppellation().add("Alsace (pinot gris)");
	menu.getAppellation().add("Alsace (pinot noir)");
	menu.getAppellation().add("Alsace (pinot, pinot blanc ou klevner)");
	menu.getAppellation().add("Alsace (riesling)");
	menu.getAppellation().add("Alsace (sylvaner)");
	menu.getAppellation().add("Alsace (tokay-pinot gris)");
	menu.getAppellation().add("Alsace grand cru");
	menu.getAppellation().add("Alsace klevener de heiligenstein");
	menu.getAppellation().add("Anjou mousseux");
	menu.getAppellation().add("Anjou-coteaux de la loire");
	menu.getAppellation().add("Anjou-gamay");
	menu.getAppellation().add("Anjou-villages");
	menu.getAppellation().add("Anjou-villages-brissac");
	menu.getAppellation().add("Arbois");
	menu.getAppellation().add("Arbois mousseux");
	menu.getAppellation().add("Arbois pupillin");
	menu.getAppellation().add("Auxey-duresses");
	menu.getAppellation().add("Bearn");
	menu.getAppellation().add("Betard-montrachet");
	menu.getAppellation().add("Banyuls");
	menu.getAppellation().add("Banyuls grand cru");
	menu.getAppellation().add("Barsac");
	menu.getAppellation().add("Beaujolais");
	menu.getAppellation().add("Beaujolais-villages");
	menu.getAppellation().add("Beaumes de venise");
	menu.getAppellation().add("Beaune");
	menu.getAppellation().add("Bergerac");
	menu.getAppellation().add("Bergerac rose");
	menu.getAppellation().add("Bergerac sec");
	menu.getAppellation().add("Bienvenues-betard-montrachet");
	menu.getAppellation().add("Blagny");
	menu.getAppellation().add("Blanquette de limoux");
	menu.getAppellation().add("Blanquette de limoux methode ancestrale");
	menu.getAppellation().add("Blaye");
	menu.getAppellation().add("Bonnes-mares");
	menu.getAppellation().add("Bonnezeaux");
	menu.getAppellation().add("Bordeaux");
	menu.getAppellation().add("Bordeaux clairet");
	menu.getAppellation().add("Bordeaux rose");
	menu.getAppellation().add("Bordeaux sec");
	menu.getAppellation().add("Bordeaux superieur");
	menu.getAppellation().add("Bordeaux-cotes de francs");
	menu.getAppellation().add("Bourgogne");
	menu.getAppellation().add("Bourgogne aligote");
	menu.getAppellation().add("Bourgogne aligote bouzeron");
	menu.getAppellation().add("Bourgogne cote chalonnaise");
	menu.getAppellation().add("Bourgogne cote d'auxerre");
	menu.getAppellation().add("Bourgogne grand ordinaire");
	menu.getAppellation().add("Bourgogne hautes-cotes de beaune");
	menu.getAppellation().add("Bourgogne hautes-cotes de nuits");
	menu.getAppellation().add("Bourgogne mousseux");
	menu.getAppellation().add("Bourgogne ordinaire");
	menu.getAppellation().add("Bourgogne passetoutgrain");
	menu.getAppellation().add("Bourgogne rose");
	menu.getAppellation().add("Bourgogne vezelay");
	menu.getAppellation().add("Bourgueil");
	menu.getAppellation().add("Bouzeron");
	menu.getAppellation().add("Brouilly");
	menu.getAppellation().add("Cerons");
	menu.getAppellation().add("Cote de beaune");
	menu.getAppellation().add("Cote de brouilly");
	menu.getAppellation().add("Cote de nuits-villages");
	menu.getAppellation().add("Cote roannaise");
	menu.getAppellation().add("Cote-rotie");
	menu.getAppellation().add("Cotes d'auvergne");
	menu.getAppellation().add("Cotes d'auvergne-chanturgue");
	menu.getAppellation().add("Cotes de beaune-villages");
	menu.getAppellation().add("Cotes de bergerac");
	menu.getAppellation().add("Cotes de blaye");
	menu.getAppellation().add("Cotes de bordeaux saint-macaire");
	menu.getAppellation().add("Cotes de bourg");
	menu.getAppellation().add("Cotes de castillon");
	menu.getAppellation().add("Cotes de duras");
	menu.getAppellation().add("Cotes de la malepere");
	menu.getAppellation().add("Cotes de millau");
	menu.getAppellation().add("Cotes de montravel");
	menu.getAppellation().add("Cotes de provence");
	menu.getAppellation().add("Cotes de saint-mont");
	menu.getAppellation().add("Cotes de toul");
	menu.getAppellation().add("Cotes du brulhois");
	menu.getAppellation().add("Cotes du forez");
	menu.getAppellation().add("Cotes du frontonnais");
	menu.getAppellation().add("Cotes du jura");
	menu.getAppellation().add("Cotes du jura mousseux");
	menu.getAppellation().add("Cotes du luberon");
	menu.getAppellation().add("Cotes du marmandais");
	menu.getAppellation().add("Cotes du rhone");
	menu.getAppellation().add("Cotes du rhone-villages");
	menu.getAppellation().add("Cotes du rhone-villages Beaumes-de-Venise");
	menu.getAppellation().add("Cotes du rhone-villages Cairanne");
	menu.getAppellation().add("Cotes du rhone-villages Laudun");
	menu.getAppellation().add("Cotes du rhone-villages Rasteau");
	menu.getAppellation().add("Cotes du rhone-villages Roaix");
	menu.getAppellation().add("Cotes du rhone-villages Rochegude");
	menu.getAppellation().add("Cotes du rhone-villages Rousset-les-Vignes");
	menu.getAppellation().add("Cotes du rhone-villages Seguret");
	menu.getAppellation().add("Cotes du rhone-villages Sablet");
	menu.getAppellation().add("Cotes du rhone-villages Saint-Gervais");
	menu.getAppellation().add("Cotes du rhone-villages Saint-Maurice");
	menu.getAppellation().add("Cotes du rhone-villages Saint-Pantaleon-les-vignes");
	menu.getAppellation().add("Cotes du rhone-villages Valreas");
	menu.getAppellation().add("Cotes du rhone-villages Vinsobres");
	menu.getAppellation().add("Cotes du rhone-villages Visan");
	menu.getAppellation().add("Cotes du rhone-villages chusclan");
	menu.getAppellation().add("Cotes du roussillon");
	menu.getAppellation().add("Cotes du roussillon-les aspres");
	menu.getAppellation().add("Cotes du roussillon-villages");
	menu.getAppellation().add("Cotes du ventoux");
	menu.getAppellation().add("Cotes du vivarais");
	menu.getAppellation().add("Cabardes");
	menu.getAppellation().add("Cabernet d'anjou");
	menu.getAppellation().add("Cabernet de saumur");
	menu.getAppellation().add("Cadillac");
	menu.getAppellation().add("Cahors");
	menu.getAppellation().add("Canon-fronsac");
	menu.getAppellation().add("Cassis");
	menu.getAppellation().add("Chenas");
	menu.getAppellation().add("Chateau-chalon");
	menu.getAppellation().add("Chateau-grillet");
	menu.getAppellation().add("Chateaumeillant");
	menu.getAppellation().add("Chateauneuf-du-pape");
	menu.getAppellation().add("Chatillon-en-diois");
	menu.getAppellation().add("Chablis");
	menu.getAppellation().add("Chablis grand cru");
	menu.getAppellation().add("Chablis premier cru");
	menu.getAppellation().add("Chambertin");
	menu.getAppellation().add("Chambertin clos-de-beze");
	menu.getAppellation().add("Chambolle-musigny");
	menu.getAppellation().add("Champagne");
	menu.getAppellation().add("Ajaccio");
	menu.getAppellation().add("Champagne grand cru");
	menu.getAppellation().add("Champagne premier cru");
	menu.getAppellation().add("Chapelle-chambertin");
	menu.getAppellation().add("Charlemagne");
	menu.getAppellation().add("Charmes-chambertin");
	menu.getAppellation().add("Chassagne-montrachet");
	menu.getAppellation().add("Chevalier-montrachet");
	menu.getAppellation().add("Cheverny");
	menu.getAppellation().add("Chinon");
	menu.getAppellation().add("Chiroubles");
	menu.getAppellation().add("Chorey-les-beaune");
	menu.getAppellation().add("Clairette de bellegarde");
	menu.getAppellation().add("Clairette de die");
	menu.getAppellation().add("Clairette du languedoc");
	menu.getAppellation().add("Clos de la roche");
	menu.getAppellation().add("Clos de tart");
	menu.getAppellation().add("Clos de vougeot");
	menu.getAppellation().add("Clos des lambrays");
	menu.getAppellation().add("Clos saint-denis");
	menu.getAppellation().add("Collioure");
	menu.getAppellation().add("Condrieu");
	menu.getAppellation().add("Corbieres");
	menu.getAppellation().add("Corbi?res-boutenac");
	menu.getAppellation().add("Cornas");
	menu.getAppellation().add("Corton");
	menu.getAppellation().add("Corton charlemagne");
	menu.getAppellation().add("Costieres de nemes");
	menu.getAppellation().add("Coteaux champenois");
	menu.getAppellation().add("Coteaux d'aix-en-provence");
	menu.getAppellation().add("Coteaux d'ancenis");
	menu.getAppellation().add("Coteaux de die");
	menu.getAppellation().add("Coteaux de l'aubance");
	menu.getAppellation().add("Coteaux de pierrevert");
	menu.getAppellation().add("Coteaux de saumur");
	menu.getAppellation().add("Coteaux du giennois");
	menu.getAppellation().add("Coteaux du languedoc");
	menu.getAppellation().add("Coteaux du layon");
	menu.getAppellation().add("Coteaux du layon Beaulieu-sur-Layon");
	menu.getAppellation().add("Coteaux du layon Faye-d'Anjou");
	menu.getAppellation().add("Coteaux du layon Rablay-sur-Layon");
	menu.getAppellation().add("Coteaux du layon Rochefort-sur-Loire");
	menu.getAppellation().add("Coteaux du layon Saint-Aubin-de-Luigne");
	menu.getAppellation().add("Coteaux du layon Saint-Lambert-du-Lattay");
	menu.getAppellation().add("Coteaux du layon chaume");
	menu.getAppellation().add("Coteaux du layon chaume premier cru");
	menu.getAppellation().add("Coteaux du loir");
	menu.getAppellation().add("Coteaux du lyonnais");
	menu.getAppellation().add("Coteaux du quercy");
	menu.getAppellation().add("Coteaux du tricastin");
	menu.getAppellation().add("Coteaux varois-en-provence");
	menu.getAppellation().add("Cour-cheverny");
	menu.getAppellation().add("Cremant d'alsace");
	menu.getAppellation().add("Cremant de bordeaux");
	menu.getAppellation().add("Cremant de bourgogne");
	menu.getAppellation().add("Cremant de die");
	menu.getAppellation().add("Cremant de limoux");
	menu.getAppellation().add("Cremant de loire");
	menu.getAppellation().add("Cremant du jura");
	menu.getAppellation().add("Crepy");
	menu.getAppellation().add("Criots-batard-montrachet");
	menu.getAppellation().add("Crozes-hermitage");
	menu.getAppellation().add("Echezeaux");
	menu.getAppellation().add("Entre-deux-mers");
	menu.getAppellation().add("Entre-deux-mers haut-benauge");
	menu.getAppellation().add("Fiefs vendens");
	menu.getAppellation().add("Fitou");
	menu.getAppellation().add("Fixin");
	menu.getAppellation().add("Fleurie");
	menu.getAppellation().add("Floc de gascogne");
	menu.getAppellation().add("Fronsac");
	menu.getAppellation().add("Gaillac premieres cotes");
	menu.getAppellation().add("Gevrey-chambertin");
	menu.getAppellation().add("Gigondas");
	menu.getAppellation().add("Givry");
	menu.getAppellation().add("Grands-echezeaux");
	menu.getAppellation().add("Graves");
	menu.getAppellation().add("Graves superieures");
	menu.getAppellation().add("Graves-de-vayres");
	menu.getAppellation().add("Griotte-chambertin");
	menu.getAppellation().add("Gros-plant du pays nantais");
	menu.getAppellation().add("Haut-medoc");
	menu.getAppellation().add("Haut-montravel");
	menu.getAppellation().add("Haut-poitou");
	menu.getAppellation().add("Hermitage");
	menu.getAppellation().add("Irouleguy");
	menu.getAppellation().add("Julienas");
	menu.getAppellation().add("Juraneon");
	menu.getAppellation().add("Juraneon sec");
	menu.getAppellation().add("L'etoile");
	menu.getAppellation().add("L'etoile mousseux");
	menu.getAppellation().add("La grande rue");
	menu.getAppellation().add("La teche");
	menu.getAppellation().add("Ladoix");
	menu.getAppellation().add("Lalande-de-pomerol");
	menu.getAppellation().add("Languedoc");
	menu.getAppellation().add("Latricieres-chambertin");
	menu.getAppellation().add("Lavilledieu");
	menu.getAppellation().add("Les baux-de-provence");
	menu.getAppellation().add("Limoux");
	menu.getAppellation().add("Lirac");
	menu.getAppellation().add("Loupiac");
	menu.getAppellation().add("Lussac saint-emilion");
	menu.getAppellation().add("Mecon");
	menu.getAppellation().add("Mecon-superieur");
	menu.getAppellation().add("Mecon-villages");
	menu.getAppellation().add("Medoc");
	menu.getAppellation().add("Macvin du jura");
	menu.getAppellation().add("Madiran");
	menu.getAppellation().add("Maranges");
	menu.getAppellation().add("Maranges premier cru");
	menu.getAppellation().add("Marcillac");
	menu.getAppellation().add("Margaux");
	menu.getAppellation().add("Marsannay");
	menu.getAppellation().add("Marsannay rose");
	menu.getAppellation().add("Maury");
	menu.getAppellation().add("Mazis-chambertin");
	menu.getAppellation().add("Mazoyeres-chambertin");
	menu.getAppellation().add("Menetou-salon");
	menu.getAppellation().add("Mercurey");
	menu.getAppellation().add("Meursault");
	menu.getAppellation().add("Minervois");
	menu.getAppellation().add("Minervois-la-liviniere");
	menu.getAppellation().add("Monbazillac");
	menu.getAppellation().add("Montagne-saint-emilion");
	menu.getAppellation().add("Montagny");
	menu.getAppellation().add("Monthelie");
	menu.getAppellation().add("Montlouis");
	menu.getAppellation().add("Montlouis mousseux");
	menu.getAppellation().add("Montlouis petillant");
	menu.getAppellation().add("Montrachet");
	menu.getAppellation().add("Montravel");
	menu.getAppellation().add("Morey saint-denis");
	menu.getAppellation().add("Morgon");
	menu.getAppellation().add("Moselle");
	menu.getAppellation().add("Moulin-a-vent");
	menu.getAppellation().add("Moulis");
	menu.getAppellation().add("Muscadet");
	menu.getAppellation().add("Muscadet cotes de grandlieu");
	menu.getAppellation().add("Muscadet coteaux de la loire");
	menu.getAppellation().add("Muscadet sevre-et-maine");
	menu.getAppellation().add("Muscat de beaumes-de-venise");
	menu.getAppellation().add("Muscat de frontignan");
	menu.getAppellation().add("Muscat de lunel");
	menu.getAppellation().add("Muscat de mireval");
	menu.getAppellation().add("Muscat de rivesaltes");
	menu.getAppellation().add("Muscat de saint-jean-de-minervois");
	menu.getAppellation().add("Muscat du cap corse");
	menu.getAppellation().add("Musigny");
	menu.getAppellation().add("Pecharmant");
	menu.getAppellation().add("Pacherenc du vic-bilh");
	menu.getAppellation().add("Pacherenc du vic-bilh sec");
	menu.getAppellation().add("Palette");
	menu.getAppellation().add("Patrimonio");
	menu.getAppellation().add("Pauillac");
	menu.getAppellation().add("Pernand-vergelesses");
	menu.getAppellation().add("Pessac-leognan");
	menu.getAppellation().add("Petit chablis");
	menu.getAppellation().add("Pineau des charentes");
	menu.getAppellation().add("Pomerol");
	menu.getAppellation().add("Pommard");
	menu.getAppellation().add("Pommeau de normandie");
	menu.getAppellation().add("Pouilly-fuisse");
	menu.getAppellation().add("Pouilly-fume");
	menu.getAppellation().add("Pouilly-loche");
	menu.getAppellation().add("Pouilly-sur-loire");
	menu.getAppellation().add("Pouilly-vinzelles");
	menu.getAppellation().add("Premieres cotes de blaye");
	menu.getAppellation().add("Premieres cotes de bordeaux");
	menu.getAppellation().add("Provence");
	menu.getAppellation().add("Puisseguin-saint-emilion");
	menu.getAppellation().add("Puligny-montrachet");
	menu.getAppellation().add("Quarts de chaume");
	menu.getAppellation().add("Quincy");
	menu.getAppellation().add("Regnie");
	menu.getAppellation().add("Reuilly");
	menu.getAppellation().add("Richebourg");
	menu.getAppellation().add("Rivesaltes");
	menu.getAppellation().add("Romanee (La)");
	menu.getAppellation().add("Romanee saint-vivant");
	menu.getAppellation().add("Romanee-conti");
	menu.getAppellation().add("Rose d'anjou");
	menu.getAppellation().add("Rose de loire");
	menu.getAppellation().add("Rose des riceys");
	menu.getAppellation().add("Rosette");
	menu.getAppellation().add("Roussette de savoie");
	menu.getAppellation().add("Roussette du bugey");
	menu.getAppellation().add("Ruchottes-chambertin");
	menu.getAppellation().add("Rully");
	menu.getAppellation().add("Saint sardos");
	menu.getAppellation().add("Saint-emilion");
	menu.getAppellation().add("Saint-emilion grand cru");
	menu.getAppellation().add("Saint-amour");
	menu.getAppellation().add("Saint-aubin");
	menu.getAppellation().add("Saint-chinian");
	menu.getAppellation().add("Saint-chinian Berlou");
	menu.getAppellation().add("Saint-chinian Roquebrun");
	menu.getAppellation().add("Saint-estephe");
	menu.getAppellation().add("Saint-georges-saint-emilion");
	menu.getAppellation().add("Saint-joseph");
	menu.getAppellation().add("Saint-julien");
	menu.getAppellation().add("Saint-nicolas-de-bourgueil");
	menu.getAppellation().add("Saint-peray");
	menu.getAppellation().add("Saint-peray mousseux");
	menu.getAppellation().add("Saint-poureain");
	menu.getAppellation().add("Saint-romain");
	menu.getAppellation().add("Saint-veran");
	menu.getAppellation().add("Sainte-croix-du-mont");
	menu.getAppellation().add("Sainte-foy-bordeaux");
	menu.getAppellation().add("Sancerre");
	menu.getAppellation().add("Santenay");
	menu.getAppellation().add("Saumur");
	menu.getAppellation().add("Saumur mousseux");
	menu.getAppellation().add("Saumur-champigny");
	menu.getAppellation().add("Saussignac");
	menu.getAppellation().add("Sauternes");
	menu.getAppellation().add("Sauvignon de saint-bris");
	menu.getAppellation().add("Savennieres");
	menu.getAppellation().add("Savigny-les-beaune");
	menu.getAppellation().add("Seyssel");
	menu.getAppellation().add("Seyssel mousseux");
	menu.getAppellation().add("Sud-Ouest");
	menu.getAppellation().add("Tavel");
	menu.getAppellation().add("Touraine");
	menu.getAppellation().add("Touraine amboise");
	menu.getAppellation().add("Touraine azay-le-rideau");
	menu.getAppellation().add("Touraine mesland");
	menu.getAppellation().add("Touraine mousseux");
	menu.getAppellation().add("Touraine noble joue");
	menu.getAppellation().add("Touraine petillant");
	menu.getAppellation().add("Tursan");
	menu.getAppellation().add("Valeneay");
	menu.getAppellation().add("Vallee de la Loire");
	menu.getAppellation().add("Vallee du Rhone");
	menu.getAppellation().add("Vin de savoie");
	menu.getAppellation().add("Vin de savoie mousseux");
	menu.getAppellation().add("Vin de savoie petillant");
	menu.getAppellation().add("Vin du bugey");
	menu.getAppellation().add("Vins d'entraygues et du fel");
	menu.getAppellation().add("Vins d'estaing");
	menu.getAppellation().add("Vins de corse");
	menu.getAppellation().add("Vins de l'orleannais");
	menu.getAppellation().add("Vins du thouarsais");
	menu.getAppellation().add("Vire-clesse");
	menu.getAppellation().add("Volnay");
	menu.getAppellation().add("Volnay santenots");
	menu.getAppellation().add("Vosne-romanee");
	menu.getAppellation().add("Vougeot");
	menu.getAppellation().add("Vouvray");
	menu.getAppellation().add("Vouvray mousseux");
	menu.getAppellation().add("Vouvray petillant");
	
	menu.getCépage().add("(Vide)");
	menu.getCépage().add("Altesse");
	menu.getCépage().add("Aramon");
	menu.getCépage().add("Arbanne");
	menu.getCépage().add("Arbois");
	menu.getCépage().add("Arrufiac");
	menu.getCépage().add("Auxerrois");
	menu.getCépage().add("Bequignol");
	menu.getCépage().add("Barbaroux");
	menu.getCépage().add("Baroque");
	menu.getCépage().add("Blanc Fume");
	menu.getCépage().add("Blanquette");
	menu.getCépage().add("Bouchet");
	menu.getCépage().add("Bourboulenc");
	menu.getCépage().add("Breton");
	menu.getCépage().add("Cabernet-franc");
	menu.getCépage().add("Cabernet-sauvignon");
	menu.getCépage().add("Carignan");
	menu.getCépage().add("Chardonnay");
	menu.getCépage().add("Chasselas");
	menu.getCépage().add("Chenin blanc");
	menu.getCépage().add("Chenin noir");
	menu.getCépage().add("Cinsault");
	menu.getCépage().add("Clairette");
	menu.getCépage().add("Colombard");
	menu.getCépage().add("Cot");
	menu.getCépage().add("Counoise");
	menu.getCépage().add("Courbu");
	menu.getCépage().add("Cruchen");
	menu.getCépage().add("Duras");
	menu.getCépage().add("Durif");
	menu.getCépage().add("Fer");
	menu.getCépage().add("Fer-Servadou");
	menu.getCépage().add("Folle Blanche");
	menu.getCépage().add("Frontignan");
	menu.getCépage().add("Gamay");
	menu.getCépage().add("Gewurtztraminer");
	menu.getCépage().add("Grenache");
	menu.getCépage().add("Grenache Blanc");
	menu.getCépage().add("Gringet");
	menu.getCépage().add("Grolleau");
	menu.getCépage().add("Gros Manseng");
	menu.getCépage().add("Gros Plant");
	menu.getCépage().add("Gros-Lot");
	menu.getCépage().add("Jacquere");
	menu.getCépage().add("Klevner");
	menu.getCépage().add("Knipperle");
	menu.getCépage().add("Macabeu");
	menu.getCépage().add("Malbec");
	menu.getCépage().add("Malvoisie");
	menu.getCépage().add("Manicle");
	menu.getCépage().add("Mansenc");
	menu.getCépage().add("Marsanne");
	menu.getCépage().add("Mauzac");
	menu.getCépage().add("Melon");
	menu.getCépage().add("Menu Pineau");
	menu.getCépage().add("Merlot");
	menu.getCépage().add("Merlot Blanc");
	menu.getCépage().add("Meunier");
	menu.getCépage().add("Mondeuse");
	menu.getCépage().add("Mourvedre");
	menu.getCépage().add("Muscadelle");
	menu.getCépage().add("Muscadet");
	menu.getCépage().add("Muscadin");
	menu.getCépage().add("Muscat");
	menu.getCépage().add("Muscat noir");
	menu.getCépage().add("Negrette");
	menu.getCépage().add("Nielluccio");
	menu.getCépage().add("Noirin");
	menu.getCépage().add("Oeillade Blanc");
	menu.getCépage().add("Pacherenc");
	menu.getCépage().add("Pascal");
	menu.getCépage().add("Pecoultouar");
	menu.getCépage().add("Petit Mansin");
	menu.getCépage().add("Petit Meslier");
	menu.getCépage().add("Petit Verdot");
	menu.getCépage().add("Picardan");
	menu.getCépage().add("Picpoul");
	menu.getCépage().add("Pineau d'Aunis");
	menu.getCépage().add("Pineau de la Loire");
	menu.getCépage().add("Pinot Meunier");
	menu.getCépage().add("Pinot blanc");
	menu.getCépage().add("Pinot gris");
	menu.getCépage().add("Pinot noir");
	menu.getCépage().add("Poulsard");
	menu.getCépage().add("Riesling");
	menu.getCépage().add("Rolle");
	menu.getCépage().add("Romorantin");
	menu.getCépage().add("Roussanne");
	menu.getCépage().add("Roussette");
	menu.getCépage().add("Semillon");
	menu.getCépage().add("Sacy");
	menu.getCépage().add("Sauvignon");
	menu.getCépage().add("Savagnin");
	menu.getCépage().add("Sciacarello");
	menu.getCépage().add("St-Pierre");
	menu.getCépage().add("Sylvaner");
	menu.getCépage().add("Syrah");
	menu.getCépage().add("Tannat");
	menu.getCépage().add("Terret");
	menu.getCépage().add("Tibouren");
	menu.getCépage().add("Traminer");
	menu.getCépage().add("Tressalier");
	menu.getCépage().add("Ugni-Blanc");
	menu.getCépage().add("Vaccarese");
	menu.getCépage().add("Verdot");
	menu.getCépage().add("Vermentino");
	menu.getCépage().add("Viognier");
	
	menu.getBouteille().add("(Vide)");
	menu.getBouteille().add("1,5 l (magnum)");
	menu.getBouteille().add("1,6 l (magnum)");
	menu.getBouteille().add("12,8 l (balthazar)");
	menu.getBouteille().add("16 l (nabuchodonosor)");
	menu.getBouteille().add("3 l (double magnum)");
	menu.getBouteille().add("3,2 l (jeroboam)");
	menu.getBouteille().add("35 cl");
	menu.getBouteille().add("37,5 cl");
	menu.getBouteille().add("4 l (jeroboam)");
	menu.getBouteille().add("4,8 l (rehoboam)");
	menu.getBouteille().add("40 cl");
	menu.getBouteille().add("6 l (imperiale)");
	
	menu.getCatégorie().add("(Vide)");
	menu.getCatégorie().add("Aperitifs");
	menu.getCatégorie().add("Bieres");
	menu.getCatégorie().add("Champagnes");
	menu.getCatégorie().add("Spiritueux");
	menu.getCatégorie().add("Vins");
	
	menu.getClassement().add("(Vide)");
	menu.getClassement().add("1er Cru");
	menu.getClassement().add("1er Cru Classe");
	menu.getClassement().add("1er Cru Superieur");
	menu.getClassement().add("1er Grand Cru A");
	menu.getClassement().add("1er Grand Cru B");
	menu.getClassement().add("1er Grand Cru Classe");
	menu.getClassement().add("2eme Cru Classe");
	menu.getClassement().add("3eme Cru Classe");
	menu.getClassement().add("4eme Cru Classe");
	menu.getClassement().add("5eme Cru Classe");
	menu.getClassement().add("A.O.V.D.Q.S.");
	menu.getClassement().add("Cru Artisan");
	menu.getClassement().add("Cru Bourgeois");
	menu.getClassement().add("Cru Bourgeois Exceptionnel");
	menu.getClassement().add("Cru Bourgeois Superieur");
	menu.getClassement().add("Cru Classe");
	menu.getClassement().add("Grand Cru");
	menu.getClassement().add("Grand Cru Bourgeois");
	menu.getClassement().add("Grand Cru Classe");
	menu.getClassement().add("Vin de pays");
	menu.getClassement().add("Vin de table");
	
	menu.getCouleur().add("(Vide)");
	menu.getCouleur().add("Rouge");
	menu.getCouleur().add("Blanc");
	menu.getCouleur().add("Rose");
	menu.getCouleur().add("Champagne");
	menu.getCouleur().add("Liquoreux");
	menu.getCouleur().add("Autre");
}
}
