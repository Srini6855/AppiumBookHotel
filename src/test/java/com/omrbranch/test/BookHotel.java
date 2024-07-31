package com.omrbranch.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.omrbranch.base.BaseClass;

public class BookHotel extends BaseClass {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities caps = addDesiredCapabilities("android", "12", "emulator-5554", "Uiautomator2",
				"com.omr_branch", "com.omr_branch.MainActivity");
		URL url = constructURL("http://127.0.0.1:4723/");
		appLaunch(url, caps);
		implicitWait();
		elementSendKeys("login_email_input", "srinipmps@gmail.com");
		elementSendKeys("login_password_input", "8@ndHEw5TfaLm5e");
		elementClick("login_button");
		elementClick("search_select_state");
		swipeUpFromElement("Kerala");
		elementClickT("Tamil Nadu");
		elementClickT("Select City");
		elementClickT("Coimbatore");
		elementClickT("Select Room Type");
		elementClickT("Standard");
		elementClickT("Standard");
		elementClick("search_select_checkin");
		elementClickT("29");
		elementClickT("OK");
		elementClick("search_select_checkout");
		elementClickT("30");
		elementClickT("OK");
		elementClickT("No. Of Room");
		elementClickT("1-One");
		elementClickT("No. Of Adults");
		elementClickT("1-One");
		elementSendKeys("search_no_of_children", "1");
		elementClick("search_button");
		sleep();
		swipeUp();
		elementClickP("hotel_continue_button", 1);
		elementClick("android:id/button2");
		sleep();
		swipeUp();
		elementClickT("Myself");
		elementClickT("Select Salutation");
		elementClickT("Mr.");
		elementSendKeysT("First Name", "Srinivasu");
		elementSendKeysT("Last Name", "A");
		elementSendKeysT("Mobile No.", "9487715046");
		elementSendKeysT("Email", "srinipmps@gmail.com");
		elementClickT("Enter GST Details (Optional)");
		elementSendKeysT("Enter Registration No.", "9043592058");
		swipeUp();
		swipeUp();
		elementSendKeysT("Enter Company Name", "Greens Tech OMR Branch");
		elementSendKeysT("Enter Company Address", "Thoraipakkam");
		elementClickT("Next");
		elementClickT("Late Check-in");
		elementSendKeys(locatorByXpath("//android.widget.EditText[@content-desc='TextInput']"), "Veg Only");
		elementClick("book_hotel_next_button");
		sleep(10000);
		elementClick(locatorByXpath(
				"//android.widget.TextView[@text='UPI']/parent::android.view.View/parent::android.view.View"));
		sleep();
//		elementSendKeysByJs("upi_id", "lkjhgf");
//		elementClick("upi_id");
//		elementSendKeys(locatorByXpath("//android.widget.EditText"), "seleniumtraining@vbc");
//		elementSendKeys(xpathForResource("upi_id"), "seleniumtraining@vbc");
		elementClickT("Submit");
		sleep();
//		System.out.println(
//				"Booking Id : " + (elementGetText(locatorByXpath("(//android.widget.TextView)[4]")).split(" "))[0]);
	}

}
