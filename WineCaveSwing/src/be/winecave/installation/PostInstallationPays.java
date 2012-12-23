package be.winecave.installation;

import java.util.ArrayList;
import java.util.List;

import be.winecave.model.PaysViticole;

public class PostInstallationPays implements PostInstallData<List<PaysViticole>> {
	
	private List<PaysViticole> listePays ;
	
	public PostInstallationPays(ArrayList<PaysViticole> listePays) {
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
	public List<PaysViticole> getData() {
		return listePays;
	}

	@Override
	public void setData(List<PaysViticole> postInstallData) {
		listePays = postInstallData;
		
	}
}
