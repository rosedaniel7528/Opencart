package withoutFrameWork;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PlacingOrder {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// System.setProperty("webdriver.chrome.driver",
		// "F:\\unknown\\chromedriver-win64\\chromedriver-win64.exe");

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String productName = "Nikon D300";
		driver.manage().window().maximize();
		driver.get("https://awesomeqa.com/ui/index.php?route=common/home");
		driver.findElement(By.xpath("// a[text()='Cameras']")).click();

		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector(".product-layout"))));
		List<WebElement> a = driver.findElements(By.cssSelector(".product-layout"));
		for (WebElement d : a) {
			String name = d.findElement(By.cssSelector(" div[class='caption'] h4")).getText();
			if (name.contains(productName)) {
				d.findElement(By.cssSelector("button[onclick*='cart.add']")).click();
			}
		}
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("cart"))));
		driver.findElement(By.id("cart")).click();

		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.cssSelector("strong i[class*='fa-shopping-cart']"))));
		driver.findElement(By.cssSelector("strong i[class*='fa-shopping-cart']")).click();
		//cart page
		List<WebElement> cartList = driver.findElements(By.cssSelector(".table-bordered td[class='text-left'] a "));
		boolean Flag = cartList.stream().anyMatch(s -> s.getText().equals(productName));
		Assert.assertTrue(Flag);
		driver.findElement(By.cssSelector(".buttons.clearfix div[class='pull-right']")).click();
		//checkout page
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("collapse-checkout-option"))));
		driver.findElement(By.cssSelector("input[value='guest']")).click();
		driver.findElement(By.id("button-account")).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("collapse-payment-address"))));
		driver.findElement(By.id("input-payment-firstname")).sendKeys("Rose");
		driver.findElement(By.id("input-payment-lastname")).sendKeys("Daniel");
		driver.findElement(By.id("input-payment-email")).sendKeys("rose@gmail.com");
		driver.findElement(By.id("input-payment-telephone")).sendKeys("2323423232");
		driver.findElement(By.id("input-payment-address-1")).sendKeys("nowhere");
		driver.findElement(By.id("input-payment-city")).sendKeys("hyd");
		driver.findElement(By.id("input-payment-postcode")).sendKeys("267887");
		WebElement country = driver.findElement(By.id("input-payment-country"));
		Select opt = new Select(country);
		opt.selectByVisibleText("Brazil");
		WebElement zone = driver.findElement(By.id("input-payment-zone"));
		Select opt2 = new Select(zone);
		opt2.selectByVisibleText("Acre");
		driver.findElement(By.id("button-guest")).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("collapse-shipping-method"))));
		driver.findElement(By.id("button-shipping-method")).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("collapse-payment-method"))));
		driver.findElement(By.cssSelector("input[type*='checkbox'][name='agree']")).click();
		driver.findElement(By.id("button-payment-method")).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("collapse-checkout-confirm"))));
		driver.findElement(By.id("button-confirm")).click();
		// order success page
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("common-success"))));
		String ordermsg = driver.findElement(By.cssSelector("#content h1")).getText();
		Assert.assertEquals(ordermsg, "Your order has been placed!");
	}

}
