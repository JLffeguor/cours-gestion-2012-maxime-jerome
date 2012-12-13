package be.winecave.main;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.winecave.util.AppConfig;
import be.winecave.util.FileUtil;

public class WineCave {
	private static Log log = LogFactory.getLog(FileUtil.class);

	public static void main(String[] args) throws URISyntaxException, IOException {
		if(log.isDebugEnabled()) {
			debuggingPurpose();
		}
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		launchCheck();
	}
	
	public static void debuggingPurpose(){
		Properties props = System.getProperties();
		props.list(System.out);
	}
	
	public static void launchCheck(){
		
		if( AppConfig.isFirstExecution() ) {
			//TODO remplir la db ici avec les données post-install
		}
	}
}
