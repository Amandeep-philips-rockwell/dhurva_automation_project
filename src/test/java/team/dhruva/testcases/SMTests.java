package team.dhruva.testcases;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

import team.dhruva.executor.SMExecutor;
import team.dhruva.locators.GlobalLocators;
import team.dhruva.locators.SMLocators;

public class SMTests extends SMExecutor implements GlobalLocators,SMLocators{
	@Test(priority = 3)
	public void verify_export() throws Exception {
		click(MAINTANACE_MENU);
		click(SM_SUB_MENU); 
		click(TABLE_FIRST_ROW_CHECK_BOX);
		 List<String> exportedData = clickkExportToDownloadFile(EXPORT_BUTTON);
	    List<String> tableData = getAllElements(TABLE_CUSTOM_ROW_ALL_DATA.replace("000", "1")).allTextContents();
	    List<String> fixdata = fixDataForSM(tableData);
	    assertEquals(compareList(exportedData,splitAndMerge(fixdata)), true);
	}
}
