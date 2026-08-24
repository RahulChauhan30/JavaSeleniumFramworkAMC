package com.amc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amc.qa.base.TestBase;

public class SUVsPopUpPage extends TestBase{

	@FindBy(xpath = "//a[@href='/own-online/variant-selection?pid=SCN']//div[@class='face1 face'][normalize-space()='Book Now']")
	WebElement scnBookNow;
	
	SUVsPopUpPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public VariantSelectionPage clickOnBookNow()
	{
		scnBookNow.isDisplayed();
		scnBookNow.click();
		return new VariantSelectionPage();
	}
}
