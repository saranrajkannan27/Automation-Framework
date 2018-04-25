package businessComponents;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;
import testDataAccess.MSExcelReader;
import utils.Utility;

public class FunctionalComponentsWeb extends Utility {
	

	public FunctionalComponentsWeb(MSExcelReader dataTable,WebDriver driver,ExtentTest test) {
		super(dataTable,driver,test);
	}

	public void login() throws InterruptedException {
		LoginPage log = new LoginPage(dataTable, driver, test);
		log.login();
	

	}
	

}
