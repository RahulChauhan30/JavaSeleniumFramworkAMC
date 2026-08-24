package com.amc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amc.qa.base.TestBase;
import com.amc.qa.util.ScrollOnPage;

public class ContactUsPage extends TestBase{
	
	ScrollOnPage scrollOnpage = new ScrollOnPage();
	
	@FindBy(xpath = "//h1[text()='CONTACT US']")
	WebElement contactUsHeading;
	
	@FindBy(xpath = "//span[text()='GET IN TOUCH']")
	WebElement getInTouch;
	
	@FindBy(xpath = "//input[@name='getInTouchFirstName']")
	WebElement getInTouchFirstName;
	
	@FindBy(xpath = "//input[@name='getInTouchLastName']")
	WebElement getInTouchLastName;
	
	@FindBy(xpath = "//input[@name='getInTouchContactNo']")
	WebElement getInTouchContactNo;
	
	@FindBy(xpath = "//input[@name='getInTouchEmail']")
	WebElement getInTouchEmail;
	
	@FindBy(xpath = "//div[@class='select-selected']")
	WebElement selectVehicleDropDown;
	
	@FindBy(xpath = "//div[@data-value='THAR ROXX']")
	WebElement vehicle;
	
	@FindBy(xpath = "//textarea[@name='getInTouchMessage']")
	WebElement getInTouchMessage;
	
	@FindBy(xpath = "//a[@data-type='privacy-policy-popup']")
	WebElement PrivacyPolicy;
	
	@FindBy(xpath = "//label[@class='custom-control-label p2-regular' and contains(text(),'I agree that Mahindra & Mahindra')]")
	WebElement tncCheckbox;
	
	ContactUsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void submitGetInTouchForm(String FirstName, String Lastname, String contact, String email, String message) throws InterruptedException
	
	{
		contactUsHeading.isDisplayed();
		scrollOnpage.scrollToElement(driver, contactUsHeading);
		getInTouchFirstName.click();
		getInTouchFirstName.sendKeys(FirstName);
		getInTouchLastName.click();
		getInTouchLastName.sendKeys(Lastname);
		getInTouchContactNo.click();
		getInTouchContactNo.sendKeys(contact);
		getInTouchEmail.click();
		getInTouchEmail.sendKeys(email);
		selectVehicleDropDown.click();
		vehicle.click();
		getInTouchMessage.click();
		getInTouchMessage.sendKeys(message);
		tncCheckbox.click();
		Thread.sleep(5000);
		
	}

}
