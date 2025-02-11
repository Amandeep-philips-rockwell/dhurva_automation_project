package team.dhruva.executor;

import java.util.ArrayList;
import java.util.List;

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
}
