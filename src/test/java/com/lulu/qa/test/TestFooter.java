package com.lulu.qa.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.lulu.qa.AbstractGoldQaTest;
import com.lulu.qa.web.ConfigConstants;
import com.lulu.qa.web.pages.AbstractGoodRxPage;
import com.lulu.qa.web.pages.FooterPage;
import com.lulu.qa.web.pages.HomePage;
import com.lulu.qa.web.pages.LoginPage;
import com.lulu.qa.web.pages.SupportPage;
import com.lulu.qa.web.utils.WebUtil;
import com.qapitol.sauron.annotations.SauronTest;
import com.qapitol.sauron.configuration.Config;
import com.qapitol.sauron.platform.grid.Grid;
import com.qapitol.sauron.platform.utilities.WebDriverWaitUtils;

public class TestFooter extends AbstractGoldQaTest {

	@SauronTest
	@Test(description = "TC45: Verify whether user able to click on FAQ", alwaysRun = true, groups = { "All",
			"Android" })
	public void verifyClickingOnFAQ() throws Exception {
		if (AbstractGoodRxPage.getTargetClient().equalsIgnoreCase("android")) {
			WebDriverWaitUtils.waitUntilElementIsPresent(homePage.getLocator(HomePage.LOGOGOOD_BTN));
			loginPage.waitAndClickOn(LoginPage.MAINLOGIN_BTN);
			footerPage.waitAndClickOn(FooterPage.FAQ_LNK);
			WebDriverWaitUtils.waitUntilElementIsPresent(supportPage.getLocator(SupportPage.SUPPORT_TXT));
			assertTrue(supportPage.waitAndCheckIsElementDisplayed(SupportPage.SUPPORT_TXT),
					"Support Text was not displayed");
			Grid.driver().navigate().back();
		} else {
			loginPage.waitAndClickOn(LoginPage.MAINLOGIN_BTN);
			footerPage.waitAndClickOn(FooterPage.FAQ_LNK);
			WebUtil.longSleepForOnboarding();
			String parentID = WebUtil.switchToNewTab();
			WebUtil.sleep();
			assertEquals(Grid.driver().getCurrentUrl(), Config.getConfigProperty(ConfigConstants.FAQ_URL),
					"Redirected FAQ Url is not as expected" + Grid.driver().getCurrentUrl());
			WebUtil.close();
			WebUtil.switchToParent(parentID);
		}
	}

	@SauronTest
	@Test(description = "TC47: Verify whether user is able to click on Privacy policy", alwaysRun = true, groups = {
			"All", "Android" })
	public void verifyClickingOnPrivacyPolicy() throws Exception {
		if (AbstractGoodRxPage.getTargetClient().equalsIgnoreCase("android")) {
			WebDriverWaitUtils.waitUntilElementIsPresent(homePage.getLocator(HomePage.LOGOGOOD_BTN));
			loginPage.waitAndClickOn(LoginPage.MAINLOGIN_BTN);
			footerPage.waitAndClickOn(FooterPage.PRIVACYPOLICY_LNK);
			WebDriverWaitUtils.waitUntilElementIsPresent(footerPage.getLocator(FooterPage.PRIVACYPOLICY_HDR));
			assertTrue(footerPage.waitAndCheckIsElementDisplayed(FooterPage.PRIVACYPOLICY_HDR),
					"Privacy Policy text was not displayed");
		} else {
			footerPage.clickOnPrivacyPolicy();
			assertEquals(Grid.driver().getCurrentUrl(),
					Config.getConfigProperty(ConfigConstants.SERVER_URL) + "privacy-policy",
					"Redirected Privacy policy URL is not as expected" + Grid.driver().getCurrentUrl());
			Assert.assertTrue(footerPage.waitAndCheckIsElementDisplayed(FooterPage.PRIVACYPOLICY_HDR),
					"Privacy policy header is not present");
		}
	}

	@SauronTest
	@Test(description = "TC48: Verify whether user is able to click on Terms of Service", alwaysRun = true, groups = {
			"All", "Android" })
	public void verifyClickingOnTermsOfService() throws Exception {
		if (AbstractGoodRxPage.getTargetClient().equalsIgnoreCase("android")) {
			WebDriverWaitUtils.waitUntilElementIsPresent(homePage.getLocator(HomePage.LOGOGOOD_BTN));
			loginPage.waitAndClickOn(LoginPage.MAINLOGIN_BTN);
			footerPage.waitAndClickOn(FooterPage.TERMSOFSERVICE_LNK);
			assertTrue(footerPage.waitAndCheckIsElementDisplayed(FooterPage.TERMSOFSERVICE_HDR),
					"Terms of Service Header text was not displayed");
		} else {
			footerPage.clickOnTermsOfService();
			String headerText = footerPage.getTermsOfServicesHeaderText();
			assertEquals(headerText.contains("Terms of Service"), true,
					"Terms of Service Header text was not displayed");
			assertEquals(Grid.driver().getCurrentUrl(),
					Config.getConfigProperty(ConfigConstants.SERVER_URL) + "terms-of-service",
					"Terms of service url is not present" + Grid.driver().getCurrentUrl());
			assertTrue(footerPage.waitAndCheckIsElementDisplayed(FooterPage.EFFECTIVEDATE),
					"Effective Date element is not present");
		}

	}

	@SauronTest
	@Test(description = "TC22: Verify whether user is able to tap on \"Disclaimer for GoodRx Gold members\" link", groups = {
			"Android" })
	public void verifyClickingOnDisclaimer() throws Exception {
		WebDriverWaitUtils.waitUntilElementIsPresent(homePage.getLocator(HomePage.LOGOGOOD_BTN));
		loginPage.waitAndClickOn(LoginPage.MAINLOGIN_BTN);
		footerPage.waitAndClickOn(FooterPage.DISCLAIMER_LNK);
		WebDriverWaitUtils.waitUntilElementIsPresent(footerPage.getLocator(FooterPage.DISCLAIMER_HDR));
		assertTrue(footerPage.waitAndCheckIsElementDisplayed(FooterPage.DISCLAIMER_HDR),
				"Disclaimer header text was not displayed");
	}

	@SauronTest
	@Test(description = "TC50: Verify whether user is able to tap on \"Bonus offers for GoodRx Gold members\" link", alwaysRun = true, groups = {
			"All" })
	public void verifyClickingOnBonusOffersForGoldMembers() throws Exception {
		footerPage.clickOnBonusOffersForGoldMembers();
		WebUtil.sleep();
		assertEquals(Grid.driver().getCurrentUrl(), Config.getConfigProperty(ConfigConstants.SERVER_URL) + "benefits",
				"Redirected Benefits Url is not as expected" + Grid.driver().getCurrentUrl());
		Assert.assertTrue(footerPage.waitAndCheckIsElementDisplayed(FooterPage.BENEFITS_HDR),
				"Benefits Header is not present");
	}

	@SauronTest
	@Test(description = "TC49: Verify whether user is able to tap on \"the phone number\"", alwaysRun = true, groups = {
			"All" })
	public void verifyClickingOnHelpLineNumber() throws InterruptedException {
		hamburgerPage.clickOnHamburgerIcon();
		footerPage.verifyHelpLineNumber();
	}

}
