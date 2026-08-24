package com.amc.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.amc.qa.base.TestBase;

public class ScreenShot extends TestBase{
	
	
	public void takeScreenShot() throws IOException
	{
		String dateTime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String currentDir = System.getProperty("user.dir");
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File( "C:\\Users\\Rahul Chauhan\\eclipse-workspace\\AMCTest\\src\\main\\java\\com\\amc\\qa\\screenshot\\"+dateTime+".png"));
	}

}
