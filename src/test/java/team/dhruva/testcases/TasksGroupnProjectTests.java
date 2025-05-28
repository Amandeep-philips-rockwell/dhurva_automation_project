package team.dhruva.testcases;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import team.dhruva.executor.TasksGroupnProjectExecutor;

public class TasksGroupnProjectTests extends TasksGroupnProjectExecutor {
	public String tasksName = ""; 
	@Test(priority = 1,groups = "Tasks Groups")
	public void verify_import_in_task_groups() throws Exception {
		click(MAINTANACE_MENU);
		click(TASK_GROUPS_SUB_MENU);
		String[] genData = dataGenForImport();
		create_csv_file(TASKGROUP_HEADER, genData, "TG");
		click(IMPORT_BUTTON);
		uploadFile(FILE_UPLOAD_FIELD, "TG"+".csv");
		click(CONTINUE_BUTTON);
		click(CONTINUE_BUTTON);
		click(UPLOAD_IMPORT_BUTTON);
		click(UPLOAD_DONE_BUTTON);
		search(SEARCH_BOX, genData[0]);
		Assert.assertEquals(totalRecords(RECORD_COUNT) >= 1, true);
		click(TABLE_FIRST_ROW_FIRST_CELL);
		Thread.sleep(1000);
		Assert.assertEquals(visible(TASKGROUP_POPUP_SCREEN_LABLE), true);
		click(OK_BUTTON);
	}
	
	@Test(priority = 2,groups = "Tasks Groups")
	public void verify_export_in_task_groups() throws Exception {
		click(MAINTANACE_MENU);
		click(TASK_GROUPS_SUB_MENU);
		click(TABLE_FIRST_ROW_CHECK_BOX);
		List<String> tableData = readTabledata(TABLE_CUSTOM_ROW_ALL_DATA.replace("000", "1"));
		List<String> exportedData = clickExportToDownloadFile(EXPORT_BUTTON, tableData.size());
		assertEquals(compareList(exportedData, tableData), true);
	}
	
	@Test(priority = 3,groups = "Tasks Groups")
	public void create_new_taskgroup_verify_using_search() throws Exception {
		click(MAINTANACE_MENU);
		click(TASK_GROUPS_SUB_MENU);
		click(NEW_BUTTON);
		tasksName = getText(TASK_GROUP_NAME_EDITBOX);
		click(OK_BUTTON);
		search(SEARCH_BOX, tasksName);
		assertEquals(true, totalRecords(RECORD_COUNT) >= 1);
	}
	
//----------------------------------------/ Projects /------------------------------------------
	
	
	@Test(priority = 101,groups = "Project")
	public void verify_export_in_projects() throws Exception {
		click(MAINTANACE_MENU);
		click(PROJECTS_SUB_MENU);
		click(TABLE_FIRST_ROW_CHECK_BOX);
		List<String> tableData = readTabledata(TABLE_CUSTOM_ROW_ALL_DATA.replace("000", "1"));
		List<String> exportedData = clickExportToDownloadFile(EXPORT_BUTTON, tableData.size());
		assertEquals(compareList(exportedData, tableData), true);
	}
	
	
	@Test(priority = 102,groups = "Project")
	public void create_new_projects_verify_using_search() throws Exception {
		click(MAINTANACE_MENU);
		click(PROJECTS_SUB_MENU);
		click(NEW_BUTTON);
		click(NO_SITE_SITE);
		click(SAVE_BUTTON);
		String projectName = getText(TASK_GROUP_NAME_EDITBOX);
		click(BACK_BUTTON);
		search(SEARCH_BOX, projectName);
		assertEquals(true, totalRecords(RECORD_COUNT) >= 1);
	}
}
