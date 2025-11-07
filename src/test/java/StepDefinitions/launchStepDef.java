package StepDefinitions;

import org.testng.Assert;

import Pages.LaunchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class launchStepDef  {
	LaunchPage lp;

	

	@Given("The user opens DSAlgo portal link")
	public void user_is_in_launch_page() {
	//	launchBrowser();
		lp = new LaunchPage();
		lp.launchApplication();
		
	}

	@When("The User clicks on GetStarted")
	public void user_user_clicks_on_get_started() {
		lp.clickGetStarted();
	}

	@Then("User should navigate to Home page")
	public void user_should_navigate_to_home_page() {
		Assert.assertEquals(lp.fetchTitle(), "NumpyNinja");
	}

}
