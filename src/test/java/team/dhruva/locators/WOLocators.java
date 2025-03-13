package team.dhruva.locators;

public interface WOLocators {

	String PRIORITY_DROPDOWN = "//div[text()=\"Priority\"]/..//div[@class=\"autoSuggestDropdownButtonContainer35\"]";
	String TABLE_HEADER = "//th//span[@class=\"listHeaderLabel35\"]";
	String FIRST_ROW_DATA = "//tr[1]/td[@class=\"listColumnValueReadOnly\"]//p";
	String TABLE_ROWS_COUNT = "//tr";
	String WO_CODE = "//div[@class=\"formLabel35\"][contains(text(),\"Code\")]/..//p";

	// Labor tasks
	String LABOR_TASKS_ROW = "//div[@id=\"TaskList_tableContainer\"]//tbody/tr";
	String ADD_LABOR_TASK_ICON = "(//div[@class=\"listPagingContainer35\"]//img[@title=\"Add\"])[1]";
	String ADD_TASK_GROUP_ICON = "//div[@class=\"listPagingContainer35\"]//img[@title=\"Add task group\"]";
	String UPDATE_TASK_ICON = "(//div[@title=\"Update Checked\"])[1]";
	String TASK_DESCRIPTION_EDITBOX = "//div[contains(text(),\"Description*\")]/..//textarea";
	String ATTACH_MEDIA_FOR_LABOR_TASK_BUTTON = "//div[@class=\"actionButton media-insert\"]";
	String ADD_MEDIA_BUTTON_X = "//div[@class=\"listPagingContainer35\"]/span[@onclick[contains(.,\"Pane=AttachFileOrMedia\")]]/img";
	String ADD_MEDIA_BUTTON_Y= "//div[@class=\"contentPaneFrameModal\"]//div[@title=\"Click here to upload files\"]";
	String UPLOAD_BUTTON = "//form[@target=\"uploadTrg\"]/div/input[1]";
	String UPLOADING_TXT = "#__MA_FILE_UPLOAD_DIV_ID";
	String UPLOADED_FILE_CHECKBOX_ALL = "//div[@id=\"AttachFileOrMedia_tableContainer\"]//td/input[@type=\"checkbox\"]";
	String UPLOADED_FILE_CHECKBOX = "(//div[@id=\"AttachFileOrMedia_tableContainer\"]//td/input[@type=\"checkbox\"])[1]";
	String FILE_UPLOAD_THUMBNAIL = "//div[@class[contains(.,\"media-thumbnail\")]]";
	String UPLOADING_FILE_SCREEN = "//div[@class=\"dropzone dz-started\"]";
	String WO_TOP_LABEL = "//span[@class=\"listTopLabelLarge\"][contains(text(),\"Work Orders\")]";
	String TASK_GROUP_COUNT_TABLE_ROW = "//span[contains(text(),\"Task Groups\")]/../..//table/tbody/tr/td[2]";
}
