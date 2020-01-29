package com.lulu.qa.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.lulu.qa.AbstractGoldQaTest;
import com.lulu.qa.web.ConfigConstants;
import com.lulu.qa.web.pages.AbstractGoodRxPage;
import com.lulu.qa.web.pages.DrugLookUpPage;
import com.lulu.qa.web.pages.HamburgerPage;
import com.qapitol.sauron.annotations.SauronTest;
import com.qapitol.sauron.configuration.Config;
import com.qapitol.sauron.platform.grid.Grid;
import com.qapitol.sauron.platform.utilities.WebDriverWaitUtils;

public class TestDrugLookUp extends AbstractGoldQaTest {
	@SauronTest
	@Test(description = "TC15: Verify clicking on Search(Price Lookup) link, and  The placeholder should shown as 'Type your drug name'", groups = {
			"All", "Android" })
	public void testClickOnDrugLookUp() {
		hamburgerPage.waitAndClickOn(HamburgerPage.HAMBURGER_ICN);
		hamburgerPage.waitAndClickOn(HamburgerPage.DRUG_LOOKUP_HAM_LNK);
		if (AbstractGoodRxPage.getTargetClient().equalsIgnoreCase("android")) {
			WebDriverWaitUtils.waitUntilElementIsPresent(drugLookUpPage.getLocator(DrugLookUpPage.DRUG_LOOKUP_PAGE));
			assertTrue(drugLookUpPage.isElementPresent(DrugLookUpPage.DRUG_LOOKUP_PAGE),
					"Drug Look up page was not displayed");
		} else {
			String placeHolderValue = drugLookUpPage
					.waitAndGetTextByAttribute(DrugLookUpPage.DRUGNAME_TFLD, "placeholder").toString();
			assertEquals(placeHolderValue, "Type your drug name",
					"Type your drug name place holder is not present" + placeHolderValue);
		}
	}

	@SauronTest
	@Test(description = "TC17_A: Verify searching the drug with blank value with Login", groups = { "All", "bug_skip" })
	public void testSearchingTheDrugWithBlankValueWithLogin() {
		loginPage.loginMethod(Config.getConfigProperty(ConfigConstants.EMAILID),
				Config.getConfigProperty(ConfigConstants.LOGINPASSWORDDDL));
		hamburgerPage.waitAndClickOn(HamburgerPage.HAMBURGER_ICN);
		hamburgerPage.waitAndClickOn(HamburgerPage.DRUG_LOOKUP_HAM_LNK);
		drugLookUpPage.waitAndClickOn(DrugLookUpPage.SEARCH_ICN);
		String searchResult = drugLookUpPage.waitAndGetText(DrugLookUpPage.RESULT_TXT);
		assertEquals(searchResult.contains("No results yet"), true, "No Results Yet message is not present");
	}

	@SauronTest
	@Test(description = "TC17_B: Verify searching the drug with blank value without Login", groups = { "All",
			"bug_skip" })
	public void testSearchingTheDrugWithBlankValueWithoutLogin() {
		hamburgerPage.waitAndClickOn(HamburgerPage.HAMBURGER_ICN);
		hamburgerPage.waitAndClickOn(HamburgerPage.DRUG_LOOKUP_HAM_LNK);
		drugLookUpPage.waitAndClickOn(DrugLookUpPage.SEARCH_ICN);
		assertTrue(hamburgerPage.waitAndCheckIsElementDisplayed(DrugLookUpPage.RESULT_TXT),
				"'No Search Results' message is not displayed");
	}

	@SauronTest
	@Test(description = "TC18: Verify searching valid drug with Login", groups = { "All", "bug_skip" })
	public void testSearchingTheDrugWithLipitorValueWithLogin() {
		loginPage.loginMethod(Config.getConfigProperty(ConfigConstants.EMAILID),
				Config.getConfigProperty(ConfigConstants.LOGINPASSWORDDDL));
		hamburgerPage.waitAndClickOn(HamburgerPage.HAMBURGER_ICN);
		hamburgerPage.waitAndClickOn(HamburgerPage.DRUG_LOOKUP_HAM_LNK);
		drugLookUpPage.waitAndSetText(DrugLookUpPage.DRUGNAME_TFLD, "Lipitor");
		drugLookUpPage.waitAndClickOn(DrugLookUpPage.SEARCH_ICN);
		String lipitorSearchURL = Grid.driver().getCurrentUrl();
		assertEquals(lipitorSearchURL,
				Config.getConfigProperty(ConfigConstants.SERVER_URL) + ConfigConstants.LIPITOR_URI,
				"Redirected Liptor URL is not as expected" + lipitorSearchURL);
		String searchResultInformation = drugLookUpPage.getInformationOfDrug();
		assertEquals(searchResultInformation.contains("Atorvastatin (Lipitor)"), true,
				"Searched information of the current drug is not present" + searchResultInformation);
	}

}