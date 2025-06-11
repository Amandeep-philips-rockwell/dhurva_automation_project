package team.dhruva.testcases;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;

import team.dhruva.executor.AssetExecutor;
import team.dhruva.executor.WOExecutor;
import team.dhruva.locators.WOLocators;

public class AssetTests extends AssetExecutor implements WOLocators{
	WOExecutor wo_common = new WOExecutor();
	
	String assetCode = "";

	@Test(priority = 1,groups = "Assert")
	public void verify_export_in_tree_view() throws Exception {
		click(ASSETS_MENU);
		click(ALL_ASSETS_SUB_MENU);
		click(TREE_VIEW_ICON);
		click(TABLE_FIRST_ROW_CHECK_BOX);
		List<String> tableData = readTabledatafromAssetTreeView(CUSTOM_ROW_DATA_FOR_ASSET.replace("000", "1"));
		List<String> exportedData = clickExportToDownloadFile(EXPORT_BUTTON, (tableData.size()));
		assertEquals(compareList(exportedData, tableData), true);

	}
	
	@Test(priority = 2,groups = "Assert")
	public void verify_export_in_list_view() throws Exception {
		click(ASSETS_MENU);
		click(ALL_ASSETS_SUB_MENU);
		click(LIST_VIEW_ICON);
		click(TABLE_FIRST_ROW_CHECK_BOX);
		List<String> tableData = readTabledatafromAsset(CUSTOM_ROW_DATA_FOR_ASSET.replace("000", "1"));
		List<String> exportedData = clickExportToDownloadFile(EXPORT_BUTTON, tableData.size());
		assertEquals(compareList(exportedData, tableData), true);
	}
	
	@Test(priority = 3,groups = "Assert")
	public void verify_import() throws Exception {
		click(ASSETS_MENU);
		click(ALL_ASSETS_SUB_MENU);
		click(LIST_VIEW_ICON);
		String[] genData = dataGenForImport();
		create_csv_file(ASSET_HEADER, genData, "ASSET");
		click(IMPORT_BUTTON);
		uploadFile(FILE_UPLOAD_FIELD, "ASSET"+".csv");
		click(CONTINUE_BUTTON);
		click(CONTINUE_BUTTON);
		click(UPLOAD_IMPORT_BUTTON);
		click(UPLOAD_DONE_BUTTON);
		search(SEARCH_BOX, genData[1]);
		Assert.assertEquals(totalRecords(RECORD_COUNT) >= 1, true);
		click(TABLE_FIRST_ROW_FIRST_CELL);
		Thread.sleep(1000);
		Assert.assertEquals(visible(SAVE_BUTTON), true);

	}
	
	@Test(priority = 4,groups = "Assert")
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
				assetCode = getText(ASSET_NAME_EDITBOX);
				click(BACK_BUTTON);
				search(SEARCH_BOX, assetCode);
				Assert.assertEquals(true, totalRecords(RECORD_COUNT) == 1);
			} else if (i == 1) {
				click(NO_SITE_SITE);
				click(SAVE_BUTTON);
				assetCode = getText(ASSET_NAME_EDITBOX);
				click(BACK_BUTTON);
				search(SEARCH_BOX, assetCode);
				Assert.assertEquals(true, totalRecords(RECORD_COUNT) == 1);

			} else {
				click(NO_SITE_SITE);
				click(SAVE_BUTTON);
				assetCode = getText(ASSET_NAME_EDITBOX);
				click(BACK_BUTTON);
				search(SEARCH_BOX, assetCode);
				Assert.assertEquals(true, totalRecords(RECORD_COUNT) == 1);
			}
		}
	}
	
	@Test(priority = 5,groups = "Asset")
	public void check_all_type_file_upload() throws Exception {
		click(ASSETS_MENU);
		click(ALL_ASSETS_SUB_MENU);
		search(SEARCH_BOX, assetCode);
		click(CUSTOM_RECORD_ASSET.replace("000", assetCode));
		click(TAB_NAME.replace("test", "Files"),1000);
		wo_common.fileUploadAllType(FILE_UPLOAD_BUTTON,FILE_UPLOAD_BUTTON_MULTIFILE);
	}
}
