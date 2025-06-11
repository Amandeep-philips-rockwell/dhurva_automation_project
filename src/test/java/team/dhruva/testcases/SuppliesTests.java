package team.dhruva.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import team.dhruva.CommonMethods;
import team.dhruva.executor.SuppliesExecutor;
import team.dhruva.executor.WOExecutor;
import team.dhruva.locators.WOLocators;

public class SuppliesTests extends SuppliesExecutor implements WOLocators {

	WOExecutor wo_common = new WOExecutor();

	String partSuppliesName = "";

	@Test(priority = 1, groups = "Supplies")
	public void verify_export_in_tree_view_PnS() throws Exception {
		click(SUPPLIES_MENU);
		click(PART_SUPPLIES_SUB_MENU);
		click(TREE_VIEW_ICON, 1000);
		click(TABLE_FIRST_ROW_CHECK_BOX);
		List<String> tableData = readTabledatafromSuppliesTreeView(
				CUSTOM_ROW_TABLE_DATA_FOR_SUPPLIES.replace("000", "1"));
		List<String> exportedData = clickExportToDownloadFile(EXPORT_BUTTON, (tableData.size()));
		assertEquals(compareList(exportedData, tableData), true);
	}

	@Test(priority = 2, groups = "Supplies")
	public void verify_export_in_list_view_PnS() throws Exception {
		click(SUPPLIES_MENU);
		click(PART_SUPPLIES_SUB_MENU);
		click(LIST_VIEW_ICON, 1000);
		click(TABLE_FIRST_ROW_CHECK_BOX);
		List<String> tableData = readTabledatafromSupplies(CUSTOM_ROW_TABLE_DATA_FOR_SUPPLIES.replace("000", "1"));
		List<String> exportedData = clickExportToDownloadFile(EXPORT_BUTTON, tableData.size());
		assertEquals(compareList(exportedData, tableData), true);
	}

	@Test(priority = 3, groups = "Supplies")
	public void verify_import_PnS() throws Exception {
		click(SUPPLIES_MENU);
		click(PART_SUPPLIES_SUB_MENU);
		String[] genData = dataGenForImportPnS();
		create_csv_file(PnS_HEADER, genData, "P&S");
		click(IMPORT_BUTTON);
		uploadFile(FILE_UPLOAD_FIELD, "P&S" + ".csv");
		click(CONTINUE_BUTTON);
		click(CONTINUE_BUTTON);
		click(UPLOAD_IMPORT_BUTTON);
		click(UPLOAD_DONE_BUTTON);
		search(SEARCH_BOX, genData[1]);
		Assert.assertEquals(totalRecords(RECORD_COUNT) >= 1, true);
		click(TABLE_FIRST_ROW_FIRST_CELL, 1000);
		Assert.assertEquals(visible(SAVE_BUTTON), true);

	}

	@Test(priority = 4, groups = "Supplies")
	public void createPartSupplies() throws Exception {
		click(SUPPLIES_MENU);
		click(PART_SUPPLIES_SUB_MENU);
		click(NEW_BUTTON);
		partSuppliesName = getText(PARTS_SUPPLIES_NAME_EDITBOX);
		click(SAVE_BUTTON);
		click(BACK_BUTTON);
		search(SEARCH_BOX, partSuppliesName);
		assertEquals(totalRecords(RECORD_COUNT) == 1, true);
	}

	@Test(priority = 5, groups = "Supplies")
	public void check_all_type_file_upload() throws Exception {
		click(SUPPLIES_MENU);
		click(PART_SUPPLIES_SUB_MENU);
		search(SEARCH_BOX, partSuppliesName);
		click(TABLE_FIRST_ROW_FIRST_CELL, 1000);
		click(TAB_NAME.replace("test", "Files"), 1000);
		wo_common.fileUploadAllType(FILE_UPLOAD_BUTTON, FILE_UPLOAD_BUTTON_MULTIFILE);
	}
//-----------------------------------/ Current Stock /----------------------------------//

	@Test(priority = 101, groups = "Current Stock")
	public void verify_export_in_current_stock() throws Exception {
		click(SUPPLIES_MENU);
		click(CURRENT_STOCK_SUB_MENU);
		click(TABLE_FIRST_ROW_CHECK_BOX);
		List<String> tableData = readTabledatafromSupplies(CUSTOM_ROW_TABLE_DATA_FOR_SUPPLIES.replace("000", "1"));
		List<String> exportedData = clickExportToDownloadFile(EXPORT_BUTTON, tableData.size());
		assertEquals(compareList(exportedData, tableData), true);
	}

//-----------------------------------/ Inventory Cycle Count /----------------------------------//

	@Test(priority = 301, groups = "Inventory Cycle Count")
	public void verify_export_in_inventory_cycle_count() throws Exception {
		click(SUPPLIES_MENU);
		click(INVENTORY_CYCLE_COUNT_SUB_MENU);
		Thread.sleep(1000);
		List<String> tableData = readTabledatafromSupplies(CUSTOM_ROW_TABLE_DATA_FOR_SUPPLIES.replace("000", "1"));
		List<String> exportedData = clickExportToDownloadFile(EXPORT_BUTTON, tableData.size());
		assertEquals(compareList(exportedData, tableData), true);
	}

//-----------------------------------/ Bill Of Materials Groups /----------------------------------//

	@Test(priority = 401, groups = "BOM groups")
	public void verify_export_in_bill_of_materials_groups() throws Exception {
		click(SUPPLIES_MENU);
		click(BILL_OF_MATERIALS_GROUPS_SUB_MENU);
		click(TABLE_FIRST_ROW_CHECK_BOX);
		List<String> tableData = readTabledatafromSupplies(CUSTOM_ROW_TABLE_DATA_FOR_SUPPLIES.replace("000", "1"));
		List<String> exportedData = clickExportToDownloadFile(EXPORT_BUTTON, tableData.size());
		assertEquals(compareList(exportedData, tableData), true);
	}

//-----------------------------------/ Businesses /----------------------------------//

	@Test(priority = 501, groups = { "Business" })
	public void verify_export_in_businesses() throws Exception {
		click(SUPPLIES_MENU);
		click(BUSINESSES_SUB_MENU);
		click(TABLE_FIRST_ROW_CHECK_BOX);
		List<String> tableData = readTabledatafromSupplies(CUSTOM_ROW_TABLE_DATA_FOR_SUPPLIES.replace("000", "1"));
		List<String> exportedData = clickExportToDownloadFile(EXPORT_BUTTON, tableData.size());
		assertEquals(compareList(exportedData, tableData), true);
	}

	@Test(priority = 502, groups = { "Business" })
	public void verify_import_in_businesses() throws Exception {
		click(SUPPLIES_MENU);
		click(BUSINESSES_SUB_MENU);
		String[] genData = dataGenForImportBusinesses();
		create_csv_file(BUSINESSES_HEADER, genData, "BUSINESSES");
		click(IMPORT_BUTTON, 500);
		uploadFile(FILE_UPLOAD_FIELD, "BUSINESSES" + ".csv");
		click(CONTINUE_BUTTON);
		click(CONTINUE_BUTTON);
		click(UPLOAD_IMPORT_BUTTON);
		click(UPLOAD_DONE_BUTTON);
		search(SEARCH_BOX, genData[1]);
		Assert.assertEquals(totalRecords(RECORD_COUNT) >= 1, true);
		click(TABLE_FIRST_ROW_FIRST_CELL, 1000);
		Assert.assertEquals(visible(SAVE_BUTTON), true);

	}

}
