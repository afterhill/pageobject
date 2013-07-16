package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private final WebDriver driver;
	
	public LoginPage(WebDriver driver, String expectedTitle) {
		this.driver = driver;
		
		if (!expectedTitle.equals(driver.getTitle())) {
			throw new IllegalStateException("This is not the login page!");
		}
	}
	
	protected By userNameLocator = By.id("username");
	protected By passWordLocator = By.id("passwd");
	protected By loginButtonLocator = By.id("login");
	
	public LoginPage typeUserName(String username) {
		driver.findElement(userNameLocator).sendKeys(username);
		return this;
	}
	
	public LoginPage typePassword(String pass) {
		driver.findElement(passWordLocator).sendKeys(pass);
		return this;
	}
	
	public HomePage submitLogin() {
		driver.findElement(loginButtonLocator);
		return new HomePage(driver, "HomePage");
	}
	
	public LoginPage submitLoginExpectingFailure() {
		driver.findElement(loginButtonLocator).submit();
		return this;
	}
	
	public HomePage loginAs(String username, String passwd) {
		typeUserName(username);
		typePassword(passwd);
		return submitLogin();
	}
}
