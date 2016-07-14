package engage.pages;


import applogic.ApplicationManager;
import applogic1.ApplicationManager1;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;


/*
 * Base class for all the test classes
 * 
 * @author Sebastiano Armeli-Battana
 */

public class TestBase {
	protected ApplicationManager app;

	@BeforeClass
	public void init() {
		app = new ApplicationManager1();
	}

	@AfterSuite(alwaysRun = true)
	public void stop() {
		app.stop();
	}


}
