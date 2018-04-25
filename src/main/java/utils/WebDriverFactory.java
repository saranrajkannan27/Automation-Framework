package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverFactory {
	
	

	public static RemoteWebDriver getDriver(String browser) {
		WebDriver driver = null;
		
		switch(browser) {
		
		case "Chrome":
			System.setProperty("webdriver.chrome.driver","./src/main/resources/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
			
		case "Firefox":
			driver = new FirefoxDriver();
			break;
			
		case "Htmlunit":
			driver = new HtmlUnitDriver();
			break;
			
		case "InternetExplore":
			System.setProperty("webdriver.ie.driver","./src/main/resources/Drivers/IEdriver.exe");
			break;
		
		}
		return (RemoteWebDriver)driver;
		
	}


}
