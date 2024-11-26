package pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;


public class ProductList{

	WebDriver driver;
	ReusableMethods reusableMethods;
	public ProductList(WebDriver driver){
		this.driver=driver;
		this.reusableMethods =new ReusableMethods(driver);
		PageFactory.initElements(driver,this);
	}
	@FindBy(css=".product-layout")
	List<WebElement> listOfElement;
	
	public void selectProduct(String productName) { //selecting the product form the list
		reusableMethods.visibilityOfAllElements(listOfElement);
		List<WebElement> a = listOfElement;
		for (WebElement d : a) {
			String name = d.findElement(By.cssSelector(" div[class='caption'] h4")).getText();
			if (name.contains(productName)) {
				d.findElement(By.cssSelector("button[onclick*='cart.add']")).click();
			}
		}
	}
}
