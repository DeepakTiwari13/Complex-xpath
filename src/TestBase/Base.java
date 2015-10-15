package TestBase;

// This is a testbase class
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

public class Base {

	// Initializing properties

	public static Properties Loc = null;
	public static Properties Con = null;
	public static WebDriver driver = null;
	public static Logger logger = null;

	public void Initializer() throws IOException {
		Logger logger = Logger.getLogger("Base");
		
		Reporter.log("In to Initialization function");

		// Reading Locator.properties file which contains the information about
		// element locator
		logger.info("Reading locator properties file");
		Loc = new Properties();
		FileInputStream Fis = new FileInputStream(
				System.getProperty("user.dir")
						+ "\\src\\PageData\\Locator.properties");
		Loc.load(Fis);
		System.out.println("Printing the version of location file "
				+ Loc.getProperty("LocatorProperties"));

		// Reading Config.properties file which contains the information about
		// configuration

		logger.info("Reading configuration properties");
		Con = new Properties();
		Fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\PageData\\Config.properties");
		Con.load(Fis);
		System.out.println("Printing the version of Configuration file "
				+ Con.getProperty("ConfigurationProperties"));

		// Reading the driver configuration

		if (driver == null) {

			logger.info("Reading driver configuration ");
			if (Con.getProperty("Driver").equals("Chrome")) {
				System.setProperty(
						"webdriver.chrome.driver",
						(System.getProperty("user.dir") + "\\src\\Server\\chromedriver.exe"));
				System.out.println("Launching the Chrome Driver");
				logger.info("Launching the Chrome Driver");
				driver = new ChromeDriver();
			} else if (Con.getProperty("Driver").equals("IE")) {
				System.setProperty(
						"webdriver.ie.driver",
						(System.getProperty("user.dir") + "\\src\\Server\\IEDriverServer.exe"));
				System.out.println("Launching the Internet explorer Driver");
				logger.info("Launching the Internet explorer Driver");
				driver = new InternetExplorerDriver();
			} else if (Con.getProperty("Driver").equals("Firefox")) {
				// FirefoxBinary binary = new FirefoxBinary(new
				// File(System.getProperty("user.dir")+"\\src\\Server\\firefox.exe"));
				FirefoxBinary binary = new FirefoxBinary(
						new File(
								"C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"));
				logger.info("Launching the Firefox Driver");
				System.out.println("Launching the Firefox Driver");

				// Launching firefox with profile

				ProfilesIni prof = new ProfilesIni();
				System.out.println("Loading firefox profile "
						+ prof.getProfile("Deepak").toString());
				logger.info("Launching the Firefox profile ");
				FirefoxProfile myprofile = prof.getProfile("Deepak");
				driver = new FirefoxDriver(binary, myprofile);
			}

			// applying implicit wait
			logger.info("reading implicit wait ");
			String x = Con.getProperty("implicitlyWait");
			int y = Integer.parseInt(x);
			driver.manage().timeouts().implicitlyWait(y, TimeUnit.SECONDS);
			logger.info("implicit wait " + y);

			logger.info("Maximizing browser ");
			driver.manage().window().maximize();
		}
	}

}
