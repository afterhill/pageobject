package testdriver;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import pagefactory.BaiduSearchPage;

public class Scenario02 {
	private WebDriver driver;
	private BaiduSearchPage bsp;
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("http://www.baidu.com");
		bsp = new BaiduSearchPage(driver, "百度一下，你就知道");
		PageFactory.initElements(driver, bsp);
	}
	
	
	@Test
	public void testSearchKeyWord() {
		bsp.typeKeyWord("litianyi");
		bsp.clickButton();
	}
	
}
