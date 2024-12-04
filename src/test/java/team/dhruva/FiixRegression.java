package team.dhruva;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;

public class FiixRegression extends CommonMethods implements FiixRegression_Locators {

	@Test(priority = 1)
	public void verify_Login() throws Exception {
		String title = page.title();
		assertEquals("Fiix", title);
		type(USERNAME_FIELD, USERNAME);
		type(PASSWORD_FIELD, PASSWORD);
		click(SIGNIN_BUTTON);
		Thread.sleep(2000);
		assertEquals(true, visible(FIXX_HEADER));

	}
//
//	@Test(priority = 2)
//	public void verify_Dashboard() throws Exception {
//		assertEquals(true, totalElement(DASHBOARD_CARDS) >= 7);
//		assertEquals(true, visible(ACTIVE_ADMIN_DASHBOARD));
//
//	}
//
//	@Test(priority = 3)
//	public void create_WO_Verify_Value_On_Dashboard() throws Exception {
//		String woCard = getText(HIGH_PRIORITY_WO_CARD);
//		click(MAINTANACE_MENU);
//		click(WO_SUB_MENU);
//		click(NEW_BUTTON);
//		click(NO_SITE_SITE);
//		dropdown(PRIORITY_DROPDOWN, DROWNDOWN_VALUE_HIGHEST);
//		click(SAVE_BUTTON);
//		click(DASHBOARD_MENU);
//		assertEquals(Integer.parseInt(woCard) + 1, Integer.parseInt(getText(HIGH_PRIORITY_WO_CARD)));
//	}
//
//	@Test(priority = 4)
//	public void create_SM_Verify_On_Table_From_Search() throws Exception {
//		click(MAINTANACE_MENU);
//		click(SM_SUB_MENU);
//		click(NEW_BUTTON);
//		click(NO_SITE_SITE);
//		click(SAVE_BUTTON);
//		String smCode = getText(SM_CODE_EDITBOX);
//		click(BACK_BUTTON);
//		search(SEARCH_BOX, smCode);
//		assertEquals(true, totalRecords(RECORD_COUNT) == 1);
//	}
//
//	@Test(priority = 5)
//	public void create_All_Type_assert_Verify_On_Table_From_Search() throws Exception {
//		click(ASSETS_MENU);
//		click(ALL_ASSETS_SUB_MENU);
//		click(NEW_BUTTON);
//		Thread.sleep(2000);
//		Locator elements = page.locator(ALL_ASSET_TYPE_SELECTION);
//		int count = elements.count();
//		for (int i = 0; i < count; i++) {
//			if (i != 0) {
//				click(NEW_BUTTON);
//			}
//			elements.nth(i).click();
//			if (i == 0) {
//				click(OK_BUTTON);
//				click(SAVE_BUTTON);
//				String assetName = getText(ASSET_NAME_EDITBOX);
//				click(BACK_BUTTON);
//				search(SEARCH_BOX, assetName);
//				assertEquals(true, totalRecords(RECORD_COUNT) == 1);
//			} else if (i == 1) {
//				click(NO_SITE_SITE);
//				click(SAVE_BUTTON);
//				String assetName = getText(ASSET_NAME_EDITBOX);
//				click(BACK_BUTTON);
//				search(SEARCH_BOX, assetName);
//				assertEquals(true, totalRecords(RECORD_COUNT) == 1);
//
//			} else {
//				click(NO_SITE_SITE);
//				click(SAVE_BUTTON);
//				String assetName = getText(ASSET_NAME_EDITBOX);
//				click(BACK_BUTTON);
//				search(SEARCH_BOX, assetName);
//				assertEquals(true, totalRecords(RECORD_COUNT) == 1);
//			}
//		}
//	}
//
//	@Test(priority = 6)
//	public void create_Purshase_Order() throws Exception {
//		click(PURCHASING_MENU);
//		click(PO_SUB_MENU);
//		click(NEW_BUTTON);
//		click(NO_SITE_SITE);
//		click(SAVE_BUTTON);
//		String poCode = getText(PURCHASE_ORDER_NO);
//		poCode = poCode.replace("Purchase Order: PO#", "");
//		Thread.sleep(1000);
//		assertEquals(true, getText(PO_STATUS_TEXT).contains("Draft"));
//		click(BACK_BUTTON);
//		search(SEARCH_BOX, poCode);
//		assertEquals(true, totalRecords(RECORD_COUNT) >= 1);
//		click(CUSTOM_PO_CODE.replace("000", poCode));
//		click(SUBMIT_FOR_APPROVAL_BUTTON);
//		type(COMMENT_TEXT_FIELD, "test");
//		click(OK_BUTTON);
//		Thread.sleep(1000);
//		assertEquals(true, getText(PO_STATUS_TEXT).contains("Waiting For Approval"));
//		click(APPROVE_PURCHASE_ORDER_BUTTON);
//		type(COMMENT_TEXT_FIELD, "test");
//		click(OK_BUTTON);
//		Thread.sleep(1000);
//		assertEquals(true, getText(PO_STATUS_TEXT).contains("Approved"));
//		click(CANCEL_PURCHASE_ORDER_BUTTON);
//		type(COMMENT_TEXT_FIELD, "test");
//		click(OK_BUTTON);
//		Thread.sleep(1000);
//		assertEquals(true, getText(PO_STATUS_TEXT).contains("Cancelled"));
//
//	}
//
//	@Test(priority = 7)
//	public void create_PO_Receipt() throws Exception {
//		click(PURCHASING_MENU);
//		click(PO_RECEIPTS_SUB_MENU);
//		click(NEW_BUTTON);
//		click(NO_SITE_SITE);
//		click(SUPPLIERS_DROPDOWN);
//		click(FIRST_SUPPLIER_ROW);
//		click(SAVE_BUTTON);
//		String reciptCode = getText(PO_RECEIPTS_NO);
//		reciptCode = reciptCode.replace("Receipt: R#", "");
//		Thread.sleep(1000);
//		assertEquals(true, getText(PO_RECIPTS_STATUS_TEXT).contains("Draft"));
//		click(BACK_BUTTON);
//		search(SEARCH_BOX, reciptCode);
//		assertEquals(true, totalRecords(RECORD_COUNT) >= 1);
//		click(CUSTOM_PO_CODE.replace("000", reciptCode));
//		click(DRAFT_TO_RECEIVED_BUTTON);
//		Thread.sleep(1000);
//		assertEquals(true, getText(PO_RECIPTS_STATUS_TEXT).contains("Received"));
//		click(SAVE_BUTTON);
//		click(BACK_BUTTON);
//		Thread.sleep(1000);
//		String locator = RECEIPTS_STATUS_ON_TABLE.replace("000",reciptCode);
//		locator = locator.replace("test","Received");
//		assertEquals(true, visible(locator));
//
//
//	}
//
//	@Test(priority = 8)
//	public void create_PO_Receipt() throws Exception {
//		click(PURCHASING_MENU);
//		click(PO_RFQs_SUB_MENU);
//		click(NEW_BUTTON);
//		click(NO_SITE_SITE);
//		String qouteNo = genRandonNumber(3);
//		type(RFQ_QUOTE_NUMBER, qouteNo);
//		click(SHIPPING_AND_RECEIVING_TAB);
//		click(SUPPIER_DROPDOWN_ARROW);
//		click(FIRST_SUPPLIER_ROW);
//		click(SAVE_BUTTON);
//		String reciptCode = getText(RFQ_NO);
//		reciptCode = reciptCode.replace("RFQ: RFQ#", "");
//		Thread.sleep(1000);
//		assertEquals(getText(PO_RECIPTS_STATUS_TEXT).contains("Draft"), true);
//		click(BACK_BUTTON);
//		search(SEARCH_BOX, qouteNo);
//		assertEquals(totalRecords(RECORD_COUNT) >= 1, true);
//		click(CUSTOM_PO_CODE.replace("000", reciptCode));
//		click(SEND_RFQ_BUTTON);
//		click(OK_BUTTON);
//		Thread.sleep(2000);
//		assertEquals(getText(PO_RECIPTS_STATUS_TEXT).contains("Sent"), true);
//		click(SAVE_BUTTON);
//		click(BACK_BUTTON);
//		Thread.sleep(1000);
//		String locator = RECEIPTS_STATUS_ON_TABLE.replace("000", reciptCode);
//		locator = locator.replace("test", "Sent");
//		assertEquals(visible(locator), true);
//
//	}
//	@Test(priority = 9)
//	public void createPartSupplies() throws Exception {
//		click(SUPPLIES_MENU);
//		click(NEW_BUTTON);
//		String partSuppliesName = getText(PARTS_SUPPLIES_NAME_EDITBOX);
//		click(SAVE_BUTTON);
//		click(BACK_BUTTON);
//		search(SEARCH_BOX, partSuppliesName);
//		assertEquals(totalRecords(RECORD_COUNT) == 1, true);
//	}
	@Test(priority = 10)
	public void createVerifyReports() throws Exception {
		click(SUPPLIES_MENU);
		click(NEW_BUTTON);
		click(DESIGN_REPORTS_BUTTON);
		String reportName = getText(PARTS_SUPPLIES_NAME_EDITBOX);
		dropdown(REPORT_CATEGORY_DROPDOWN,REPORT_TYPE.replace("test", "Open Work Order Reports"));
		dragAndDrop(ROW_CODE,FIELDS_CONTAINER);
		click(SAVE_BUTTON);
		click(RUN_BUTTON);
	}
	
}
