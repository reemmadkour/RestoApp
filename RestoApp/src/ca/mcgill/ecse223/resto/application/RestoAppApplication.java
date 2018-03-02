package ca.mcgill.ecse223.resto.application;

import ca.mcgill.ecse223.resto.persistence.PersistenceObjectStream;
import ca.mcgill.ecse223.resto.view.CreateTablePage;
import ca.mcgill.ecse223.resto.view.RestoAppPage;
import ca.mcgill.ecse223.resto.model.RestoApp;

public class RestoAppApplication {
	private static RestoApp restoApp;
	private static String filename = "menu.resto";
	
	public static void main(String[] args) {
		
		//getRestoApp();
		// start UI
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateTablePage().setVisible(true);
                new RestoAppPage().setVisible(true);
            }
        });
        
	}
	
	public static RestoApp getRestoApp() {
		if (restoApp == null) {
			// load model
			restoApp = load();
<<<<<<< HEAD
			
=======
>>>>>>> 7d54be830e7ada4f8a79f773ddd35cdcacd90709
					}
	
 		return restoApp;
	}
	
	public static void save() {
		PersistenceObjectStream.serialize(restoApp);
	}	
	public static RestoApp load() {
		PersistenceObjectStream.setFilename(filename);
		restoApp = (RestoApp) PersistenceObjectStream.deserialize();
		// model cannot be loaded - create empty RestoApp
		if (restoApp == null) {
			restoApp = new RestoApp();
		}
		else {
			restoApp.reinitialize();
		}
		return restoApp;
	}
	public static void setFilename(String newFilename) {
		filename = newFilename;
	}
	
	
}
