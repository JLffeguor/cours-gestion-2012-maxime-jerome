package be.winecave.main;

import be.winecave.util.AppConfig;

public class WineCave {

	public static void main(String[] args) {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		launchCheck();
	}
	
	////code pour la première éxécution du porgramme , doit être porté dans une classe spécifique? --maxime 12/12/12
	public static void launchCheck(){
		
		
		if( AppConfig.isFirstExecution() ) {
			//TODO remplir la db ici
		}
	}
}
