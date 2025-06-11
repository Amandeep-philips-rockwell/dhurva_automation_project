package team.dhruva.executor;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Locator;

import team.dhruva.CommonMethods;
import team.dhruva.locators.GlobalLocators;
import team.dhruva.locators.TasksGroupnProjectLocators;
import team.dhruva.locators.WOLocators;

public class TasksGroupnProjectExecutor extends CommonMethods implements TasksGroupnProjectLocators, GlobalLocators,WOLocators{
	public List<String> readTabledata(String locator) {
		String text = "";
		List<Locator> elements = page.locator(locator).all();
		List<String> fixedData = new ArrayList<String>();
		for (Locator element : elements) {
				text = element.textContent();
				if (text.length() == 1 && element.innerHTML().contains("&nbsp;")) {
					text = "";
				}
			fixedData.add(text);

		}
		return fixedData;
	}
	public String[] dataGenForImport() {

		String[] data = { ("Automation runID - " +" GROUPNAME "+ genRandomString(5)) };

		return data;
	}
	
	
	public void fileUploadAllType(String singlefile, String Multifile) throws InterruptedException {
		String[] types = { "Image", "Default Image", "Map", "Default Map", "Diagram", "Barcode Scan", "Document",
				"Link", "Note" };
		List data = null;
		if (visible(singlefile)) {
			for (String type : types) {
				click(singlefile);
				selectDropDown(FILE_TYPE_DROPDOWN, type);
				uploadFile(FILE_UPLOAD_BOX, "sample_file.txt");
				type(NOTES_TEXTFEILD, type + " file type");
				click(OK_BUTTON_2, 3000);
				verifyFileData(type, "sample_file.txt", false);
			}
		} else {
			uploadFile_Multifile(Multifile, "sample_file_multifile.txt", MULTIFILE_DROP_ZONE);
			verifyFileData("sample_file_multifile.txt", "sample_file_multifile.txt", true);

		}

	}

	public void verifyFileData(String type, String filename, boolean multifile) {
		boolean matchResult = false;
		boolean fileResult = false;
		String hreftxt = "";
		if (!multifile) {
			assertEquals(visible(CUSTOME_NOTES_CHECK.replace("xx", type)), true);
			hreftxt = getText(CUSTOME_HREF.replace("xx", type));
		}else {
			hreftxt = getText(CUSTOME_HREF.replace("xx file type", type));
		}
		if (hreftxt.equals("Click to view full size image") || hreftxt.equals("Click to open")) {
			matchResult = true;
		}
		assertEquals(matchResult, true);
		// Wait for the download to start
		Download download = page.waitForDownload(() -> {
//			 Perform the action that initiates download
			if (!multifile) {
				page.locator(CUSTOME_HREF.replace("xx", type)).click();
			}else {
				page.locator(CUSTOME_HREF.replace("xx file type", type)).click();

			}
		});
		// Wait for the download process to complete and save the downloaded file
		String fileName = download.suggestedFilename();
		System.out.println("file name = " + fileName);
		download.saveAs(Paths.get(System.getProperty("user.home") + File.separator + "Downloads", fileName));
		String filePath = System.getProperty("user.home") + File.separator + "Downloads\\" + filename;
		File file = new File(filePath);

		if (file.exists()) {
			long fileSize = file.length(); // Get file size in bytes

			System.out.println("File size: " + fileSize + " bytes");

			// Convert to KB, MB, or GB (optional)
			double fileSizeKB = (double) fileSize / 1024;
			System.out.println(fileSizeKB);
			if (fileSizeKB >= 0) {
				fileResult = true;
			}
		}
		assertEquals(fileResult, true);

	}
	public void page_check() throws InterruptedException {
		if (!visible(TASK_GROUP_TOP_HEADER)) {
			callReset();
		}
		click(MAINTANACE_MENU);
		click(TASK_GROUPS_SUB_MENU,1000);
	}
	public void page_check_project() throws InterruptedException {
		if (!visible(PROJECTS_TOP_HEADER)) {
			callReset();
		}
		click(MAINTANACE_MENU);
		click(PROJECTS_SUB_MENU,1000);
	}
}
