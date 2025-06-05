package team.dhruva.testcases;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import team.dhruva.executor.SMExecutor;
import team.dhruva.locators.GlobalLocators;
import team.dhruva.locators.SMLocators;

public class SMTests extends SMExecutor {
	
	String smCode = "";
//	String smCode = "SM12251";
	
	@Test(priority = 1,groups = "SM")
	public void verify_export_in_SM() throws Exception {
		click(MAINTANACE_MENU);
		click(SM_SUB_MENU);
		click(TABLE_FIRST_ROW_CHECK_BOX);
		List<String> fixdata = readTabledatafromSM(TABLE_CUSTOM_ROW_ALL_DATA.replace("000", "1"));

		List<String> exportedData = clickExportToDownloadFile(EXPORT_BUTTON, fixdata.size());

		assertEquals(compareList(exportedData, fixdata), true);
	}

	@Test(priority = 2,groups = "SM")
	public void verify_import_in_SM() throws Exception {
		click(MAINTANACE_MENU);
		click(SM_SUB_MENU);
		String[] genData = dataGenForImport();
		create_csv_file(WO_HEADER, genData, "SM");
		click(IMPORT_BUTTON);
		uploadFile(FILE_UPLOAD_FIELD, "SM" + ".csv");
		click(CONTINUE_BUTTON);
		click(CONTINUE_BUTTON);
		click(UPLOAD_IMPORT_BUTTON);
		click(UPLOAD_DONE_BUTTON);
		search(SEARCH_BOX, genData[0]);
		Assert.assertEquals(totalRecords(RECORD_COUNT) >= 1, true);
		click(TABLE_FIRST_ROW_FIRST_CELL);
		Thread.sleep(1000);
		Assert.assertEquals(visible(SAVE_BUTTON), true);
	}

	@Test(priority = 3,groups = "SM")
	public void create_SM_Verify_On_Table_From_Search() throws Exception {
		click(MAINTANACE_MENU);
		click(SM_SUB_MENU);
		click(NEW_BUTTON);
		click(NO_SITE_SITE);
		click(SAVE_BUTTON);
		smCode = getText(SM_CODE_EDITBOX);
		click(BACK_BUTTON);
		search(SEARCH_BOX, smCode);
		assertEquals(true, totalRecords(RECORD_COUNT) == 1);
	}

	@Test(priority = 4,groups = "SM")
	public void verify_all_tabs_present_in_SM() throws Exception {
		click(CUSTOM_RECORDS.replace("000", smCode));
		Thread.sleep(1000);
		List<String> SMTabs = getAllElements(ALL_TABS).allTextContents();
		assertEquals(compareList(SMTabs, SM_TABS), true);

	}
	
	@Test(priority = 5,groups = "SM")
	public void add_tasks_in_SM() throws Exception {
		click(MAINTANACE_MENU);
		click(SM_SUB_MENU,1000);
		search(SEARCH_BOX, smCode);
		click(CUSTOM_RECORDS.replace("000", smCode));
		click(TAB_NAME.replace("test", "Labor Tasks"));
		assertEquals(totalElement(LABOR_TASKS_ROW),1);
		addLaborTasks(2);
		Thread.sleep(1000);
		assertEquals(totalElement(LABOR_TASKS_ROW),2);
		click(SAVE_BUTTON);

	}

	@Test(priority = 6,groups = "SM")
	public void add_task_groups_in_SM() throws Exception {
		page_check();
		search(SEARCH_BOX, smCode);
		click(CUSTOM_RECORDS.replace("000", smCode));
		click(TAB_NAME.replace("test", "Labor Tasks"));
		addTaskGroups();

	}
	
	@Test(priority = 7,groups = "SM")
	public void create_and_verify_all_types_of_scheduler() throws Exception {
		page_check();
		search(SEARCH_BOX, smCode);
		click(CUSTOM_RECORDS.replace("000", smCode));
		click(TAB_NAME.replace("test", "Scheduling"));
		addAllTypeTrigger();

	}
	
	@Test(priority = 8,groups = "SM")
	public void check_all_type_file_upload_in_SM() throws Exception {
		page_check();
		search(SEARCH_BOX, smCode);
		click(CUSTOM_RECORDS.replace("000", smCode));
		click(TAB_NAME.replace("test", "Files"),1000);
		fileUploadAllType(FILE_UPLOAD_BUTTON,FILE_UPLOAD_BUTTON_MULTIFILE);
	}
}
