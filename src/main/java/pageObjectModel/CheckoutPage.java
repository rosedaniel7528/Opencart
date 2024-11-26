package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.ReusableMethods;

public class CheckoutPage{
	WebDriver driver;
	ReusableMethods reusableMethods;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		this.reusableMethods = new ReusableMethods(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "collapse-checkout-option")
	WebElement checkoutoption;

	@FindBy(css = "input[value='guest']")
	WebElement radioguest;

	@FindBy(css = "button-account")
	WebElement Continue;

	@FindBy(id = "collapse-payment-address")
	WebElement accountandbill;

	@FindBy(id = "input-payment-firstname")
	WebElement firstname;

	@FindBy(id = "input-payment-lastname")
	WebElement lastname;

	@FindBy(id = "input-payment-email")
	WebElement email;

	@FindBy(id = "input-payment-telephone")
	WebElement number;

	@FindBy(id = "input-payment-address-1")
	WebElement adress;

	@FindBy(id = "input-payment-city")
	WebElement city;

	@FindBy(id = "input-payment-postcode")
	WebElement postcode;

	@FindBy(id = "input-payment-country")
	WebElement Country;

	@FindBy(id = "input-payment-zone")
	WebElement Zone;

	@FindBy(id = "button-guest")
	WebElement Billingcontinue;

	@FindBy(id = "collapse-shipping-method")
	WebElement deliverymethod;

	@FindBy(id = "button-shipping-method")
	WebElement deliverymethodcontinue;

	@FindBy(id = "collapse-payment-method")
	WebElement paymentmethod;

	@FindBy(css = "input[type*='checkbox'][name='agree']")
	WebElement Termscheckbox;

	@FindBy(id = "button-payment-method")
	WebElement paymentcontinue;

	@FindBy(id = "collapse-checkout-confirm")
	WebElement checkout;

	@FindBy(id = "button-confirm")
	WebElement confirmorder;

	public void fillCheckoutDetails() {
		reusableMethods.visibilityOf(checkoutoption);
		radioguest.click();
		driver.findElement(By.id("button-account")).click();

		reusableMethods.visibilityOf(accountandbill);
		firstname.sendKeys("Rose");
		lastname.sendKeys("Daniel");
		email.sendKeys("rose@gmail.com");
		number.sendKeys("2323423232");
		adress.sendKeys("nowhere");
		city.sendKeys("hyd");
		postcode.sendKeys("267887");
		WebElement country = Country;
		Select opt = new Select(country);
		opt.selectByVisibleText("Brazil");
		WebElement zone = Zone;
		Select opt2 = new Select(zone);
		opt2.selectByVisibleText("Acre");
		Billingcontinue.click();

		reusableMethods.visibilityOf(deliverymethod);
		deliverymethodcontinue.click();

		reusableMethods.visibilityOf(paymentmethod);
		Termscheckbox.click();
		paymentcontinue.click();

		reusableMethods.visibilityOf(checkout);
		confirmorder.click();
	}
}
