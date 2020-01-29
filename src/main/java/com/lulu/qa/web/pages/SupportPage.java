package com.lulu.qa.web.pages;

import io.qameta.allure.Step;

public class SupportPage extends AbstractGoodRxPage {

	public static final String HELP_ICN = "helpicon";
	public static final String SUPPORT_TXT = "support";

	/**
	 * @Desc: Clicking on help icon
	 */
	@Step("Click on the Help Icon")
	public void clickOnSupportIcon() {
		waitAndClickOn(HELP_ICN);
	}

	/**
	 * @Desc: Check whether the Suppot button is displayed or not
	 */
	@Step("Check whether the Suppot button is displayed or not")
	public boolean supportTextPresent() {
		return waitAndCheckIsElementDisplayed(SUPPORT_TXT);
	}

	
	/**
	 * @Desc: Get Support Link Text
	 */
	@Step("Get Support Link Text")
	public String supportLinkText() throws Exception {
		return getText(SUPPORT_TXT);
	}

}
