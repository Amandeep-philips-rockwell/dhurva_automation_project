package team.dhruva.locators;

public interface GlobalLocators {
	String DROWNDOWN_VALUE_HIGHEST = "//div[@class=\"modalWindowFrame ui-draggable\"]//p[text()=\"Highest\"]";
	String SAVE_BUTTON = "//div[text()=\"Save\"]";
	String SEARCH_BOX = "//input[contains(@placeholder,\"search\")]";
	String OK_BUTTON = "//div[contains(text(),\"OK\")]";
	String BACK_BUTTON = "//div[@class=\"actionButton action noselect\"]/span[text()=\"Back\"]";
	String TABLE_ROW = "//tbody/tr/td[1]";
	String RECORD_COUNT = "//div[@class=\"listPagingContainer35\"]//span";
	String TABLE_FIRST_ROW_FIRST_CELL = "//tr[1]/td[@class=\"listColumnValueReadOnly\"][2]";
	String IMPORT_BUTTON = "//div/span[@title=\"Import\"]/../span[text()=\"Import\"]";
	String EXPORT_BUTTON = "//div/span[@title=\"Export\"]/../span[text()=\"Export\"]";
	String TABLE_FIRST_ROW_CHECK_BOX = "//tr[1]/td/input[@type=\"checkbox\"]";
	String TABLE_CUSTOM_ROW_ALL_DATA = "//tr[000]/td[@class=\"listColumnValueReadOnly\"]//p";
	String NEW_BUTTON = "//div[@class=\"actionButton action noselect\"]//span[text()=\"New\"]";
	String NO_SITE_SITE = "//div[@class=\"hasBootstrapAlttextTooltip\"]/p[text()=\"(No Site)\"]";
	
	// Menu
	String MAINTANACE_MENU = "//span[@class=\"fiix-expanded\"][contains(text(),\"Maintenance\")]";
	String WO_SUB_MENU = "(//li[contains(text(),'Work Orders')])[2]";
	String SM_SUB_MENU = "//li[contains(text(),'Scheduled Maintenance')]";
	String DASHBOARD_MENU = "//span[@class=\"fiix-expanded\"][contains(text(),\"Dashboard\")]";
	String ASSETS_MENU = "//span[@class=\"fiix-expanded\"][contains(text(),\"Assets\")]";
	String ALL_ASSETS_SUB_MENU = "//li[contains(text(),'All Assets')]";
	String PURCHASING_MENU = "//span[@class=\"fiix-expanded\"][contains(text(),\"Purchasing\")]";
	String SUPPLIES_MENU = "//span[@class=\"fiix-expanded\"][contains(text(),\"Supplies\")]";
	String REPORTS_MENU = "//span[@class=\"fiix-expanded\"][contains(text(),\"Reports\")]";
	String AUDIT_TRAIL_MENU = "//span[@class=\"fiix-expanded\"][contains(text(),\"Audit Trail \")]";
	String PO_SUB_MENU = "//li[contains(text(),'Purchase Orders')]";
	String PO_RECEIPTS_SUB_MENU = "//li[contains(text(),'Receipts')]";
	String PO_RFQs_SUB_MENU = "//li[contains(text(),'RFQs')]";
	String PART_SUPPLIES_SUB_MENU = "//li[contains(text(),'Parts And Supplies')]";
	
	//table
	String CUSTOM_RECORDS = "//td[@class=\"listColumnValueReadOnly\"]//p[text()=\"000\"]";
	
	//Create screen
	String ALL_TABS = "//ul/li/p";
	
	// 

}