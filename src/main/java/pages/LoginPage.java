package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testDataAccess.MSExcelReader;
import utils.Utility;

public class LoginPage extends Utility {





	public LoginPage(MSExcelReader dataTable, WebDriver driver, ExtentTest test) {
		super(dataTable, driver, test);

	}
	
	
	public void login() throws InterruptedException {

		driver.get("https://learn.letskodeit.com/p/practice/");
		
		test.log(LogStatus.PASS, "My first framework");
		WebElement element=driver.findElement(By.xpath("//div[@id='navbar']//a[@href='/sign_in']"));
		new Actions(driver).moveToElement(element).perform();
		driver.findElement(By.linkText("Login")).click();


}
}