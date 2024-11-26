package withoutFrameWork;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Scrolling {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://awesomeqa.com/ui/index.php?route=common/home");

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(
				By.xpath("//ul[@class='nav navbar-nav']//a[@data-toggle='dropdown' and contains(text(),'Desktops')]")))
				.build().perform();
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//a[@class='see-all' and contains(text(),'Desktops')]")).click();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2500)");
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("E:\\Screenshot.png"));

	}

}
