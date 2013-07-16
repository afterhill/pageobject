package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaiduSearchPage {
	
	@FindBy(id="kw")
	private WebElement inputBox;
	
	@FindBy(id="su")
	private WebElement submitButton;
	
	public BaiduSearchPage(WebDriver driver, String expectedTitle) {
		if(!expectedTitle.equals(driver.getTitle())) {
			throw new IllegalArgumentException("This is not baidu home page.");
		}
	}
	
	public BaiduSearchPage typeKeyWord(String key) {
		inputBox.sendKeys(key);
		return this;
	}
	
	public BaiduSearchPage clickButton() {
		submitButton.submit();
		return this;
	}
	
}
