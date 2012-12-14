package be.winecave.installation;


public interface PostInstallData<E>{
	
	public void loadDataFromXml();
	
	public void saveDataToXml();
	
	public void saveDataToDb();
	
	public E getData();
	
	public void setData(E postInstallData);
	
}
