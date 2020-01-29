package com.lulu.qa.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.lulu.qa.AbstractGoldQaTest;
import com.lulu.qa.web.ConfigConstants;
import com.lulu.qa.web.pages.AbstractGoodRxPage;
import com.lulu.qa.web.pages.HamburgerPage;
import com.lulu.qa.web.pages.PrescriptionPage;
import com.qapitol.sauron.annotations.SauronTest;
import com.qapitol.sauron.configuration.Config;
import com.qapitol.sauron.platform.grid.Grid;

public class TestGetAPrescriptionLink extends AbstractGoldQaTest {

	@SauronTest
	@Test(description = "TC20: Verify clicking on Get a Prescription link", groups = { "All", "Android" })
	public void testClickOnPrescriptionLink() throws InterruptedException {
		hamburgerPage.waitAndClickOn(HamburgerPage.HAMBURGER_ICN);
		hamburgerPage.waitAndClickOn(HamburgerPage.GET_A_PRISCRIPTION);
		if (AbstractGoodRxPage.getTargetClient().equalsIgnoreCase("android")) {
			assertTrue(prescriptionPage.waitAndCheckIsElementDisplayed(PrescriptionPage.HEADER_TXT),
					"Prescription Page header text was not displayed");
			assertTrue(prescriptionPage.waitAndCheckIsElementDisplayed(PrescriptionPage.LOGO_TXT),
					"Lemonaid page was not displayed");
			Grid.driver().navigate().back();
		} else {
			String currentURLOfLink = Grid.driver().getCurrentUrl();
			assertEquals(currentURLOfLink,
					Config.getConfigProperty(ConfigConstants.SERVER_URL) + ConfigConstants.LEMONAID_URI,
					"The url is not as per" + currentURLOfLink);
			String textOfHeader = prescriptionPage.getText(PrescriptionPage.HEADER_TXT);
			assertEquals(textOfHeader.contains("Get a Doctor's Prescription for Just $10"), true,
					"Get a Doctor's Prescription for Just $10 header is not present");
			assertTrue(prescriptionPage.waitAndCheckIsElementDisplayed(PrescriptionPage.LOGO_TXT),
					"Lemonaid logo text is not displayed");
		}
	}

}