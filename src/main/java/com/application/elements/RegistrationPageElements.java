package com.application.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.commons.WebCommons;

public class RegistrationPageElements extends WebCommons {
	
	protected By registrationPageHeader = By.xpath("//h1[text()='Signing up is easy!']");
	
	@FindBy(xpath="//h1[@class='title']")
	public WebElement title; 
	
	@FindBy(xpath="//input[@name='customer.firstName']") 
	public WebElement firstName; 
	
	@FindBy(xpath="//input[@name='customer.lastName']") 
	public WebElement lastName; 
	
	@FindBy(xpath="//input[@name='customer.address.street']") 
	public WebElement address; 
	
	@FindBy(xpath="//input[@name='customer.address.city']") 
	public WebElement city; 
	
	@FindBy(xpath="//input[@name='customer.address.state']") 
	public WebElement state; 
	
	@FindBy(xpath="//input[@name='customer.address.zipCode']") 
	public WebElement zipCode; 
	
	@FindBy(xpath="//input[@name='customer.phoneNumber']") 
	public WebElement phone; 
	
	@FindBy(xpath="//input[@name='customer.ssn']") 
	public WebElement ssn; 
	
	@FindBy(xpath="//input[@name='customer.username']") 
	public WebElement custUsername; 
	
	@FindBy(xpath="//input[@name='customer.password']") 
	public WebElement custPassword; 
	
	@FindBy(xpath="//input[@name='repeatedPassword']") 
	public WebElement credConfirm; 
	 
}
