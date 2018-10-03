package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AbstractPage {

	protected WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage navigateToSite(String url) {
		driver.navigate().to(url);
		boolean status = driver.findElement(By.xpath("//*[@id=\"menu-item-38\"]/a")).isDisplayed();
		Assert.assertTrue(status);
		return new HomePage(driver);
	}

}
