package StepDefinitions;

import org.testng.Assert;

import Pages.LaunchPage;
import Pages.SignInPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInStepDef {

	SignInPage signIn = new SignInPage();
	LaunchPage lp = new LaunchPage();

	@Given("User is in Sign-Page.")
	public void user_is_in_sign_page() {

		lp.launchApplication();
		lp.clickGetStarted();

		signIn.clickOnSignIn();

	}

	@When("User clicks on Sign-in link on Sign-In Page.")
	public void user_clicks_on_sign_in_link_on_sign_in_page() {

		signIn.clickOnSignIn();
	}

	@Then("User Sign-In page should be dispalyed.")
	public void user_sign_in_page_should_be_dispalyed() {

		Assert.assertEquals(signIn.getPageTitle(), "Login");
	}

	@When("User clicks on {string} link in Sign-In Page.")
	public void user_clicks_on_link_in_sign_in_page(String registerLink) {

		signIn.clickLink(registerLink);

	}

	@Then("User should be redirected to register Page.")
	public void user_should_be_redirected_to_register_page() {
		Assert.assertEquals(signIn.getPageTitle(), "Registration");
	}

//	@When("User clicks on {string} link  below username and password field of Sign-In Page.")
//	public void user_clicks_on_link_below_username_and_password_field_of_sign_in_page(String string) {
//		
//	}

	@When("User enters {string},{string} and clicks on Login.")
	public void user_enters_and_clicks_on_login(String username, String password) throws InterruptedException {
		signIn.Login(username, password);

	}

	@Then("{string} should be displayed.")
	public void should_be_displayed(String loginMsg) {

		Assert.assertEquals(signIn.verifySuccesfulLogin().strip(), loginMsg);
	}
}
