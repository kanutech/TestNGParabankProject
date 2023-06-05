package com.framework.commons;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.base.BasePage;
import com.framework.utilities.ReadProp;

public class WebCommons {

	public WebDriver driver = BasePage.getDriver(); 
	
	public Properties prop = ReadProp.readData("Config.properties");  

	//Method to print message in the report
	public void log(String status, String message) {
		if(status.equalsIgnoreCase("pass")) {
			BasePage.logger.pass(message); 
		} else if(status.equalsIgnoreCase("info")) {
			BasePage.logger.info(message);
		} else if(status.equalsIgnoreCase("warning")) {
			BasePage.logger.warning(message);
		} else if(status.equalsIgnoreCase("fail")) {
			BasePage.logger.fail(message);
		}
	}

	//Method to take screenshots of window
	public static String takeScreenshotOfWindow(WebDriver driver, String nameOfScreenshot) throws IOException {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String filepath= System.getProperty("user.dir")+"\\Screenshots\\"+nameOfScreenshot+".png";
		FileUtils.copyFile(file, new File(filepath));
		return filepath; 
	}

	//Method to take the screenshot of webElement
	public static String takeScreenshotOfElement(WebElement element, String nameOfScreenshot) throws IOException {
		File file = element.getScreenshotAs(OutputType.FILE);
		String filepath= System.getProperty("user.dir")+"\\Screenshots\\"+nameOfScreenshot+".png";
		FileUtils.copyFile(file, new File(filepath));
		return filepath; 
	}

	//Scroll to element 
	public void scrollToElement(WebElement element) { 
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()", element);
	}

	//Method to click on the element
	public void click(WebElement element) {
		scrollToElement(element); 
		element.click();
	}

	//Method to enter text in textbox
	public void enterInfo(WebElement element, String value) { 
		scrollToElement(element);
		element.clear();
		element.sendKeys(value);
	}

	//Method to select checkbox 
	public void selectCheckbox(WebElement element, boolean status) {
		boolean isCheckBoxSelected = element.isSelected(); 
		if(isCheckBoxSelected!=status) 
			element.click(); 
	}

	//Method to select dropdown options 
	public void selectOption(WebElement element, String option, String method) {
		scrollToElement(element); 
		Select s = new Select(element);
		if(method.equalsIgnoreCase("VisibleText")) 
			s.selectByVisibleText(option);
		else if(method.equalsIgnoreCase("value"))
			s.selectByValue(option);
		else if(method.equalsIgnoreCase("Index"))
			s.selectByIndex(Integer.parseInt(option));
	}
	
	//Java Wait method
	public void wait(int sec) {
		 try { 
			 Thread.sleep(sec*1000); //expects time in milliseconds so *1000 
			 } catch (InterruptedException e) { 
				 e.printStackTrace(); 
			 }
		 
	}
	
	//Implicit wait 
	public void implicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec)); 
	}
	
	
	//Explicit wait 
	public void waitForElement(By locator, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
	}
	
	//Perform double click 
	public void doubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	//Perform right click
	public void rightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
		
	//Perform mouse hover action
	public void mouseHover(WebElement element) {
		Actions action = new Actions(driver); 
		action.moveToElement(element).perform();
	}
	
	//Launch url
	public void launchApplication(String url) {
		driver.get(url);
	}
	
	//Element is displayed 
	public boolean isElementeDisplayed(WebElement element) {
		return element.isDisplayed(); 
		
	}
		
	//Get the page title
	public String getPageTitle() {
		return driver.getTitle(); 
		
	}
	
	//Get the text from element
	public String getElementText(WebElement element) { 
		return element.getText();
	}
	
	//Get the attribute value from the element
	public String getAttributeValue(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}
	
	}