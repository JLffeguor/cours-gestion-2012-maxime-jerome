package be.winecave.util;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

import be.winecave.model.Pays;

/**
 * class pour gérer les données pré-enregistrées du programme ( liste des régions , sous régions, etc...)
 * @author maxime
 *
 */
public class PostInstallDataUtil {
	
	private static PostInstallData data = null;
	private static final String XML_FILE_LOCATION = "PostInstallData.xml";
	
	public static void loadDataFromXml(){

	}
	
	public static void saveDataToXml() {
		
	}
	
	public static void saveDataToDb() {
		
	}
	
	public static PostInstallData getData(){
		return data;
	}
	
	public static void setData(PostInstallData postData) {
		data = postData;
	}

}
