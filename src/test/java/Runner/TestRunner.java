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

			// System.setProperty("browser", browser);
			// DriverFactory.setupBrowser(browser);
			// System.out.println(browser);
		}

//	@BeforeTest

//	@Parameters("browserType")
//	public void browserChange(@Optional() String browserType) {
//		DriverFactory driverFactory = new DriverFactory();
//
//		if (browserType != null && !browserType.equals("param-val-not-found")) {
//			driverFactory.setBrowserType(browserType);
//
//		}
//Messages addressed to "meeting group chat" will also appear in the meeting group chat in Team Chat
////
//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios() {
//		return super.scenarios(); // provides PickleWrapper + FeatureWrapper
//	}
		// Map<String, String> plbrowser = new HashMap<String, String>();

//	@BeforeTest(alwaysRun = true)
//	@Parameters("browser")
//	public void beforeClass(String browser) {
//		System.out.println("Running on browser: " + browser);
//		plbrowser.put("browser", browser);
//		ScenarioContext.setbrowserData(plbrowser);
//		System.setProperty("browser", browser);
//		// System.out.println(System.getProperty(browser));
	}

}
