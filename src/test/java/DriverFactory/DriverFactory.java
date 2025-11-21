package DriverFactory;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;

public class DriverFactory {
	private static final Logger logger = LogManager.getLogger(DriverFactory.class);
	private static final ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	private static ThreadLocal<String> plbrowser = new ThreadLocal<>();
	
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		return tldriver.get();

	}

	public static void setupBrowser(String browser) {
		plbrowser.set(browser);
		System.out.println(browser);

	}

	public static void initDriver() {
		

		String browserName = plbrowser.get();
		System.out.println(browserName);
		logger.info("You selected " + browserName + " to run these tests");
		
		if (browserName.trim().equalsIgnoreCase("chrome")) {
			tldriver.set(new ChromeDriver());

		} else if (browserName.trim().equalsIgnoreCase("firefox")) {
			tldriver.set(new FirefoxDriver());

		} else if (browserName.trim().equalsIgnoreCase("edge")) {
			tldriver.set(new EdgeDriver());

		} else {
			logger.info("You selected wrong browser: " + browserName);
			return;
		}
		driver = tldriver.get();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

	}

	@After(order = 0)
	public void close() {

		tldriver.remove();

	}

}
