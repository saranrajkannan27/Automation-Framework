package utils;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import testDataAccess.MSExcelReader;

public class Utility {

	public WebDriver driver;
	public MSExcelReader dataTable;
	private Properties properties;
	public AndroidDriver androiddriver;
	public ExtentTest test;



	public Utility( MSExcelReader dataTable,WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.dataTable = dataTable;
		this.test=test;
	}

	public Utility( MSExcelReader dataTable,AndroidDriver androiddriver,ExtentTest test) {
		this.androiddriver = androiddriver;
		this.dataTable = dataTable;
		this.test=test;
	}

	public Utility() {

	}
	public void setPropeties(Properties properties) {
		this.properties = properties;
	}



}
