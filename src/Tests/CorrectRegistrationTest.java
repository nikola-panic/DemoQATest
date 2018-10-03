package TestNGtrain01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.AbstractPage;
import PageObjects.HomePage;
import PageObjects.RegisterPage;

public class CorrectRegistrationTest {

	WebDriver driver;
	
	// WebDriver instantiation
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C://Apps/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	// Browser shut down
	@AfterTest
	public void ShutDown() {
		driver.quit();
	}
	
	// Testing registration
	@Test
	public void Registration() throws InterruptedException {
		// Navigating to the site
		AbstractPage onAbsPage = new AbstractPage(driver);
		onAbsPage.navigateToSite("http://demoqa.com/");

		Thread.sleep(3000);

		// Click on the registration button
		HomePage onHomePage = new HomePage(driver);
		onHomePage.ClickToRegistration();

		Thread.sleep(3000);

		// Fill the form correctly
		RegisterPage onRegisterPage = new RegisterPage(driver);
		onRegisterPage.fillTheForm("John", "Doe", "123123123123", "johnnie", "email@email.com", "Hello World!", "goodpass",
				"goodpass");
		onRegisterPage.clickSubmit();

		Thread.sleep(3000);

	}

}
