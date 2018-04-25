package base;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentReports;

import Reporting.HtmlReporting;
import testDataAccess.MSExcelReader;
import utils.FrameworkProperties;
import utils.TestParameters;
import utils.Utility;
import utils.WebDriverFactory;

/**
 * @author Saran
 * This the main method.
 * 
 */

public class Main {

	private static String absolutepath;
	private static FrameworkProperties globalproperties;
	private static String propertyFilePath = "./src/main/resources/Properties/GlobalProperties.properties";
	private static Properties properties;
	private static Workbook runManager;
	private static LinkedList<TestParameters> testInstancetoRun;
	private static Workbook dataTable;
	private static MSExcelReader runMangerPath;
	private static MSExcelReader dataTablePath;
	private static TestParameters testParameters;
	private static ExtentReports report;





	

	public static void main(String[] args) {
		
		intializeTestReport();
		prepare();
		collectRuninfo();
		intializeDataTable();
		execute();
		warp();
		
	

	}
	


	private static void intializeTestReport() {
		report = HtmlReporting.getInstance();
		report.loadConfig(new File("./src/main/resources/Properties/extent-report-config.xml"));
		
	}




	/**
	 * prepare method is used to get framework properties.
	 */
	private static void prepare() {
		
		setAbsolutepath();
		collectGlobalProperties();
	
	}
	




	/**
	 * absolutepath method is used to get path of framework current folder .
	 */
	
	private static void setAbsolutepath() {
		
		absolutepath = new File(System.getProperty("user.dir")).getAbsolutePath();
					
	}
	
	/**
	 * setAbsolutepath method is used to get framework parameters from property file.
	 */
	
	private static void collectGlobalProperties() {
		
		globalproperties = FrameworkProperties.getInstance();
		
		properties=	globalproperties.loadPropertyFile(propertyFilePath );
		
		Utility utils=new Utility();		
		utils.setPropeties(properties);
	}
	
	
	private static void collectRuninfo() {
		
		String testSuite = properties.getProperty("TestSuite");
		
		runMangerPath=MSExcelReader.getInstance();
		runManager=runMangerPath.createobjectWorkbook("./RunManager.xls");
		testInstancetoRun = runMangerPath.getRunMangerInfo(testSuite);
		
	}

	private static void intializeDataTable() {
		String testdataName = properties.getProperty("TestDataTableName");
		dataTablePath=MSExcelReader.getInstance();
		dataTable = dataTablePath.createobjectWorkbook("./src/main/resources/TestData/"+testdataName);
	
	}

	
	private static void execute() {

		int nThreads = Integer.parseInt(properties.getProperty("NumberOfThreads"));
		ExecutorService parallelExecutor = Executors.newFixedThreadPool(nThreads);
		Runnable testRunner = null;

		for(int currentTestInstance=0 ;currentTestInstance<testInstancetoRun.size();currentTestInstance++) {
			
			String executiontype=properties.getProperty("ExecutionType");
			
			if(executiontype.equalsIgnoreCase("Webapp")){
			testRunner = new ParallelRunnerWeb(testInstancetoRun.get(currentTestInstance), MSExcelReader.getInstance(), report);
			parallelExecutor.execute(testRunner);
			}
			if(executiontype.equalsIgnoreCase("Mobile")) {
			testRunner = new ParallelRunnerMobile(testInstancetoRun.get(currentTestInstance), MSExcelReader.getInstance(), report);
			parallelExecutor.execute(testRunner);	
				
			}

		}

		parallelExecutor.shutdown();

		while(!parallelExecutor.isTerminated()) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void warp() {
	
		report.flush();
		
		try {
			Desktop.getDesktop().open(new File(HtmlReporting.reportpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
