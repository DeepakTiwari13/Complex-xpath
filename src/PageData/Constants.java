package PageData;

// Class to maintain the xpath

public class Constants {

	// Synerzip HRMS Home Tab

	public static final String LeaveBalanceTextxpath = "//h2[@class='myleaveB']";
	public static final String LeaveBalanceTablexpath = "//table[@class='table myleavetable']/tbody/tr";
	public static final String EventTextxpath = "//*[@id='eventpanel']/legend/h2]";
	public static final String CurrentDatexpath = "//td[contains(@class,'ui-state-highlight')]";
	public static final String PaidLeavexpath = "//a[contains(@href,'/symfony/web/index.php/leave/viewLeaveRequest/id')]";
	public static final String MyLeaveBalancexpath = "//table[@class='table myleavetable']/tbody/tr";
	public static final String EventListxpath = "//table[@class='table']/tbody/tr";
	public static final String Eventheadingxpath = "//*[@id='eventpanel']/legend/h2";

	// Synerzip HRMS Leave Tab

	public static final String LeaveTabxpath = "//a[@id='menu_leave_viewLeaveModule']/b";
	public static final String LeaveListxpath = "//*[@id='leave-list-search']/a";
	public static final String LeaveListLeaveTabxpath = "//table[@id='resultTable']/tbody/tr";
	
	//Synerzip HRMS Recruitment tab
	
	public static final String RecruitmentTabxpath = "//a[@id='menu_recruitment_viewRecruitmentModule']/b";
	public static final String MyCandidatexpath = "//div[@id='srchCandidates']/a";
	public static final String CandidateTablexpath = "//table[@id='resultTable']/tbody/tr";
	
	//Synerzip HRMS Performance tab
	
	public static final String PerformanceTabxpath = "//a[@id='menu_performance_viewPerformanceModule']/b";
	public static final String PerformanceReviewsxpath = "//div[@id='content']/div[1]/a";
	public static final String PerformanceCyclexpath = "//select[@id='period']/option[1]";
	public static final String Employeedetaillistxpath = "//table[@id='reviewTable']/tbody/tr";
	public static final String Section1xpath = "//form[@id='frmSave']/div[1]/div[1]/h1";
	public static final String CompleteInformationxpath = "//form[@id='frmSave']/div[1]/div[2]/ol";
	public static final String Section2xpath = "//div[@id='tab-container']/div[1]/h1";
	public static final String SelfReviewsxpath = "//div[@id='tab-container']/ul/li[1]/a";
	public static final String TableHeaderxpath = "//div[@id='selfReview']/table/thead/tr";
	public static final String ActualTablexpath = "//div[@id='selfReview']/table/tbody/tr";
	
	//Synerzip HRMS My Info tab
	
	public static final String MyInfoTabxpath= "//a[@id='menu_pim_viewMyDetails']/b";
	public static final String PersonalDetailsxpath= "//li[@class='selected']/a";
	public static final String ContactDetailsxpath= "//ul[@id='sidenav']/li[2]/a";
	public static final String EmergencyContactsxpath= "//ul[@id='sidenav']/li[3]/a";
	public static final String Dependentsxpath= "//ul[@id='sidenav']/li[4]/a";
	public static final String Immigrationxpath= "//ul[@id='sidenav']/li[5]/a";
	public static final String Jobxpath= "//ul[@id='sidenav']/li[6]/a";
	public static final String Salaryxpath= "//ul[@id='sidenav']/li[7]/a";
	public static final String Projectxpath= "//ul[@id='sidenav']/li[8]/a";
	public static final String Qualificationsxpath= "//ul[@id='sidenav']/li[9]/a";
	public static final String MemberShipsxpath= "//ul[@id='sidenav']/li[10]/a";
	public static final String PersonalDetailContent= "//*[@id='frmEmpPersonalDetails']/fieldset/ol[1]/li";
	public static final String PersonalHeader= "//*[@id='pdMainContainer']/div[1]/h1";
	
	//Synerzip HRMS Directory tab
	
	public static final String DirectoryTabxpath= "//*[@id='menu_pim_viewDirectory']";
	public static final String Paginatiodetailsxpath= "//form[@id='frmList_ohrmListComponent']/div[1]/ul/li[1]";
	public static final String CompleteTablexpath= "//table[@id='resultTable']/tbody/tr/td/td[2]/span1";
	public static final String DriectroyElementxpath= "//div[@id='employee-information']/a";
	
	
	
	
}
