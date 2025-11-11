
package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DriverFactory.DriverFactory;

public class SignInPage {
	
	private WebDriver driver;
	@FindBy(xpath = "//a[text()='Sign in']")
	WebElement signInLink;
	
	@FindBy(xpath = "//a[@href='/register']")
	WebElement register1Link;
	
	@FindBy(xpath = "//a[text()='Register!']")
	WebElement register2Link;

	public SignInPage() {
		driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnSignIn()
	{
		signInLink.click();
		
	}
	
	public String verifySiginPage()
	{
		return driver.getTitle();
	}
	
	public void clickOnRegister1Link()
	{
		register1Link.click();
	}
	
	public String verifyRegisterPage()
	{
		return driver.getTitle();
	}
	
	public void clickOnRegister2Link()
	{
		register2Link.click();
	}
	
	

	
	
	//a[text()='Sign in']
	
	//a[@href='/register']
	
	//a[text()='Register!']

}
