package com.amc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amc.qa.base.TestBase;

public class FinanceAndExchangePage  extends TestBase{
	
	@FindBy(xpath = "//*[text()='Exchange & Finance options']")
	WebElement labelExchangeFinanceoptions;
	
	@FindBy(xpath = "//label[@for='exchangeOptionYes']")
	WebElement exchangeOptionYes;
	
	@FindBy(xpath = "//label[@for='financeOptionYes']")
	WebElement financeOptionYes;
	
	@FindBy(xpath = "//div[@class='face1 face'][normalize-space()='Proceed To Review']")
	WebElement proceedToReview;
	
	FinanceAndExchangePage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public ReviewPage selectFinanceAndExchange() throws InterruptedException
	{
		labelExchangeFinanceoptions.isDisplayed();
		exchangeOptionYes.click();
		financeOptionYes.click();
		proceedToReview.isEnabled();
		proceedToReview.click();
		Thread.sleep(2000);
		return new ReviewPage();
		
	}

}
