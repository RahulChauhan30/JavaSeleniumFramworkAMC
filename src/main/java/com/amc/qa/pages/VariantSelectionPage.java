package com.amc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amc.qa.base.TestBase;
import com.amc.qa.util.ScrollOnPage;

public class VariantSelectionPage extends TestBase {
	
	ScrollOnPage scrollOnpage = new ScrollOnPage();
	
	@FindBy(xpath = "//span[@class='value p2-regular']//span[@class='approx-price']")
	WebElement exShowroomPricce;
	
	@FindBy(xpath = "//a[@data-target='#seeDisclaimer']")
	WebElement seeDisclaimers;
	
	@FindBy(xpath = "//div[@data-attr='fuelType']//*[local-name()='svg' and @class='icon arrow-down']")
	WebElement selectFuelDropDown;
	
	@FindBy(xpath = "//div[@data-attr='seatingCapacity']//*[local-name()='svg' and @class='icon arrow-down']")
	WebElement seatingCapacityDropDown;
	
	@FindBy(xpath = "//div[@data-attr='gearBoxType']//*[local-name()='svg' and @class='icon arrow-down']")
	WebElement transmissionDropDown;
	
	@FindBy(xpath="(//input[@type='radio'])[2]")
	WebElement selectCardRadio;
	
	@FindBy(xpath = "//div[contains(@class,'item-card selected ')]")
	WebElement selectedCard;
	
	@FindBy(xpath = "(//button[@class='color-attribute  selectable'])[1]")
	WebElement productColor;
	
	@FindBy(xpath = "//div[@class='face1 face'][normalize-space()='Confirm & Proceed']")
	WebElement confirmAndProceedButton;
	
	VariantSelectionPage()
	{
		PageFactory.initElements(driver, this);
	}

	public SelectDealerPage selectVariant()
	{
		exShowroomPricce.isDisplayed();
		String ExShowroomPrice = exShowroomPricce.getText();
		System.out.println(ExShowroomPrice);
		seeDisclaimers.isDisplayed();
		selectFuelDropDown.isDisplayed();
		seatingCapacityDropDown.isDisplayed();
		transmissionDropDown.isDisplayed();
		selectedCard.isDisplayed();
		selectedCard.click();
		
		scrollOnpage.scrollByOffSetValue(0, 400);
		
		productColor.isDisplayed();
		productColor.click();
		confirmAndProceedButton.isDisplayed();
		confirmAndProceedButton.isEnabled();
		confirmAndProceedButton.click();
		
		return new SelectDealerPage();
	}
}
