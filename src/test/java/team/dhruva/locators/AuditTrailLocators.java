package team.dhruva.locators;

public interface AuditTrailLocators {

	//Audit trail
	String START_DATE_PICKER = "//label[@title=\"Start Date\"]/../..//mat-datepicker-toggle/button";
	String END_DATE_PICKER = "//label[@title=\"End Date\"]/../..//span[@class=\"mat-mdc-button-touch-target\"]";
	String PREVIOS_MONTH_ARROW = "//button[@aria-label=\"Previous month\"]";
	String ALL_DATE_SELECTOR = "//td[@role=\"gridcell\"]/button[not (contains(@aria-disabled,\"true\"))]";
	String IFRAME_ID = "#v6IframeId";
	String DOWNLOAD_BUTTON = "//button[@name=\"download-button\"]";
	String DOWNLOAD_LOADER = "//*[text()=\"This can take up to 2 minutes. Please stay on this page until the download is complete.\"]";
	String EQUIPMENT_TAB = "#equipmentTab";

	
}
