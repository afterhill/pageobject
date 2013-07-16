package screenshot;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RobotScreenshot {
	public static void main(String[] args) throws IOException, AWTException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.baidu.com/");
		Robot robot = new Robot();
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRect = new Rectangle(0, 0, dimension.width, dimension.height);
		robot.createScreenCapture(screenRect);
		BufferedImage f = robot.createScreenCapture(screenRect);
		savePngWithUIUDName(f);
		driver.quit();
	}
	
	private static void savePngWithUIUDName(BufferedImage f) throws IOException {
		UUID uniqueName = UUID.randomUUID();
		System.out.println(uniqueName);
		ImageIO.write(f, "png", new File("D:\\" + uniqueName.toString() + ".png"));
	}
}
