package team.dhruva.testcases;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

import team.dhruva.executor.PurshaseExecutor;

public class PurshaseTests extends PurshaseExecutor {
//------------------------------------ Purshase Order ------------------------------------------	
	@Test(priority = 101,groups = "Purchase Order")
	public void create_Purshase_Order() throws Exception {
		click(PURCHASING_MENU);
		click(PO_SUB_MENU);
		click(NEW_BUTTON);
		click(NO_SITE_SITE);
		click(SAVE_BUTTON);
		String poCode = getText(PURCHASE_ORDER_NO);
		poCode = poCode.replace("Purchase Order: PO#", "");
		Thread.sleep(1000);
		assertEquals(true, getText(PO_STATUS_TEXT).contains("Draft"));
		click(BACK_BUTTON);
		search(SEARCH_BOX, poCode);
		assertEquals(true, totalRecords(RECORD_COUNT) >= 1);
		click(CUSTOM_PO_CODE.replace("000", poCode));
		click(SUBMIT_FOR_APPROVAL_BUTTON);
		type(COMMENT_TEXT_FIELD, "test");
		click(OK_BUTTON);
		Thread.sleep(1000);
		assertEquals(true, getText(PO_STATUS_TEXT).contains("Waiting For Approval"));
		click(APPROVE_PURCHASE_ORDER_BUTTON);
		type(COMMENT_TEXT_FIELD, "test");
		click(OK_BUTTON);
		Thread.sleep(1000);
		assertEquals(true, getText(PO_STATUS_TEXT).contains("Approved"));
		click(CANCEL_PURCHASE_ORDER_BUTTON);
		type(COMMENT_TEXT_FIELD, "test");
		click(OK_BUTTON);
		Thread.sleep(1000);
		assertEquals(true, getText(PO_STATUS_TEXT).contains("Cancelled"));

	}

	@Test(priority = 102,groups = "Purchase Order")
	public void verify_export_for_Purshase_order() throws Exception {
		click(PURCHASING_MENU);
		click(PO_SUB_MENU);
		click(TABLE_FIRST_ROW_CHECK_BOX);
		List<String> fixdata = readTabledatafromRFQs(TABLE_CUSTOM_ROW_ALL_DATA.replace("000", "1"));

		List<String> exportedData = clickExportToDownloadFile(EXPORT_BUTTON, fixdata.size());

		assertEquals(compareList(exportedData, fixdata), true);
	}

//------------------------------------ Receipts ------------------------------------------	
	@Test(priority = 201,groups = "Receipts")
	public void create_PO_Receipt() throws Exception {
		click(PURCHASING_MENU);
		click(PO_RECEIPTS_SUB_MENU);
		click(NEW_BUTTON);
		click(NO_SITE_SITE);
		click(SUPPLIERS_DROPDOWN);
		click(FIRST_SUPPLIER_ROW);
		click(SAVE_BUTTON);
		String reciptCode = getText(PO_RECEIPTS_NO);
		reciptCode = reciptCode.replace("Receipt: R#", "");
		Thread.sleep(1000);
		assertEquals(true, getText(PO_RECIPTS_STATUS_TEXT).contains("Draft"));
		click(BACK_BUTTON);
		search(SEARCH_BOX, reciptCode);
		assertEquals(true, totalRecords(RECORD_COUNT) >= 1);
		click(CUSTOM_PO_CODE.replace("000", reciptCode));
		click(DRAFT_TO_RECEIVED_BUTTON);
		Thread.sleep(1000);
		assertEquals(true, getText(PO_RECIPTS_STATUS_TEXT).contains("Received"));
		click(SAVE_BUTTON);
		click(BACK_BUTTON);
		Thread.sleep(1000);
		String locator = RECEIPTS_STATUS_ON_TABLE.replace("000", reciptCode);
		locator = locator.replace("test", "Received");
		assertEquals(true, visible(locator));

	}

	@Test(priority = 202,groups = "Receipts")
	public void verify_export_for_Receipts() throws Exception {
		click(PURCHASING_MENU);
		click(PO_RECEIPTS_SUB_MENU);
		click(TABLE_FIRST_ROW_CHECK_BOX);
		List<String> fixdata = readTabledatafromRFQs(TABLE_CUSTOM_ROW_ALL_DATA.replace("000", "1"));

		List<String> exportedData = clickExportToDownloadFile(EXPORT_BUTTON, fixdata.size());

		assertEquals(compareList(exportedData, fixdata), true);
	}

//------------------------------------ RFQs ------------------------------------------	

	@Test(priority = 301,groups = "RFQs")
	public void create_PO_RFQs() throws Exception {
		click(PURCHASING_MENU);
		click(PO_RFQs_SUB_MENU);
		click(NEW_BUTTON);
		click(NO_SITE_SITE);
		String qouteNo = genRandonNumber(3);
		type(RFQ_QUOTE_NUMBER, qouteNo);
		click(SHIPPING_AND_RECEIVING_TAB);
		click(SUPPIER_DROPDOWN_ARROW);
		click(FIRST_SUPPLIER_ROW);
		click(SAVE_BUTTON);
		String reciptCode = getText(RFQ_NO);
		reciptCode = reciptCode.replace("RFQ: RFQ#", "");
		Thread.sleep(1000);
		assertEquals(getText(PO_RECIPTS_STATUS_TEXT).contains("Draft"), true);
		click(BACK_BUTTON);
		search(SEARCH_BOX, qouteNo);
		assertEquals(totalRecords(RECORD_COUNT) >= 1, true);
		click(CUSTOM_PO_CODE.replace("000", reciptCode));
		click(SEND_RFQ_BUTTON);
		click(OK_BUTTON);
		Thread.sleep(2000);
		assertEquals(getText(PO_RECIPTS_STATUS_TEXT).contains("Sent"), true);
		click(SAVE_BUTTON);
		click(BACK_BUTTON);
		Thread.sleep(1000);
		String locator = RECEIPTS_STATUS_ON_TABLE.replace("000", reciptCode);
		locator = locator.replace("test", "Sent");
		assertEquals(visible(locator), true);

	}

	@Test(priority = 302,groups = "RFQs")
	public void verify_export_for_RFQs() throws Exception {
		click(PURCHASING_MENU);
		click(PO_RFQs_SUB_MENU);
		click(TABLE_FIRST_ROW_CHECK_BOX);
		List<String> fixdata = readTabledatafromRFQs(TABLE_CUSTOM_ROW_ALL_DATA.replace("000", "1"));

		List<String> exportedData = clickExportToDownloadFile(EXPORT_BUTTON, fixdata.size());

		assertEquals(compareList(exportedData, fixdata), true);
	}
}
