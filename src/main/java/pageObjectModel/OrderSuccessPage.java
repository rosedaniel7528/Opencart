package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.ReusableMethods;

public class OrderSuccessPage{

	WebDriver driver;
	ReusableMethods reusemethods;
	public OrderSuccessPage(WebDriver driver){
		this.driver=driver;
		this.reusemethods = new ReusableMethods(driver);
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="common-success")
	WebElement orderpage;
	
	@FindBy(css="#content h1")
	WebElement orderMsg;
	
	public void orderconfirmation() {
		reusemethods.visibilityOf(orderpage);
		String ordermsg = orderMsg.getText();
		Assert.assertEquals(ordermsg, "Your order has been placed!");
	}
}
