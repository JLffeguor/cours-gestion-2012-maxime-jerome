package be.winecave.main;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.jar.JarFile;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.ejb.Ejb3Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.winecave.installation.PostInstallationBouteille;
import be.winecave.installation.PostInstallationCategorie;
import be.winecave.installation.PostInstallationClassement;
import be.winecave.installation.PostInstallationCouleur;
import be.winecave.installation.PostInstallationPays;
import be.winecave.installation.PostInstallationRegionViticole;
import be.winecave.installation.PostInstallationSousRegionViticole;
import be.winecave.util.AppConfig;
import be.winecave.util.FileUtil;
import be.winecave.util.JarUtils;

public class WineCave {
	private static Log log = LogFactory.getLog(FileUtil.class);
	private static ApplicationContext context;
	
	private static boolean debugMode;

	public static void main(String[] args) throws URISyntaxException, IOException {
		
		if(log.isDebugEnabled()) { //TODO check console arg
			activeDebugMode();
		}
		
		launchCheck();
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
	}
	
	private static void activeDebugMode(){
		System.out.println("java system properties");
		Properties props = System.getProperties();
		props.list(System.out);
		
		debugMode = true;
	}
	
	private static void launchCheck() {
		
		ensureRessourcesInstalled();
		
		if( AppConfig.isFirstExecution() ) {
			log.debug("this is first execution");
			
			ExportDbSchema(true);//TODO set to false in prod --maxime 24/12/12
			
			context = new ClassPathXmlApplicationContext("applicationContext.xml");
			
			saveToDbPostIstallationData();
			
			////destruction forcé du spring context pour déchargé les classe postinstallation de la mémoire (nous n'en avons plus besoin)
			((AbstractApplicationContext) context).registerShutdownHook();
			context = new ClassPathXmlApplicationContext("applicationContext.xml");
		}
	}
	
	private static void ensureRessourcesInstalled() {
		JarFile jar = null;
		
		try {
			jar = JarUtils.jarForClass(WineCave.class, null);
		} catch (MalformedURLException | URISyntaxException e) {
			throw new RuntimeException("can't detect if the app is in a jar or not ", e);
		}
		
		
		if ( jar != null ) {
			log.debug("iam in jar");
			//we must copy ressource out now
			//nooooooooooooooooooooooooooooowwwwwwwwwwwwwwwwww
			//...
			//okay
			
			try {
				JarUtils.addRessourcesNextJar(jar, "PostInstallationData", false);
				JarUtils.addRessourcesNextJar(jar, "Config", false);
			} catch (IOException e) {
				throw new RuntimeException("can't install Ressource next jar ", e);
			}
			
		} else  {
			log.debug("i am not in a jar");
		}
	}
	
	@SuppressWarnings("deprecation")
	private static void ExportDbSchema(boolean dropBefore) {
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
	
	private static void saveToDbPostIstallationData() {
		//assuming spring context already created
		((PostInstallationPays) context.getBean("postInstallationPays")).saveDataToDb();
		((PostInstallationRegionViticole) context.getBean("postInstallationRegionViticole")).saveDataToDb();
		((PostInstallationSousRegionViticole) context.getBean("postInstallationSousRegionViticole")).saveDataToDb();
		((PostInstallationBouteille) context.getBean("postInstallationBouteille")).saveDataToDb();
		((PostInstallationCategorie) context.getBean("postInstallationCategorie")).saveDataToDb();
		((PostInstallationClassement) context.getBean("postInstallationClassement")).saveDataToDb();
		((PostInstallationCouleur) context.getBean("postInstallationCouleur")).saveDataToDb();
	}
	

}
