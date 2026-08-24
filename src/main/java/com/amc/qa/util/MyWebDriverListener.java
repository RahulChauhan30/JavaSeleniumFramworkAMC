package com.amc.qa.util;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import com.amc.qa.base.TestBase;

public class MyWebDriverListener extends TestBase implements WebDriverListener {
	
	ScreenShot sc = new ScreenShot();

	    @Override
	    public void beforeClick(WebElement element) {
	        System.out.println("Before clicking: " + element);
	    }

	    @Override
	    public void afterClick(WebElement element) {
	        System.out.println("Clicked: " + element);
	    }
	    public void onErrorException(WebDriver driver, Throwable throwable) throws IOException {
	        System.out.println("Error occurred: " + throwable.getMessage());
	        // You can add screenshot logic here
	       sc.takeScreenShot();
	    }
	    public void onError(Object target, Throwable throwable) throws IOException {
	        System.out.println("Error occurred: " + throwable.getMessage());
	        // You can add screenshot logic here
	       sc.takeScreenShot();
	    }
	
	    public void beforeNavigateTo(String url, WebDriver driver) {
			System.out.println("Before navigating to: '" + url + "'");
		}

		public void afterNavigateTo(String url, WebDriver driver) {
			System.out.println("Navigated to:'" + url + "'");
		}

		public void beforeChangeValueOf(WebElement element, WebDriver driver) {
			System.out.println("Value of the:" + element.toString() + " before any changes made");
		}

		public void afterChangeValueOf(WebElement element, WebDriver driver) {
			System.out.println("Element value changed to: " + element.toString());
		}


}
