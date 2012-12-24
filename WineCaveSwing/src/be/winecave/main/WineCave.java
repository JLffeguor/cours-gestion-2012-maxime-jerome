package be.winecave.main;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.jar.JarFile;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.ejb.Ejb3Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.winecave.installation.PostInstallationPays;
import be.winecave.model.PaysViticole;
import be.winecave.util.AppConfig;
import be.winecave.util.FileUtil;
import be.winecave.util.JarUtils;

public class WineCave {
	private static Log log = LogFactory.getLog(FileUtil.class);
	private static ApplicationContext context;
	
	private static boolean debugMode;

	public static void main(String[] args) throws URISyntaxException, IOException {
		launchCheck();
		
		if(log.isDebugEnabled()) {
			debuggingPurpose();
		}
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
	}
	
	public static void debuggingPurpose(){
		Properties props = System.getProperties();
		props.list(System.out);
		
		debugMode = true;
	}
	
	@SuppressWarnings("deprecation")
	public static void ExportDbSchema(boolean dropBefore) {
		// Empty map. We add no additional property, everything is already in the persistence.xml
		Map<String,Object> map=new HashMap<String,Object>(); 
		// Get the config from the persistence.xml file, with the unit name as parameter.
		Ejb3Configuration conf =  new Ejb3Configuration().configure("ConnectionMySql",map);
		SchemaExport schemaExport = new SchemaExport(conf.getHibernateConfiguration());
		
		if(dropBefore) {
			schemaExport.drop(debugMode, true);
		}
		schemaExport.create(debugMode, true);
	}
	
	public static void launchCheck() throws URISyntaxException, IOException{
		JarFile jar = null;
		if ( (jar = JarUtils.jarForClass(WineCave.class, null)) != null ) {
			System.out.println("iam in jar");
			System.out.println(jar.getName());
			//we must copy ressource out now
			//nooooooooooooooooooooooooooooowwwwwwwwwwwwwwwwww
			//...
			//okay
			JarUtils.addRessourcesNextJar(jar, "PostInstallationData", false);
			JarUtils.addRessourcesNextJar(jar, "Config", false);
			
		} else  {
			System.out.println("i am not in a jar");
		}
		
		
		if( AppConfig.isFirstExecution() ) {
			System.out.println("this is first execution");
			
			ExportDbSchema(false);
			
			context = new ClassPathXmlApplicationContext("applicationContext.xml");
			
			//TODO remplir la db ici avec les données post-install
			
			PostInstallationPays postInstallationPays = (PostInstallationPays) context.getBean("postInstallationPays");
			postInstallationPays.loadDataFromXml();
			postInstallationPays.saveDataToDb();
			postInstallationPays.getData().add(new PaysViticole("test"));
			
			postInstallationPays.saveDataToXml();

			////destruction forcé du spring context pour déchargé les classe postinstallation de la mémoire (nous n'en avons plus besoin)
			((AbstractApplicationContext) context).registerShutdownHook();
			context = new ClassPathXmlApplicationContext("applicationContext.xml");
		}
	}
}
