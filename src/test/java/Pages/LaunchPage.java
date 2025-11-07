package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DriverFactory.DriverFactory;
import Utils.ConfigReader;

public class LaunchPage {
	private WebDriver driver;
	@FindBy(xpath = "//button[@class='btn']")
	private WebElement getStartedButton;

	public LaunchPage() {
		driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}

	public void clickGetStarted() {
		getStartedButton.click();
	}

	public String fetchTitle() {
		System.out.println(driver.getTitle());
		return driver.getTitle();

	}

	public void launchApplication() {
		String url = ConfigReader.getProperty("url");
		driver.get(url);
	}
}
