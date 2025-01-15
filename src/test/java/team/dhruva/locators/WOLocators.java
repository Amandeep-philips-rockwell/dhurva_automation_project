package team.dhruva.locators;

public interface WOLocators {

	String PRIORITY_DROPDOWN = "//div[text()=\"Priority\"]/..//div[@class=\"autoSuggestDropdownButtonContainer35\"]";
	String TABLE_HEADER = "//th//span[@class=\"listHeaderLabel35\"]";
	String FIRST_ROW_DATA = "//tr[1]/td[@class=\"listColumnValueReadOnly\"]//p";
	String TABLE_ROWS_COUNT = "//tr";
	String WO_CODE = "//div[@class=\"formLabel35\"][contains(text(),\"Code\")]/..//p";
}
