package team.dhruva.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import team.dhruva.CommonMethods;
import team.dhruva.executor.DashboardExecutor;
import team.dhruva.locators.DashboardLocators;
import team.dhruva.locators.GlobalLocators;
import team.dhruva.locators.WOLocators;

public class DashboardTests extends DashboardExecutor {
	@Test(priority = 1)
	public void create_WO_Verify_Value_On_Dashboard() throws Exception {
		String woCard = getText(HIGH_PRIORITY_WO_CARD);
		click(MAINTANACE_MENU);
		click(WO_SUB_MENU);
		click(NEW_BUTTON);
		click(NO_SITE_SITE);
		dropdown(PRIORITY_DROPDOWN, DROWNDOWN_VALUE_HIGHEST);
		click(SAVE_BUTTON);
		click(DASHBOARD_MENU);
		assertEquals(Integer.parseInt(woCard) + 1, Integer.parseInt(getText(HIGH_PRIORITY_WO_CARD)));
	}
}
