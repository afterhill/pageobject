package testdriver;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.containsString;

import pageobject.HomePage;
import pageobject.LoginPage;

public class Scenario01 {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
	}
	
	@Test
	public void testLogin() {
		LoginPage lp = new LoginPage(driver, "LoginPage");
		HomePage hp = lp.loginAs("test", "test-setraining");
		assertThat(hp.getTitle(), containsString("HomePage"));
		
	}
	
}
