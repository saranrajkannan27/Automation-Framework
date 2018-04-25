package businessComponents;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import pages.LoginPageMobile;
import testDataAccess.MSExcelReader;
import utils.Utility;

public class FunctionalComponentsMobile extends Utility {
	

	public FunctionalComponentsMobile(MSExcelReader dataTable,AndroidDriver androiddriver,ExtentTest test) {
		super(dataTable,androiddriver,test);
	}

	public void login() throws InterruptedException {
		LoginPageMobile log = new LoginPageMobile(dataTable, androiddriver, test);
		log.login();
	

	}
	

}
