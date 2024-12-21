package practiceprob;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class prob2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		WebDriverWait waitt = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency")).click();
		Thread.sleep(1000);
		WebElement d= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select opt = new Select(d);
		opt.selectByVisibleText("USD");
		System.out.println(opt.getFirstSelectedOption().getText());
		
		
		
		driver.findElement(By.id("autosuggest")).click();
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		List<WebElement> li= driver.findElements(By.cssSelector("#ui-id-1 a"));
		
		for(WebElement l: li) {
			String text =l.getText();
			if(text.equalsIgnoreCase("India")) {
	
				l.click();
				break;
			}
		}
		((JavascriptExecutor)driver).executeScript("window.open('about:blank','blank')");
        
        
		Set<String> tabs= driver.getWindowHandles();
		for(String i: tabs) {
			if(!i.contains("rahulshetty"))
		driver.switchTo().window(i);
		}
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(10))
			       .pollingEvery(Duration.ofSeconds(2))
			       .ignoring(NoSuchElementException.class);

			   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       return driver.findElement(By.id("alertbtn"));
			     }
			   });
			   driver.findElement(By.id("alertbtn")).click();
			   driver.switchTo().alert().accept();
			   
			   List<WebElement> list= driver.findElements(By.xpath("//li[@class='gf-li']/a"));
			   String clk= Keys.chord(Keys.CONTROL,Keys.ENTER);
			   for(WebElement l:list) {
				   l.sendKeys(clk);
			   }
			   Set<String> hand= driver.getWindowHandles();
			   
			   String parent = driver.getWindowHandle();
			   for(String h:hand) {
				   if(!h.equals(parent)) {
					  driver.switchTo().window(h);
					  driver.close();
				   }
			   }
			   driver.switchTo().window(parent);
			  JavascriptExecutor js=  (JavascriptExecutor)driver;
			  js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
	}
}
