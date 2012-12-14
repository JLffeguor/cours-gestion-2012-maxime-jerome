package be.winecave.installation;

import java.util.ArrayList;
import java.util.List;

import be.winecave.model.Pays;

public class PostInstallationPays implements PostInstallData<List<Pays>> {
	
	private List<Pays> listePays ;
	
	public PostInstallationPays(ArrayList<Pays> listePays) {
		setData(listePays);
	}

	@Override
	public void loadDataFromXml() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveDataToXml() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveDataToDb() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pays> getData() {
		return listePays;
	}

	@Override
	public void setData(List<Pays> postInstallData) {
		listePays = postInstallData;
		
	}
}
