package BusinessClass;

// This class contains the Business logic for HomeTab 
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import PageData.Constants;
import TestBase.Base;

public class HomeTab extends Base {

	// Declaring TestNG's soft assert
	public SoftAssert s_assert = new SoftAssert();

	// Declaring the log4j object
	public static Logger logger = Logger.getLogger("HomeTab");

	@FindBy(xpath = Constants.LeaveBalanceTextxpath)
	public WebElement LeaveBalanceText;
	@FindBy(xpath = Constants.LeaveBalanceTablexpath)
	public WebElement LeaveBalanceTable;
	@FindBy(xpath = Constants.EventTextxpath)
	public WebElement EventText;
	@FindBy(xpath = Constants.CurrentDatexpath)
	public WebElement CurrentDate;
	@FindBy(xpath = Constants.PaidLeavexpath)
	public WebElement PaidLeaves;
	@FindBy(xpath = Constants.Eventheadingxpath)
	public WebElement Eventheading;
	
	
	// Function to fetch calendar details
	public void myCalender() {
		Reporter.log("In to myCalenderTest");
		logger.info("Fetching Paid Leaves");
		String Leaves = PaidLeaves.getAttribute("title");
		s_assert.assertNotNull(Leaves);
		logger.info("Total Paid Leaves " + Leaves);
		logger.info("Fetching calendar details");
		String TodaysDate = CurrentDate.getAttribute("data-date");
		logger.info("Printing today's date " + TodaysDate);
		s_assert.assertNotNull(TodaysDate, "Todays Date is not being shown");
		s_assert.assertAll();

	}

	// Function to fetch the LeaveBalance
	public void MyLeaveBalance() {
		Reporter.log("Into leave balance");
		logger.info("Fetching leave balance");
		logger.info(LeaveBalanceText.getText());
		List<WebElement> CalList = driver.findElements(By
				.xpath(Constants.MyLeaveBalancexpath));
		for (int i = 0; i < CalList.size(); i++) {
			logger.info("Printing Leave Balance Calender "
					+ CalList.get(i).getText());
			System.out.println("Printing Leave Balance Calender "
					+ CalList.get(i).getText());
		}
		int count = CalList.size();
		if (count == 0) {
			s_assert.fail("No leave balance list present");
			s_assert.assertAll();
		}
	}

	// Function to fetch the upcoming events
	public void UpComingEvents() {
		Reporter.log("In to leave balance");
		logger.info("Fetching Upcoming Events");
		String Eventheader = Eventheading.getText();
		logger.info(Eventheader);
		List<WebElement> EventList = driver.findElements(By
				.xpath(Constants.EventListxpath));
		for (int i = 0; i < EventList.size(); i++) {
			logger.info("Printing Upcoming Events "
					+ EventList.get(i).getText());
			System.out.println("Printing Upcoming Events "
					+ EventList.get(i).getText());
		}

		s_assert.assertNotNull(Eventheader,
				"Event List WebElement is not present");
		s_assert.assertAll();
	}
	
}
