package testComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resource.ExtentReport;

public class Listeners extends BaseTest implements ITestListener{
	ExtentTest test; // keeps record/log of extentreport test cases 
	ExtentReports extent = ExtentReport.extentreportobj(); //Monitor the test cases
	ThreadLocal<ExtentTest> thread= new ThreadLocal<ExtentTest>();
	
	
	@Override
	public void onTestStart(ITestResult result) {
		test =extent.createTest(result.getMethod().getMethodName());
		System.out.println(result.getMethod().getMethodName());
		thread.set(test);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		thread.get().log(Status.PASS,"Test Passed");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = (WebDriver) result.getTestContext().getAttribute("WebDriver");
		String picturepath = null;
		try {
			picturepath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread.get().addScreenCaptureFromPath(picturepath);
		thread.get().log(Status.FAIL,"Test Failed");
	}
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();;
	}
	
	
	

}
