package com.lulu.qa.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import org.testng.annotations.Test;
import com.lulu.qa.AbstractGoldQaTest;
import com.lulu.qa.web.ConfigConstants;
import com.lulu.qa.web.pages.AbstractGoodRxPage;
import com.lulu.qa.web.pages.SupportPage;
import com.qapitol.sauron.annotations.SauronTest;
import com.qapitol.sauron.configuration.Config;
import com.qapitol.sauron.platform.grid.Grid;

public class TestSupport extends AbstractGoldQaTest {

	@SauronTest
	@Test(description = "TC21: Verify clicking on Help Icon, user should be able to redirect to the support page", groups = {
			"All", "Android" })
	public void ClickOnHelpIcon() throws InterruptedException {
		supportPage.waitAndClickOn(SupportPage.HELP_ICN);
		if (AbstractGoodRxPage.getTargetClient().equalsIgnoreCase("android")) {
			assertTrue(supportPage.waitAndCheckIsElementDisplayed(SupportPage.SUPPORT_TXT),
					"Support Page was not displayed");
			Grid.driver().navigate().back();
		} else {
			String parentWindow = Grid.driver().getWindowHandle();
			ArrayList<String> windows = new ArrayList<String>(Grid.driver().getWindowHandles());
			windows.remove(parentWindow);
			String supportWindow = windows.get(0);
			Grid.driver().switchTo().window(supportWindow);
			assertTrue(supportPage.supportTextPresent());
			String currentURLOfSupport = Grid.driver().getCurrentUrl();
			assertEquals(currentURLOfSupport, Config.getConfigProperty(ConfigConstants.SUPPORTURL),
					"Redirected Support URL is not as expected :: " + currentURLOfSupport);
			Grid.driver().close();
			Grid.driver().switchTo().window(parentWindow);
		}
	}
}