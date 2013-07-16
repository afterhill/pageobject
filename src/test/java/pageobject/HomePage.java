package pageobject;

import org.openqa.selenium.WebDriver;

public class HomePage {
	private final WebDriver driver;
	
	public HomePage(WebDriver driver, String expectedTitle) {
		this.driver = driver;

		if (!expectedTitle.equals(driver.getTitle())) {
			throw new IllegalStateException("This is not the login page!");
		}
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
}
