package team.dhruva.executor;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.Locator;

import team.dhruva.CommonMethods;
import team.dhruva.locators.GlobalLocators;
import team.dhruva.locators.PurshaseLocators;

public class PurshaseExecutor extends CommonMethods implements GlobalLocators,PurshaseLocators{
	public List<String> readTabledatafromRFQs(String locator) {
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
