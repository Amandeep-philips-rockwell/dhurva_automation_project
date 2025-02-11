package team.dhruva.testcases;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.FileChooser.SetFilesOptions;

import team.dhruva.executor.WOExecutor;
import team.dhruva.locators.GlobalLocators;
import team.dhruva.locators.WOLocators;

public class WOTests extends WOExecutor {
	String woCode = null;

	@Test(priority = 1)
	public void verify_import() throws Exception {
		click(MAINTANACE_MENU);
		click(WO_SUB_MENU);
		String[] genData = dataGenForImport();
		create_csv_file(WO_HEADER, genData, "WO");
		click(IMPORT_BUTTON);
		uploadFile(FILE_UPLOAD_FIELD, "WO");
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

	@Test(priority = 2)
	public void verify_export() throws Exception {
		click(MAINTANACE_MENU);
		click(WO_SUB_MENU);
		click(TABLE_FIRST_ROW_CHECK_BOX);
		List<String> tableData = readTabledatafromSupplies(TABLE_CUSTOM_ROW_ALL_DATA.replace("000", "1"));
		List<String> exportedData = clickExportToDownloadFile(EXPORT_BUTTON, tableData.size());

		assertEquals(compareList(exportedData, tableData), true);
	}

	@Test(priority = 3)
	public void create_WO_Verify_Using_Search() throws Exception {
		click(MAINTANACE_MENU);
		click(WO_SUB_MENU);
		click(NEW_BUTTON);
		click(NO_SITE_SITE);
		click(SAVE_BUTTON);
		woCode = getText(WO_CODE);
		click(BACK_BUTTON);
		search(SEARCH_BOX, woCode);
		assertEquals(true, totalRecords(RECORD_COUNT) >= 1);
	}

	@Test(priority = 4)
	public void verify_all_tabs_present() throws Exception {
		click(CUSTOM_RECORDS.replace("000", woCode));
		Thread.sleep(1000);
		List<String> WOTabs = getAllElements(ALL_TABS).allTextContents();
		assertEquals(compareList(WOTabs, s), true);

	}

}
