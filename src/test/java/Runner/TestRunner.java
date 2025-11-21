package Runner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import DriverFactory.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/Sign-In.feature", glue = { "StepDefinitions",
		"hooks" }, plugin = { "pretty", "html:target/cucumber-report.html" }, tags = "not @DataDriven")

public class TestRunner extends AbstractTestNGCucumberTests {
	@BeforeClass(alwaysRun = true)
	@Parameters("browser")
	public void beforeClass(String browser) {
		if (browser != null && !browser.equals("param-val-not-found")) {
			System.out.println(browser);
			DriverFactory.setupBrowser(browser);
	
		}
	}
}
