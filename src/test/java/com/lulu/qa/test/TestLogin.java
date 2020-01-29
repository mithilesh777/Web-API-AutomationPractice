package com.lulu.qa.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.lulu.qa.AbstractGoldQaTest;
import com.lulu.qa.web.ConfigConstants;
import com.lulu.qa.web.DataConfigConstants;
import com.lulu.qa.web.pages.AbstractGoodRxPage;
import com.lulu.qa.web.pages.LoginPage;
import com.lulu.qa.web.utils.WebUtil;
import com.qapitol.sauron.annotations.SauronTest;
import com.qapitol.sauron.configuration.Config;
import com.qapitol.sauron.platform.grid.Grid;
import com.qapitol.sauron.platform.utilities.WebDriverWaitUtils;

@Test(singleThreaded = true)
public class TestLogin extends AbstractGoldQaTest {
	@SauronTest
	@Test(description = " TC07: Verify clicking on Log In keeping email address blank", alwaysRun = true, groups = {
			"All", "Android" })
	public void clickOnLoginKeepingEmailAddressBlank() {
		if (AbstractGoodRxPage.getTargetClient().equalsIgnoreCase("android")) {
			loginPage.loginMethodForMobile("", "navya123");
			assertEquals(WebUtil.getToastMessage().contains("Please fill out this field"), true,
					"Toast message was not displayed");
			Grid.driver().navigate().back();
		} else {
			loginPage.loginMethod("", Config.getConfigProperty(ConfigConstants.PASSWORD));
			loginPage.verifyErrorMessage(LoginPage.EMAIL_TXT);
		}
	}

	@SauronTest
	@Test(description = "TC08: Verify clicking on Log In keeping password blank", alwaysRun = true, groups = { "All",
			"Android" })
	public void clickOnLoginKeepingPasswordBlank() {
		if (AbstractGoodRxPage.getTargetClient().equalsIgnoreCase("android")) {
			loginPage.loginMethodForMobile("mt@qapitol.com", "");
			assertEquals(WebUtil.getToastMessage().contains("Please fill out this field"), true,
					"Toast message was not displayed");
			Grid.driver().navigate().back();
		} else {
			loginPage.loginMethod(Config.getConfigProperty(ConfigConstants.USERNAME), "");
			loginPage.verifyErrorMessage(LoginPage.PASSWORD_TXT);
		}
	}

	@SauronTest
	@Test(description = "TC09: Verify clicking on Log In button keeping Email Address & Password blank", alwaysRun = true, groups = {
			"All", "Android" })
	public void clickOnLoginKeepingEmailAddressAndPasswordBlank() {
		if (AbstractGoodRxPage.getTargetClient().equalsIgnoreCase("android")) {
			loginPage.loginMethodForMobile("", "");
			assertEquals(WebUtil.getToastMessage().contains("Please fill out this field"), true,
					"Toast message was not displayed");
			Grid.driver().navigate().back();
		} else {
			loginPage.loginMethod("", "");
			loginPage.verifyErrorMessage(LoginPage.EMAIL_TXT);
		}
	}

	@SauronTest
	@Test(description = "TC10: Verify clicking on forgot password", groups = { "All", "Android" })
	public void clickOnForgotPassword() {
		loginPage.waitAndClickOn(LoginPage.MAINLOGIN_BTN);
		loginPage.waitAndClickOn(LoginPage.FORGOTPASSWORD_LNK);
		if (AbstractGoodRxPage.getTargetClient().equalsIgnoreCase("android")) {
			assertTrue(loginPage.assertForgotYourPasswordHdr(), "Forgot password header is not present");
		} else {
			assertTrue(Grid.driver().getCurrentUrl().contains(DataConfigConstants.FORGOTPASSWORD_URI),
					" This Redirected Forgot Password URL is not as expected : " + Grid.driver().getCurrentUrl());
			assertTrue(loginPage.isEmailFieldExist());
		}
	}

	@SauronTest
	@Test(description = "TC11: Verify login using facebook account", groups = { "All" })
	public void loginUsingFacebook() {
		loginPage.waitAndClickOn(LoginPage.MAINLOGIN_BTN);
		loginPage.waitAndClickOn(LoginPage.FACEBOOK_BTN);
		WebDriverWaitUtils.waitUntilElementIsPresent(loginPage.getLocator(LoginPage.FACEBOOKEMAIL_TFLD));
		assertTrue(Grid.driver().getCurrentUrl().contains("facebook"), "Url is not as expected");
		loginPage.enterFacebookEmail(Config.getConfigProperty(ConfigConstants.FACEBOOKEMAIL));
		loginPage.enterFacebookPassword(Config.getConfigProperty(ConfigConstants.FACEBOOKPASSWORD));
		loginPage.clickOnFacebookLoginBtn();
		assertTrue(Grid.driver().getCurrentUrl().contains(DataConfigConstants.LOGINFACEBOOK_URL),
				"Page Url is not as expected  ");
	}

	@SauronTest
	@Test(description = "TC12: Verify login using Google account", groups = { "All" })
	public void loginUsingGoogle() {
		loginPage.waitAndClickOn(LoginPage.MAINLOGIN_BTN);
		loginPage.waitAndClickOn(LoginPage.LOGINUSINGGOOGLE_BTN);
		assertTrue(Grid.driver().getCurrentUrl().contains("google.com"), "Url is not as expected");
		loginPage.enterGoogleEmail(Config.getConfigProperty(ConfigConstants.GOOGLEEMAIL));
		loginPage.enterGooglePassword(Config.getConfigProperty(ConfigConstants.GOOGLEPASSWORD));
		assertTrue(Grid.driver().getCurrentUrl().contains(DataConfigConstants.LOGINFACEBOOK_URL),
				"Redirected URL is not as expected ::" + Grid.driver().getCurrentUrl());
	}

	@SauronTest
	@Test(description = "TC13: Check the validation, enter google/fb credential in email & password field & login", groups = {
			"All" })
	public void enterGoogleOrFbCredentialInLogin() {
		loginPage.waitAndClickOn(LoginPage.MAINLOGIN_BTN);
		loginPage.waitAndSetText(LoginPage.EMAIL_TXT, Config.getConfigProperty(ConfigConstants.GOOGLEEMAIL1));
		loginPage.waitAndSetText(LoginPage.PASSWORD_TXT, Config.getConfigProperty((ConfigConstants.GOOGLEPASSWORD1)));
		loginPage.clickOnLogin();
		assertTrue(
				loginPage.getText(LoginPage.ERRORMESSAGE_TXT)
						.equalsIgnoreCase(DataConfigConstants.LOGINGOOGLE_AND_FACEBOOK_ERRORMESSAGE),
				"Expected error message is not displayed when login with Facebook or Google Account Credentials");
	}

	@SauronTest
	@Test(description = "TC14: Verify clicking on Sign Up for a FREE trial button", groups = { "All" })
	public void verifyClickingOnSignUpForFreeTrial() {
		Grid.driver().get(Config.getConfigProperty(ConfigConstants.SERVER_URL));
		loginPage.clickOnSignUpForAFreeTrialBtn();
		assertTrue(Grid.driver().getCurrentUrl().contains(DataConfigConstants.SIGNUPFREETRIAL),
				"Redirected URL is not as expected ::" + Grid.driver().getCurrentUrl());
	}

	@SauronTest
	@Test(description = "TC22: Verify clicking on Log In button", alwaysRun = true, groups = { "All", "Android" })
	public void verifyClickingOnLogInButton() {
		loginPage.waitAndClickOn(LoginPage.MAINLOGIN_BTN);
		assertTrue(loginPage.waitAndCheckIsElementDisplayed(LoginPage.LOGIN_BTN), "Login Page Was not displayed");
	}

}
