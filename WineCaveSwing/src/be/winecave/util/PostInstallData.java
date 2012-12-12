package be.winecave.util;

import java.util.ArrayList;

import be.winecave.model.Pays;


//TODO trouver un meilleur nom et ce n'est pas vraiment une classe utilitaire au sens strict donc changer de package aussi
public class PostInstallData {
	
	private ArrayList<Pays> ListePays;
	
	public PostInstallData(ArrayList<Pays> ListePays) {
		this.setListePays(ListePays);
	}

	public ArrayList<Pays> getListePays() {
		return ListePays;
	}

	public void setListePays(ArrayList<Pays> listePays) {
		ListePays = listePays;
	}

}
