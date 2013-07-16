package screenshot;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FullScreenShot {
	public static void main(String[] args) throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.baidu.com/");
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("D:\\test.png"));
		savePngWithUIUDName(f);
		driver.quit();
	}
	
	private static void savePngWithUIUDName(File f) throws IOException {
		UUID uniqueName = UUID.randomUUID();
		System.out.println(uniqueName);
		FileUtils.copyFile(f, new File("D:\\" + uniqueName.toString() + ".png"));
	}
}
