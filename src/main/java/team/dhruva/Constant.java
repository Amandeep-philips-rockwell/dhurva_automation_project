package team.dhruva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Constant {
	// DEV
	String USERNAME = "amandeepphilips";
	String PASSWORD = "12345";
	String URL = "https://punesandbox.fiixdevserver.com/";
	String SELF_SIGNUP = "https://crm.fiixdevserver.com/accounts/signup?package=Lite";

	// STAGE
//String USERNAME = "amandeep.philips";
//String PASSWORD = "12345";
//String URL = "https://dhruva.fiixstg.com/";

//Prod
//String USERNAME = "Amandeep";
//String PASSWORD = "cmms1234";
//String URL = "https://smoketest.macmms.com/";

	List<String> s = new ArrayList<String>(Arrays.asList("General", "Completion", "Labor Tasks", "Parts",
			"Meter Readings", "Purchase Order", "Misc Costs Page", "Notifications", "Files", "Work Log", "Custom"));

// Inport headers
	String[] WO_HEADER = { "Name", "Age", "City" };

}
