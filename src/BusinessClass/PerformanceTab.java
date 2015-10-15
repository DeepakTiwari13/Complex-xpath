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

public class PerformanceTab extends Base {

	// Declaring TestNG's soft assert
	public SoftAssert s_assert = new SoftAssert();

	// Declaring the log4j object
	public static Logger logger = Logger.getLogger("PerformanceTab");

	@FindBy(xpath = Constants.PerformanceTabxpath)
	public WebElement PerformanceTab;
	@FindBy(xpath = Constants.PerformanceReviewsxpath)
	public WebElement Performancereviewes;
	@FindBy(xpath = Constants.PerformanceCyclexpath)
	public WebElement PerformanceCycle;
	@FindBy(xpath = Constants.Section1xpath)
	public WebElement Section1;
	@FindBy(xpath = Constants.CompleteInformationxpath)
	public WebElement Userinfo;
	@FindBy(xpath = Constants.Section2xpath)
	public WebElement Section2;
	@FindBy(xpath = Constants.SelfReviewsxpath)
	public WebElement Selfreviewsection;
	@FindBy(xpath = Constants.TableHeaderxpath)
	public WebElement TableHeader;
	@FindBy(xpath = Constants.ActualTablexpath)
	public WebElement SelfReviewList;

	public void PerformanceTabTest() {
		Reporter.log("In to PerformanceTabTest");
		logger.info("Switching to Performance Tab");
		PerformanceTab.click();
		logger.info("Fetching Performance Cycle duration");
		logger.info(PerformanceCycle.getText());
		logger.info("Fetching Performance Details");
		List<WebElement> EmployeePerformanceDetails = driver.findElements(By
				.xpath(Constants.Employeedetaillistxpath));
		for (int i = 0; i < EmployeePerformanceDetails.size(); i++) {
			logger.info(EmployeePerformanceDetails.get(i).getText());
			System.out.println("Employee Performance Details "
					+ EmployeePerformanceDetails.get(i).getText());
		}
		logger.info("Navigating user to Performance Review section");
		s_assert.assertNotNull(
				EmployeePerformanceDetails.get(0).findElement(By.tagName("a")),
				"First employee not found");
		EmployeePerformanceDetails.get(0).findElement(By.tagName("a")).click();
		logger.info("Displaying Review Information");
		logger.info(Section1.getText());
		logger.info(Userinfo.getText());
		logger.info(Section2.getText());
		logger.info("Switching to Self Review Tab");
		Selfreviewsection.click();
		List<WebElement> THeader = driver.findElements(By
				.xpath(Constants.TableHeaderxpath));
		for (int j = 0; j < THeader.size(); j++) {
			logger.info(THeader.get(j).getText());
			System.out.println("Printing table header "
					+ THeader.get(j).getText());
		}

		List<WebElement> Ratings = driver.findElements(By
				.xpath(Constants.ActualTablexpath));
		int count = Ratings.size();
		for (int k = 0; k < Ratings.size(); k++) {
			logger.info(Ratings.get(k).getText());
			System.out.println("Printing real ratings "
					+ Ratings.get(k).getText());
		}
		if (count == 0) {
			s_assert.fail("User does not have any ratings");

		}
		s_assert.assertAll();
	}
}
