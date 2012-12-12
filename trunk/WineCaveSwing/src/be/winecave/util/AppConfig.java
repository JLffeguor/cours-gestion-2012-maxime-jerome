package be.winecave.util;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * accède de manière trivial à la configuration de l'application
 * @author maxime
 *
 */
public class AppConfig {
	
	private static Log log = LogFactory.getLog(FileUtil.class);
	
	private static final String PROPERTIE_FILE_LOCATION = "app.properties";
	private static final String PROPERTIE_FILE_ENCODING = "UTF-8";
	
	private static PropertiesConfiguration applicationProperties =  null;
	
	/**
	 * methode éxécuté seulement par les autres méthodes
	 */
	private static void loadPropertiesConfiguration() {
		try {
			applicationProperties = new PropertiesConfiguration(PROPERTIE_FILE_LOCATION);
		} catch (ConfigurationException e) {
			throw new RuntimeException(e);
		}
		applicationProperties.setEncoding(PROPERTIE_FILE_ENCODING);
	}
	
	//TODO mettre à public si nécessaire
	private static boolean getBooleanProperty(String key) {
		if(applicationProperties == null) {
			loadPropertiesConfiguration();
		}
		
		return applicationProperties.getBoolean(key);
	}
	
	private static void setProperty(String key,String value){
		if(applicationProperties == null) {
			loadPropertiesConfiguration();
		}
		applicationProperties.setProperty(key, value);		
		try {
			applicationProperties.save();//attention le fichier properties modifier sera celui dans bin pas celui dans src
		} catch (ConfigurationException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * méthode ne donnat qu'une seule fois al valuer true.
	 * Après l'éxécution de cette méthod , le flag de première éxécution ets mis à false
	 * @return
	 */
	public static boolean isFirstExecution(){
		if ( getBooleanProperty("firstExecution") ) {
			log.debug("première éxécution de l'application");
			setProperty("firstExecution","false");
			return true;
		} else {
			return false;
		}
	}

}
