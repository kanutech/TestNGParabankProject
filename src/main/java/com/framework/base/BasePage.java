package com.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class BasePage {

	public static ExtentHtmlReporter html= null;
	public static ExtentReports extent = null;
	public static ExtentTest logger = null;
	static WebDriver driver; 

	//Setup Reporting 
	@BeforeSuite(alwaysRun=true)
	public static void setupReport() {		
		//Create empty html report
		html = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\AutomationTestReport.html");

		//Attach empty report into extent report to set the configuration
		extent = new ExtentReports();
		extent.attachReporter(html);

		//Add project details
		extent.setSystemInfo("Project Name", "TestNG Automation Project");
		extent.setSystemInfo("Description", "Sample Project");
	}

	//Start printing test results for specific test case 
	public static void startReporting(String testcase) {
		logger = extent.createTest(testcase);
	}

	//Stop printing results
	public static void stopReporting() {
		extent.flush();
	}

	//Setup browser 
	@BeforeMethod(alwaysRun=true)
	@Parameters(value="browser")
	public void setupBrowser(String browser) { 
		if(browser.equalsIgnoreCase("chrome")) 
			driver = new ChromeDriver(); 
		else if(browser.equalsIgnoreCase("firefox")) 
			driver = new FirefoxDriver();
		else if(browser.equalsIgnoreCase("edge")) 
			driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); 
	}
	//Method to share driver with other classes
	public static WebDriver getDriver() {
		return driver; 
	}
	
	//Method to close the browser
	@AfterMethod(alwaysRun=true)
	public static void closeBrowser() { 
		driver.quit();
	}
	
}
