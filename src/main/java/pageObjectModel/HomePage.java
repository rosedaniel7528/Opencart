package pageObjectModel;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import utilities.ReusableMethods;

public class HomePage {

	WebDriver driver;
	ReusableMethods reusablemethods;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		this.reusablemethods = new ReusableMethods(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "// a[text()='Cameras']")
	WebElement cameraicon;

	@FindBy(id = "search")
	WebElement searchfield;

	@FindBy(css = "input[name*='search']")
	WebElement searchbox;

	@FindBy(css = ".btn.btn-default.btn-lg")
	WebElement searchbtn;

	@FindBy(xpath = "//ul[@class='nav navbar-nav']//a[@data-toggle='dropdown' and contains(text(),'Desktops')]")
	WebElement desktop;

	public void clickMenu() {
		cameraicon.click();
	}

	public void searchbox(String productname) {

		reusablemethods.visibilityOf(searchfield);
		searchbox.click();
		searchbox.sendKeys(productname);
		searchbtn.click();
	}

	public void clickdesktop() {
		Actions act = new Actions(driver);
		act.moveToElement(desktop).build().perform();
		desktop.click();
		reusablemethods.scrolldown();
	}

	public void brokenlinks() throws MalformedURLException, IOException {
		
		List<WebElement> links = driver.findElements(By.cssSelector("footer div[class='row'] a"));
		for (int i=0;i<links.size();i++) {
			SoftAssert soft = new SoftAssert();
			String url = links.get(i).getAttribute("href");
			HttpURLConnection con = (HttpURLConnection)new URL(url).openConnection();
			con.setRequestMethod("HEAD");
			con.connect();
			int code = con.getResponseCode();
			if(code>400) {
				soft.fail("Broken link: " + links.get(i).getText());
			}
			soft.assertAll();
		}
	}
}
