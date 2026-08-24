package com.amc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amc.qa.base.TestBase;

public class PayUCheckOutPage extends TestBase{
	
	@FindBy(xpath = "//h1[text()='Checkout']")
	WebElement labelCheckout;
	
	@FindBy(xpath = "//p[text()='Wallet']")
	WebElement wallet;
	
	@FindBy(xpath = "//span[text()='Airtel Payments Bank']")
	WebElement airtelPaymentBank;
	
	@FindBy(xpath = "(//button[text()='PROCEED'])[1]")
	WebElement proceedButton;
	
	@FindBy(xpath = "//input[@id='OTP']")
	WebElement OtpInput;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath = "//input[@value='Simulate Success Response']")
	WebElement simulateSuccessResponse;
	
	@FindBy(xpath = "//input[@value='Simulate Failure Response']")
	WebElement simulateFailureResponse;
	
	PayUCheckOutPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public BookingCongratulationsPage paymentUsingPayu() throws InterruptedException
	{
		labelCheckout.isDisplayed();
		
		wallet.click();
		Thread.sleep(1000);
		airtelPaymentBank.click();
		proceedButton.click();
		Thread.sleep(1000);
		OtpInput.isDisplayed();
		OtpInput.sendKeys("123456");
		submitButton.click();
		Thread.sleep(1000);
		simulateSuccessResponse.click();
		Thread.sleep(1000);
		return new BookingCongratulationsPage();
	}
	

}
