package withoutFrameWork;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
		
		driver.findElement(By.cssSelector(".fa.fa-user")).click();
		
		
		

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(
				By.xpath("//ul[@class='nav navbar-nav']//a[@data-toggle='dropdown' and contains(text(),'Desktops')]")))
				.build().perform();
		driver.findElement(
				By.xpath("//ul[@class='nav navbar-nav']//a[@class='see-all' and contains(text(),'Desktops')]")).click();

		act.moveToElement(driver.findElement(By.cssSelector("[name='search']"))).click().keyDown(Keys.SHIFT)
				.sendKeys("Sony VAIO").doubleClick().build().perform();
		driver.findElement(By.cssSelector("#search [type='button']")).click();

//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,2500)");
		
		Set<String> handles= driver.getWindowHandles();
		List<String> j= new ArrayList<>(handles);
		
		for(String h:handles) {
			driver.switchTo().window(h);
			if(driver.getTitle().contains("title")) {
				driver.close();
				break;
			}
		}
		

	}

}
