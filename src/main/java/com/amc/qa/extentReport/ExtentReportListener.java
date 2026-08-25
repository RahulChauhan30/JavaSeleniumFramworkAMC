package com.amc.qa.extentReport;
import com.amc.qa.base.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

	public class ExtentReportListener extends TestBase implements ITestListener {

	    private static ExtentReports extent;
	    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	    @Override
	    public void onStart(ITestContext context) {
	        // Initialize ExtentReports
	        ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\Rahul Chauhan\\eclipse-workspace\\AMCTest\\test-output\\ExtentReport.html");
	        extent = new ExtentReports();
	        extent.attachReporter(spark);
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        // Create a test entry
	        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
	        test.set(extentTest);
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test.get().log(Status.PASS, "Test Passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	       // test.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());
	        
	     // Generate timestamp for unique screenshot names
	        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	        String screenshotPath = System.getProperty("user.dir")+"\\src\\main\\java\\com.amc.qa.screenshot\\SS" +result.getMethod().getMethodName()+timestamp+".png" ;
	        try {
	        	File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        	FileUtils.copyFile(screenshot, new File(screenshotPath));
	        	

	            // Attach screenshot to Extent Report
	        	test.get().fail("Test Failed: " + result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	        	
	        }
	        catch(Exception e )
	        {
	        	test.get().fail("Fail to attache Screenshot: " + e.getMessage());
	        }

	        // Optional: attach screenshot path if available
	        // String screenshotPath = "path/to/screenshot.png";
	        // test.get().addScreenCaptureFromPath(screenshotPath);
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        test.get().log(Status.SKIP, "Test Skipped: " + result.getThrowable());
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        // Flush report
	        extent.flush();
	    }
	}



