package Tests;

// This class contains the test based on POM and with Page Factory

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BusinessClass.LeaveTab;
import TestBase.Base;
import Utility.UtilD;

public class SynerzipLeaveTabTest extends Base {

	// Declaring the log4j object
	public static Logger logger = Logger.getLogger("SynerzipLeaveTabTest");

	// Launch LeaveTabTest
	@Test(priority = 1)
	public void LeaveTabTest() {
		Reporter.log("In to LeaveTabTest");
		logger.info("Executing LeaveTabTest");
		LeaveTab LT = PageFactory.initElements(driver, LeaveTab.class);
		LT.MyLeaveList();
		UtilD.TakeScreenShotFun("SynerzipLeaveTabTest");

	}

}
