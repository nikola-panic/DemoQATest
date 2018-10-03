package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegisterPage extends AbstractPage {

	WebElement onCorrectPage = driver.findElement(By.cssSelector("#post-49 > header > h1"));
	WebElement nameField = driver.findElement(By.id("name_3_firstname"));
	WebElement lastNameField = driver.findElement(By.id("name_3_lastname"));
	WebElement maritialStatus = driver.findElement(By.name("radio_4[]"));
	WebElement hobbyChoose = driver.findElement(By.name("checkbox_5[]"));
	WebElement dropDown = driver.findElement(By.id("dropdown_7"));
	WebElement monthOfBirth = driver.findElement(By.id("mm_date_8"));
	WebElement dayOfBirth = driver.findElement(By.id("dd_date_8"));
	WebElement yearOfBirth = driver.findElement(By.id("yy_date_8"));
	WebElement phoneNumber = driver.findElement(By.id("phone_9"));
	WebElement userNameField = driver.findElement(By.id("username"));
	WebElement emailField = driver.findElement(By.id("email_1"));
	WebElement uploadImg = driver.findElement(By.id("profile_pic_10"));
	WebElement descriptionField = driver.findElement(By.id("description"));
	WebElement passwordField = driver.findElement(By.id("password_2"));
	WebElement confirmPasswordField = driver.findElement(By.id("confirm_password_password_2"));
	WebElement strengthIndicator = driver.findElement(By.id("piereg_passwordStrength"));
	WebElement submitButton = driver.findElement(By.name("pie_submit"));

	Select selectCountry = new Select(dropDown);
	Select birthMonth = new Select(monthOfBirth);
	Select birthDay = new Select(dayOfBirth);
	Select birthYear = new Select(yearOfBirth);

	String imgPath = "C:/Users/HP/Desktop/avatardefault.jpg";

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	public RegisterPage checkPage() {
		boolean status = onCorrectPage.isDisplayed();
		Assert.assertTrue(status);
		return new RegisterPage(driver);
	}

	public void fillTheForm(String name, String lastName, String phone, String username, String email,
			String description, String password, String confirmPass) {
		nameField.sendKeys(name);
		lastNameField.sendKeys(lastName);
		maritialStatus.click();
		hobbyChoose.click();
		selectCountry.selectByValue("Serbia and Montenegro");
		birthMonth.selectByValue("3");
		birthDay.selectByValue("3");
		birthYear.selectByValue("1993");
		phoneNumber.sendKeys(phone);
		userNameField.sendKeys(username);
		emailField.sendKeys(email);
		uploadImg.sendKeys(imgPath);
		descriptionField.sendKeys(description);
		passwordField.sendKeys(password);
		confirmPasswordField.sendKeys(confirmPass);
	}

	public String getPasswordStrength() {
		return strengthIndicator.getText();
	}

	public void clickSubmit() {
		submitButton.click();
	}

}
