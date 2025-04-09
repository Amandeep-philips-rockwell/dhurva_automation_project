package team.dhruva;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorConvertOp;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.github.javafaker.Faker;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class CommonMethods extends BaseClass {

	public Faker faker = new Faker();

	public void type(String locator, String text) {
		page.locator(locator).fill(text);

	}

	public void click(String locator) throws InterruptedException {
		page.locator(locator).click();

	}

	public void waitForLoader() throws InterruptedException {
		waitforElementInvisible("#loadingBar");

	}

	public void moveToElement(String locator) throws InterruptedException {
		page.locator(locator).scrollIntoViewIfNeeded();
		Thread.sleep(1000);
	}

	public void click(String locator, int time) throws InterruptedException {
		page.locator(locator).click();
		Thread.sleep(time);
	}

	public void clickElementInList(String locator, int position) throws InterruptedException {
		Locator element = page.locator(locator);
		element.nth(position).click();
		Thread.sleep(1000);
	}

	public String getTextOfElementInList(String locator, int position) {
		Locator element = page.locator(locator);
		return element.nth(position).textContent();
	}

	public void getURL(String url) {
		page.navigate(url);
	}

	public Locator getAllElements(String locator) {
		Locator allElements = page.locator(locator);
		return allElements;

	}

	public void iFrameClick(String iframe, String locator) {
		// Locate element inside frame
		page.frameLocator(iframe).locator(locator).click();
//		username.fill("John");
//        Frame frame = page.frame(iframe);
//		frame.click(locator);
	}

	public static List<String> splitAndMerge(List<String> inputList) {
		List<String> mergedList = new ArrayList<>();

		for (String str : inputList) {
			String[] parts = str.split(",");
			for (String s : parts) {
				s = s.replace("\"", "");
			}
			mergedList.addAll(Arrays.asList(parts));
		}

		return mergedList;
	}

	public void downloadAndReadDataForAudit(String iframe, String locator) throws IOException {

		// Wait for the download to start
		Download download = page.waitForDownload(() -> {
			// Perform the action that initiates download
			page.frameLocator(iframe).locator(locator).click();
		});
		// Wait for the download process to complete and save the downloaded file
		// somewhere
		String filename = download.suggestedFilename();
		System.out.println("file name = " + filename);
		download.saveAs(Paths.get(System.getProperty("user.home") + File.separator + "Downloads", filename));

		String filePath = System.getProperty("user.home") + File.separator + "Downloads\\" + filename;
		String line = "";
		String csvSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			while ((line = br.readLine()) != null) {

				// Use comma as separator
				String[] data = line.split(csvSplitBy);

				for (int i = 0; i < data.length; i++) {
//                    System.out.println(data[i]);
				}
				// Print each line
//                System.out.println(data[0] + " " + data[1] + " " + data[2]); 
			}
		}

		File file = new File(filePath);
		System.out.println(file.length());
		assertEquals((file.length() / 1024) > 40, true);
	}

//	public void readExcel() {
//        String filePath = System.getProperty("user.home")+ File.separator + "Downloads\\"+filename ;
//
//        // Create a FileInputStream to read the file
//        FileInputStream fileInputStream = new FileInputStream(filePath);
//
//        // Create a Workbook object to represent the Excel workbook
//        Workbook workbook = new XSSFWorkbook(fileInputStream);
//
//        // Get the first sheet
//        Sheet sheet = workbook.getSheetAt(0);
//
//        // Iterate over rows and cells
//        for (Row row : sheet) {
//            for (Cell cell : row) {
//                switch (cell.getCellType()) {
//                    case STRING:
//                        System.out.print(cell.getStringCellValue() + "\t");
//                        break;
//                    case NUMERIC:
//                        System.out.print(cell.getNumericCellValue() + "\t");
//                        break;
//                    // Handle other cell types as needed
//                }
//            }
//            System.out.println();
//        }
//
//        // Close the workbook and file stream
//        workbook.close();
//        fileInputStream.close();	
//	}
//	

	public void customElementIframeClick(String iframe, String locator, int position) {
		page.frameLocator(iframe).locator(locator).nth(position).click();

	}

	public int totalElement(String locator) {

//		page.waitForLoadState();
//		page.waitForSelector(locator);
//		int cnt = page.locator("table").locator("tr").count();
		int cnt = page.locator(locator).count();
		return cnt;
	}

	public int totalRecords(String locator) {
		String count = getText(locator);
		char c = count.charAt(0);
		count = count.replace("&nbsp;record.", "");
//		int c= Integer.parseInt(count);
		return Integer.parseInt(c + "");
	}

	public String getText(String locator) {
		String text = page.locator(locator).innerText();
		if (text.length() == 0) {
			text = page.locator(locator).textContent();
		}
		if (text.length() == 0) {
			text = page.locator(locator).innerHTML();

		}
		if (text.length() == 0) {
			text = page.locator(locator).getAttribute("value");

		}
		return text;

	}

	public boolean visible(String locator) {
		return page.locator(locator).isVisible();
	}

	public void dropdown(String Dropdown, String value) throws InterruptedException {
		click(Dropdown);
		click(value);

	}

	public void selectDropDown(String locator, String value) {
		Locator dropdown = page.locator(locator);

		// Select an option by its visible text
		dropdown.selectOption(value);
	}

	public void search(String locator, String searchString) throws InterruptedException {
		page.locator(locator).isEditable();
		Thread.sleep(1000);
		click(locator);
		type(locator, searchString);
		Thread.sleep(1000);
		page.keyboard().press("Enter");
		Thread.sleep(2000);
	}

	public void dragAndDrop(String from, String to) {
		Locator sourceElement = page.locator(from);
		Locator targetElement = page.locator(to);

		sourceElement.dragTo(targetElement);
	}

	public void waitforElementInvisible(String locator) throws InterruptedException {
		while (!page.locator(locator).isHidden()) {
			Thread.sleep(1000);
			System.out.println("no seee");
		}

	}

	public void switchToNewlOpenTab() throws InterruptedException {
		Page page2 = context.newPage();
		page2.navigate("https://www.google.com");

		List<Page> pages = context.pages();

		// Switch to the newly opened tab (assuming it's the second one)
		Page newTab = pages.get(1);
		Page newTab2 = pages.get(2);
//		assertEquals(newTab.url().contains("/JasperServlet?id"), true);
		if (newTab.url().contains("/JasperServlet?id") || newTab2.url().contains("/JasperServlet?id")) {
			assertEquals(true, true);

		}else {
			assertEquals(false, true);

		}
		pages.get(1).close();
		pages.get(2).close();
//        newTab.bringToFront();   
//        page.keyboard().type("Control+S");

//        // Wait for the download event
//        Promise<Download> downloadPromise = page.waitForEvent("download");
//        page.click("text=Download PDF");
//        Download download = downloadPromise.future().get();
//
//        // Wait for the download to complete
//        download.waitForCompletion();
//
//        // Get the path of the downloaded PDF
//        String filePath = download.path();
//
//        // Read the PDF content using Apache PDFBox
//        PDDocument document = PDDocument.load(new File(filePath));
//        PDFTextStripper pdfStripper = new PDFTextStripper();
//        String text = pdfStripper.getText(document);
//
//        System.out.println(text);

	}

	public void captureScreenshot(String fileName) {
		try {
			page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(fileName)));
		} catch (Exception e) {
			// Handle exceptions
		}
	}

	public String genRandomString(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			int index = random.nextInt(characters.length());
			sb.append(characters.charAt(index));
		}

		return sb.toString();
	}

	public void deleteFile(String filename) {
		File file = new File(filename);

		if (file.delete()) {
			System.out.println("File deleted successfully.");
		} else {
			System.out.println("Failed to delete the file.");
		}
	}

	public void deleteAllFilesFromFolder(String folderName) {
		File folder = new File(folderName);

		File[] files = folder.listFiles();
		if (files != null) {
			for (File file : files) {
				file.delete();
			}
		}
	}

	public String genRandonNumber(int length) {

		String randomNumber = "";
		for (int i = 0; i < length; i++) {
			randomNumber += faker.random().nextInt(10);
		}
		return randomNumber;

	}

	public int genRandonNumberInRange(int min, int max) {

		int randomNumberInRange = faker.number().numberBetween(min, max);

		return randomNumberInRange;

	}

	public void imageToText() throws IOException {
		try {
			// Replace with the path to your Tesseract executable
			System.setProperty("tess4j.tessedit_char_whitelist",
					"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
			ITesseract instance = new Tesseract();
			instance.setDatapath("C:\\Users\\APhilips1\\Downloads\\teees"); // Path to your Tesseract data directory

			// Replace with the path to your image file
			File imageFile = new File("tetx.png");
			BufferedImage originalImage = ImageIO.read(imageFile);

			// Apply black and white filter
			BufferedImage blackAndWhiteImage = applyBlackAndWhiteFilter(originalImage);

			String result = instance.doOCR(imageFile);

			System.out.println("Extracted Text:\n" + result);

		} catch (TesseractException e) {
			System.err.println("Error during OCR: " + e.getMessage());
		}
	}

	private static BufferedImage applyBlackAndWhiteFilter(BufferedImage image) {
		BufferedImageOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_CIEXYZ), null);
		BufferedImage grayImage = op.filter(image, null);

		// Thresholding (simple black and white conversion)
		int width = grayImage.getWidth();
		int height = grayImage.getHeight();
		BufferedImage blackAndWhiteImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int pixel = grayImage.getRGB(x, y);
				int red = (pixel >> 16) & 0xff;
				// Assuming grayscale, red, green, and blue components are the same
				int threshold = 128; // Adjust threshold as needed
				blackAndWhiteImage.setRGB(x, y, red > threshold ? 0xFFFFFFFF : 0xFF000000);
			}
		}

		return blackAndWhiteImage;
	}

//	public boolean compareList(List<String> one, List<String> two) {
//		System.out.println("exported = " + one);
//		System.out.println("table = " + two);
//		Assert.assertEquals(one.size() == two.size(), true);
//		boolean elementsEqual = true;
//		String s = null, a = null;
//		for (int i = 0; i < one.size(); i++) {
//			s = one.get(i);
//			a = two.get(i);
//			if (s.length() > 1 || a.length() > 1) {
//				s.replace("\"", "").trim();
//				a.replace("\"", "").trim();
//			}
//			if (s == null && a == null) {
//				System.out.println("null object compaire");
//			} else if (!s.equals(a)) {
//				System.out.println(s + " != " + a);
//				elementsEqual = false;
//				break; // Exit the loop early if a mismatch is found
//			}
//		}
//		return elementsEqual;
//	}

	public boolean compareList(List<String> one, List<String> two) {
		try {
//			System.out.println("exported = " + one);
//			System.out.println("table = " + two);

			// Check if the lists have the same size
			if (one.size() != two.size()) {
				System.out.println("List sizes are different.");
				return false;
			}

			// Iterate through the lists and compare elements
			for (int i = 0; i < one.size(); i++) {
				String a = one.get(i);
				String b = two.get(i);

				// Remove surrounding quotes and trim
				a = a.replace("\"", "").trim();
				b = b.replace("\"", "").trim();
				a = a.replaceAll("; ", "");
				b = b.replaceAll("; ", "");
				a = a.replaceAll("\n", "");
				b = b.replaceAll("\n", "");

//				a = a.replaceAll("[\\\"\\n; ]+", "");
//				b = b.replaceAll("[\\\"\\n; ]+", "");
//				a.trim();
//				b.trim();

				if (a != null && b != null) {
					System.out.println("Comparing " + a + " = " + b);
					// Compare the elements
					if (!a.equals(b)) {
						System.out.println(a + " != " + b);
						return false;

					}
				}
			}

			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception occur");
			return false;
		}
	}

	public void create_csv_file(String[] header, String[] record, String filename) {
		List<String[]> data = new ArrayList<>();
		data.add(header);
		data.add(record);

		try (CSVWriter writer = new CSVWriter(new FileWriter("resource\\" + filename + ".csv"))) {
			writer.writeAll(data);
			System.out.println("Import file created");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<String> clickExportToDownloadFile(String locator, int count)
			throws IOException, CsvValidationException {
		// Wait for the download to start
		Download download = page.waitForDownload(() -> {
			// Perform the action that initiates download
			page.locator(locator).click();
		});
		// Wait for the download process to complete and save the downloaded file
		// somewhere
		String filename = download.suggestedFilename();
		System.out.println("file name = " + filename);
		download.saveAs(Paths.get(System.getProperty("user.home") + File.separator + "Downloads", filename));

		String filePath = System.getProperty("user.home") + File.separator + "Downloads\\" + filename;
		return readCSV(filePath, count);
	}

	public List<String> fixTableData(List<String> tableData) {
		List<String> fixData = new ArrayList<>();
		for (String s : tableData) {
			if (s.length() > 0 && s.contains(",")) {
				String[] sdata = s.split(",");
				for (String value : sdata) {
					fixData.add(value.trim()); // Trim to remove leading/trailing whitespace
				}
			}
			fixData.add(s);
		}
		return fixData;
	}

	public static List<String> readCSV(String filePath, int count) throws IOException, CsvValidationException {
//		List<String> data = new ArrayList<>();
//		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//			// Skip the header row
//			br.readLine();
//
//			// Read the first row of data
//			String line = br.readLine();
//			if (line != null) {
//				String[] values = line.split(",");
//				for (String value : values) {
//					data.add(value.trim()); // Trim to remove leading/trailing whitespace
//				}
//			}
//		}
//		return data;
		List<String> fixedData = new ArrayList<String>();
		try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
			// Skip the header row

			reader.readNext();

			// Read the first row after the header
			String[] nextLine = reader.readNext();
			if (count > 0 && nextLine.length != count) {
				for (int i = 0; i < count; i++) {
					fixedData.add(nextLine[i]);
				}
				return fixedData;

			}

			if (nextLine != null) {
				return Arrays.asList(nextLine);
			} else {
				return List.of(); // Return an empty list if no data is found after the header
			}
		} catch (IOException e) {
			e.printStackTrace();
			return List.of(); // Return an empty list on error
		}
	}

	public void callReset() {
		page.reload();
	}

	public void uploadFile(String location, String filename) throws InterruptedException {
		Locator fileInput = page.locator(location);

		// Path to the file you want to upload
//        String filePath = "/path/to/your/file.txt"; 
		Path file = Paths.get("resource\\" + filename);

		// Upload the file
		fileInput.setInputFiles(file);
		Thread.sleep(1000);
	}
	

}
