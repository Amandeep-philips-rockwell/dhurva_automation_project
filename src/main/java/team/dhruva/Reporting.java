package team.dhruva;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends CommonMethods implements ITestListener {
	private static ExtentReports extent = new ExtentReports();
	private static ExtentTest test;

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent-report.html");
		htmlReporter.config().setTheme(Theme.DARK);
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Environment", "DEV");
		extent.setSystemInfo("Browser", "Chrome");
		deleteAllFilesFromFolder("screenshots");
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
//        test.assignCategory(String.join(", ", groups)); // Assign groups as categories

        
//        String testName = result.getTestName();
//        String[] groups = result.getTestContext().getCurrentXmlTest().getGroups().getIncludeNames().toArray(new String[0]);
//        test = extent.createTest(testName);
//        test.assignCategory(String.join(", ", groups));
		 for (String group : result.getMethod().getGroups()) {
	            test.assignCategory(group);
	        }
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass("Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String screenshotPath = "screenshots/"+genRandomString(15)+".png"; 
	    captureScreenshot(screenshotPath);
		test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		test.fail(result.getThrowable());
		callReset();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// Implement your logic here
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// Implement your logic here
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
