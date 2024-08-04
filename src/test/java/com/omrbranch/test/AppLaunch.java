package com.omrbranch.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.omrbranch.base.BaseClass;

public class AppLaunch extends BaseClass {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities caps = addDesiredCapabilities("android", "12", "emulator-5554", "Uiautomator2",
				"com.omr_branch", "com.omr_branch.MainActivity");
		URL url = constructURL("http://127.0.0.1:4723/");
		appLaunch(url, caps);
		implicitWait();
		elementSendKeys(locatorByXpath("//*[@resource-id='login_email_input']"), "srinipmps@gmail.com");
		elementSendKeys(locatorByXpath("//*[@resource-id='login_password_input']"), "8@ndHEw5TfaLm5e");
		elementClick(locatorByXpath("//*[@resource-id='login_button']"));
		elementClick(locatorByXpath("//*[@resource-id='search_select_state']"));
		elementClick(locatorByXpath("//*[@text='Kerala']"));
		elementClick(locatorByXpath("//*[@text='Select City']"));
		elementClick(locatorByXpath("//*[@text='Kochi']"));
		elementClick(locatorByXpath("//*[@text='Select Room Type']"));
		elementClick(locatorByXpath("//*[@text='Standard']"));
		elementClick(locatorByXpath("//*[@resource-id='search_select_checkin']"));
		elementClick(locatorByXpath("//*[@text='30']"));
		elementClick(locatorByXpath("//*[@text='OK']"));
		elementClick(locatorByXpath("//*[@resource-id='search_select_checkout']"));
		elementClick(locatorByXpath("//*[@text='31']"));
		elementClick(locatorByXpath("//*[@text='OK']"));
		elementClick(locatorByXpath("//*[@text='No. Of Room']"));
		elementClick(locatorByXpath("//*[@text='1-One']"));
		elementClick(locatorByXpath("//*[@text='No. Of Adults']"));
		elementClick(locatorByXpath("//*[@text='1-One']"));
		elementSendKeys(locatorByXpath("//*[@resource-id='search_no_of_children']"), "1");
		elementClick(locatorByXpath("//*[@resource-id='search_button']"));
		sleep();
		swipeUp();
		elementClick(locatorByXpath("(//*[@resource-id='hotel_continue_button'])[1]"));
		elementClick(locatorByXpath("//*[@resource-id='android:id/button2']"));
		sleep();
		swipeUp();
		swipeUp();
		elementClick(locatorByXpath("//*[@text='Myself']"));
		elementClick(locatorByXpath("//*[@text='Select Salutation']"));
		elementClick(locatorByXpath("//*[@text='Mr.']"));
		elementSendKeys(locatorByXpath("//*[@text='First Name']"), "Srinivasu");
		elementSendKeys(locatorByXpath("//*[@text='Last Name']"), "A");
		elementSendKeys(locatorByXpath("//*[@text='Mobile No.']"), "9487715046");
		elementSendKeys(locatorByXpath("//*[@text='Email']"), "srinipmps@gmail.com");
		elementClick(locatorByXpath("//*[@text='Enter GST Details (Optional)']"));
		elementSendKeys(locatorByXpath("//*[@text='Enter Registration No.']"), "9043592058");
		sleep();
		swipeUp();
		elementSendKeys(locatorByXpath("//*[@text='Enter Company Name']"), "Greens Tech OMR Branch");
		elementSendKeys(locatorByXpath("//*[@text='Enter Company Address']"), "Thoraipakkam");
		elementClick(locatorByXpath("//*[@text='Next']"));
		elementClick(locatorByXpath("//*[@text='Late Check-in']"));
		elementSendKeys(locatorByXpath("//android.widget.EditText[@content-desc='TextInput']"), "Veg Only");
		elementClick(locatorByXpath("//*[@resource-id='book_hotel_next_button']"));
		explicitWaitClick(locatorByXpath("//*[@text='Credit/Debit/ATM Card']"));
		String context = driver.getContext();
		Set<String> contextHandles = driver.getContextHandles();
		System.out.println(contextHandles);
		for (String string : contextHandles) {
			if (!context.equals(string)) {
				driver.context(string);
			}
		}
		elementClick(locatorByXpath("//*[@text='Credit/Debit/ATM Card']"));
		elementClick(locatorByXpath("//div[@class='credit-card pm']"));
		elementDdnVisibleText(locatorByXpath("//select[@id='payment_type']"), "Debit Card");
		elementDdnVisibleText(locatorByXpath("//select[@id='card_type']"), "Visa");
		elementSendKeys(locatorByXpath("//input[@id='card_no']"), "5555555555552222");
		elementSendKeys(locatorByXpath("//input[@id='card_name']"), "Srinivasu");
		elementDdnVisibleText(locatorByXpath("//select[@id='card_month']"), "2025");
		elementDdnVisibleText(locatorById("card_year"), "July");
		elementSendKeys(locatorByXpath("//input[@id='cvv']"), "123");
		driver.context("NATIVE_APP");
		elementClick(locatorByXpath("//*[@text='Submit']"));
//		

	}

}
