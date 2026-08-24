package com.amc.qa.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.amc.qa.base.TestBase;

public class ScrollOnPage extends TestBase {
	
	
	public void scrollByOffSetValue(int x, int y)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy("+x+","+y+");");
	}
	
	public void scrollToElement(WebDriver driver, WebElement element )
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
	}

}
