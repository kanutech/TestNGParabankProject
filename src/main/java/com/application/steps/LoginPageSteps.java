package com.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.application.elements.LoginPageElements;
import com.framework.utilities.Utils;

public class LoginPageSteps extends LoginPageElements {

	public LoginPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	public void launchApplication() {
		launchApplication(prop.getProperty("url"));
		Assert.assertEquals(getPageTitle(), prop.getProperty("title"));
		log("info", "application is successfully launched");
	}

	public void verifyLogoAndCaption() {
		Assert.assertTrue(isElementeDisplayed(logo));
		log("info", "application logo is displayed");
		Assert.assertEquals(getElementText(caption), prop.getProperty("caption"));
		log("info", "application caption is as expected");
	}
	
	public void verifyLoginPageHeader () {
		Assert.assertEquals(getElementText(loginPageHeader), "Customer Login");
		log("info", "application header is as expected");
		
	}
	
	public void enterUsernameAndPassword(String user, String pwd) {
		enterInfo(userNameTextBox, user);
		enterInfo(passwordTextBox, pwd);
		log("info", "username and password is successfully entered");
	}
	
	public void clickOnLoginButton() {
		click(loginButton);
		log("info", "clicked on login button"); 
	}
	
	public void verifyLoginIsSuccessful() {
		waitForElement(accountOverviewPageHeader, Utils.WAIT_TIME);
		log("pass", "login is successul");
	}
	
	
	
	public void clickOnRegistrationLink() {
		click(registrationLink);
		log("info", "clicked on registration page link");	
	}
	
	public void clickOnForgotpasswordLink() {
		click(forgotLoginLink);
		log("info", "clicked on forgot password link");
	}
	
	
	
}
