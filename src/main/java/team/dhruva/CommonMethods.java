package team.dhruva;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Locator;

public class CommonMethods extends BaseClass{

    Faker faker = new Faker();

	public void type(String locator, String text) {
		page.locator(locator).fill(text);

	}

	public void click(String locator) {
		page.locator(locator).click();
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
		String text =  page.locator(locator).innerText();
		if (text.length() == 0){
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
	
	public void dropdown(String Dropdown,String value) throws InterruptedException {
		click(Dropdown);
		click(value);

	}
	
	public void search(String locator, String searchString) throws InterruptedException {
		page.locator(locator).isEditable();
		Thread.sleep(1000);
		type(locator,searchString);
		page.keyboard().down("Enter");
		Thread.sleep(3000);
	}
	
	public void dragAndDrop(String from, String to) {
        Locator sourceElement = page.locator(from);
        Locator targetElement = page.locator(to);

        sourceElement.dragTo(targetElement);
	}
	
	public String genRandonNumber(int length) {

        String randomNumber = "";
        for (int i = 0; i < length; i++) {
            randomNumber += faker.random().nextInt(10);
        }
		return randomNumber;
		
	}
}
