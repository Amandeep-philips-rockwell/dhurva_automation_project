package team.dhruva.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import team.dhruva.CommonMethods;
import team.dhruva.locators.LoginLocators;

public class LoginTests extends CommonMethods implements LoginLocators {
	@Test(priority = 1,groups = "Login")
	public void verify_Login() throws Exception {
		String title = page.title();
		assertEquals("Fiix", title);
		waitforElementvisible(FORGET_PASSWORD_HYPERLINK);
		Thread.sleep(1000);
		if (visible(V6_LOGIN_PAGE_LOGO)) {
			type(USERNAME_FIELD_V6, USERNAME);
			type(PASSWORD_FIELD_V6, PASSWORD);
			click(SIGNIN_BUTTON_V6);

		} else {
			type(USERNAME_FIELD, USERNAME);
			type(PASSWORD_FIELD, PASSWORD);
			click(SIGNIN_BUTTON);

		}
		waitforElementvisible(SIDE_MENU_OPTION);
		Thread.sleep(2000);
		assertEquals(true, visible(FIXX_HEADER));

	}
}
