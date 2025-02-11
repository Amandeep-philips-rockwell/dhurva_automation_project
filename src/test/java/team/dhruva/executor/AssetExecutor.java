package team.dhruva.executor;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.Locator;

import team.dhruva.CommonMethods;
import team.dhruva.locators.AssetLocators;
import team.dhruva.locators.GlobalLocators;

public class AssetExecutor extends CommonMethods implements GlobalLocators, AssetLocators {
	public List<String> readTabledatafromAsset(String locator) {
		String text = "";
		List<Locator> elements = page.locator(locator).all();
		List<String> fixedData = new ArrayList<String>();

		for (Locator element : elements) {
			if (element.locator("div").locator("span").count() > 0) {
				String className = element.locator("span").getAttribute("class");
				if (className != null && className.equals("iconsListRunning35")) {
					text = "on";
				} else if (className != null && className.equals("iconsListPaused35")) {
					text = "off";
				}
			} else {
				text = element.textContent();
				if (text.equals("₹")) {
					text = "1,042";
				} else if (text.equals("د.ا")) {
					text = "1,712";
				}
			}
			if (text.length() == 1 && element.innerHTML().contains("&nbsp;")) {
				text = "";
			}
			fixedData.add(text);

		}
		return fixedData;
	}

	public List<String> readTabledatafromAssetTreeView(String locator) {
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
				}
				if (text.length() == 1 && element.innerHTML().contains("&nbsp;")) {
					text = "";
				}
				fixedData.add(text);

			}

		}
		return fixedData;
	}

	public String[] dataGenForImport() {

		String[] data = { genRandomString(3) + genRandomString(3), "A" + (genRandonNumber(2) + genRandonNumber(3)),
				"Automation runID - " + genRandomString(5) };

		return data;
	}
}
