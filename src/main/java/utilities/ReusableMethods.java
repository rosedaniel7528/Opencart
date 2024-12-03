package utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethods {

	WebDriver driver;
	WebDriverWait wait;

	public ReusableMethods(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	

	public void visibilityOfAllElements(List<WebElement> listOfElement) {
		wait.until(ExpectedConditions.visibilityOfAllElements(listOfElement));
	}

	public void elementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void visibilityOf(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void scrolldown() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2500)");
	}
}
