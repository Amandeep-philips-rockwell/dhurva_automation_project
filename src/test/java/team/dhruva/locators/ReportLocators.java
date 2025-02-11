package team.dhruva.locators;

public interface ReportLocators {

	//Reports
	String DESIGN_REPORTS_BUTTON = "//div[@class=\"modalWindowFrame ui-draggable\"]//p[text()=\"Designer Report\"]";
	String REPORT_CATEGORY_DROPDOWN = "//div[text()=\"Report Category\"]/..//select";
	String REPORT_TYPE = "//div[text()=\"Report Category\"]/..//select/option[text()=\"test\"]";
	String DESIGN_TAB = "//li/p[text()=\"Design\"]";
	String VIEW_TABLE_HYPERLINK = "//a[text()=\"click here to pick the main table\"]";
	String SELECT_TABLE_ASSET = "//tbody/tr/td/div[text()=\"Asset\"]";
	String EXPAND_TABLE_ICON = "//img[@src=\"/pg/list/expand.png\"]";
	String ROW_CODE = "//span[text()=\"Code\"]";
	String FIELDS_CONTAINER = "//div[@id=\"fields_tableContainer\"]";
	String RUN_BUTTON = "//span[@id=\"contextButtonRun\"]";
	String RUN_BUTTON_POPUP = "(//span[@id=\"contextButtonRun\"])[2]";
	String GENERATING_REPORT_POPUP = "//p[text()=\"Generating report...\"]";
	
	
}
