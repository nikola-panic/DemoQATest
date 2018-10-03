package TestNGtrain01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.AbstractPage;
import PageObjects.HomePage;
import PageObjects.RegisterPage;

public class BadRegistrationTest {

	WebDriver driver;
	
	// WebDriver instantiation
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C://Apps/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	// Browser shut down
	@AfterTest(enabled = false)
	public void shutDown() {
		driver.close();
	}

	// Testing entering the empty field, false email & mismatching passwords
	@Test
	public void FalseRegistration() throws InterruptedException {
		// Navigating to the site
		AbstractPage onAbsPage = new AbstractPage(driver);
		onAbsPage.navigateToSite("http://demoqa.com/");

		Thread.sleep(3000);

		// Click on the registration button
		HomePage onHomePage = new HomePage(driver);
		onHomePage.ClickToRegistration();

		Thread.sleep(3000);

		// Fill false form, empty field, false email, mismatching passwords
		RegisterPage onRegisterPage = new RegisterPage(driver);
		onRegisterPage.fillTheForm("John", "Doe", "fakenumber", "", "wrongemail", "Hello World!", "weakpass",
				"weakPpass");
		onRegisterPage.clickSubmit();
		
		Thread.sleep(3000);

		// Get the error messages
		String emptyFieldErrorMsg = driver
				.findElement(By.cssSelector("#pie_register > li:nth-child(7) > div > div > span")).getText();
		String emailErrorMsg = driver.findElement(By.xpath("//*[@id=\"pie_register\"]/li[8]/div/div/span")).getText();
		String mismatchingPassMsg = driver
				.findElement(By.cssSelector("#pie_register > li:nth-child(12) > div > div > span")).getText();
		
		Assert.assertTrue(emptyFieldErrorMsg.contains("* This field is required"));
		Assert.assertTrue(emailErrorMsg.contains("* Invalid email address"));
		Assert.assertTrue(mismatchingPassMsg.contains("* Fields do not match"));
		
	}
}