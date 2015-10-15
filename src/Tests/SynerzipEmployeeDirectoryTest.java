package Tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import BusinessClass.DirectoryTab;
import TestBase.Base;
import Utility.UtilD;

public class SynerzipEmployeeDirectoryTest extends Base{
	
	// Declaring the log4j object
		public static Logger logger = Logger.getLogger("SynerzipEmployeeDirectoryTest");
		
		@Test(priority = 1)
		public void EmployeeDirectoryTest() {
			Reporter.log("In to EmployeeDirectoryTest");
			logger.info("Executing EmployeeDirectoryTest");
			DirectoryTab DT = PageFactory.initElements(driver, DirectoryTab.class);
			DT.DirectoryTabTest();
			UtilD.TakeScreenShotFun("SynerzipEmployeeDirectoryTest");

		}
		@AfterTest
		public void AfterLaunchURLTest() throws InterruptedException {
			
			Reporter.log("In to AfterLaunchURLTest");
			UtilD.LogoutTest();
			logger.info("Closing the driver..............");
			driver.close();
		}

}
