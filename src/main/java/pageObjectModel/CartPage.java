package pageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.ReusableMethods;

public class CartPage{
	WebDriver driver;
	ReusableMethods reusableMethods;
	public CartPage(WebDriver driver){
		this.driver=driver;
		this.reusableMethods = new ReusableMethods(driver);
		PageFactory.initElements(driver,this);
	}
	@FindBy(css=".table-bordered td[class='text-left'] a")
	List<WebElement> productlist;
	
	@FindBy(css=".buttons.clearfix div[class='pull-right']")
	WebElement checkout;
	
	public void checkproductincart(String productName) {
		List<WebElement> cartList = productlist;
		boolean Flag = cartList.stream().anyMatch(s -> s.getText().equals(productName));
		Assert.assertTrue(Flag);
		checkout.click();
	}
	
}
