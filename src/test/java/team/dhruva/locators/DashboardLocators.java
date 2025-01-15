package team.dhruva.locators;

public interface DashboardLocators {
	String DASHBOARD_CARDS = "//div[@class=\"react-grid-item widgetWrapper cssTransforms\"]";
	String FIXX_HEADER = "//div[@class=\"pk-logobar-g\"]";
	String ACTIVE_ADMIN_DASHBOARD = "//div[@class=\"active dashboardTab\"]";
	String HIGH_PRIORITY_WO_CARD = "//span[contains(text(),\"High Priority Work Orders\")]/../../../..//div[@class=\"value\"]";
}
