package com.amc.qa.pages;

import java.util.Scanner;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amc.qa.base.TestBase;

public class SignInOTPPopUp extends TestBase {
	
	@FindBy(xpath = "//input[contains(@class,'form-control otpValidation required')]")
	WebElement otpInput;
	
	@FindBy(xpath = "//a[@class='resendOTPText']")
	WebElement resendOtpButton;
	
	@FindBy(xpath = "//div[@class='sign-in-otp-header']//p[@class='mb-4'][contains(text(),'Please input the 4-digit code sent to')]")
	WebElement singInOtpHeaderText;
	
	@FindBy(xpath = "//div[@class='face2 face' and contains(.,'Sign In')]")
	WebElement signInButton;
	
	
	SignInOTPPopUp()
	{
		PageFactory.initElements(driver, this);
	}
	
	public LandingPage enterOTP()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the OTP Received:");
		String otpValue = scanner.nextLine();
		otpInput.isDisplayed();
		otpInput.click();
		otpInput.sendKeys(otpValue);
		
		signInButton.click();
		
		return new LandingPage();
		
		
	}
	

}
