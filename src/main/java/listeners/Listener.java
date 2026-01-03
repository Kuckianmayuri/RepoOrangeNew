package listeners;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import config.baseClass;

public class Listener implements ITestListener {

	private static ExtentReports extent;
	private static ExtentTest test;

	@Override
	public void onStart(ITestContext context) {

		// Create folder if it doesn't exist
		File reportDir = new File("./ExtentReports");
		if (!reportDir.exists()) {
			reportDir.mkdir();
		}
		Date date = new Date();
		String newdata = date.toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./ExtentReports/Report_" + newdata + ".html");
		spark.config().setReportName("OrangeHRM Automation Report");
		spark.config().setDocumentTitle("Automation Test Report");
		spark.config().setTheme(Theme.DARK);
		// Create ExtentReports object
		extent = new ExtentReports();
		extent.attachReporter(spark);

		extent.setSystemInfo("Tester", "Mayuri");
		extent.setSystemInfo("Environment", "QA");
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, "====" + result.getMethod().getMethodName() + " Exceution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "====" + result.getMethod().getMethodName() + " Exceution Successfully done");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		Date d = new Date();
		String newdata = d.toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot ts = (TakesScreenshot) baseClass.sdriver;
		String temp = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(temp, testname + newdata);
		test.log(Status.FAIL, "====" + result.getMethod().getMethodName() + " Exceution failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "====" + result.getMethod().getMethodName() + " Exceution skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
