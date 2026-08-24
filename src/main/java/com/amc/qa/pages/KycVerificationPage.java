package com.amc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amc.qa.base.TestBase;

public class KycVerificationPage extends TestBase{
	
	@FindBy(xpath = "//*[normalize-space()='KYC Verification']")
	WebElement labelKYCVerification;
	
	@FindBy(xpath = "//button[@data-value='pan-tan']")
	WebElement coporateTab;
	
	@FindBy(xpath = "//input[@id='verify-pan']")
	WebElement panTanInputFiled;
	
	@FindBy(xpath = "//label[contains(text(),'I agree to voluntarily share my PAN/TAN details fo')]")
	WebElement checkBoxVerifyPanTan;
	
	@FindBy(xpath = "//div[@class='form-group custom-control custom-checkbox js-tos-pantan']")
	WebElement checkBox;
	
	@FindBy(xpath = "(//div[@class='face1 face'][normalize-space()='Verify'])[2]")
	WebElement verifyButton;
	
	KycVerificationPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public PayUCheckOutPage verifyKyc(String eKycData) throws InterruptedException
	{
		labelKYCVerification.isDisplayed();
		coporateTab.click();
		panTanInputFiled.isDisplayed();
		panTanInputFiled.click();
		panTanInputFiled.sendKeys(eKycData);
		Thread.sleep(5000);
		checkBox.click();
		Thread.sleep(5000);
		checkBoxVerifyPanTan.click();
		Thread.sleep(5000);
		verifyButton.isEnabled();
		verifyButton.click();
		Thread.sleep(2000);
		return new PayUCheckOutPage();
	}

}
