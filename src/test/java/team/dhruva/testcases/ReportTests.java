package team.dhruva.testcases;

import org.testng.annotations.Test;

import team.dhruva.executor.ReportExecutor;

public class ReportTests extends ReportExecutor{
	@Test(priority = 1,groups = "Reports")
	public void createVerifyReports() throws Exception {
		click(REPORTS_MENU);
		click(NEW_BUTTON);
		click(DESIGN_REPORTS_BUTTON);
		String reportName = getText(PARTS_SUPPLIES_NAME_EDITBOX);
		selectDropDown(REPORT_CATEGORY_DROPDOWN, "Open Work Order Reports");
		click(SAVE_BUTTON);
		click(DESIGN_TAB);
		click(VIEW_TABLE_HYPERLINK);
		click(SELECT_TABLE_ASSET);
		click(EXPAND_TABLE_ICON);
		dragAndDrop(ROW_CODE, FIELDS_CONTAINER);
		click(SAVE_BUTTON);
		click(RUN_BUTTON);
		click(RUN_BUTTON_POPUP);
//		Thread.sleep(5000);
		waitforElementInvisible(GENERATING_REPORT_POPUP);
		switchToNewlOpenTab();
	}
}
