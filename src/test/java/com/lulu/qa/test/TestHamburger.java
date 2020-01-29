package com.lulu.qa.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.lulu.qa.AbstractGoldQaTest;
import com.lulu.qa.web.ConfigConstants;
import com.lulu.qa.web.pages.AbstractGoodRxPage;
import com.lulu.qa.web.pages.HamburgerPage;
import com.lulu.qa.web.pages.HomePage;
import com.lulu.qa.web.pages.LoginPage;
import com.lulu.qa.web.pages.SupportPage;
import com.qapitol.sauron.annotations.SauronTest;
import com.qapitol.sauron.configuration.Config;
import com.qapitol.sauron.platform.grid.Grid;
import com.qapitol.sauron.platform.utilities.WebDriverWaitUtils;

public class TestHamburger extends AbstractGoldQaTest {

	@SauronTest
	@Test(description = "TC92: Verify clicking on 'Additional Benefits' option displayed in the hamburger menu", groups = {
			"All", "Android" })
	public void testClickOnAdditionalBenefits() {
		if (AbstractGoodRxPage.getTargetClient().equalsIgnoreCase("android")) {
			WebDriverWaitUtils.waitUntilElementIsPresent(homePage.getLocator(HomePage.LOGOGOOD_BTN));
			hamburgerPage.waitAndClickOn(HamburgerPage.HAMBURGER_ICN);
			hamburgerPage.waitAndClickOn(HamburgerPage.ADDITIONALBENEFITS_LNK);
		} else {
			loginPage.loginMethod(Config.getConfigProperty(ConfigConstants.lulu_USERNAME),
					Config.getConfigProperty(ConfigConstants.lulu_PASSWORD));
			hamburgerPage.clickHamAndAdditionalBenifits();
		}
		String textOfBenefits = hamburgerPage.waitAndGetText(HamburgerPage.GOODGOLD_TXT);
		assertEquals(textOfBenefits, "More lulu Gold Member Benefits",
				"More lulu Gold Member Benefits text is not present");
	}

	@SauronTest
	@Test(description = "TC93: Verify clicking on 'Dental Plan' link should redirect respective dental site", groups = {
			"All" })
	public void testClickOnDentalPlans() {
		loginPage.loginMethod(Config.getConfigProperty(ConfigConstants.lulu_USERNAME),
				Config.getConfigProperty(ConfigConstants.lulu_PASSWORD));
		String parentWindow = hamburgerPage.clickOnExternalLink("Dental Plans", HamburgerPage.DENTALPLAN_LNK);
		String textOfGoodRx = hamburgerPage.waitAndGetText(HamburgerPage.GOODRX_TXT);
		assertEquals(textOfGoodRx.contains("GOODRX"), true, "GOODRX text is not present");
		hamburgerPage.closeAndSwitchToParentWindow(parentWindow);

	}

	@SauronTest
	@Test(description = "TC94: Verify clicking on 'Heartland Veterinary Supply' link should redirect respective Heartland Veterinary Supply site", groups = {
			"All" })
	public void testClickOnHearlandVenterinarySupply() {
		loginPage.loginMethod(Config.getConfigProperty(ConfigConstants.lulu_USERNAME),
				Config.getConfigProperty(ConfigConstants.lulu_PASSWORD));
		String parentWindow = hamburgerPage.clickOnExternalLink("Heartland", HamburgerPage.HEARTLAND_LNK);
		assertTrue(hamburgerPage.waitAndCheckIsElementDisplayed(HamburgerPage.HEARTLAND_TXT),
				"Heartland Veterinary Supply & Pharmacy text is not present");
		String currentURLOfLink = Grid.driver().getCurrentUrl();
		assertEquals(currentURLOfLink, Config.getConfigProperty(ConfigConstants.HEARTLANDSUPPLY),
				"Redirected Heartland Supply is not as expected " + currentURLOfLink);
		hamburgerPage.closeAndSwitchToParentWindow(parentWindow);
	}

	@SauronTest
	@Test(description = "TC95: Verify clicking on 'TotalDiabetesSupply.com' link should redirect respective TotalDiabetesSupply site", groups = {
			"All" })
	public void testClickOnTotalDiabetesSupply() {
		loginPage.loginMethod(Config.getConfigProperty(ConfigConstants.lulu_USERNAME),
				Config.getConfigProperty(ConfigConstants.lulu_PASSWORD));
		String parentWindow = hamburgerPage.clickOnExternalLink("Total", HamburgerPage.TOTALDIABETESSUPPLY_LNK);
		assertTrue(hamburgerPage.waitAndCheckIsElementDisplayed(HamburgerPage.TOTALDIABETESLOGO),
				"Total diabetes logo is not present");
		String currentURLOfLink = Grid.driver().getCurrentUrl();
		assertEquals(currentURLOfLink, Config.getConfigProperty(ConfigConstants.TOTALDIABETESSUPPLY),
				"Redirected Total Diabetes Supply is not as expected " + currentURLOfLink);
		hamburgerPage.closeAndSwitchToParentWindow(parentWindow);
	}

	@SauronTest
	@Test(description = "TC96: Verify clicking on 'Personal Labs'  link should redirect respective Personal Labs site", groups = {
			"All" })
	public void testClickOnPersonalTabs() {
		loginPage.loginMethod(Config.getConfigProperty(ConfigConstants.lulu_USERNAME),
				Config.getConfigProperty(ConfigConstants.lulu_PASSWORD));
		String parentWindow = hamburgerPage.clickOnExternalLink("Personal", HamburgerPage.PERSONALLABS_LNK);
		String currentTextOfPage = hamburgerPage.waitAndGetText(HamburgerPage.PERSONALLABSGOODRX_TXT);
		assertEquals(currentTextOfPage, "lulu", "lulu text is not present");
		String currentURLOfLink = Grid.driver().getCurrentUrl();
		assertEquals(currentURLOfLink, Config.getConfigProperty(ConfigConstants.PERSONALABS),
				"Redirected Personal Labs URL is not as expected " + currentURLOfLink);
		String currentParagraphText = hamburgerPage.waitAndGetText(HamburgerPage.GOODRXINFO_TXT);
		assertEquals(currentParagraphText, "Welcome to lulu loyalty customer!",
				"Welcome to lulu loyalty customer! is not present");
		hamburgerPage.closeAndSwitchToParentWindow(parentWindow);
	}

	@SauronTest
	@Test(description = "TC:15 Verify the options in Hamburger Menu", groups = "Android")
	public void clickOnHamburgerMenu() {
		hamburgerPage.waitAndClickOn(HamburgerPage.HAMBURGER_ICN);
		assertTrue(hamburgerPage.waitAndCheckIsElementDisplayed(HamburgerPage.FIND_A_PHARMACY),
				"Find a pharmacy option is not present");
		assertTrue(hamburgerPage.waitAndCheckIsElementDisplayed(HamburgerPage.GET_A_PRISCRIPTION),
				"Get a prescription option is not present");
		assertTrue(hamburgerPage.waitAndCheckIsElementDisplayed(HamburgerPage.ADDITIONALBENEFITS_LNK),
				"Additional benefits option is not present");
	}

	@SauronTest
	@Test(description = "TC08: Verify whether User is able to click on Membership link", groups = { "Android" })
	public void clickOnMembership() {
		WebDriverWaitUtils.waitUntilElementIsPresent(homePage.getLocator(HomePage.LOGOGOOD_BTN));
		hamburgerPage.waitAndClickOn(HamburgerPage.HAMBURGER_ICN);
		hamburgerPage.waitAndClickOn(HamburgerPage.MEMBERSHIP_LNK);
		WebDriverWaitUtils.waitUntilElementIsPresent(hamburgerPage.getLocator(HamburgerPage.MEMBERSHIP_HDR));
		assertTrue(hamburgerPage.waitAndCheckIsElementDisplayed(HamburgerPage.MEMBERSHIP_HDR),
				"Membership header is not present");
	}

	@SauronTest
	@Test(description = "TC24: Verify whether user able to click on HELP in Hamburger Menu", groups = { "Android" })
	public void clickOnHelpHamburgur() throws Exception {
		hamburgerPage.waitAndClickOn(HamburgerPage.HAMBURGER_ICN);
		hamburgerPage.waitAndClickOn(HamburgerPage.HELP_LINK_HAMBERGUR);
		WebDriverWaitUtils.waitUntilElementIsPresent(supportPage.getLocator(SupportPage.SUPPORT_TXT));
		assertTrue(supportPage.waitAndCheckIsElementDisplayed(SupportPage.SUPPORT_TXT),
				"Support Text was not displayed");
		Grid.driver().navigate().back();
	}

	@SauronTest
	@Test(description = "TC25: Verify whether user able to click on 'GoldRx Gold' Option in Hamburger Menu", groups = {
			"Android" })
	public void clickOnGolRXHamburger() throws Exception {
		WebDriverWaitUtils.waitUntilElementIsPresent(homePage.getLocator(HomePage.LOGOGOOD_BTN));
		hamburgerPage.waitAndClickOn(HamburgerPage.HAMBURGER_ICN);
		hamburgerPage.waitAndClickOn(HamburgerPage.GOODRX_GOLD_LNK_HAMBURGER);
		WebDriverWaitUtils.waitUntilElementIsPresent(homePage.getLocator(HomePage.STARTYOURFREETRAIL_BTN));
		assertTrue(homePage.waitAndCheckIsElementDisplayed(HomePage.STARTYOURFREETRAIL_BTN),
				"Free Trial Button Was not displayed in home page");
		Grid.driver().navigate().back();
	}

	@SauronTest
	@Test(description = "TC10: Verify clicking on 'Login Btn' in Hamburger page", groups = { "Android" })
	public void testClickOnLoginBtnHamburgerPage() throws Exception {
		hamburgerPage.waitAndClickOn(HamburgerPage.HAMBURGER_ICN);
		hamburgerPage.waitAndClickOn(HamburgerPage.LOGIN_BTN_HAMBURGER);
		assertTrue(loginPage.waitAndCheckIsElementDisplayed(LoginPage.LOGIN_BTN), "Login Page Was not displayed");
	}
}