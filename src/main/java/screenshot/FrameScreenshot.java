package screenshot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameScreenshot {
	public static void main(String[] args) throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.baidu.com/");
		WebElement button = driver.findElement(By.id("kw"));
		int buttonWidth = button.getSize().getWidth();
		int buttonHeight = button.getSize().getHeight();
		Point point = button.getLocation();
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImage = ImageIO.read(f);
		BufferedImage eleScreenshot = fullImage.getSubimage(point.getX(),
				point.getY(), buttonWidth, buttonHeight);
		ImageIO.write(eleScreenshot, "png", f);
		savePngWithUIUDName(f);
		driver.quit();
	}

	private static void savePngWithUIUDName(File f) throws IOException {
		UUID uniqueName = UUID.randomUUID();
		System.out.println(uniqueName);
		FileUtils
				.copyFile(f, new File("D:\\" + uniqueName.toString() + ".png"));
	}
}
