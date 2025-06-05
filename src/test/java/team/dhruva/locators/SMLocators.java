package team.dhruva.locators;

public interface SMLocators {

	String SM_CODE_EDITBOX = "//div[@class=\"formLabel35\"][contains(text(),\"Code\")]/..//input";
	String SM_TOP_LABEL = "//span[@class=\"listTopLabelLarge\"][contains(text(),\"Scheduled Maintenance List\")]";
	String LABOR_TASKS_ROW = "//div[@id=\"TaskList_tableContainer\"]//tbody/tr";
	
	String ADD_LABOR_TASK_ICON = "(//div[@class=\"listPagingContainer35\"]//img[@title=\"Add\"])[3]";
	String ADD_TASK_GROUP_ICON = "//div[@class=\"listPagingContainer35\"]//img[@title=\"Add task group\"]";
	String UPDATE_TASK_ICON = "(//div[@title=\"Update Checked\"])[1]";
	String TASK_DESCRIPTION_EDITBOX = "//div[contains(text(),\"Description*\")]/..//textarea";
	String ATTACH_MEDIA_FOR_LABOR_TASK_BUTTON = "//div[@class=\"actionButton media-insert\"]";
	String ADD_MEDIA_BUTTON_X = "//div[@class=\"listPagingContainer35\"]/span[@onclick[contains(.,\"Pane=AttachFileOrMedia\")]]/img[@title=\"Add\"]";
	String ADD_MEDIA_BUTTON_Y= "//div[@class=\"contentPaneFrameModal\"]//div[@title=\"Click here to upload files\"]";
	String UPLOAD_BUTTON = "//form[@target=\"uploadTrg\"]/div/input[1]";
	String UPLOADING_TXT = "#__MA_FILE_UPLOAD_DIV_ID";
	String UPLOADED_FILE_CHECKBOX = "(//div[@id=\"AttachFileOrMedia_tableContainer\"]//td/input[@type=\"checkbox\"])[1]";
	String FILE_UPLOAD_THUMBNAIL = "//div[@class[contains(.,\"media-thumbnail\")]]";
	String UPLOADING_FILE_SCREEN = "//div[@class=\"dropzone dz-started\"]";
	String TASK_GROUP_COUNT_TABLE_ROW = "//span[contains(text(),\"Task Groups\")]/../..//table/tbody/tr/td[2]";
	
	//scheduling
	String ADD_TRIGGER_ICON = "(//div[@class=\"listPagingContainer35\"]//img[@title=\"Add\"])[1]";
	String TIME_SCHEDULE_RADIO_BUTTON = "//span[contains(text(),\"Time Schedule\")]/../..//input";
	String METER_READING_RADIO_BUTTON = "//span[contains(text(),\"Meter Reading\")]/../..//input";
	String EVENT_TRIGGER_RADIO_BUTTON = "//span[contains(text(),\"Event Trigger\")]/../..//input";
	String TRIGGER_DESCRIPTION_TABLE = "//span[contains(text(),\"Trigger Description\")]/../../../../..//tbody//tr";
	String EVENT_TRIGGER_NAME_DROPDOWN = "#ASSET_EVENT_TYPE_btn";
	String EVENT_SCREEN_FIRST_ROW = "//span[contains(text(),\"Asset Event Types\")]/../..//table//tr[1]/td[2]";
	
	//files tab
	String FILE_UPLOAD_BUTTON = "//div[@class=\"listPagingContainer35\"]//select/option[text()=\"File\"]/../../..//img[@title=\"Add\"]";
	String FILE_UPLOAD_BUTTON_MULTIFILE = "//div[contains(@id,\"tabPage_Files_tabpage\")]//div[@title=\"Click here to upload files\"]";
	String FILE_TYPE_DROPDOWN = "//div[contains(@data-cell-element-id,\"intFileTypeID\")]//select";
	String FILE_UPLOAD_BOX = "//img[@src=\"/pg/upload-button.png\"]/../input[1]";
	String NOTES_TEXTFEILD = "//span[contains(text(),\"Scheduled Maintenance File\")]/../..//textarea";
	String ALL_TABLE_ROW_DATA = "//div[@id=\"Files_tableContainer\"]//table//tr[1]/td";
	String ALL_TABLE_ROW_FOR_FILES = "//div[@id=\"Files_tableContainer\"]//table//tr";
	String SPECIFIC_CLICK_ON_FILE_TAB_FOR_DOWNLOAD = "//div[@id=\"Files_tableContainer\"]//table//tr[00]/td[5]//a";
	String CUSTOME_NOTES_CHECK = "//p[text()=\"xx file type\"]";
	String CUSTOME_HREF = "//p[text()=\"xx file type\"]/../../..//a[@href]";
	String MULTIFILE_DROP_ZONE = "//div[@class=\"dropzone dz-started\"]";
}
