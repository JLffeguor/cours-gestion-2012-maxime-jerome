package be.winecave.main;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.winecave.Repository.TestService;
import be.winecave.installation.PostInstallationPays;
import be.winecave.util.AppConfig;
import be.winecave.util.FileUtil;

public class WineCave {
	private static Log log = LogFactory.getLog(FileUtil.class);
	private static ApplicationContext context;

	public static void main(String[] args) throws URISyntaxException, IOException {
		if(log.isDebugEnabled()) {
			debuggingPurpose();
		}
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		launchCheck();
	}
	
	public static void debuggingPurpose(){
		Properties props = System.getProperties();
		props.list(System.out);
	}
	
	public static void launchCheck(){
		////TODO remove --maxime 23/12/12
		PostInstallationPays postInstallationPays = (PostInstallationPays) context.getBean("postInstallationPays");
		postInstallationPays.loadDataFromXml();
		postInstallationPays.saveDataToDb();
		
		if( AppConfig.isFirstExecution() ) {
			//TODO remplir la db ici avec les données post-install
		}
	}
}
