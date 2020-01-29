package com.lulu.qa.web.pages;

import com.lulu.qa.web.utils.WebUtil;
import io.qameta.allure.Step;

public class AccountPage extends AbstractGoodRxPage {

	public static final String ACCOUNT_HEADER = "accounthdr";
	public static final String WELCOME_DEVMODE_MSG = "welcomedevmodemsg";
	public static final String UPGRADE_MEMBERSHIP_BUTTON = "upgrademembershipbutton";
	public static final String UPGRADE_TO_FAMILY_MEMBERSHIP_PAGE_HDR = "upgradetofamilymembershippagegeader";
	public static final String YESUPGRADENOWBTN = "yesupgradenowbtn";
	public static final String SUCCESS_MSG_OF_UPGRADE_FAMILY_MEMBERSHIP = "successmsgofupgradefamilymembership";
	public static final String DOWNGRADE_MEMBERSHIP_BUTTON = "downgrademembershipbutton";
	public static final String DOWNGRADE_MEMBERSHIP_HDR = "downgrademembershiphdr";
	public static final String YESDOWNGRADE_NOW_BUTTON = "yesdowngradenowbtn";
	public static final String IAGREETOTERMS_BEFOREDOWNGRADING_ERRORMSG = "iagreetotermsbeforedowngradingerrormsg";
	public static final String DOWNGRADE_CHECKBOX = "downgradecheckbox";
	public static final String DOWNGRADE_PLAN_SUCCESS_MSG = "successmsgofdowngrademembership";
	public static final String CANCELDOWNGRADE_BUTTON = "canceldowngradebtn";
	public static final String PAUSEACCOUNT_BUTTON = "pauseaccountbtn";
	public static final String CANCELUPGRADE_BUTTON = "cancelupgradebtn";

	/**
	 * @Desc: Checking whether 'Account Header' is displayed
	 * @Return: boolean
	 */
	@Step("Assert the account header")
	public boolean isAccountHeaderPresent() {
		WebUtil.sleep();
		return waitAndCheckIsElementDisplayed(ACCOUNT_HEADER);
	}

	/**
	 * @Desc: Fetching the welcome to dev mode message and ger rgba string
	 * @return String
	 */
	@Step("get the welcome to dev mode message")
	public String getWelcomeToDevModeMsg() {
		WebUtil.scrollToElementUsingVisibleXpathText("Update Credit Card");
		waitUntilElementIsPresent(WELCOME_DEVMODE_MSG);
		return locateElement(WELCOME_DEVMODE_MSG).getCssValue("color");

	}

}
