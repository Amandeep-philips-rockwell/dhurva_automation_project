package team.dhruva.testcases;

import org.testng.annotations.Test;

import team.dhruva.executor.AuditTrailExecutor;

public class AuditTrailTests extends AuditTrailExecutor {

	@Test(priority = 1,groups = "Audit Trail")
	public void verifyAudiTrailforWO() throws Exception {
		click(AUDIT_TRAIL_MENU);
		iFrameClick(IFRAME_ID, START_DATE_PICKER);
		iFrameClick(IFRAME_ID, PREVIOS_MONTH_ARROW);
		customElementIframeClick(IFRAME_ID, ALL_DATE_SELECTOR, 1);
		iFrameClick(IFRAME_ID, END_DATE_PICKER);
		customElementIframeClick(IFRAME_ID, ALL_DATE_SELECTOR, -1);
		iFrameClick(IFRAME_ID, DOWNLOAD_BUTTON);
		downloadAndReadDataForAudit(IFRAME_ID, DOWNLOAD_BUTTON);

	}

	@Test(priority = 2,groups = "Audit Trail")
	public void verifyAudiTrailforEquipmentS() throws Exception {
		click(AUDIT_TRAIL_MENU);
		iFrameClick(IFRAME_ID, EQUIPMENT_TAB);
		iFrameClick(IFRAME_ID, START_DATE_PICKER);
		iFrameClick(IFRAME_ID, PREVIOS_MONTH_ARROW);
		customElementIframeClick(IFRAME_ID, ALL_DATE_SELECTOR, 1);
		iFrameClick(IFRAME_ID, END_DATE_PICKER);
		customElementIframeClick(IFRAME_ID, ALL_DATE_SELECTOR, -1);
		iFrameClick(IFRAME_ID, DOWNLOAD_BUTTON);
		downloadAndReadDataForAudit(IFRAME_ID, DOWNLOAD_BUTTON);

	}
	
}
