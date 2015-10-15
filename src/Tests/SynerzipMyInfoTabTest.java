package Tests;

// This class contains the test based on POM and with Page Factory

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BusinessClass.MyInfoTab;
import TestBase.Base;
import Utility.UtilD;

public class SynerzipMyInfoTabTest extends Base {

	// Declaring the log4j object
	public static Logger logger = Logger.getLogger("SynerzipMyInfoTabTest");

	// Launch SynerzipMyInfoTabTest
	@Test(priority = 1)
	public void MyInfoTabTest() {
		Reporter.log("In to MyInfoTabTest");
		logger.info("Executing MyInfoTabTest");
		MyInfoTab MIT = PageFactory.initElements(driver, MyInfoTab.class);
		MIT.MyInfoTabTest();
		MIT.PersonalDetailsTest();
		UtilD.TakeScreenShotFun("SynerzipMyInfoTabTest");

	}

	// After test activities

}
