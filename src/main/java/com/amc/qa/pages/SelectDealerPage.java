package com.amc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amc.qa.base.TestBase;

public class SelectDealerPage extends TestBase {

	@FindBy(xpath = "//input[@id='store-postal-codes']")
	WebElement enterYourCityOrPin;

	@FindBy(xpath = "//select[@id='store-radius']")
	WebElement radius;

	@FindBy(xpath = "//div[@class='face1 face'][normalize-space()='Search for Dealers']")
	WebElement searchForDealerButton;

	@FindBy(xpath = "//input[@type='radio' and @id='input-NB001NB04']")
	WebElement nbsDealerRadio;

	@FindBy(xpath = "//div[@class='face1 face'][normalize-space()='Select & Proceed']")
	WebElement selectAndProceedButton;

	SelectDealerPage() {
		PageFactory.initElements(driver, this);
	}

	public FinanceAndExchangePage selectDealer() throws InterruptedException {
		enterYourCityOrPin.isDisplayed();
		radius.isDisplayed();
		Thread.sleep(2000);
		searchForDealerButton.isEnabled();
		searchForDealerButton.click();
		Thread.sleep(3000);
		nbsDealerRadio.isEnabled();
		nbsDealerRadio.click();
		return new FinanceAndExchangePage();
	}
}
