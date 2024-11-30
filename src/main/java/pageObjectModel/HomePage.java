package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.ReusableMethods;

public class HomePage {
	
	WebDriver driver;
	ReusableMethods reusablemethods;
	public HomePage(WebDriver driver) {
	
		this.driver=driver;
		this.reusablemethods = new ReusableMethods(driver);
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="// a[text()='Cameras']")
	WebElement cameraicon;
	
	@FindBy(id="search")
	WebElement searchfield;
	
	@FindBy(css="input[name*='search']")
	WebElement searchbox;
	
	@FindBy(css=".btn.btn-default.btn-lg")
	WebElement searchbtn;
	
	public void clickMenu() {
		cameraicon.click();
	}
	
	public void searchbox() {
		
		reusablemethods.visibilityOf(searchfield);
		searchbox.click();
		searchbox.sendKeys("ipod");
		searchbtn.click();
	}
}
