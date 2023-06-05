package com.framework.base;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.application.steps.ForgotPassPageSteps;
import com.application.steps.LoginPageSteps;
import com.application.steps.RegistrationPageSteps;

public class BaseTest extends BasePage {
	
	//Purpose of this class is used to Initialising each page class object with particular browser session when required
	public LoginPageSteps loginPage = null;
	public ForgotPassPageSteps forgotPassPg = null;
	public RegistrationPageSteps regPage = null;

	@BeforeMethod(alwaysRun = true, dependsOnMethods="setupBrowser") 
	public void intialisePageClasses() {
		WebDriver driver = BasePage.getDriver(); 
		loginPage = new LoginPageSteps(driver); 
		regPage = new RegistrationPageSteps(driver); 
		forgotPassPg = new ForgotPassPageSteps(driver); 
	}
	
	@DataProvider(name="testData")
	public String[][] testData(Method method) { 
		String[][] data = { { "abc", "123"} , {"xyz", "xyz123"} };
		return data; 
	}
}
