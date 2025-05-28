package team.dhruva.locators;

public interface LoginLocators {
	String USERNAME_FIELD = "//input[@id=\"j_username\"]";
	String PASSWORD_FIELD = "//input[@id=\"j_password\"]";
	
	String USERNAME_FIELD_V6 = "//label[@title=\"Email\"]//input";
	String PASSWORD_FIELD_V6 = "//label[@title=\"Password\"]//input";
	String SIGNIN_BUTTON_V6 = "//button[@class=\"primary-button login-button\"]";
	
	String SIGNIN_BUTTON = "//input[@class=\"loginButton\"]";
	
	String SIDE_MENU_OPTION = "//div[@id=\"maMainSidebarPane\"]";
	String FIXX_HEADER = "//div[@class=\"pk-logobar-g\"]";
String V6_LOGIN_PAGE_LOGO = "//img[@src=\"https://fiixcmms-devserver.com/auth/images/fiix-logo.png\"]";
String FORGET_PASSWORD_HYPERLINK = "//a[contains(text(),\"Forgot your password?\")]";
}
