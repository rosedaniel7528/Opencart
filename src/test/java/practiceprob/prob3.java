package practiceprob;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class prob3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ChromeOptions option = new ChromeOptions();
		//to get rid of chrome popups like location,mic
		option.setExperimentalOption("excludeSwitches",
			     Arrays.asList("disable-popup-blocking"));
		option.setAcceptInsecureCerts(true);
		// to set download location
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		option.setExperimentalOption("prefs", prefs);
		
		WebDriver driver= new ChromeDriver(option);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		driver.manage().deleteCookieNamed("dsvdv");
		
		File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("E:\\imagee.png"));
		
	}

}
