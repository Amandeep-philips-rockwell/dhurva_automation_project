package team.dhruva.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;

import team.dhruva.executor.AssetExecutor;

public class AssetTests extends AssetExecutor{
	@Test(priority = 5)
	public void create_All_Type_assert_Verify_On_Table_From_Search() throws Exception {
		click(ASSETS_MENU);
		click(ALL_ASSETS_SUB_MENU);
		click(NEW_BUTTON);
		Thread.sleep(2000);
		Locator elements = page.locator(ALL_ASSET_TYPE_SELECTION);
		int count = elements.count();
		for (int i = 0; i < count; i++) {
			if (i != 0) {
				click(NEW_BUTTON);
			}
			elements.nth(i).click();
			if (i == 0) {
				click(OK_BUTTON);
				click(SAVE_BUTTON);
				String assetName = getText(ASSET_NAME_EDITBOX);
				click(BACK_BUTTON);
				search(SEARCH_BOX, assetName);
				Assert.assertEquals(true, totalRecords(RECORD_COUNT) == 1);
			} else if (i == 1) {
				click(NO_SITE_SITE);
				click(SAVE_BUTTON);
				String assetName = getText(ASSET_NAME_EDITBOX);
				click(BACK_BUTTON);
				search(SEARCH_BOX, assetName);
				Assert.assertEquals(true, totalRecords(RECORD_COUNT) == 1);

			} else {
				click(NO_SITE_SITE);
				click(SAVE_BUTTON);
				String assetName = getText(ASSET_NAME_EDITBOX);
				click(BACK_BUTTON);
				search(SEARCH_BOX, assetName);
				Assert.assertEquals(true, totalRecords(RECORD_COUNT) == 1);
			}
		}
	}
}
