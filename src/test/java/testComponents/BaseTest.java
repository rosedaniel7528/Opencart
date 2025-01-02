package testComponents;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.io.IOException;
import org.testng.ITestContext;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	public WebDriver initilize(ITestContext context) {
		ChromeOptions option = new ChromeOptions();
		option.setExperimentalOption("excludeSwitches",
			     Arrays.asList("disable-popup-blocking"));
		driver = new ChromeDriver(option);
		driver.get("https://awesomeqa.com/ui/index.php?route=common/home");
		driver.manage().window().maximize();
		context.setAttribute("WebDriver",driver);
		return driver;
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}

	public List<HashMap<String, String>> dataReader(String path) throws IOException {

		// converting jason file into string
		String jasonStringfile = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
		// converting String into HasMap using Jason Databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> map = mapper.readValue(jasonStringfile,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return map;
	}
	
	    public String getScreenshot(String testname, WebDriver driver2) throws IOException {
		TakesScreenshot take =(TakesScreenshot)driver2;
		File source =take.getScreenshotAs(OutputType.FILE);
		File picture = new File(System.getProperty("user.dir")+"\\reports\\"+testname+".png");
		System.out.println(System.getProperty("user.dir")+"\\reports\\"+testname+".png");
		FileUtils.copyFile(source,picture);
		return System.getProperty("user.dir")+"\\reports\\"+testname+".png";
	}
}
