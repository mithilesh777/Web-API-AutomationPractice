package com.lulu.qa.web.pages;

import java.util.ArrayList;
import com.lulu.qa.web.utils.WebUtil;
import com.qapitol.sauron.platform.grid.Grid;
import io.qameta.allure.Step;

public class HamburgerPage extends AbstractGoodRxPage {

	public static final String HAMBURGER_ICN = "hamburgericon";
	public static final String DENTALPLAN_LNK = "dentalplanlink";
	public static final String HEARTLAND_LNK = "heartlandlink";
	public static final String TOTALDIABETESSUPPLY_LNK = "totaldiabetessupplylink";
	public static final String PERSONALLABS_LNK = "personallabslink";
	public static final String ADDITIONALBENEFITS_LNK = "additionalbenefitslink";
	public static final String GOODRX_TXT = "goodrxtext";
	public static final String GOODGOLD_TXT = "goodgoldtxt";
	public static final String DENTALPLANS_TXT = "dentalplanstxt";
	public static final String HEARTLAND_TXT = "heartlandtxt";
	public static final String PERSONALLABSGOODRX_TXT = "personallabsgoodrxtxt";
	public static final String GOODRXINFO_TXT = "goodrxinfotxt";
	public static final String MEMBERSHIP_LNK = "membershiplink";
	public static final String ACCOUNT_LINK = "accountlink";
	public static final String SIGNOUT_BTN = "signoutbtn";
	public static final String DRUG_LOOKUP_HAM_LNK = "druglookupfromhamburgerlink";
	public static final String FIND_A_PHARMACY = "findapharmacy";
	public static final String GET_A_PRISCRIPTION = "getapriscription";
	public static final String MEMBERSHIP_HDR = "membershiphdr";
	public static final String HELP_LINK_HAMBERGUR = "helpLinkfromhamburgerlink";
	public static final String GOODRX_GOLD_LNK_HAMBURGER = "goldRxGoldHamburgerlink";
	public static final String TOTALDIABETESLOGO = "totalDiabeteslogo";
	public static final String LOGIN_BTN_HAMBURGER = "loginBtnHamburgerPage";

	/**
	 * @Desc: Click on hamburger icon
	 **/
	@Step("Click on the hamburger icon")
	public void clickOnHamburgerIcon() {
		waitAndClickOn(HAMBURGER_ICN);
	}

	/**
	 * @Desc: verify Total Diabetes Logo
	 **/
	@Step("verify Total Diabetes Logo")
	public boolean verifyTotalDiabetesLogo() {
		return waitAndCheckIsElementDisplayed(TOTALDIABETESLOGO);
	}

	/**
	 * @Desc: Click on hamburger icon and Click Account
	 **/

	/**
	 * @Desc: Click on Find A Pharmacy Icon
	 **/
	@Step("Click on the Find A Pharmacy Icon")
	public void clickOnFindAPharmacy() {
		waitAndClickOn(FIND_A_PHARMACY);
	}

	/**
	 * @Desc: Click on Get A Priscrition Icon
	 **/
	@Step("Click on the Get A Priscrition Icon")
	public void clickOnGetAPriscrition() {
		waitAndClickOn(GET_A_PRISCRIPTION);
	}

	/**
	 * @Desc: get Goodrx text
	 **/
	@Step("get Goodrx text")
	public String getGoodrxtext() {
		return waitAndGetText(GOODRX_TXT);
	}

	/**
	 * @Desc: Click on 'Additional Benefits' icon
	 **/
	@Step("Click on the Additional Benefits Icon")
	public void clickOnAdditionalBenefits() {
		waitAndClickOn(ADDITIONALBENEFITS_LNK);
	}

	/**
	 * @Desc: Click on Additional Benefits Link
	 **/
	@Step("Click on the Additional Benefits Icon")
	public void clickOnDrugLookUp() {
		waitAndClickOn(DRUG_LOOKUP_HAM_LNK);
	}

	/**
	 * @Desc: Capture message of 'More GoodRx Gold'
	 * 
	 * @Return: String
	 **/
	@Step("Get the text of 'More GoodRx Gold'")
	public String getTextOfGoodRxMore() {
		return waitAndGetText(GOODGOLD_TXT);
	}

	/**
	 * @Desc: Capture message of 'GoodRx for Personal Labs'
	 * 
	 * @Return: String
	 **/
	@Step("Get the text of GoodRx for Personal Labs")
	public String getTextOfGoodRxPL() {
		return waitAndGetText(PERSONALLABSGOODRX_TXT);
	}

	/**
	 * @Desc:Capture message of 'GoodRx Gold'
	 * 
	 * @Return: String
	 **/
	@Step("Get the text of ' GoodRx Gold'")
	public String getTextOfGoodRxText() {
		return waitAndGetText(GOODRXINFO_TXT);
	}

	/**
	 * @Desc: Capture message of 'GoodRx Dental'
	 * 
	 * @Return: String
	 **/
	@Step("Get the text of  GoodRx Gold of Dental Page")
	public String getTextOfGoodRxDental() {
		return waitAndGetText(DENTALPLANS_TXT);
	}

	/**
	 * @Desc: Click on HeartLand Supply
	 **/
	@Step("Get the text of HeartLand Supply")
	public boolean getTextOfGoodRxHeartLandSupply() {
		return waitAndCheckIsElementDisplayed(HEARTLAND_TXT);
	}

	/**
	 * @Desc: Click on 'Membership' link
	 **/
	@Step("Click on Membership Link")
	public void clickOnMemberShipsLink() {
		waitAndClickOn(MEMBERSHIP_LNK);
	}

	/**
	 * @Desc: Click on 'Account' link
	 **/
	@Step("Click on Account Link")
	public void clickOnAccountLink() {
		waitAndClickOn(ACCOUNT_LINK);
	}

	/**
	 * @Desc: Click on 'Hamburger & then Additional Benfits'
	 */
	@Step("Click on Hamburger & click on Additional benfits")
	public void clickHamAndAdditionalBenifits() {
		WebUtil.sleep();
		waitAndClickOn(HAMBURGER_ICN);
		waitAndClickOn(ADDITIONALBENEFITS_LNK);
	}

	

	/**
	 * @Desc: Click on Sign out button
	 * 
	 */
	@Step("Click on Signout button")
	public void clickOnSignOut() {
		if (isElementPresent(HAMBURGER_ICN)) {
			waitAndClickOn(HAMBURGER_ICN);
		}
		if (isElementPresent(SIGNOUT_BTN)) {
			locateElement(SIGNOUT_BTN).click();
		}
		waitAndClickOn(HAMBURGER_ICN);
	}

	/**
	 * @Desc: Click on External Link
	 * 
	 */
	@Step("Click on External Link")
	public String clickOnExternalLink(String text, String element) {
		clickHamAndAdditionalBenifits();
		waitUntilElementIsPresent(element);
		WebUtil.scrollAndClickLink(text, locateElement(element));
		String parentWindow = Grid.driver().getWindowHandle();
		ArrayList<String> windows = new ArrayList<String>(Grid.driver().getWindowHandles());
		windows.remove(parentWindow);
		String heartlandLink = windows.get(0);
		Grid.driver().switchTo().window(heartlandLink);
		return parentWindow;
	}

	public void closeAndSwitchToParentWindow(String parentWindow) {
		Grid.driver().close();
		Grid.driver().switchTo().window(parentWindow);
	}

	/**
	 * @Desc: Click on hamburger icon and Click Account
	 **/
	@Step("Method to Click on the hamburger icon and Click on Account")
	public void clickOnHamburgerIconAndClickOnAccount() {
		waitAndClickOn(HAMBURGER_ICN);
		WebUtil.longSleepForOnboarding();
		waitAndClickOn(ACCOUNT_LINK);
		WebUtil.longSleepForOnboarding();

	}

	/**
	 * @Desc: Click on Help Link Hambergur Menu
	 **/
	@Step("Click on Help Link Hambergur Menu")
	public void clickOnHelpHambergur() {
		waitAndClickOn(HELP_LINK_HAMBERGUR);
	}

	/**
	 * @Desc: Click on 'Good RX Gold' Link Hambergur Menu
	 **/
	@Step("Click on 'Good RX Gold' Link Hambergur Menu")
	public void clickOnGoodRxGoldLink() {
		waitAndClickOn(GOODRX_GOLD_LNK_HAMBURGER);
	}

	/**
	 * @Desc: Click on 'Login Btn' in Hambergur Menu
	 **/
	@Step("Click on 'Login Btn' in Hambergur Menu")
	public void clickOnLoginHamburgerPage() {
		waitAndClickOn(HAMBURGER_ICN);
		waitAndClickOn(LOGIN_BTN_HAMBURGER);
	}

}
