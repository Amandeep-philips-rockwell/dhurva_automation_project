package team.dhruva.executor;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Locator;

import team.dhruva.CommonMethods;
import team.dhruva.locators.GlobalLocators;
import team.dhruva.locators.SMLocators;

public class SMExecutor extends CommonMethods implements GlobalLocators, SMLocators {
	public List<String> readTabledatafromSM(String locator) {
		String text = "";
		List<Locator> elements = page.locator(locator).all();
		List<String> fixedData = new ArrayList<String>();
		int calulate = 0;
		int columnP = getColumnPosition("Next Trigger Threshold Date"); 
		for (Locator element : elements) {
			if (element.locator("span").count() > 0) {

				String className = element.locator("span").getAttribute("class");
				if (className != null && className.equals("iconsListRunning35")) {
					text = "1";
				} else if (className != null && className.equals("iconsListPaused35")) {
					text = "0";
				}
			} else {
				text = element.textContent();

				if (text.contains("Every day")) {
					text = "Every day";
				}

			}
			if (text.length() == 1 && element.innerHTML().contains("&nbsp;")) {
				text = "";
			}
			if (columnP == calulate) {
				text = "see dates section";
			}
			calulate++;
			fixedData.add(text);

		}
		return fixedData;
	}

	public String[] dataGenForImport() {

		String[] data = { ("SM" + (genRandonNumber(2) + genRandonNumber(3))),
				"Automation runID - " + genRandomString(5) };

		return data;
	}
	
	public int getColumnPosition(String columnName) {
		List<String> names = page.locator(TABLE_HEADERS).allTextContents();
		int position = 0;
		for (int i = 0;i<names.size();i++) {
			if (names.get(i).equals(columnName)) {
				position = i;
				break;
			}

		}
		return position;

	}
	public void addLaborTasks(int count) throws InterruptedException {
		
		while(count != 0) {
		click(ADD_LABOR_TASK_ICON);
		type(TASK_DESCRIPTION_EDITBOX, genRandomString(10));
		click(ATTACH_MEDIA_FOR_LABOR_TASK_BUTTON,1000);
		if (visible(ADD_MEDIA_BUTTON_X)) {
			click(ADD_MEDIA_BUTTON_X);
			uploadFile(UPLOAD_BUTTON, "sample_file.txt");
			click(OK_BUTTON_3,1000);
			click(UPLOADED_FILE_CHECKBOX,1000);
			click(OK_BUTTON_2,1000);
		}else {
            FileChooser fileChooser = page.waitForFileChooser(() -> {
                // Trigger the file input click
                page.locator(ADD_MEDIA_BUTTON_Y).click();
            });

            // Set the file path
            fileChooser.setFiles(Paths.get("resource\\" + "sample_file.txt"));
            waitforElementInvisible(UPLOADING_FILE_SCREEN);
    		click(UPLOADED_FILE_CHECKBOX,1000);
    		click(OK_BUTTON_2,1000);
		}
		assertEquals(totalElement(FILE_UPLOAD_THUMBNAIL), 1);
		click(OK_BUTTON);
		count--;
		}
		Thread.sleep(1000);
	}
	
	public void addTaskGroups() throws InterruptedException {
		int ogCount = totalElement(LABOR_TASKS_ROW);
		click(ADD_TASK_GROUP_ICON,500);
		int count = totalElement(TASK_GROUP_COUNT_TABLE_ROW);
		if (count> 15) {
			count = 15;
		}
		int ran = genRandonNumberInRange(0,count);
		String gCount = getTextOfElementInList(TASK_GROUP_COUNT_TABLE_ROW, ran);
		clickElementInList(TASK_GROUP_COUNT_TABLE_ROW,ran);
		click(OK_BUTTON,1000);
		int newCount = totalElement(LABOR_TASKS_ROW);
		assertEquals(true,(ogCount+Integer.parseInt(gCount)) == newCount);


	}
	public void page_check() throws InterruptedException {
		if (!visible(SM_TOP_LABEL)) {
			callReset();
		}
		click(MAINTANACE_MENU);
		click(SM_SUB_MENU,1000);

	}
	public void addAllTypeTrigger() throws InterruptedException  {
		int trigger_row = totalElement(TRIGGER_DESCRIPTION_TABLE);
		click(ADD_TRIGGER_ICON);
		click(OK_BUTTON);
		click(ADD_TRIGGER_ICON);
		click(METER_READING_RADIO_BUTTON);
		click(OK_BUTTON);
		click(ADD_TRIGGER_ICON);
		click(EVENT_TRIGGER_RADIO_BUTTON);
		click(EVENT_TRIGGER_NAME_DROPDOWN);
		click(EVENT_SCREEN_FIRST_ROW);
		click(OK_BUTTON,2000);
		int new_trigger_row = totalElement(TRIGGER_DESCRIPTION_TABLE);
		assertEquals(true, trigger_row+2 == new_trigger_row);
		
	}
	public void fileUploadAllType(String locator) throws InterruptedException {
		String[] types = { "Image", "Default Image", "Map", "Default Map", "Diagram", "Barcode Scan", "Document",
				"Link", "Note" };
		List data = null;
		for (String type : types) {
			click(locator);
			selectDropDown(FILE_TYPE_DROPDOWN, type);
			uploadFile(FILE_UPLOAD_BOX, "sample_file.txt");
			type(NOTES_TEXTFEILD, type + " file type");
			click(OK_BUTTON, 3000);
			data = getAllElements(ALL_TABLE_ROW_DATA.replace("1", (totalElement(ALL_TABLE_ROW_FOR_FILES) - 1) + ""))
					.allTextContents();
			assertEquals(verifyFileData(data, "sample_file.txt", type), true);

		}

	}

	public boolean verifyFileData(List data, String filename, String filetype) {

		boolean matchResult = false;
		boolean fileResult = false;

		assertEquals(data.get(1), filename);
		assertEquals(data.get(2), filetype);
		if (data.get(4).equals("Click to view full size image") || data.get(4).equals("Click to open")) {
			matchResult = true;
		}
		assertEquals(true, matchResult);
		// Wait for the download to start
		Download download = page.waitForDownload(() -> {
			// Perform the action that initiates download
			page.locator(SPECIFIC_CLICK_ON_FILE_TAB_FOR_DOWNLOAD
					.replace("00", (totalElement(ALL_TABLE_ROW_FOR_FILES) - 1) + "")).click();
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
			} else {
				fileResult = false;
			}
		}
		return fileResult;

	}
}
