package com.hfn.heartsappAutomatedMobileTesting;

import com.microsoft.appcenter.appium.Factory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import com.microsoft.appcenter.appium.EnhancedAndroidDriver;

import org.junit.rules.TestWatcher;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Rule;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppTest {
	
	@Rule
    public TestWatcher watcher = Factory.createWatcher();
	
	private static EnhancedAndroidDriver<MobileElement> driver;
	
	@Before
    public void setUp() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
    	dc.setCapability("deviceName", "emulator-5554");
    	dc.setCapability("platformName", "Android");
    	dc.setCapability("appPackage", "com.hfn.unified");
    	dc.setCapability("appActivity", "com.hfn.unified.MainActivity");
    	dc.setCapability("noReset", false);
        driver = Factory.createAndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("All set");
    }
	
	@Test
	public void testLoginEmailAbhyasi() 
	{
		if (driver.findElements( By.id("android:id/button1") ).size() != 0) {
			driver.findElementById("android:id/button1").click();
		}
		
		Login login = new Login(driver);
		assertTrue(login.emailLogin("preceptor.2@mailinator.com", "preceptor"));
	}
	
//	@Test
//	public void testLoginEmailPreceptor() 
//	{	if (driver.findElements( By.id("android:id/button1") ).size() != 0) {
//			driver.findElementById("android:id/button1").click();
//		}
//		Login login = new Login(driver);
//		assertTrue(login.emailLogin("preceptor.2@mailinator.com", "preceptor"));
//	}
//	
	@After
    public void TearDown(){
		System.out.println("Ending ...");
		driver.label("Stopping App");
	    driver.quit();
        System.out.println("Done ...");
    }
}
