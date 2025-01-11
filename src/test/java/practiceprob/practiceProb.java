package practiceprob;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class practiceProb {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://awesomeqa.com/ui/index.php?route=common/home");
		
		driver.findElement(By.cssSelector(".product-thumb img")).click();
		
		driver.navigate().back();
		driver.navigate().refresh();
		driver.navigate().forward();
		
		Actions act = new Actions(driver);
		
		WebElement k=driver.findElement(By.cssSelector("ul[class='thumbnails'] li:nth-child(1) a:nth-child(1)"));
	
		act.clickAndHold(k).build().perform();
		act.moveToElement(driver.findElement(By.id("search"))).release().build().perform();

		((JavascriptExecutor)driver).executeScript("window.open('about:blank','blank')");
		Set<String> tabs= driver.getWindowHandles();
		for(String i: tabs) {
			if(!i.contains("awesomeqa"))
		driver.switchTo().window(i);
		}
	    driver.get("https://jqueryui.com/droppable/");
	    driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
	    
	    WebElement obj =driver.findElement(By.id("draggable"));
	    WebElement drop =driver.findElement(By.id("droppable"));
	    act.clickAndHold(obj).moveToElement(drop).release().build().perform();
	   
	    driver.switchTo().defaultContent();
	    
	    
	}

}
