package resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public static ExtentReports extentreportobj() {
		
		String path= System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter spark = new ExtentSparkReporter(path);
		spark.config().setReportName("Opencart WebAutomation");
		spark.config().setDocumentTitle("Test Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "Rose Daniel");
		return extent;
	}
}
