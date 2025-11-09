package DriverFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utils.ConfigReader;

public class DriverFactory {
	private static final Logger logger = LogManager.getLogger(DriverFactory.class);
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void initDriver() {
		String browserName = ConfigReader.getProperty("browser");
		logger.info("You selected "+browserName+ " to run these tests");

		if (browserName.trim().equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.trim().equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.trim().equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
	}
}
