package com.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.application.elements.RegistrationPageElements;
import com.framework.utilities.Utils;

public class RegistrationPageSteps extends RegistrationPageElements {
	
	public RegistrationPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void registrationPageIsLaunchedSuccessfully() {
		waitForElement(registrationPageHeader, Utils.WAIT_TIME);
		log("pass", "registration page is launched successfully");
	}

}
