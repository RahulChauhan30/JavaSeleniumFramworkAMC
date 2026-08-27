package com.amc.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import com.amc.qa.util.MyWebDriverListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public static final Logger log = LogManager.getLogger(TestBase.class);
	

	public TestBase() {

		prop = new Properties();
		
		// Load log4j.properties
        //PropertyConfigurator.configure("log4j.properties");

		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\Rahul Chauhan\\eclipse-workspace\\AMCTest\\src\\main\\java\\com\\amc\\qa\\config\\config.properties");

			prop.load(fis);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void initialization()
	{
		WebDriver e_driver = null;
		String browserName = prop.getProperty("Browser");
		if(browserName.equals("Chrome"))
		{
			e_driver = new ChromeDriver();
		}
		else if(browserName.equals("Edge"))
		{
			e_driver = new EdgeDriver();
		}
		
		log.info("*****Setting up driver***** ");
		MyWebDriverListener listener = new MyWebDriverListener();
		driver = new EventFiringDecorator<>(listener).decorate(e_driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		//log.info("*** navigating to URL ********");
		driver.get(prop.getProperty("URL"));
		log.info("*** navigating to URL ********" + prop.getProperty("URL"));
	}

}
