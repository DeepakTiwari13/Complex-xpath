package Tests;

// This class contains the test based on POM and with Page Factory

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BusinessClass.RecruitmentTab;
import TestBase.Base;
import Utility.UtilD;

public class SynerzipRecruitmentTabTest extends Base {

	// Declaring the log4j object
	public static Logger logger = Logger
			.getLogger("SynerzipRecruitmentTabTest");

	@Test(priority = 1)
	public void RecruitmentTabTest() {
		Reporter.log("In to RecruitmentTabTest");
		logger.info("Executing RecruitmentTabTest");
		RecruitmentTab RT = PageFactory.initElements(driver,
				RecruitmentTab.class);
		RT.RecruitmentTabTest();
		UtilD.TakeScreenShotFun("SynerzipRecruitmentTabTest");

	}

}
