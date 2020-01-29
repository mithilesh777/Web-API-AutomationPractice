package com.lulu.qa.web.pages;
import static org.testng.Assert.assertTrue;
import java.util.Arrays;
import java.util.List;

import com.lulu.qa.web.ConfigConstants;
import com.lulu.qa.web.pages.AbstractGoodRxPage;
import com.lulu.qa.web.utils.WebUtil;
import com.qapitol.sauron.appium.platform.grid.SauronAppiumAndroidDriver;
import com.qapitol.sauron.configuration.Config;
import com.qapitol.sauron.platform.grid.Grid;
import com.qapitol.sauron.platform.utilities.WebDriverWaitUtils;
import io.qameta.allure.Step;


public class LuluLoginPage extends AbstractGoodRxPage{
	public static final String MAINLOGIN_BTNLULU = "mainLoginBtnLulu";
	public static final String EMAILADDRESS_FIELD = "emailField";
	public static final String PROCEED_BTN = "proceedButton";
	public static final String PASSWORD_FIELD = "passwordField";
	public static final String REMEMBERME_CHECKBOX = "remembermeCheckBox";
	public static final String LOGIN_BTN = "loginBtn";
	

	@Step("Click on login button")
	public void luluLogin() {
		waitAndClickOn(MAINLOGIN_BTNLULU);
	}
	@Step("Click on email address field")
	public void emailAddressField() {
		waitAndClickOn(EMAILADDRESS_FIELD);
	}
	@Step("Click on proceed button")
	public void proceedBtn() {
		waitAndClickOn(PROCEED_BTN);
	}
	@Step("Click on password field")
	public void passwordField() {
		waitAndClickOn(PASSWORD_FIELD);
	}
	@Step("Click on remember me checkbox")
	public void rememberMeCheckbox() {
		waitAndClickOn(REMEMBERME_CHECKBOX);
	}
	@Step("Click on login Button")
	public void loginBtn() {
		waitAndClickOn(LOGIN_BTN);
	}
	@Step("LoginMethod")
	public void loginFn() {
	
	waitAndClickOn(LuluLoginPage.MAINLOGIN_BTNLULU);
	waitAndSetText(LuluLoginPage.EMAILADDRESS_FIELD, Config.getConfigProperty(ConfigConstants.EMAILID));
	waitAndClickOn(LuluLoginPage.PROCEED_BTN);
	waitAndSetText(LuluLoginPage.PASSWORD_FIELD, Config.getConfigProperty(ConfigConstants.LOGINPASSWORDDDL));
	waitAndClickOn(LuluLoginPage.REMEMBERME_CHECKBOX);
	waitAndClickOn(LuluLoginPage.LOGIN_BTN);
}
	
}