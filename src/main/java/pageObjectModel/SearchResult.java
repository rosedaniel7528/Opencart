package pageObjectModel;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ReusableMethods;

public class SearchResult {
	
	WebDriver driver;
	ReusableMethods reuse;

	public SearchResult(WebDriver driver) {
		this.driver= driver;
		this.reuse= new ReusableMethods(driver);
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".product-thumb")
	List<WebElement> productlist;
	
	
	public void selectproduct(String productname) throws InterruptedException {
		
		//reuse.visibilityOfAllElements(productlist);
		Thread.sleep(3000);
		List<WebElement> lop = productlist;
		List<WebElement> pro = lop.stream()
				.filter(c -> c.findElement(By.cssSelector("h4")).getText().equalsIgnoreCase(productname))
				.collect(Collectors.toList());

		pro.get(0).findElement(By.cssSelector(".fa-shopping-cart")).click();
	}
	
}
