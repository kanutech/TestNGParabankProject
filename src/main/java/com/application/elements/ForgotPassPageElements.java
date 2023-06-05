package com.application.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.commons.WebCommons;

public class ForgotPassPageElements extends WebCommons {
	
	protected By forgotLoginPageHeader = By.xpath("//h1[text()='Customer Lookup']");

	@FindBy(xpath="//input[@name='firstName']") 
	public WebElement firstName; 
	
	@FindBy(xpath="//input[@name='lastName']") 
	public WebElement lastName; 
	
	@FindBy(xpath="//input[@name='address.street']") 
	public WebElement address; 
	
	@FindBy(xpath="//input[@name='address.city']") 
	public WebElement city; 
	
	@FindBy(xpath="//input[@name='address.state']") 
	public WebElement state; 
	
	@FindBy(xpath="//input[@name='address.zipCode']") 
	public WebElement zipCode; 
	
	@FindBy(xpath="//input[@name='ssn']") 
	public WebElement ssn;
	
	@FindBy(xpath="//input[@value='Find My Login Info']") 
	public WebElement findMyLoginInfo; 
}
