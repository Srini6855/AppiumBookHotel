package com.omrbranch.test;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.omrbranch.base.BaseClass;

public class SwipeUptoLastState extends BaseClass {
	public static void main(String[] args) throws Exception {
		DesiredCapabilities caps = addDesiredCapabilities("android", "12", "c27e9f42", "Uiautomator2",
				"com.omr_branch", "com.omr_branch.MainActivity");
		URL url = constructURL("http://127.0.0.1:4723/");
		appLaunch(url, caps);
		implicitWait();
		elementSendKeys("login_email_input", "srinipmps@gmail.com");
		elementSendKeys("login_password_input", "8@ndHEw5TfaLm5e");
		elementClick("login_button");
		elementClick("search_select_state");
		swipeUpFromElement("Kerala");
		System.out.println(elementGetTextT("Tamil Nadu"));
	}

}
