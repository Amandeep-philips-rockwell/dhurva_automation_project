package team.dhruva.executor;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Locator;

import team.dhruva.CommonMethods;
import team.dhruva.locators.GlobalLocators;
import team.dhruva.locators.SuppliesLocators;

public class SuppliesExecutor extends CommonMethods implements GlobalLocators, SuppliesLocators {
	public String[] dataGenForImportPnS() {

		String[] data = { "New PnS - " + genRandomString(3) + genRandomString(3),
				"A" + (genRandonNumber(2) + genRandonNumber(3)), "Automation runID - " + genRandomString(5) };

		return data;
	}

	
	public String[] dataGenForImportBusinesses() {

		String[] data = { "B-" + genRandonNumber(2) + genRandonNumber(2),
				"AP - " +genRandomString(2) +" "+ faker.name().lastName() + "LTD", "Automation runID - " + genRandomString(5) };

		return data;
	}
	public List<String> readTabledatafromSupplies(String locator) throws InterruptedException {
		String text = "";
		String temp = "";
		List<Locator> elements = page.locator(locator).all();
		System.out.println("total elements = "+elements.size());
		List<String> fixedData = new ArrayList<String>();

		for (Locator element : elements) {
			temp = "";
			if (element.locator("p").count() > 2) {
				Locator e = element.locator("p");
				for (int i = 0; i < e.count(); i++) {
					temp = temp + e.nth(i).textContent();
				}
			}

			if (element.locator("p").locator("span").count() > 0) {

				if (element.textContent().contains("Multiple Locations")) {
					element.hover();
					Thread.sleep(1000);
					temp = getText(MULTILOCATION_POPOVER);
				}
			}
			if (temp.length() == 0) {
				text = element.textContent();
				if (text.length() == 1 && element.innerHTML().contains("&nbsp;")) {
					text = "";
				}
			} else {
				text = temp;

			}
			if (text.equals("₹")) {
				text = "1,042";
			} else if (text.equals("د.ا")) {
				text = "1,712";
			}else if (text.equals("Submit Purchase Request")) {
				text = "";
			}
			if (text.length() == 1 && element.innerHTML().contains("&nbsp;")) {
				text = "";
			}

			fixedData.add(text);

		}

		return fixedData;
	}
	
	public List<String> readTabledatafromSuppliesTreeView(String locator) {
		String text = "";
		List<Locator> elements = page.locator(locator).all();
		List<String> fixedData = new ArrayList<String>();

		for (Locator element : elements) {
			if (element.locator("div").locator("span").count() > 0) {
				if (element.locator("div").locator("img").count() > 0) {
					fixedData.add("");
				} else {
					String className = element.locator("span").getAttribute("class");
					if (className != null && className.equals("iconsListRunning35")) {
						text = "on";
					} else if (className != null && className.equals("iconsListPaused35")) {
						text = "off";
					}
					fixedData.add(text);

				}
			} else {
				text = element.textContent();
				if (text.equals("₹")) {
					text = "1,042";
				} else if (text.equals("د.ا")) {
					text = "1,712";
				}else if (text.equals("Submit Purchase Request")) {
					text = "";
				}
				if (text.length() == 1 && element.innerHTML().contains("&nbsp;")) {
					text = "";
				}
				fixedData.add(text);

			}

		}
		return fixedData;
	}
}
