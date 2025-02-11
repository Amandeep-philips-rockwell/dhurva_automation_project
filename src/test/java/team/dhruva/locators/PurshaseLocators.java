package team.dhruva.locators;

public interface PurshaseLocators {

	// Purchase Order
	String PURCHASE_ORDER_NO = "//table[@class=\"mainFormContainer35\"]//span[contains(text(),\"Purchase Order: PO#\")]";
	String SUBMIT_FOR_APPROVAL_BUTTON = "//div[@class=\"actionButton action\"]/span[contains(text(),\"Submit For Approval\")]";
	String COMMENT_TEXT_FIELD = "//div[contains(text(),\"Comments to attach\")]/..//textarea";
	String APPROVE_PURCHASE_ORDER_BUTTON = "//div[@class=\"actionButton action\"]/span[contains(text(),\"Approve Purchase Order\")]";
	String CANCEL_PURCHASE_ORDER_BUTTON = "//div[@class=\"actionButton action\"]/span[contains(text(),\"Cancel Purchase Order\")]";
	String PO_STATUS_TEXT = "(//td[@valign=\"top\"]//div[@class=\"formCellInside35\"]/div)[2]";
	String CUSTOM_PO_CODE = "//td[@class=\"listColumnValueReadOnly\"]//p[text()=\"000\"]";

	// Receitps
	String PO_RECEIPTS_NO = "//table[@class=\"mainFormContainer35\"]//span[contains(text(),\"Receipt: R#\")]";
	String PO_RECIPTS_STATUS_TEXT = "(//td[@valign=\"top\"]//div[@class=\"formCellInside35\"]/div)[1]";
	String DRAFT_TO_RECEIVED_BUTTON = "//div[@class=\"actionButton action\"]/span[contains(text(),\"Set Draft To Received\")]";
	String SUPPLIERS_DROPDOWN = "(//td[@valign=\"top\"]//div[@class=\"formCellInside35\"]/div)[2]//div[@onclick]";
	String FIRST_SUPPLIER_ROW = "//div[@class=\"modalWindowFrame ui-draggable\"]//table//tr[1]/td[1]";
	String RECEIPTS_STATUS_ON_TABLE = "//td[@class=\"listColumnValueReadOnly\"]//p[text()=\"000\"]/../../..//p[text()=\"test\"]";
	
	//RFQs
	String SHIPPING_AND_RECEIVING_TAB = "//li/p[text()=\"Shipping/Receiving\"]";
	String SUPPIER_DROPDOWN_ARROW = "//div[text()=\"Supplier\"]/..//td[2]";
	String RFQ_NO = "//table[@class=\"mainFormContainer35\"]//span[contains(text(),\"RFQ: RFQ#\")]";
	String SEND_RFQ_BUTTON = "//div[@class=\"actionButtons\"]//span[contains(text(),\"Send RFQ\")]";
	String RFQ_QUOTE_NUMBER = "//div[text()=\"Quote #\"]/..//input";
	
	
}
