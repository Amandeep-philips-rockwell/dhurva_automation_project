package team.dhruva.testcases;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

import com.microsoft.playwright.FileChooser.SetFilesOptions;

import team.dhruva.executor.WOExecutor;
import team.dhruva.locators.GlobalLocators;
import team.dhruva.locators.WOLocators;

public class WOTests extends WOExecutor implements WOLocators,GlobalLocators {
	String woCode = null;
//	@Test(priority = 1)
//	public void create_WO_Verify_Using_Search() throws Exception {
//		click(MAINTANACE_MENU);
//		click(WO_SUB_MENU); 
//		click(NEW_BUTTON);
//		click(NO_SITE_SITE);
//		click(SAVE_BUTTON);
//		woCode = getText(WO_CODE);
//		click(BACK_BUTTON);
//		search(SEARCH_BOX, woCode);
//		assertEquals(true, totalRecords(RECORD_COUNT) >= 1);
//	}
//	@Test(priority = 2)
//	public void verify_all_tabs_present() throws Exception {
//	click(CUSTOM_RECORDS.replace("000", woCode));
//	Thread.sleep(1000);
//    List<String> WOTabs = getAllElements(ALL_TABS).allTextContents();
//	assertEquals(compareList(WOTabs,s), true);
//
//	}
//	
//	
	@Test(priority = 3)
	public void verify_import() throws Exception {
		create_csv_file(WO_HEADER, dataGenForImport(),"wo");

	}
	
//	@Test(priority = 3)
//	public void verify_export() throws Exception {
//		click(MAINTANACE_MENU);
//		click(WO_SUB_MENU); 
//		click(TABLE_FIRST_ROW_CHECK_BOX);
//		 List<String> exportedData = clickkExportToDownloadFile(EXPORT_BUTTON);
//	    List<String> tableData = getAllElements(TABLE_CUSTOM_ROW_ALL_DATA.replace("000", "1")).allTextContents();
//	    
//	    assertEquals(compareList(exportedData,splitAndMerge(tableData)), true);
//	}
}
 