package pageObjectModel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;

public class Cartdialoguebox{

	WebDriver driver;
	ReusableMethods reusablemethod;
	public Cartdialoguebox(WebDriver driver) {
		this.driver=driver;
		this.reusablemethod= new ReusableMethods(driver);
		PageFactory.initElements(driver,this);
	}
	@FindBy(css=".btn.btn-inverse.btn-block.btn-lg.dropdown-toggle")
	WebElement cart;
	
	@FindBy(css="strong i[class*='fa-shopping-cart']")
	WebElement cartbox;
	
	
	public void clickChekout() throws InterruptedException {
		Thread.sleep(1000);
		reusablemethod.visibilityOf(cart);
		cart.click();
		reusablemethod.visibilityOf(cartbox);
		cartbox.click();
	}
}
