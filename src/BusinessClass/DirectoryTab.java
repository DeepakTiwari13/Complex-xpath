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
import Utility.UtilD;

public class DirectoryTab extends Base {

	// Declaring TestNG's soft assert
	public SoftAssert s_assert = new SoftAssert();

	// Declaring the log4j object
	public static int sum = 0;

	public static Logger logger = Logger.getLogger("DirectoryTab");
	List<WebElement> EmplList = null;

	@FindBy(xpath = Constants.DirectoryTabxpath)
	public WebElement DirectoryTab;
	@FindBy(xpath = Constants.Paginatiodetailsxpath)
	public WebElement Paginationinfo;
	@FindBy(xpath = Constants.DriectroyElementxpath)
	public WebElement Directory;

	public void DirectoryTabTest() {
		Reporter.log("In to DirectoryTabTest");
		logger.info("Switching to DirectoryTab");
		DirectoryTab.click();
		//logger.info("Printing pagination data " + Paginationinfo.getText());

		logger.info("Fetching Employee details from directory");
		String part1 = "//a[@href='javascript:submitPage(";
		String part2 = ")']";

		String part3 = "//table[@id='resultTable']/tbody/tr[";
		String part4 = "]/td[2]/span[1]";

		int i = 1;

		while (UtilD.Checkandclick(part1 + i + part2) != null) {
			driver.findElement(By.xpath(part1 + i + part2)).click();

			int j = 1;
			while (UtilD.Checkandclick(part3 + j + part4) != null) {

				WebElement InnerLoop = driver.findElement(By.xpath(part3 + j
						+ part4));

				logger.info("Printing employee ID  and Name "
						+ InnerLoop.getText());
				System.out.println("Printing employee ID  and Name "
						+ InnerLoop.getText());

				logger.info("Position of employee in a list displayed for current page "
						+ j);
				System.out
						.println("Position of employee in a list displayed for current page "
								+ j);
				j++;

			}
			logger.info("Number of pages paginated  " + i);
			System.out.println("Number of pages paginated  " + i);
			i++;
			j--;
			sum = sum + j;
			logger.info("Total number of employess  " + sum);
			System.out.println("Total number of employess  " + sum);
		}
			s_assert.assertNotNull(Directory,"Not on directory page");
			s_assert.assertAll();
	}

}
