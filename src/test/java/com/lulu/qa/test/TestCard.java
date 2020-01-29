package com.lulu.qa.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

import com.lulu.qa.AbstractGoldQaTest;
import com.lulu.qa.web.ConfigConstants;
import com.lulu.qa.web.pages.AbstractGoodRxPage;
import com.lulu.qa.web.pages.CardPage;
import com.lulu.qa.web.utils.WebUtil;
import com.qapitol.sauron.annotations.SauronTest;
import com.qapitol.sauron.configuration.Config;
import com.qapitol.sauron.platform.grid.Grid;

public class TestCard extends AbstractGoldQaTest {

	@SauronTest
	@Test(description = "TC87: Verify Clicking Your Card displayed at the top right corner in the header", groups = "All")
	public void testClickOnYourCardTab() {
		loginPage.loginMethod(Config.getConfigProperty(ConfigConstants.EMAILID),
				Config.getConfigProperty(ConfigConstants.LOGINPASSWORDDDL));
		cardPage.waitAndClickOn(CardPage.YOURCARD_TAB);
		String currentURLOfLink = Grid.driver().getCurrentUrl();
		assertEquals(currentURLOfLink, Config.getConfigProperty(ConfigConstants.SERVER_URL) + "card",
				"Redirected Card Url is not as expected" + currentURLOfLink);

	}

	@SauronTest
	@Test(description = "TC89: Verify clicking on Text My Card Info button", groups = "All")
	public void testClickOnTextMyCard() {

		loginPage.loginMethod(Config.getConfigProperty(ConfigConstants.EMAILID),
				Config.getConfigProperty(ConfigConstants.LOGINPASSWORDDDL));
		cardPage.waitAndClickOn(CardPage.YOURCARD_TAB);
		cardPage.waitAndClickOn(CardPage.TEXTMYCARD_BTN);
		String popUpModalMessageByText = cardPage.waitAndGetText(CardPage.GETCARDINFOBYTEXT_TXT);
		assertEquals(popUpModalMessageByText, "Get Card Info by SMS Text", "Get Card Info by SMS Text is not present");

	}

	@SauronTest
	@Test(description = "TC90: Verify clicking on Email My Card Info button", groups = "All")
	public void testClickOnEmailMyCard() {

		loginPage.loginMethod(Config.getConfigProperty(ConfigConstants.EMAILID),
				Config.getConfigProperty(ConfigConstants.LOGINPASSWORDDDL));
		cardPage.waitAndClickOn(CardPage.YOURCARD_TAB);
		cardPage.waitAndClickOn(CardPage.EMAILMYCARD_BTN);
		String popUpModalMessageByEmail = cardPage.waitAndGetText(CardPage.GETCARDINFOBYEMAIL_TXT);
		assertEquals(popUpModalMessageByEmail, "Get Card Info by Email", "Get Card Info by Email text is not present");

	}

	@SauronTest
	@Test(description = "TC91: Verify clicking on 'Request a New Card' link", groups = "All")
	public void testClickOnRequestANewCard() {

		loginPage.loginMethod(Config.getConfigProperty(ConfigConstants.EMAILID),
				Config.getConfigProperty(ConfigConstants.LOGINPASSWORDDDL));
		cardPage.waitAndClickOn(CardPage.YOURCARD_TAB);
		cardPage.waitAndClickOn(CardPage.REQUESTANEW_LNK);
		String currentURL = Grid.driver().getCurrentUrl();
		assertEquals(currentURL, Config.getConfigProperty(ConfigConstants.SERVER_URL) + "card/new",
				"Redirected new card URL is not as expected" + currentURL);
		String textMessage = cardPage.waitAndGetText(CardPage.EXPECTTOSEE_MSG);
		assertEquals(textMessage,
				"We've received your request for a new card! Expect to see it within two weeks of your request!",
				"Message shown on card is improper");
		String colorCode = cardPage.getTextOfColorCode();
		String colorCodeHex = Color.fromString(colorCode).asHex();
		assertEquals(colorCodeHex, "#d9edf7", "Color code is not matching as expected" + colorCodeHex);

	}

	/**
	 * @throws Exception
	 * @Desc: Handling print dialogue popup: 1. seTimeout method evaluates
	 *        expression after specified delay. 2. Clicking on print card print
	 *        dialogue will open and driver loses control from current selenium
	 *        session, to handle we are executing settimeout method using
	 *        JavascriptExecutor so that driver will initiate printing process in
	 *        seperate thread and return to current selenium session
	 */
	@SauronTest
	@Test(description = "TC88: Verify clicking on 'Print Card' button", groups = "All")
	public void testClickOnPrintCard() throws Exception {
		loginPage.loginMethod(Config.getConfigProperty(ConfigConstants.EMAILID),
				Config.getConfigProperty(ConfigConstants.LOGINPASSWORDDDL));
		cardPage.waitAndClickOn(CardPage.YOURCARD_TAB);
		WebElement element = cardPage.waitUntilElementIsPresent(CardPage.PRINTCARD_BTN);
		((JavascriptExecutor) Grid.driver()).executeScript("setTimeout(function() { window.print(); }, 0);", element);
		WebUtil.sleep();
		String targetBrowser = AbstractGoodRxPage.getBrowser();
		if (targetBrowser.equalsIgnoreCase("chrome")) {
			String parentId = WebUtil.switchToNewTab();
			assertTrue(cardPage.waitAndCheckIsElementDisplayed(CardPage.PRINTCARD_PREVIEW),
					"Preview of the print card is not displayed");
			WebUtil.switchToParent(parentId);
		} else if (targetBrowser.equalsIgnoreCase("firefox") || targetBrowser.equalsIgnoreCase("iexplorer")) {
			assertTrue(WebUtil.verifyPrint("GoodRxCard"), "Unable to Print GoodRX Card");
		}
	}
}
