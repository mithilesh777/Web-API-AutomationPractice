package com.lulu.qa.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.lulu.qa.AbstractGoldQaTest;
import com.lulu.qa.web.ConfigConstants;
import com.lulu.qa.web.pages.AbstractGoodRxPage;
import com.lulu.qa.web.pages.HamburgerPage;
import com.lulu.qa.web.pages.PharmacyDirectorypage;
import com.lulu.qa.web.utils.WebUtil;
import com.qapitol.sauron.annotations.SauronTest;
import com.qapitol.sauron.configuration.Config;
import com.qapitol.sauron.platform.grid.Grid;

public class TestPharmacyDirectorylink extends AbstractGoldQaTest {
	@SauronTest
	@Test(description = "TC19: Verify clicking on Pharmacy Directory link, should redirect to pharmacy's directory page", alwaysRun = true, groups = {
			"All", "Android" })
	public void testClickOnParticipatingPharmcies() {
		if (AbstractGoodRxPage.getTargetClient().equalsIgnoreCase("android")) {
			hamburgerPage.waitAndClickOn(HamburgerPage.HAMBURGER_ICN);
			hamburgerPage.waitAndClickOn(HamburgerPage.FIND_A_PHARMACY);
			assertTrue(
					pharmacyDirectorypage.waitAndCheckIsElementDisplayed(PharmacyDirectorypage.PHARMACY_DIRECTORY_TEXT),
					"Pharmacy Page was not displayed");
		} else {
			hamburgerPage.waitAndClickOn(HamburgerPage.HAMBURGER_ICN);
			hamburgerPage.waitAndClickOn(HamburgerPage.FIND_A_PHARMACY);
			WebUtil.longSleepForOnboarding();
			String actualUrl = Grid.driver().getCurrentUrl().toString();
			assertEquals(actualUrl,
					Config.getConfigProperty(ConfigConstants.SERVER_URL) + ConfigConstants.DIRECTORY_URI,
					"Redirected Pharmacy URL is not as expected ::" + actualUrl);
			String pharmacyDirectoryText = pharmacyDirectorypage.getText(PharmacyDirectorypage.PHARMACY_DIRECTORY_TEXT);
			assertEquals(pharmacyDirectoryText.contains("Pharmacy Directory"), true,
					"pharmacy Directory text is not present");
		}

	}
}
