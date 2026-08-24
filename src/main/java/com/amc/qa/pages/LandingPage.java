package com.amc.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amc.qa.base.TestBase;
import com.amc.qa.util.ScreenShot;
import com.amc.qa.util.ScrollOnPage;

public class LandingPage extends TestBase{
	
	ScrollOnPage scrollOnPage = new ScrollOnPage();
	ScreenShot sc = new ScreenShot();
	
	@FindBy(xpath = "(//*[local-name()='svg' and contains(@class,'icon mahindra-rise-logo')])[1]")
	WebElement mahindraLogo;
	
	@FindBy(xpath = "//a[@class='cc-btn cc-allow cc-btn-format']")
	WebElement acceptAllCoocies;
	
	@FindBy(xpath = "//span[text()='Cookie Preferences']")
	WebElement coockiePreference;
	
	@FindBy(xpath = "//*[local-name()='svg' and contains(@class,'icon header-login-icon')]")
	WebElement loginIcon;
	
	@FindBy(xpath = "//span[@class='user-message']")
	WebElement userProfileIcon;
	
	@FindBy(xpath = "//a[text()='SUVs']")
	WebElement suvsTab;
	
	@FindBy(xpath = "//a[@href='https://auto.mahindra.com/contact-us.html' and @title='Go to Contact us']")
	WebElement contactUsLink;
	
	
	
	public LandingPage()
	{
		PageFactory.initElements(driver, this);
	}

	
	public String validatePageTitle()
	{
		return driver.getTitle();
	}
	
	public void acceptCookies() throws IOException
	{
		boolean b = acceptAllCoocies.isDisplayed();
		boolean c = coockiePreference.isDisplayed();
		
		
		System.out.println(b);
		
		acceptAllCoocies.click();
		//sc.takeScreenShot();
		
	}
	
	public boolean getLogo()
	{
		boolean b = mahindraLogo.isDisplayed();
		
		return b;
	}
	
	public SignInPopUp login()
	{
		loginIcon.click();
		
		return new SignInPopUp();
	}
	
	public MyAccountPage userProfile()
	{
		userProfileIcon.isDisplayed();
		userProfileIcon.click();
		
		return new MyAccountPage();
	}
	
	public SUVsPopUpPage navigateToSUVs()
	{
		suvsTab.isDisplayed();
		suvsTab.click();
		return new SUVsPopUpPage();
	}
	
	public ContactUsPage navigateToContactUs()
	{
		scrollOnPage.scrollToElement(driver, contactUsLink);
		contactUsLink.click();
		return new ContactUsPage();
	}
	
	
}
