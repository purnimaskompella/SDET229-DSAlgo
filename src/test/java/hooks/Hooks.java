package hooks;

import DriverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	@Before
	public void launchBrowser() {
		DriverFactory.initDriver();
	}

	@After
	public void quitBrowser() {
		if (DriverFactory.getDriver() != null) {
			DriverFactory.getDriver().quit();
		}
	}
}
