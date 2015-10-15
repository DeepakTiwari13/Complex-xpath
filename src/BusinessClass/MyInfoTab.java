package BusinessClass;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import PageData.Constants;
import TestBase.Base;

public class MyInfoTab extends Base {
	
	// Declaring TestNG's soft assert
	public SoftAssert s_assert = new SoftAssert();

	// Declaring the log4j object
	public static Logger logger = Logger.getLogger("MyInfoTab");

	@FindBy(xpath = Constants.MyInfoTabxpath)
	public WebElement MyInfotab;
	@FindBy(xpath = Constants.PersonalDetailsxpath)
	public WebElement Personaldetails;
	@FindBy(xpath = Constants.ContactDetailsxpath)
	public WebElement Contactdetails;
	@FindBy(xpath = Constants.EmergencyContactsxpath)
	public WebElement EmergencyContacts;
	@FindBy(xpath = Constants.Dependentsxpath)
	public WebElement Dependents;
	@FindBy(xpath = Constants.Immigrationxpath)
	public WebElement Immigration;
	@FindBy(xpath = Constants.Jobxpath)
	public WebElement Job;
	@FindBy(xpath = Constants.Salaryxpath)
	public WebElement Salary;
	@FindBy(xpath = Constants.Projectxpath)
	public WebElement Project;
	@FindBy(xpath = Constants.Qualificationsxpath)
	public WebElement Qualifications;
	@FindBy(xpath = Constants.MemberShipsxpath)
	public WebElement MemberShips;
	@FindBy(xpath = Constants.PersonalDetailContent)
	public WebElement PDContent;
	@FindBy(xpath = Constants.PersonalHeader)
	public WebElement FirstHEader;

	public void MyInfoTabTest() {
		logger.info("Switching to MyInfoTab Tab");
		MyInfotab.click();
	}

	public void PersonalDetailsTest() {
		Reporter.log("In to PersonalDetailsTest");
		logger.info("Clicking on Personal Details link in left menu");
		Personaldetails.click();
		logger.info("Printing personal details");
		logger.info(PDContent.getText());
		s_assert.assertNotNull(FirstHEader,"Not on MyInfo page");
		s_assert.assertAll();
	}
	
}
