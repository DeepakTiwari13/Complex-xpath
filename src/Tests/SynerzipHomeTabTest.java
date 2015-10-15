package Tests;

// This class contains the test based on POM and with Page Factory

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BusinessClass.HomeTab;
import TestBase.Base;
import Utility.UtilD;

public class SynerzipHomeTabTest extends Base {

	// Declaring the log4j object
	public static Logger logger = Logger.getLogger("SynerzipHomeTabTest");

	@Test(priority = 1)
	public void HomeTabTest() {
		Reporter.log("In to HomeTabTest");
		logger.info("Executing HomeTabTest");
		HomeTab Ht = PageFactory.initElements(driver, HomeTab.class);
		Ht.UpComingEvents();
		Ht.MyLeaveBalance();
		Ht.myCalender();
		UtilD.TakeScreenShotFun("SynerzipHomeTabTest");

	}

}
