
package Pages;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DriverFactory.DriverFactory;

public class SignInPage {

	private static final Logger logger = LogManager.getLogger(SignInPage.class);
	private WebDriver driver;
	@FindBy(xpath = "//a[text()='Sign in']")
	WebElement signInLink;

	@FindBy(xpath = "//a[@href='/register']")
	WebElement register1Link;

	@FindBy(xpath = "//a[text()='Register!']")
	WebElement register2Link;

	@FindBy(id = ("id_username"))
	WebElement UsernameInputbox;

	@FindBy(id = ("id_password"))
	WebElement PasswordInputbox;

	@FindBy(xpath = ("//input[@value='Login']"))
	WebElement LoginButton;

	@FindBy(xpath = ("//div[@role='alert']"))
	WebElement LoginAlert;

	Map<String, WebElement> registerLink = new HashMap<>();

	public SignInPage() {
		driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);

		{
			registerLink.put("register", register1Link);
			registerLink.put("register!", register2Link);
		}

	}

	// registerLink.put("",xyz);

	// Map<String, Integer> map = new HashMap<>();
	// map.put("one", 1);
	// map.put("two", 2);
	// linkLocators.put("register", register1Link);
	// linkLocators.put("register!", register2Link);

	public void clickOnSignIn() {
		signInLink.click();

	}

//	public String verifySiginPage() {
//		return driver.getTitle();
//	}

	public String getPageTitle() {
		return driver.getTitle();
	}

//	public void clickOnRegister1Link() {
//		register1Link.click();
//	}

//	public String verifyRegisterPage() {
//		return driver.getTitle();
//	}

//	public void clickOnRegister2Link() {
//		register2Link.click();
//	}

	public void clickLink(String linkName) {
		WebElement linkElement = registerLink.get(linkName);

		if (linkElement != null) {

			linkElement.click();
		} else {
			throw new IllegalArgumentException("Link name not found in locator map: " + linkName);
		}

	}

	public void Login(String username, String password) {

		UsernameInputbox.sendKeys(username);
		PasswordInputbox.sendKeys(password);
		LoginButton.click();

	}

	public String verifySuccesfulLogin() {
		return LoginAlert.getText();
	}

}
