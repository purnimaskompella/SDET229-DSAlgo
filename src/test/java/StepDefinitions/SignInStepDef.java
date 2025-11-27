package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import DriverFactory.DriverFactory;
import Pages.LaunchPage;
import Pages.SignInPage;
import Utils.Savedata;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInStepDef {

	public static Scenario scenario;
	public static String scenarioname;
	DriverFactory df = new DriverFactory();

	SignInPage signIn = new SignInPage();
	LaunchPage lp = new LaunchPage();

	@Before(order = 1)
	public static void beforeScenario(Scenario sc) {

		scenario = sc;
		scenarioname = scenario.getName();
		System.out.println("Scenarioname is " + scenario.getName());
		System.out.println("Scenarioname is " + sc.getName());
	}

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
	public void user_should_be_redirected_to_register_page() throws IOException {
		Assert.assertEquals(signIn.getPageTitle(), "Registration");

	}

	@When("User enters username,password and clicks on Login.")
	public void user_enters_username_password_and_clicks_on_login() throws InterruptedException, IOException {

		Map<String, String> Logindata = Savedata.getData();

		String username = Logindata.get("Username").trim();
		String password = Logindata.get("Password").trim();
		signIn.Login(username, password);

	}

	@When("User enters Login Credentials.")
	public void user_enters_and_clicks_on_login(DataTable loginDataTable) throws IOException {
		List<List<String>> logincredentials = loginDataTable.asLists();
		if (!logincredentials.isEmpty()) {
			signIn.Login(logincredentials.get(0).getFirst(), logincredentials.get(0).getLast());
		}
	}

	@Then("{string} message should be displayed on home Page.")
	public void message_should_be_displayed_on_home_page(String expectedMessage) throws IOException {
		String actualMessage = signIn.verifySuccesfulLogin();
		// Screenshot.fullPageScreenshot("SignIn");
		Assert.assertEquals(actualMessage, expectedMessage);

	}

	@Then("Expected message in excel should be displayed.")
	public void Expected_message_in_excel_should_be_displayed() throws IOException {
		Map<String, String> Logindata = Savedata.getData();
		String actualMessage = signIn.verifySuccesfulLogin();
		// Screenshot.fullPageScreenshot("SignIn");
		Assert.assertEquals(actualMessage, Logindata.get("Expected Result").trim());
	}

}
