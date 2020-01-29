package com.lulu.qa.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.lulu.qa.AbstractGoldQaTest;
import com.lulu.qa.web.ConfigConstants;
import com.lulu.qa.web.DataConfigConstants;
import com.lulu.qa.web.pages.HamburgerPage;
import com.lulu.qa.web.utils.WebUtil;
import com.qapitol.sauron.annotations.SauronTest;
import com.qapitol.sauron.configuration.Config;
import com.qapitol.sauron.platform.grid.Grid;

public class TestAccount extends AbstractGoldQaTest {
	@SauronTest
	@Test(description = "TC41: Verify whether user is able to click on link https://gold.grxstaging.com/account", groups = "All")
	public void clickOnAccountURL() {
		Grid.driver().get(Config.getConfigProperty(ConfigConstants.SERVER_URL) + DataConfigConstants.ACCOUNT_URI);
		Assert.assertTrue(loginPage.isLogInHeaderPresent(), "LogIn Header is not present");
	}

	@SauronTest
	@Test(description = "TC46: Verify whether User is able to click on Membership link", groups = "All")
	public void clickOnMemberShip() {
		hamburgerPage.waitAndClickOn(HamburgerPage.HAMBURGER_ICN);
		hamburgerPage.waitAndClickOn(HamburgerPage.MEMBERSHIP_LNK);
		assertEquals(Grid.driver().getCurrentUrl(),
				Config.getConfigProperty(ConfigConstants.SERVER_URL) + "memberships");
	}

	@SauronTest
	@Test(description = "TC52: Verify wether user is able to click on account Page link", groups = "All")
	public void clickOnAccountPageLink() {
		loginPage.loginMethod(Config.getConfigProperty(ConfigConstants.lulu_USERNAME),
				Config.getConfigProperty(ConfigConstants.lulu_PASSWORD));
		hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		assertEquals(Grid.driver().getCurrentUrl(),
				Config.getConfigProperty(ConfigConstants.SERVER_URL) + DataConfigConstants.ACCOUNT_URI);
		Assert.assertTrue(accountPages.isAccountHeaderPresent(), "Account Header is not Present");
	}

	@SauronTest
	@Test(description = "TC72: Verify the alert success for using card type", groups = "All")
	public void checkTheColorOfWelcomeDevModeMsg() {
		loginPage.loginMethod(Config.getConfigProperty(ConfigConstants.lulu_USERNAME),
				Config.getConfigProperty(ConfigConstants.lulu_PASSWORD));
		hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		assertEquals(WebUtil.colorCodeReturnAsString(accountPages.getWelcomeToDevModeMsg()), "GREEN",
				"msg is not green in color");
	}

}