package com.lulu.qa.web.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Set;

import com.lulu.qa.web.DataConfigConstants;
import com.lulu.qa.web.utils.WebUtil;

import com.qapitol.sauron.appium.platform.grid.SauronAppiumAndroidDriver;
import com.qapitol.sauron.platform.grid.Grid;
import io.qameta.allure.Step;

public class FooterPage extends AbstractGoodRxPage {
	public static final String FAQ_LNK = "faqlnk";
	public static final String PRIVACYPOLICY_LNK = "privacypolicylnk";
	public static final String TERMSOFSERVICE_LNK = "termsofservicelnk";
	public static final String BONUSOFFER_TXT = "bonusoffertxt";
	public static final String PRIVACYPOLICY_HDR = "privacypolicyhdr";
	public static final String TERMSOFSERVICE_HDR = "termsofservicehdr";
	public static final String BENEFITS_HDR = "Benefitshdr";
	public static final String EFFECTIVEDATE = "effectivedate";
	public static final String BONUSOFFER_HDR = "bonusofferhdr";
	public static final String DISCLAIMER_LNK = "disclaimertxt";
	public static final String DISCLAIMER_HDR = "disclaimerHeader";
	public static final String FOOTER_HELPLINE_NUMBER = "helpLineNumberFooterPage";
	public static final String GOODRX_TXT = "goodrxtxt";
	public static final String HELPLINE_NUMBER_APP = "phoneNumberApp";
	public static final String FOOTER_HELPLINE_NUMBER_VIEW = "helpLineNumberFooterPageAppView";
	public static final String PREFERENCE = "preference";

	

	/**
	 * @Desc: Click on 'Privacy policy' text
	 */
	@Step("click on privacy policy")
	public void clickOnPrivacyPolicy() throws Exception {
		WebUtil.scrollToElementUsingVisibleXpathText(DataConfigConstants.FAQ_TEXT);
		waitAndClickOn(PRIVACYPOLICY_LNK);
	}

	/**
	 * @throws Exception
	 * @Desc: Click on 'Footer Helpline'
	 */
	@Step("click on Footer Helpline Number")
	public String clickOnFooterHelpLine() throws Exception {
		// FOOTER_HELPLINE_NUMBER_VIEW
		((SauronAppiumAndroidDriver) Grid.driver()).context("NATIVE_APP");
		WebUtil.scrollToElementUsingVisibleXpathText(FOOTER_HELPLINE_NUMBER_VIEW);
		String helpLineNumber = waitAndGetText(FOOTER_HELPLINE_NUMBER_VIEW);
		waitAndClickOn(FOOTER_HELPLINE_NUMBER_VIEW);
		return helpLineNumber;
	}

	/**
	 * @throws Exception
	 * @Desc: Click on 'Terms of Service' hyperlink text
	 */
	@Step("Click on 'Terms of service'")
	public void clickOnTermsOfService() throws Exception {
		WebUtil.scrollToElementUsingVisibleXpathText(DataConfigConstants.FAQ_TEXT);
		waitAndClickOn(TERMSOFSERVICE_LNK);
	}

	/**
	 * @throws Exception
	 * @Desc: Click on 'Bonus offers for GoodRx Gold Members' hyperlink text
	 */
	@Step("Click on 'Bonus offers for GoodRx Gold members'")
	public void clickOnBonusOffersForGoldMembers() throws Exception {
		WebUtil.scrollToElementUsingVisibleXpathText(DataConfigConstants.FAQ_TEXT);
		waitAndClickOn(BONUSOFFER_TXT);
	}

	/**
	 * @throws Exception
	 * @Desc: Scroll till 'Frequently Asked Questions'
	 */
	@Step("Scroll to 'Frequently Asked Questions link'")
	public void scrolltoFAQ() throws Exception {
		WebUtil.verticalSwipe(getLocator(FAQ_LNK), 40);
	}

	/**
	 * @throws Exception
	 * @Desc: Scroll to 'Bonus offers for GoodRx Gold Members' hyperlink text
	 */
	@Step("Scroll to 'Bonus offers' hyperlink text")
	public void scrolltoBonusOffers() throws Exception {
		waitUntilElementIsPresent(BONUSOFFER_TXT);
		WebUtil.verticalSwipe(getLocator(BONUSOFFER_TXT), 40);
	}

	/**
	 * @throws Exception
	 * @Desc: Click on 'FAQ' hyperlink text
	 */
	@Step("Click on 'FAQ'")
	public void clickFAQ() throws Exception {
		waitAndClickOn(FAQ_LNK);
	}

	/**
	 * @throws Exception
	 * @Desc: Scroll to 'Terms of Service link
	 */
	@Step("Scroll to 'Terms of Service link'")
	public void scrolltoTermsOfServicesLink() throws Exception {
		WebUtil.verticalSwipe(getLocator(TERMSOFSERVICE_LNK), 40);
	}

	/**
	 * @throws Exception
	 * @Desc: Click on Terms of Service Link
	 */
	@Step("Click on 'Terms of Service Link")
	public void clickonTermsOfServicesLink() throws Exception {
		waitAndClickOn(TERMSOFSERVICE_LNK);
	}

	/**
	 * @throws Exception
	 * @Desc: Get Terms of Service Header Text
	 */
	@Step("Get Terms of Service Header Text")
	public String getTermsOfServicesHeaderText() throws Exception {
		return waitAndGetText(TERMSOFSERVICE_HDR);
	}

	/**
	 * @throws Exception
	 * @Desc: Scroll to 'Privacy Policy link'
	 */
	@Step("Scroll to 'Privacy Policy Link'")
	public void scrolltoPrivacyPolicyLink() throws Exception {
		WebUtil.verticalSwipe(getLocator(PRIVACYPOLICY_LNK), 40);
	}

	/**
	 * @throws Exception
	 * @Desc: Click on Privacy Policy Link (PPL)
	 */
	@Step("Click on 'PPL'")
	public void clickonPPL() throws Exception {
		waitAndClickOn(PRIVACYPOLICY_LNK);
	}

	/**
	 * @throws Exception
	 * @Desc: Get Privacy Policy Header Text
	 */
	@Step("Get Privacy Policy Header Text")
	public String getPPLHeaderText() throws Exception {
		return waitAndGetText(PRIVACYPOLICY_HDR);
	}

	/**
	 * @throws Exception
	 * @Desc: Scroll to Disclaimer link
	 */
	@Step("Scroll to 'Disclaimer Link' Text")
	public void scrolltoDisclaimer() throws Exception {
		WebUtil.verticalSwipe(getLocator(DISCLAIMER_LNK), 40);
	}

	/**
	 * @throws Exception
	 * @Desc: Click on Disclaimer Link Text
	 */
	@Step("Click on 'Disclaimer' hyper Text Link")
	public void clickonDisclaimer() throws Exception {
		waitAndClickOn(DISCLAIMER_LNK);
	}

	/**
	 * @throws Exception
	 * @Desc: Get Disclaimer header Text
	 */
	@Step("Get 'Disclaimer' Header Text")
	public String getdisclaimerText() throws Exception {
		return waitAndGetText(DISCLAIMER_HDR);
	}

	/**
	 * @Desc:Verify the Helpline Number
	 */
	@Step("Verify the  Helpline Number")
	public void verifyHelpLineNumber() {
		if (isMobilePage()) {
			try {
				clickOnFooterHelpLine();
			} catch (Exception e) {
			}
			try {
				locateElement(PREFERENCE).click();
			} catch (Exception e) {
			}
			((SauronAppiumAndroidDriver) Grid.driver()).context("NATIVE_APP");
			assertTrue(locateElement(HELPLINE_NUMBER_APP).isDisplayed(), "Unable to navigate to Phone App");
			Grid.driver().navigate().back();
			Grid.driver().navigate().back();
			Grid.driver().navigate().back();
			Set<String> contexts = ((SauronAppiumAndroidDriver) Grid.driver()).getContextHandles();
			for (String context : contexts) {
				if (!context.equals("NATIVE_APP")) {
					((SauronAppiumAndroidDriver) Grid.driver()).context(context);
					break;
				}
			}
		} else {
			assertEquals(locateElement(FOOTER_HELPLINE_NUMBER).getText(), "1-855-487-0694");
		}
	}

}
