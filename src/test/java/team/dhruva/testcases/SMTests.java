package team.dhruva.testcases;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import team.dhruva.executor.SMExecutor;
import team.dhruva.locators.GlobalLocators;
import team.dhruva.locators.SMLocators;

public class SMTests extends SMExecutor {
	@Test(priority = 1)
	public void verify_export() throws Exception {
		click(MAINTANACE_MENU);
		click(SM_SUB_MENU);
		click(TABLE_FIRST_ROW_CHECK_BOX);
		List<String> fixdata = readTabledatafromSM(TABLE_CUSTOM_ROW_ALL_DATA.replace("000", "1"));

		List<String> exportedData = clickExportToDownloadFile(EXPORT_BUTTON, fixdata.size());

		assertEquals(compareList(exportedData, fixdata), true);
	}

	@Test(priority = 2)
	public void verify_import() throws Exception {
		click(MAINTANACE_MENU);
		click(SM_SUB_MENU);
		String[] genData = dataGenForImport();
		create_csv_file(WO_HEADER, genData, "SM");
		click(IMPORT_BUTTON);
		uploadFile(FILE_UPLOAD_FIELD, "SM");
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

	@Test(priority = 3)
	public void create_SM_Verify_On_Table_From_Search() throws Exception {
		click(MAINTANACE_MENU);
		click(SM_SUB_MENU);
		click(NEW_BUTTON);
		click(NO_SITE_SITE);
		click(SAVE_BUTTON);
		String smCode = getText(SM_CODE_EDITBOX);
		click(BACK_BUTTON);
		search(SEARCH_BOX, smCode);
		assertEquals(true, totalRecords(RECORD_COUNT) == 1);
	}
}
