package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	private final WebDriver driver;
	@FindBy(how = How.NAME, using = "username")
	private WebElement userName;
	
	@FindBy(name = "password")
	private WebElement passWord;
	
	public LoginPage(WebDriver driver, String expectedTitle) {
		this.driver = driver;
		
		if (!expectedTitle.equals(driver.getTitle())) {
			throw new IllegalArgumentException("This is not the login page");
		}
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
}
