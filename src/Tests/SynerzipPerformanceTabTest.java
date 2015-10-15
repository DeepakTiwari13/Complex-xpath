package Tests;

// This class contains the test based on POM and with Page Factory

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BusinessClass.PerformanceTab;
import TestBase.Base;
import Utility.UtilD;

public class SynerzipPerformanceTabTest extends Base {

	// Declaring the log4j object
	public static Logger logger = Logger
			.getLogger("SynerzipPerformanceTabTest");

	// Launch SynerzipPerformanceTabTest
	@Test(priority = 1)
	public void PerformanceTabTest() {
		Reporter.log("In to PerformanceTabTest");
		logger.info("Executing PerformanceTabTest");
		PerformanceTab PT = PageFactory.initElements(driver,
				PerformanceTab.class);
		PT.PerformanceTabTest();
		UtilD.TakeScreenShotFun("SynerzipPerformanceTabTest");

	}

}
