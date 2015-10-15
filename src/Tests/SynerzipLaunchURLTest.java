package Tests;

//This class contains data driven based test cases 
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import TestBase.Base;
import Utility.UtilD;

public class SynerzipLaunchURLTest extends Base {

	// Declaring TestNG's soft assert
	public SoftAssert s_assert = new SoftAssert();

	// Declaring the log4j object
	public static Logger logger = Logger.getLogger("SynerzipLaunchURLTest");

	// Defining the before test activities
	@BeforeTest
	public void BeforeLaunchURLTest() throws IOException {
		UtilD.DiskSpace();
		Initializer();

	}

	// LaunchURLTest
	@Test(priority = 1)
	public void LaunchURLTest() {
		Reporter.log("Executing LaunchURLTest");
		logger.info("Executing LaunchURLTest");
		driver.get(Con.getProperty("TestAppUrl"));
		s_assert.assertTrue(
				UtilD.ServerResponse(Con.getProperty("TestAppUrl")),
				"Server response is not 200");
		System.out.println("Testing soft assert");
		s_assert.assertAll();

	}

}
