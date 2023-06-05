package com.application.tests;

import org.testng.annotations.Test;
import com.framework.base.BaseTest;

public class ApplicationTest extends BaseTest {
	
	@Test(priority=1, groups= {"Smoke"})
	public void verifyApplicationIsLaunchedSuccessfully() {
		loginPage.launchApplication();
	}
	
	@Test(priority=2)
	public void verifyApplicationLogoAndCaption() {
		loginPage.launchApplication();
		loginPage.verifyLogoAndCaption(); 
	}

	@Test(priority=3)
	public void verifyApplicationHeader() {
		loginPage.launchApplication();
		loginPage.verifyLoginPageHeader();
	}
	
	@Test(priority=4, dataProvider="testData")
	public void verifyApplicationLoginIsSuccessful(String user, String pwd) {
		loginPage.launchApplication();
		loginPage.enterUsernameAndPassword(user, pwd);
		loginPage.clickOnLoginButton();
		loginPage.verifyLoginIsSuccessful(); 
	}
	
	@Test(priority=5)
	public void verifyRegistrationPageIsLaunched() {
		loginPage.launchApplication();
		loginPage.clickOnRegistrationLink();
		regPage.registrationPageIsLaunchedSuccessfully();
	}
	
	@Test(priority=6)
	public void verifyForgotPasswordPageIsLaunched() {
		loginPage.launchApplication();
		loginPage.clickOnForgotpasswordLink();
		forgotPassPg.verifyForgotPasswordPageIsLaunchedSuccessfully();
	}
}
