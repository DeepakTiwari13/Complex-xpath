package BusinessClass;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import PageData.Constants;
import TestBase.Base;

public class LeaveTab extends Base {

	// Declaring TestNG's soft assert
	public SoftAssert s_assert = new SoftAssert();

	// Declaring the log4j object
	public static Logger logger = Logger.getLogger("LeaveTab");

	@FindBy(xpath = Constants.LeaveTabxpath)
	public WebElement LeaveTab;
	@FindBy(xpath = Constants.LeaveListxpath)
	public WebElement LeaveList;

	public void MyLeaveList() {
		Reporter.log("In to MyLeave tab test");
		logger.info("Switching to Leave Tab");
		LeaveTab.click();
		logger.info("Fetching Leave List");
		List<WebElement> LeaveListLeaveTab = driver.findElements(By
				.xpath(Constants.LeaveListLeaveTabxpath));
		for (int i = 0; i < LeaveListLeaveTab.size(); i++) {
			logger.info(LeaveListLeaveTab.get(i).getText());
			System.out.println(LeaveListLeaveTab.get(i).getText());
		}

		int count = LeaveListLeaveTab.size();
		if (count == 0) {
			s_assert.fail("No leave list present");
		}
		s_assert.assertAll();
	}
}
