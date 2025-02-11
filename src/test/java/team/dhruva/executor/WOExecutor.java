package team.dhruva.executor;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.Locator;

import team.dhruva.CommonMethods;
import team.dhruva.locators.GlobalLocators;
import team.dhruva.locators.WOLocators;

public class WOExecutor extends CommonMethods implements WOLocators, GlobalLocators {
	public String[] dataGenForImport() {

		String[] data = { (genRandonNumber(2) + genRandonNumber(3)), "Automation runID - " + genRandomString(5),
				"Open" };

		return data;
	}

	public List<String> readTabledatafromSupplies(String locator) throws InterruptedException {
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
}
