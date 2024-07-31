package com.classStudents;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class Swathi {
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "android");
		caps.setCapability("appium:platformVersion", "12");
		caps.setCapability("appium:deviceName", "emulator-5554");
		caps.setCapability("appium:automationName", "Uiautomator2");
		caps.setCapability("appium:appPackage", "com.omr_branch");
		caps.setCapability("appium:appActivity", "com.omr_branch.MainActivity");

		// URL url = new URL("https://127.0.0.1:4723/");
		URL url = new URL("http://127.0.0.1:4723/");

		WebDriver driver = new AppiumDriver(url, caps);
		System.out.println("App is Launched Sucessfully");
	}

}
