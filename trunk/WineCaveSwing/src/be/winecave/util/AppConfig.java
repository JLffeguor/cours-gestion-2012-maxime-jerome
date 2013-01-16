package be.winecave.util;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import be.winecave.main.ProgressDialog;

/**
 * accède de manière trivial à la configuration de l'application
 * @author maxime
 *
 */
public class AppConfig {
	
	private static Log log = LogFactory.getLog(FileUtil.class);
	
	private static final String PROPERTIE_FILE_NAME = "app.properties";
	private static final Path PROPERTIE_FILE_PATH = FileUtil.getPathIntoConfigFolder(PROPERTIE_FILE_NAME); //TODO get filessystem seems more portable maybe implement a solution to don't have so long static declaration for a location? --maxime 13/12/12
	private static final Charset PROPERTIE_FILE_ENCODING = FileUtil.getDefaultFileEncoding();
	
	private static PropertiesConfiguration applicationProperties =  null;
	

	
	private static void loadPropertiesConfiguration() {
		
		 ProgressDialog frame = new ProgressDialog();
	     frame.pack();
	     frame.setVisible(true);
	     frame.loop2();
	     frame.setVisible(false);
	     
		if ( applicationProperties != null ) {
			return; //propertyFile already loaded : nothing to do!
		}
		
		////everything OK we can load property file now
		try {
			applicationProperties = new PropertiesConfiguration(PROPERTIE_FILE_PATH.toFile());//we load form outside the jar (src in DEV)
			applicationProperties.setEncoding(PROPERTIE_FILE_ENCODING.toString());//doesn't throw exception but it's have more clean code --maxime 13/12/12
		} catch (ConfigurationException e) {
			throw new RuntimeException(e);
		}
		
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
			applicationProperties.save();
		} catch (ConfigurationException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * méthode ne donnat qu'une seule fois al valuer true.
	 * Après l'éxécution de cette méthode , le flag de première éxécution ets mis à false
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
