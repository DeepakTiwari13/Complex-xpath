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

public class RecruitmentTab extends Base {

	// Declaring TestNG's soft assert
	public SoftAssert s_assert = new SoftAssert();

	public static Logger logger = Logger.getLogger("RecruitmentTab");

	@FindBy(xpath = Constants.RecruitmentTabxpath)
	public WebElement RecruitmentTab;
	@FindBy(xpath = Constants.MyCandidatexpath)
	public WebElement MyCandidates;
	@FindBy(xpath = Constants.CandidateTablexpath)
	public WebElement CandidateTable;

	public void RecruitmentTabTest() {
		Reporter.log("In to RecruitmentTab");
		logger.info("Switching to RecruitmentTab");
		RecruitmentTab.click();
		logger.info("Fetching Candidate List");
		List<WebElement> CandidateList = driver.findElements(By
				.xpath(Constants.CandidateTablexpath));
		int count = CandidateList.size();
		for (int i = 0; i < CandidateList.size(); i++) {
			logger.info(CandidateList.get(i).getText());
			System.out.println(CandidateList.get(i).getText());
		}
		if (count == 0) {
			logger.info("No candidate has been referred by you");
		}
		s_assert.assertNotNull(MyCandidates,
				"My referred candidates element not found");
		s_assert.assertAll();

	}

}
