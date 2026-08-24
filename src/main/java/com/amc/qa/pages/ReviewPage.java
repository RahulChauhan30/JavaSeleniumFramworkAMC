package com.amc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amc.qa.base.TestBase;
import com.amc.qa.util.ScrollOnPage;

public class ReviewPage extends TestBase {
	
	ScrollOnPage scrollOnPage = new ScrollOnPage();
	
	@FindBy(xpath = "//div[@class='form-group custom-control custom-checkbox']")
	WebElement checkbox;
	
	@FindBy(xpath = "//div[@class='face1 face'][normalize-space()='Continue']")
	WebElement buttonContinue;
	
	ReviewPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public KycVerificationPage reviewAndContinue() throws InterruptedException
	{
		scrollOnPage.scrollByOffSetValue(0, 500);
		checkbox.isDisplayed();
		checkbox.click();
		buttonContinue.isEnabled();
		buttonContinue.click();
		Thread.sleep(2000);
		return new KycVerificationPage();
		
	}
	

}
