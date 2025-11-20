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
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	public static void initDriver(String browserName) {
	//	String browserName = ConfigReader.getProperty("browser");
		logger.info("You selected "+browserName+ " to run these tests");

		if (browserName.equalsIgnoreCase("chrome")) {
			tlDriver.set(new ChromeDriver());
		} else if (browserName.trim().equalsIgnoreCase("firefox")) {
			tlDriver.set(new FirefoxDriver());
		} else if (browserName.trim().equalsIgnoreCase("edge")) {
			tlDriver.set( new EdgeDriver());
		}
		else tlDriver.set(new FirefoxDriver());
		tlDriver.get().manage().window().maximize();
	}
}
