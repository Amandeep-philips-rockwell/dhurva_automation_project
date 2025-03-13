package team.dhruva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Constant {
	// DEV
//	String USERNAME = "amandeepphilips";
//	String PASSWORD = "12345";
//	String URL = "https://punesandbox.fiixdevserver.com/";
	String SELF_SIGNUP = "https://crm.fiixdevserver.com/accounts/signup?package=Lite";

	// STAGE
String USERNAME = "amandeep.philips";
String PASSWORD = "12345";
String URL = "https://dhruva.fiixstg.com/";

//Prod
//String USERNAME = "Amandeep";
//String PASSWORD = "cmms1234";
//String URL = "https://smoketest.macmms.com/";
	
//Zilla
//	
//	String USERNAME = "apzuser";
//	String PASSWORD = "12345";
//	String URL = "https://apent.fiixzilla.ninja/";
	
	

	List<String> WO_TABS = new ArrayList<String>(Arrays.asList("General", "Completion", "Labor Tasks", "Parts",
			"Meter Readings", "Purchase Order", "Misc Costs Page", "Notifications", "Files", "Work Log", "Custom"));

	List<String> SM_TABS = new ArrayList<String>(Arrays.asList("General", "Scheduling", "Nested PMs","Labor Tasks", "Parts",
			 "Notifications","Notes", "Files", "Log"));
	
// Inport headers
	String[] WO_HEADER = { "Code", "Description", "Status" };
	String[] SM_HEADER = { "Code", "Description" };
	String[] ASSET_HEADER = { "Name", "Code", "Description" };
	String[] PnS_HEADER = { "Name", "Code", "Description" };
	String[] BUSINESSES_HEADER = { "Code", "Name", "Address" };


}
