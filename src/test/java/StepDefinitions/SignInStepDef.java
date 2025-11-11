package StepDefinitions;
import Pages.SignInPage;

import io.cucumber.java.en.*;

public class SignInStepDef {

	SignInPage signIn= new SignInPage();

@When("User clicks on Sign-in link")
public void user_clicks_on_sign_in_link() {
	signIn.clickOnSignIn();
}

@Then("User should be in Sign-in Page")
public void user_should_be_in_sign_in_page() {
    signIn.verifySiginPage();
}

@When("User clicks on Sign-in link on the Page")
public void user_clicks_on_sign_in_link_on_the_page() {
    
}

@Given("User is in Sign-in Page")
public void user_is_in_sign_in_page() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("User enters valid credentials and clicks on Login")
public void user_enters_valid_credentials_and_clicks_on_login() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Expected Message should be displayed")
public void expected_message_should_be_displayed() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("User enters invalid credentials and clicks on Login")
public void user_enters_valid_credentials_and_clicks_on_login(io.cucumber.datatable.DataTable dataTable) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
	
	
    throw new io.cucumber.java.PendingException();
}

}
