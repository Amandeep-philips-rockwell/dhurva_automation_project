package team.dhruva.locators;

public interface TasksGroupnProjectLocators {
	String TASK_GROUP_NAME_EDITBOX = "//div[contains(@id,\"_column_strName_gridLabel\")]/..//input";
	String TASKGROUP_POPUP_SCREEN_LABLE = "//span[@class=\"formLabelModal\"][text()=\"Task Group\"]";
	String TASK_GROUP_TOP_HEADER = "//span[@class=\"listTopLabelLarge\"][contains(text(),\"Task Group\")]";
	String PROJECTS_TOP_HEADER = "//span[@class=\"listTopLabelLarge\"][contains(text(),\"Projects\")]";
}
