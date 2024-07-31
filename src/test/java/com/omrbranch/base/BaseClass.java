package com.omrbranch.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class BaseClass {

	static DesiredCapabilities caps;
	static AndroidDriver driver;

	public static DesiredCapabilities addDesiredCapabilities(String value1, String value2, String value3, String value4,
			String value5, String value6) {
		caps = new DesiredCapabilities();
		caps.setCapability("platformName", value1);
		caps.setCapability("appium:platformVersion", value2);
		caps.setCapability("appium:deviceName", value3);
		caps.setCapability("appium:automationName", value4);
		caps.setCapability("appium:appPackage", value5);
		caps.setCapability("appium:appActivity", value6);
		return caps;

	}

	public static URL constructURL(String dataUrl) throws MalformedURLException {
		return new URL(dataUrl);
	}

	public static void appLaunch(URL url, DesiredCapabilities caps) {
		driver = new AndroidDriver(url, caps);
	}

	public static WebElement locatorByXpath(String data) {
		return driver.findElement(By.xpath(data));
	}

	public static String elementGetText(WebElement elemnet) {
		return elemnet.getText();
	}

	public static String elementGetTextT(String text) {
		return locatorByXpath("//*[@text='" + text + "']").getText();
	}

	public static WebElement xpathForResource(String resource_id) {
		return locatorByXpath("//*[@resource-id='" + resource_id + "']");
	}

	public static WebElement xpathForText(String text) {
		return locatorByXpath("//*[@text='" + text + "']");
	}

	public static void elementSendKeys(WebElement element, String data) {
//		explicitWait(element);
		element.sendKeys(data);
	}

	public static void elementSendKeysByJs(String resource_id, String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + data + "')",
				locatorByXpath("//*[@resource-id='" + resource_id + "']"));
	}

	public static void elementSendKeys(String resource_id, String data) {
		locatorByXpath("//*[@resource-id='" + resource_id + "']").sendKeys(data);
	}

	public static void elementSendKeysT(String text, String data) {
		locatorByXpath("//*[@text='" + text + "']").sendKeys(data);
	}

	public static void elementClick(WebElement element) {
		explicitWait(element);
		element.click();
	}

	public static void elementClick(String resource_id) {
		locatorByXpath("//*[@resource-id='" + resource_id + "']").click();
	}

	public static void elementClickP(String resource_id, int position) {
		locatorByXpath("" + "(//*[@resource-id='" + resource_id + "'])[" + position + "]").click();
	}

	public static void elementClickT(String text) {
		explicitWait(locatorByXpath("//*[@text='" + text + "']"));
		locatorByXpath("//*[@text='" + text + "']").click();
	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public static void explicitWait(WebElement element) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driverWait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void sleep() throws InterruptedException {
		Thread.sleep(5000);
	}

	public static void sleep(int sec) throws InterruptedException {
		Thread.sleep(sec);
	}

	public static void swipeUp() throws InterruptedException {
		Dimension size = driver.manage().window().getSize();
		int startX = size.getWidth() / 2;
		int startY = size.getHeight() / 2;
		int endX = startX;
		int endY = (int) (size.getHeight() * 0.25);
		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		Sequence sequence = new Sequence(finger1, 1)
				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
				.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger1, Duration.ofMillis(200)))
				.addAction(
						finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
				.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Collections.singletonList(sequence));
	}

	public static void swipeUpFromElement(String text) throws InterruptedException {
		Dimension size = driver.manage().window().getSize();
		Point location = xpathForText(text).getLocation();
		int startX = size.getWidth() / 2;
		int endX = startX;
		int endY = (int) (size.getHeight() * 0);
		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		Sequence sequence = new Sequence(finger1, 1)
				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), location))
				.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger1, Duration.ofMillis(200)))
				.addAction(
						finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
				.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Collections.singletonList(sequence));
	}

}
