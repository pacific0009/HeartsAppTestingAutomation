package com.hfn.heartsappAutomatedMobileTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.microsoft.appcenter.appium.EnhancedAndroidDriver;

import io.appium.java_client.MobileElement;

public class Login {
	private EnhancedAndroidDriver<MobileElement> driver;
	
	Login(EnhancedAndroidDriver<MobileElement> driver){
		this.driver = driver; 
	}
	
	public boolean emailLogin(String uid, String pass) {
		driver.label("Email Loign Initiated");
		driver.findElementsByXPath("//android.widget.TextView").get(3).click();
		
		try{Thread.sleep(15000);}catch(InterruptedException e){System.out.println(e);}
		driver.findElementsByXPath("//android.widget.TextView").get(0).click();
		
		driver.findElementsByXPath("//android.widget.EditText").get(0).sendKeys(uid);
		driver.findElementsByXPath("//android.widget.EditText").get(1).sendKeys(pass);
		
		driver.findElementsByXPath("//android.view.ViewGroup").get(8).click();
		try{Thread.sleep(5000);}catch(InterruptedException e){System.out.println(e);}
		
		String text = driver.findElementsByXPath("//android.widget.TextView").get(1).getAttribute("value");
		if(!text.equals("Sign Out")) {
			return false;
		}
		driver.label("Email Loign Ended");
		return true;
	}
}
