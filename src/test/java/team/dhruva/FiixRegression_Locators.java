package team.dhruva;

public interface FiixRegression_Locators {
	
	
	// Global
	String DROWNDOWN_VALUE_HIGHEST = "//div[@class=\"modalWindowFrame ui-draggable\"]//p[text()=\"Highest\"]";
	String SAVE_BUTTON = "//div[text()=\"Save\"]";
	String SEARCH_BOX = "//input[contains(@placeholder,\"search\")]";
	String OK_BUTTON = "//div[contains(text(),\"OK\")]";
	String BACK_BUTTON = "//div[@class=\"actionButton action noselect\"]/span[text()=\"Back\"]";
	String TABLE_ROW = "//tbody/tr/td[1]";
	String RECORD_COUNT = "//div[@class=\"listPagingContainer35\"]//span";
	String TABLE_FIRST_ROW_FIRST_CELL = "//tr[1]/td[@class=\"listColumnValueReadOnly\"][2]";
	
	//Login screen
	
	String USERNAME_FIELD = "//input[@id=\"j_username\"]";
	String PASSWORD_FIELD = "//input[@id=\"j_password\"]";
	String SIGNIN_BUTTON = "//input[@class=\"loginButton\"]";
	
	// Dashboard
	
	String DASHBOARD_CARDS = "//div[@class=\"react-grid-item widgetWrapper cssTransforms\"]";
	String FIXX_HEADER = "//div[@class=\"pk-logobar-g\"]";
	String ACTIVE_ADMIN_DASHBOARD = "//div[@class=\"active dashboardTab\"]";
	String HIGH_PRIORITY_WO_CARD = "//span[contains(text(),\"High Priority Work Orders\")]/../../../..//div[@class=\"value\"]";

	
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


	
	// Work Order
	String NEW_BUTTON = "//div[@class=\"actionButton action noselect\"]//span[text()=\"New\"]";
	String NO_SITE_SITE = "//div[@class=\"hasBootstrapAlttextTooltip\"]/p[text()=\"(No Site)\"]";
	String PRIORITY_DROPDOWN = "//div[text()=\"Priority\"]/..//div[@class=\"autoSuggestDropdownButtonContainer35\"]";
	String TABLE_HEADER = "//th//span[@class=\"listHeaderLabel35\"]";
	String FIRST_ROW_DATA = "//tr[1]/td[@class=\"listColumnValueReadOnly\"]//p";
	String TABLE_ROWS_COUNT = "//tr";
	
	// Assert
	String ALL_ASSET_TYPE_SELECTION = "//div[@class=\"AssetTypeSelectContainer\"]/div/div";
	String ASSET_NAME_EDITBOX = "//div[@class=\"formExtraLarge\"]/input";
	
	// Schedule maintainence
	String SM_CODE_EDITBOX = "//div[@class=\"formLabel35\"][contains(text(),\"Code\")]/..//input";
	
	// Purchase Order
	String PURCHASE_ORDER_NO = "//table[@class=\"mainFormContainer35\"]//span[contains(text(),\"Purchase Order: PO#\")]";
	String SUBMIT_FOR_APPROVAL_BUTTON = "//div[@class=\"actionButton action\"]/span[contains(text(),\"Submit For Approval\")]";
	String COMMENT_TEXT_FIELD = "//div[contains(text(),\"Comments to attach\")]/..//textarea";
	String APPROVE_PURCHASE_ORDER_BUTTON = "//div[@class=\"actionButton action\"]/span[contains(text(),\"Approve Purchase Order\")]";
	String CANCEL_PURCHASE_ORDER_BUTTON = "//div[@class=\"actionButton action\"]/span[contains(text(),\"Cancel Purchase Order\")]";
	String PO_STATUS_TEXT = "(//td[@valign=\"top\"]//div[@class=\"formCellInside35\"]/div)[2]";
	String CUSTOM_PO_CODE = "//td[@class=\"listColumnValueReadOnly\"]//p[text()=\"000\"]";

	// Receitps
	String PO_RECEIPTS_NO = "//table[@class=\"mainFormContainer35\"]//span[contains(text(),\"Receipt: R#\")]";
	String PO_RECIPTS_STATUS_TEXT = "(//td[@valign=\"top\"]//div[@class=\"formCellInside35\"]/div)[1]";
	String DRAFT_TO_RECEIVED_BUTTON = "//div[@class=\"actionButton action\"]/span[contains(text(),\"Set Draft To Received\")]";
	String SUPPLIERS_DROPDOWN = "(//td[@valign=\"top\"]//div[@class=\"formCellInside35\"]/div)[2]//div[@onclick]";
	String FIRST_SUPPLIER_ROW = "//div[@class=\"modalWindowFrame ui-draggable\"]//table//tr[1]/td[1]";
	String RECEIPTS_STATUS_ON_TABLE = "//td[@class=\"listColumnValueReadOnly\"]//p[text()=\"000\"]/../../..//p[text()=\"test\"]";
	
	//RFQs
	String SHIPPING_AND_RECEIVING_TAB = "//li/p[text()=\"Shipping/Receiving\"]";
	String SUPPIER_DROPDOWN_ARROW = "//div[text()=\"Supplier\"]/..//td[2]";
	String RFQ_NO = "//table[@class=\"mainFormContainer35\"]//span[contains(text(),\"RFQ: RFQ#\")]";
	String SEND_RFQ_BUTTON = "//div[@class=\"actionButtons\"]//span[contains(text(),\"Send RFQ\")]";
	String RFQ_QUOTE_NUMBER = "//div[text()=\"Quote #\"]/..//input";
	
	//Part and Supplies
	String PARTS_SUPPLIES_NAME_EDITBOX = "//div[@class=\"formExtraLarge\"]/input";

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
	
	//Audit trail
	String START_DATE_PICKER = "//label[@title=\"Start Date\"]/../..//mat-datepicker-toggle/button";
	String END_DATE_PICKER = "//label[@title=\"End Date\"]/../..//span[@class=\"mat-mdc-button-touch-target\"]";
	String PREVIOS_MONTH_ARROW = "//button[@aria-label=\"Previous month\"]";
	String ALL_DATE_SELECTOR = "//td[@role=\"gridcell\"]/button[not (contains(@aria-disabled,\"true\"))]";
	String IFRAME_ID = "#v6IframeId";
	String DOWNLOAD_BUTTON = "//button[@name=\"download-button\"]";
	String DOWNLOAD_LOADER = "//*[text()=\"This can take up to 2 minutes. Please stay on this page until the download is complete.\"]";
	String EQUIPMENT_TAB = "#equipmentTab";

	//self Signup
	String CAPCHA = "//div[@class=\"first-form-wrapper\"]/img";
}
