package Tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import TestBase.Base;
import Utility.UtilD;

public class SynerzipHRMSLoginTest extends Base {
	
	// Declaring TestNG's soft assert
	public SoftAssert s_assert = new SoftAssert();

	// Declaring the log4j object
	public static Logger logger = Logger.getLogger("SynerzipHRMSLoginTest");

	@BeforeTest
	public void BeforeLaunchURLTest() throws IOException {
		Initializer();

	}

	@Test(priority = 1)
	public void SynerzipHRMSLogin() {
		logger.info("Executing SynerzipHRMSLogin test");
		driver.get(Con.getProperty("TestAppUrl"));
		UtilD.LoginTest();
		s_assert.assertNotNull(UtilD.IsElementClickable(
				"LoggedInUserVerificationText").getText());
		logger.info("Executing LoginVerificationTest");
		String LogginUserName = UtilD.IsElementClickable(
				"LoggedInUserVerificationText").getText();
		logger.info(LogginUserName);
		String[] parts = LogginUserName.split(" ");
		String string2 = parts[1];
		logger.info(string2);
		s_assert.assertEquals(string2, Con.getProperty("IntendedUser"));
		UtilD.TakeScreenShotFun("SynerzipHRMSLoginTest");
		s_assert.assertAll();

	}

}
