package team.dhruva;

import java.util.Arrays;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseClass implements Constant {

	// Shared between all tests in this class.
	public static Playwright playwright;
	public static Browser browser;

	// New instance for each test method.
	public static BrowserContext context;
	public static Page page;

	@BeforeTest(alwaysRun = true)
	public void launchBrowser() {
		try {
			playwright = Playwright.create();
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50)
					.setArgs(Arrays.asList("--start-maximized")));
			context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
			page = context.newPage();

			page.navigate(URL);

		} catch (Exception e) {
			System.out.println("Expection as - " + e.toString());
		}
	}

	@AfterTest
	public void closeBrowser() {
		page.close();
		browser.close();
		playwright.close();
	}
}