package com.amc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amc.qa.base.TestBase;

public class SignInPopUp extends TestBase {
	
	@FindBy(xpath = "//input[@name='loginMobile']")
	WebElement mobileNumberInput;
	
	@FindBy(xpath = "(//*[local-name()='svg' ]//parent::div[normalize-space() ='Request OTP'])[1]")
	WebElement requestOtpButton;
	
	
	
	public SignInPopUp()
	{
		PageFactory.initElements(driver, this);
	}
	
	public SignInOTPPopUp SignIn(String mobileNumber) throws InterruptedException
	{
		mobileNumberInput.isDisplayed();
		mobileNumberInput.click();
		mobileNumberInput.sendKeys(mobileNumber);
		Thread.sleep(3000);
		requestOtpButton.isEnabled();
		requestOtpButton.click();
		
		return new SignInOTPPopUp();
	}

}
