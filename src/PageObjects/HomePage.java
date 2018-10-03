package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends AbstractPage {

	WebElement RegistrationButton = driver.findElement(By.xpath("//*[@id=\"menu-item-374\"]/a"));

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void ClickToRegistration() {
		RegistrationButton.click();
	}

}
