package com.amc.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amc.qa.base.TestBase;
import com.amc.qa.pages.BookingCongratulationsPage;
import com.amc.qa.pages.ContactUsPage;
import com.amc.qa.pages.FinanceAndExchangePage;
import com.amc.qa.pages.KycVerificationPage;
import com.amc.qa.pages.LandingPage;
import com.amc.qa.pages.MyAccountPage;
import com.amc.qa.pages.PayUCheckOutPage;
import com.amc.qa.pages.ReviewPage;
import com.amc.qa.pages.SUVsPopUpPage;
import com.amc.qa.pages.SelectDealerPage;
import com.amc.qa.pages.SignInOTPPopUp;
import com.amc.qa.pages.SignInPopUp;
import com.amc.qa.pages.VariantSelectionPage;
import com.amc.qa.util.ReadDataFromExcelSheet;

public class LandingPageTest extends TestBase{
	LandingPage landingPage;
	SignInPopUp signInPopUp ;
	SignInOTPPopUp signInOtpPopUp;
	LandingPage afterLoginlandingPage;
	MyAccountPage myAccountPage;
	SUVsPopUpPage suvsPopUpPage;
	VariantSelectionPage variantSelectionPage;
	SelectDealerPage selectDealerPage;
	FinanceAndExchangePage financeAndExchagePage;
	ReviewPage reviewPage;
	KycVerificationPage ekycVerififcationPage;
	PayUCheckOutPage payuCheckOutPage;
	BookingCongratulationsPage bookingCongratulationPage;
	ContactUsPage contactUs;
	ReadDataFromExcelSheet readData = new ReadDataFromExcelSheet();
	
	String excelDataPath = "C:\\Users\\Rahul Chauhan\\eclipse-workspace\\AMCTest\\src\\main\\java\\com\\amc\\qa\\data\\ContactUs.xlsx";
	String sheetName = "Sheet1";
	
	public LandingPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		landingPage = new LandingPage();
		landingPage.acceptCookies();
	}
	
	@Test(enabled = true)	
	public void LandingPageTitleTest()
	{
		log.info("*** validating mahindra title ********");
		String title = landingPage.validatePageTitle();
		Assert.assertEquals(title, "Mahindra Auto - Passenger & Commercial Vehicles");
	}
	
	@Test(enabled = true)	
	public void LandingPageLogoTest()
	{
		log.info("*** validating mahindra logo visiblity ********");
	
		boolean b = landingPage.getLogo();
		Assert.assertEquals(b, true);
	}
	
	@DataProvider
	public Object[][] getContactData() throws IOException
	{
		Object[][] data =  readData.getExcelDataAsString(excelDataPath, sheetName);
		return data;
	}
	
	@Test(enabled = false)	
	public void LoginTest() throws InterruptedException
	{
		signInPopUp = landingPage.login();
		signInOtpPopUp = signInPopUp.SignIn(prop.getProperty("mobileNumber"));
		afterLoginlandingPage = signInOtpPopUp.enterOTP();
		myAccountPage = afterLoginlandingPage.userProfile();
		
	}
	
	@Test(enabled = false, dataProvider = "getContactData")	
	public void navigateToContactUS(String firstname, String lastName, String contact, String email, String message) throws InterruptedException
	{
		contactUs = landingPage.navigateToContactUs();
		Thread.sleep(3000);
		contactUs.submitGetInTouchForm(firstname,lastName,contact,email,message);
		
	}
	
	@Test(enabled = false)
	public void VehicelBookingTest() throws InterruptedException
	{
		signInPopUp = landingPage.login();
		signInOtpPopUp = signInPopUp.SignIn(prop.getProperty("mobileNumber"));
		afterLoginlandingPage = signInOtpPopUp.enterOTP();
		Thread.sleep(3000);
		suvsPopUpPage = afterLoginlandingPage.navigateToSUVs();
		variantSelectionPage = suvsPopUpPage.clickOnBookNow();
		selectDealerPage = variantSelectionPage.selectVariant();
		financeAndExchagePage = selectDealerPage.selectDealer();
		reviewPage = financeAndExchagePage.selectFinanceAndExchange();
		ekycVerififcationPage = reviewPage.reviewAndContinue();
		payuCheckOutPage = ekycVerififcationPage.verifyKyc(prop.getProperty("eKycData"));
		bookingCongratulationPage = payuCheckOutPage.paymentUsingPayu();
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}

