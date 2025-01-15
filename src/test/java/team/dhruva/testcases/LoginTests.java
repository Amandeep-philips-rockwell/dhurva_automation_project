package team.dhruva.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import team.dhruva.CommonMethods;
import team.dhruva.locators.LoginLocators;

public class LoginTests extends CommonMethods implements LoginLocators {
	@Test(priority = 1)
	public void verify_Login() throws Exception {
		String title = page.title();
		assertEquals("Fiix", title);
		type(USERNAME_FIELD, USERNAME);
		type(PASSWORD_FIELD, PASSWORD);
		click(SIGNIN_BUTTON);
		Thread.sleep(2000);
		assertEquals(true, visible(FIXX_HEADER));

	}
}
