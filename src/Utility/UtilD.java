package Utility;

//This class contains the utility function
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.FileStore;
import java.nio.file.FileSystemException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import TestBase.Base;

public class UtilD extends Base {
	
	// Declaring TestNG's soft assert
	public static SoftAssert s_assert = new SoftAssert();

	// Declaring Log4j as global variable
	public static Logger logger = Logger.getLogger("UtilD");

	// Function to take screenshot
	public static boolean TakeScreenShotFun(String TestName) {

		logger.info("Taking screenshot");
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")
					+ "\\src\\Screenshots\\" + TestName + ".jpg"));
			logger.info("Screenshot is kept at "
					+ System.getProperty("user.dir") + "\\src\\Screenshots\\"
					+ TestName + ".jpg");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Function to check server response
	public static boolean ServerResponse(String Page) {

		logger.info("Checking server response for " + Page);

		try {
			URL url = new URL(Page);
			HttpURLConnection openConnection = (HttpURLConnection) url
					.openConnection();
			openConnection.connect();
			int rCode = openConnection.getResponseCode();
			logger.info("Server response for " + Page + "is  " + rCode);
			return true;
		} catch (Throwable t) {
			logger.info("Failed to get server response for  " + Page);
			System.out.println(t.getMessage());
		}
		return false;
	}

	// Function to check available and total disc space
	public static void DiskSpace() throws IOException {
		logger.info("Checking for available and total disk space");
		NumberFormat nf = NumberFormat.getNumberInstance();
		for (Path root : FileSystems.getDefault().getRootDirectories()) {
			System.out.print(root + ": ");

			try {
				FileStore store = Files.getFileStore(root);
				System.out.println("available="
						+ nf.format(store.getUsableSpace()) + ", total="
						+ nf.format(store.getTotalSpace()));

			}

			catch (FileSystemException e) {
				System.out.println("error querying space: " + e.toString());
			}
		}
	}

	// Function to check whether element exist or not
	public static boolean IsElementExist(String LocX) {

		int size = driver.findElements(By.xpath(Con.getProperty(LocX))).size();
		if (size > 0) {
			logger.info("Element exist " + (Con.getProperty(LocX)));
			return true;
		} else
			logger.info("Element not exist " + (Con.getProperty(LocX)));
		return false;

	}

	// Function to check whether element is clickable or not
	public static WebElement IsElementClickable(String xpathofelement) {
		logger.info("Locating the element " + xpathofelement);

		try {

			return driver
					.findElement(By.xpath(Loc.getProperty(xpathofelement)));
		} catch (Throwable t) {
			System.out.println(t.getMessage());
			logger.info("Element not located " + xpathofelement);
			return null;

		}

	}

	public static void LoginTest() {
		logger.info("Executing LoginTest");
		UtilD.IsElementClickable("LoginPageUserName").sendKeys(
				Con.getProperty("UserName"));
		UtilD.IsElementClickable("LoginPagePassword").sendKeys(
				Con.getProperty("Password"));
		UtilD.IsElementClickable("LoginPageLoginButton").click();
	}

	public static void LogoutTest() throws InterruptedException {
		logger.info("Executing LogoutTest");
		UtilD.IsElementClickable("LoggedInUserVerificationText").click();
		UtilD.IsElementClickable("Logout");
		String TitleName = driver.getTitle();
		s_assert.assertEquals(TitleName, Con.getProperty("LoginPageTitle"));
		s_assert.assertAll();
	}

	public static WebElement Checkandclick(String xpathofelement) {
		logger.info("Locating the element " + xpathofelement);

		try {

			return driver.findElement(By.xpath(xpathofelement));
		} catch (Throwable t) {
			System.out.println(t.getMessage());
			logger.info("Element not located " + xpathofelement);
			return null;

		}

	}

}
