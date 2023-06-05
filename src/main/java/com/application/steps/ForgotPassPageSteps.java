package com.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.application.elements.ForgotPassPageElements;

public class ForgotPassPageSteps extends ForgotPassPageElements {
	
	public ForgotPassPageSteps (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void verifyForgotPasswordPageIsLaunchedSuccessfully() {
		waitForElement(forgotLoginPageHeader, 10);
		log("pass", "forgot password page is launched successfully");
	}
}
