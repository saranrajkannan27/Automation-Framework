package Reporting;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;

public class HtmlReporting {
	
	
	private static String reportFolderName="RUN_"+getCurrentFormattedTime();
	private static String relativePath=new File (System.getProperty("user.dir")).getAbsolutePath();
	public static String reportpath=relativePath+"/Results/"+reportFolderName+"/TestSummary.html/";
	
	// Create an object of HtmlReport
	private static ExtentReports Instance= new ExtentReports(reportpath,true,NetworkMode.OFFLINE);
	
	// Create constructor private so that this class cannot be instantiated
	private HtmlReporting() {
		
	}
	
	// Get the only object available
	
	public static ExtentReports getInstance() {
		return Instance;
		
	}
	public static String getCurrentFormattedTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ss");
		Calendar calendar = Calendar.getInstance();
		return dateFormat.format(calendar.getTime());
	}


}
