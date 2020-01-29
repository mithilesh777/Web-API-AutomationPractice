package com.lulu.qa.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.testng.annotations.Test;

import com.lulu.qa.AbstractGoldQaTest;
import com.lulu.qa.web.DataConfigConstants;
import com.lulu.qa.web.pages.AccountPage;
import com.lulu.qa.web.pages.SignupPage;
import com.lulu.qa.web.utils.WebUtil;
import com.qapitol.sauron.annotations.SauronTest;

public class TestSignUpForm extends AbstractGoldQaTest {

	@SauronTest
	@Test(description = "TC:24 -> Verify Page Navigating to Choose Membership Page", groups = { "All" })
	public void testChooseMembershipHighlighted() {
		signupPage.waitAndClickOn(SignupPage.STARTFREE_BTN);
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.checkChooseMembershipPageHighlighted(emailId, password);
	}

	@SauronTest
	@Test(description = "TC:25 -> User should be able to select Any plan(Individual/Family)", groups = { "All" })
	public void testSelectAnyMembershipPlans() {
		signupPage.waitAndClickOn(SignupPage.STARTFREE_BTN);
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.checkChooseMembershipPageHighlighted(emailId, password);
		signupPage.validatingDefaultRadioTextAsIndividual();
		signupPage.changeChooseMembershipPageHighlighted();
	}

	@SauronTest
	@Test(description = "TC:26 -> User should be able xto tap on Continue Button For UI-Variant(SignUp)", groups = {
			"All" })
	public void testTapOnContinueButton() {
		signupPage.waitAndClickOn(SignupPage.STARTFREE_BTN);
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.checkChooseMembershipPageHighlighted(emailId, password);
		signupPage.validatingDefaultRadioTextAsIndividual();
		signupPage.clickOnContinue();
	}

	@SauronTest

	@Test(description = "TC:33 -> Verify by Clicking back button", groups = { "All" })
	public void testClickonbackButton() {
		signupPage.waitAndClickOn(SignupPage.STARTFREE_BTN);
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.checkChooseMembershipPageHighlighted(emailId, password);
		signupPage.clickOnBackButton();
	}

	@SauronTest
	@Test(description = "TC:28 -> Without enterring First name and Last name Validating Toast Message (Please fill out this Field.) ", priority = 58, groups = {
			"All" })
	public void testEnterNoTextInFirstNameLastName() {
		signupPage.waitAndClickOn(SignupPage.STARTFREE_BTN);
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.checkChooseMembershipPageHighlighted(emailId, password);
		signupPage.signUpFormGoodRxEnterNoTextFirstNameLastName();
	}

	@SauronTest
	@Test(description = "TC:31 -> Verify by selecting Future Date of Birth", groups = { "All" })
	public void testDropDownAgeFuture() {
		signupPage.waitAndClickOn(SignupPage.STARTFREE_BTN);
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.checkChooseMembershipPageHighlighted(emailId, password);
		signupPage.selectDropDownEnterNameFields(DataConfigConstants.DROPDOWNRANGESTARTSFUTURE,
				DataConfigConstants.DROPDOWNRANGEENDSFUTURE, WebUtil.getFutureYear(0, "yyyy"));
	}

	@SauronTest
	@Test(description = "TC:30 -> Verify by selecting Lessthan 18 Years Date of Birth", groups = { "All" })
	public void testDropDown18MinusAge() {
		signupPage.waitAndClickOn(SignupPage.STARTFREE_BTN);
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.checkChooseMembershipPageHighlighted(emailId, password);
		signupPage.selectDropDownEnterNameFields(DataConfigConstants.DROPDOWNRANGESTARTSMINOR,
				DataConfigConstants.DROPDOWNRANGEENDSMINOR, WebUtil.getPreviousYear(3, "yyyy"));
	}

	@SauronTest
	@Test(description = "TC:29 -> Verify by selecting More than 18 Years Date of Birth", groups = { "All" })
	public void testEnterValidFirstNameLastName() {
		signupPage.waitAndClickOn(SignupPage.STARTFREE_BTN);
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.checkChooseMembershipPageHighlighted(emailId, password);
		signupPage.selectDropDownEnterNameFields(DataConfigConstants.DROPDOWNRANGESTARTS,
				DataConfigConstants.DROPDOWNRANGEENDS, WebUtil.getPreviousYear(20, "yyyy"));
	}

	@SauronTest
	@Test(description = "TC:32 -> Verify Continue Next Step Button is Clickable", groups = { "All" })
	public void testContinueNextStepClickable() {
		signupPage.waitAndClickOn(SignupPage.STARTFREE_BTN);
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.checkChooseMembershipPageHighlighted(emailId, password);
		signupPage.continueNextStepClickabe(DataConfigConstants.DROPDOWNRANGESTARTS,
				DataConfigConstants.DROPDOWNRANGEENDS, WebUtil.getPreviousYear(20, "yyyy"));
		String[] expectedErrorMsg = { "Finish", "Create Account" };
		List<String> errorMsgList = Arrays.asList(expectedErrorMsg);
		assertTrue(errorMsgList.contains(signupPage.getTextOnFinishButton()), signupPage.getTextOnFinishButton());
	}

	@SauronTest
	@Test(description = "TC:35 -> Verify whether user is able to insert invalid Card number", groups = { "All" })
	public void testInvalidCardDetails() {
		signupPage.waitAndClickOn(SignupPage.STARTFREE_BTN);
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.checkChooseMembershipPageHighlighted(emailId, password);
		signupPage.selectDropDownEnterNameFields(DataConfigConstants.DROPDOWNRANGESTARTS,
				DataConfigConstants.DROPDOWNRANGEENDS, WebUtil.getPreviousYear(20, "yyyy"));
		signupPage.enterCardDetails(WebUtil.getSixteenDigitRandomNumber(), WebUtil.getExpiryMonthFutureYear(),
				Integer.toString(WebUtil.getRangeNumber(Integer.parseInt(DataConfigConstants.CVCMINLRANGESTARTS),
						Integer.parseInt(DataConfigConstants.CVCMAXLRANGEEND))));
		assertEquals(signupPage.waitAndGetText(SignupPage.CARDNUMBERWARNING_TXT), "Your card number is invalid.",
				"Invalid Warning Message is not as Expected :"
						+ signupPage.waitAndGetText(SignupPage.CARDNUMBERWARNING_TXT));
		assertEquals(WebUtil.colorCodeReturnAsString(signupPage.getTextColorCardNumber()), "RED",
				"Text Color is not RED :" + WebUtil.colorCodeReturnAsString(signupPage.getTextColorCardNumber()));

	}

	@SauronTest
	@Test(description = "TC:36 -> Verify when user enters past date as Exp Date", groups = { "All" })
	public void testPastDateToCardExpiry() {
		signupPage.waitAndClickOn(SignupPage.STARTFREE_BTN);
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.checkChooseMembershipPageHighlighted(emailId, password);
		signupPage.selectDropDownEnterNameFields(DataConfigConstants.DROPDOWNRANGESTARTS,
				DataConfigConstants.DROPDOWNRANGEENDS, WebUtil.getPreviousYear(20, "yyyy"));
		signupPage.enterCardDetails(DataConfigConstants.VALIDCARDNUBER, WebUtil.getExpiryMonthPastYear(),
				Integer.toString(WebUtil.getRangeNumber(Integer.parseInt(DataConfigConstants.CVCMINLRANGESTARTS),
						Integer.parseInt(DataConfigConstants.CVCMAXLRANGEEND))));
		assertEquals(signupPage.waitAndGetText(SignupPage.CARDEXPIRYWARNING_TXT),
				"Your card's expiration year is in the past.", "Invalid Warning Message is not as Expected :"
						+ signupPage.waitAndGetText(SignupPage.CARDEXPIRYWARNING_TXT));
		assertEquals(WebUtil.colorCodeReturnAsString(signupPage.getTextColorCardExpiry()), "RED",
				"Text Color is not RED :" + WebUtil.colorCodeReturnAsString(signupPage.getTextColorCardExpiry()));
	}

	@SauronTest
	@Test(description = "TC:37 -> Verify when user enters less than 3 digits as CVC", groups = { "All" })
	public void testEnterLessthanThreeDigitsToCvc() {
		signupPage.waitAndClickOn(SignupPage.STARTFREE_BTN);
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.checkChooseMembershipPageHighlighted(emailId, password);
		signupPage.selectDropDownEnterNameFields(DataConfigConstants.DROPDOWNRANGESTARTS,
				DataConfigConstants.DROPDOWNRANGEENDS, WebUtil.getPreviousYear(20, "yyyy"));
		signupPage.enterCardDetails(DataConfigConstants.VALIDCARDNUBER, WebUtil.getExpiryMonthFutureYear(),
				Integer.toString(WebUtil.getRangeNumber(11, 99)));
		assertEquals(signupPage.waitAndGetText(SignupPage.CARDCVCWARNING_TXT),
				"Your card's security code is incomplete.", "Invalid Warning Message is not as Expected :"
						+ signupPage.waitAndGetText(SignupPage.CARDCVCWARNING_TXT));
		assertEquals(WebUtil.colorCodeReturnAsString(signupPage.getTextColorCVC()), "RED",
				"Text Color is not RED :" + WebUtil.colorCodeReturnAsString(signupPage.getTextColorCVC()));
	}

	@SauronTest
	@Test(description = "TC:34 -> Verify when user enters Valid Card Number", groups = { "All" })
	public void testValidCardNumberWithTextColorBlack() {
		signupPage.waitAndClickOn(SignupPage.STARTFREE_BTN);
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.checkChooseMembershipPageHighlighted(emailId, password);
		signupPage.selectDropDownEnterNameFields(DataConfigConstants.DROPDOWNRANGESTARTS,
				DataConfigConstants.DROPDOWNRANGEENDS, WebUtil.getPreviousYear(20, "yyyy"));
		signupPage.enterCardDetails(DataConfigConstants.VALIDCARDNUBER, WebUtil.getExpiryMonthFutureYear(),
				Integer.toString(WebUtil.getRangeNumber(11, 99)));
		assertEquals(WebUtil.colorCodeReturnAsString(signupPage.getTextColorCardNumber()), "BLACK",
				"Text Color is not BLACK :" + WebUtil.colorCodeReturnAsString(signupPage.getTextColorCardNumber()));
	}

	@SauronTest
	@Test(description = "TC:38 -> Verify CVC info icon", groups = { "All" })
	public void testClickOnCvcInfoIcon() {
		signupPage.waitAndClickOn(SignupPage.STARTFREE_BTN);
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.checkChooseMembershipPageHighlighted(emailId, password);
		signupPage.selectDropDownEnterNameFields(DataConfigConstants.DROPDOWNRANGESTARTS,
				DataConfigConstants.DROPDOWNRANGEENDS, WebUtil.getPreviousYear(20, "yyyy"));
		signupPage.enterCardDetails(DataConfigConstants.VALIDCARDNUBER, WebUtil.getExpiryMonthFutureYear(),
				Integer.toString(WebUtil.getRangeNumber(Integer.parseInt(DataConfigConstants.CVCMINLRANGESTARTS),
						Integer.parseInt(DataConfigConstants.CVCMAXLRANGEEND))));
		signupPage.waitAndClickOn(SignupPage.CARDCVC_ICN);
		assertEquals(signupPage.waitAndGetText(SignupPage.CARDCVCINFO_TXT),
				"3-digit security code usually found on the back of your card. "
						+ "American Express cards have a 4-digit code located on the front.",
				"Invalid Warning Message is not as Expected :" + signupPage.waitAndGetText(SignupPage.CARDCVCINFO_TXT));

	}

	@SauronTest
	@Test(description = "TC:39 -> Verify Click on Finish with Blank Values", groups = { "All" })
	public void testClickOnFinshWithBlankValues() {
		signupPage.waitAndClickOn(SignupPage.STARTFREE_BTN);
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.checkChooseMembershipPageHighlighted(emailId, password);
		signupPage.selectDropDownEnterNameFields(DataConfigConstants.DROPDOWNRANGESTARTS,
				DataConfigConstants.DROPDOWNRANGEENDS, WebUtil.getPreviousYear(20, "yyyy"));
		signupPage.enterCardDetails("", "", "");
		assertEquals(signupPage.waitAndGetText(SignupPage.CARDNUMBERBLANK_TXT), "Your card number is incomplete.",
				"Card incomplete Warning Message is not as Expected :"
						+ signupPage.waitAndGetText(SignupPage.CARDNUMBERBLANK_TXT));
		assertEquals(WebUtil.colorCodeReturnAsString(signupPage.getTextColorCardNumber()), "RED",
				"Text Color is not RED :" + WebUtil.colorCodeReturnAsString(signupPage.getTextColorCardNumber()));
	}

	@SauronTest
	@Test(description = "TC:40 -> Verify whether user is able to click on Finish", groups = { "All" })
	public void testClickOnFinishButton() {
		signupPage.waitAndClickOn(SignupPage.STARTFREE_BTN);
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.checkChooseMembershipPageHighlighted(emailId, password);
		signupPage.selectDropDownEnterNameFields(DataConfigConstants.DROPDOWNRANGESTARTS,
				DataConfigConstants.DROPDOWNRANGEENDS, WebUtil.getPreviousYear(20, "yyyy"));
		signupPage.enterCardDetails(DataConfigConstants.VALIDCARDNUBER, WebUtil.getExpiryMonthFutureYear(),
				Integer.toString(WebUtil.getRangeNumber(Integer.parseInt(DataConfigConstants.CVCMINLRANGESTARTS),
						Integer.parseInt(DataConfigConstants.CVCMAXLRANGEEND))));
		WebUtil.sleep();
		assertEquals(signupPage.waitAndGetText(SignupPage.IDONOTAGREE_BTN).trim(), "I do not agree",
				"Card incomplete Warning Message is not as Expected :"
						+ signupPage.waitAndGetText(SignupPage.IDONOTAGREE_BTN).trim());
		signupPage.clickOnIDonotAgreeButton();
	}

	@SauronTest
	@Test(description = "TC:42 -> Verify after filling all required card details user should be able "
			+ "to view alert screen lulu Gold Terms & Conditions with i agree and I do not agree button", groups = {
					"All" })
	public void testNotificationPopUp() {
		signupPage.waitAndClickOn(SignupPage.STARTFREE_BTN);
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.checkChooseMembershipPageHighlighted(emailId, password);
		signupPage.selectDropDownEnterNameFields(DataConfigConstants.DROPDOWNRANGESTARTS,
				DataConfigConstants.DROPDOWNRANGEENDS, WebUtil.getPreviousYear(20, "yyyy"));
		signupPage.enterCardDetails(DataConfigConstants.VALIDCARDNUBER, WebUtil.getExpiryMonthFutureYear(),
				Integer.toString(WebUtil.getRangeNumber(Integer.parseInt(DataConfigConstants.CVCMINLRANGESTARTS),
						Integer.parseInt(DataConfigConstants.CVCMAXLRANGEEND))));
		WebUtil.sleep();
		assertEquals(signupPage.waitAndGetText(SignupPage.IDONOTAGREE_BTN).trim(), "I do not agree",
				"Card incomplete Warning Message is not as Expected :"
						+ signupPage.waitAndGetText(SignupPage.IDONOTAGREE_BTN).trim());
		signupPage.clickOnIDonotAgreeButton();
	}

	@SauronTest
	@Test(description = "TC:44 -> Verify after clicking on i Don't agree button", groups = { "All" })
	public void testIDonotAgreePopUp() {
		signupPage.waitAndClickOn(SignupPage.STARTFREE_BTN);
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.checkChooseMembershipPageHighlighted(emailId, password);
		signupPage.selectDropDownEnterNameFields(DataConfigConstants.DROPDOWNRANGESTARTS,
				DataConfigConstants.DROPDOWNRANGEENDS, WebUtil.getPreviousYear(20, "yyyy"));
		signupPage.enterCardDetails(DataConfigConstants.VALIDCARDNUBER, WebUtil.getExpiryMonthFutureYear(),
				Integer.toString(WebUtil.getRangeNumber(Integer.parseInt(DataConfigConstants.CVCMINLRANGESTARTS),
						Integer.parseInt(DataConfigConstants.CVCMAXLRANGEEND))));
		WebUtil.sleep();
		signupPage.clickOnIDonotAgreeButton();
		String[] expectedErrorMsg = { "Finish", "Create Account" };
		List<String> errorMsgList = Arrays.asList(expectedErrorMsg);
		assertTrue(errorMsgList.contains(signupPage.getTextOnFinishButton()), signupPage.getTextOnFinishButton());
	}

	@SauronTest
	@Test(description = "TC:43 -> Verify after clicking on i agree button", groups = { "All" })
	public void testIAgreePopUp() {
		signupPage.waitAndClickOn(SignupPage.STARTFREE_BTN);
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.checkChooseMembershipPageHighlighted(emailId, password);
		signupPage.selectDropDownEnterNameFields(DataConfigConstants.DROPDOWNRANGESTARTS,
				DataConfigConstants.DROPDOWNRANGEENDS, WebUtil.getPreviousYear(20, "yyyy"));
		signupPage.enterCardDetails(DataConfigConstants.VALIDCARDNUBER, WebUtil.getExpiryMonthFutureYear(),
				Integer.toString(WebUtil.getRangeNumber(Integer.parseInt(DataConfigConstants.CVCMINLRANGESTARTS),
						Integer.parseInt(DataConfigConstants.CVCMAXLRANGEEND))));
		signupPage.clickOnIagreeButton();
		assertEquals(signupPage.getTextThanksHomePage(), "Thank you for joining lulu Gold!",
				"Expected text not present on Home Page :" + signupPage.getTextThanksHomePage());
	}

	@SauronTest
	@Test(description = "TC84: Verify clicking on 'Cancel And Delete Account' button", groups = { "All" })
	public void testDeleteAccount() {
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.signupOnboard(emailId, password);
		hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		WebUtil.scrollDownWeb(3000);
		signupPage.waitAndClickOn(SignupPage.CANCELDELETE_BTN);
		signupPage.waitAndClickOn(SignupPage.CHECKBOXDELETEREASON);
		loginPage.enterPassword(DataConfigConstants.TEXTUSERPASSWORD);
		signupPage.waitAndClickOn(SignupPage.CANCELANDDELETEPAGE_BTN);
	}

	@SauronTest
	@Test(description = "TC:85 -> Verify user is unable to login using deleted account", groups = { "All" })
	public void testLoginWithDeleteAccount() {
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.signupOnboard(emailId, password);
		hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		WebUtil.scrollDownWeb(3000);
		signupPage.waitAndClickOn(SignupPage.CANCELDELETE_BTN);
		signupPage.waitAndClickOn(SignupPage.CHECKBOXDELETEREASON);
		loginPage.enterPassword(DataConfigConstants.TEXTUSERPASSWORD);
		signupPage.waitAndClickOn(SignupPage.CANCELANDDELETEPAGE_BTN);
		WebUtil.sleepForAccount();
		loginPage.loginMethod(emailId, password);
		assertEquals(
				signupPage.waitAndGetText(SignupPage.LOGINWARNMESSAGEWITHDELETEACCOUNT_TXT)
						.contains("If you have an account, please try again."),
				true, "Warning Message with Delete Account is not as Expected :"
						+ signupPage.waitAndGetText(SignupPage.LOGINWARNMESSAGEWITHDELETEACCOUNT_TXT));
	}

	@SauronTest
	@Test(description = "TC:86 -> Verify user can sign up with the same account which was deleted", priority = 75, groups = {
			"All" })
	public void testSignUpWithDeleteAccount() {
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.signupOnboard(emailId, password);
		hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		WebUtil.scrollDownWeb(3000);
		signupPage.waitAndClickOn(SignupPage.CANCELDELETE_BTN);
		signupPage.waitAndClickOn(SignupPage.CHECKBOXDELETEREASON);
		loginPage.enterPassword(DataConfigConstants.TEXTUSERPASSWORD);
		signupPage.waitAndClickOn(SignupPage.CANCELANDDELETEPAGE_BTN);
		WebUtil.sleepForAccount();
		signupPage.waitAndClickOn(SignupPage.STARTFREE_BTN);
		signupPage.checkChooseMembershipPageHighlighted(emailId, password);
	}

	@SauronTest
	@Test(description = "TC77: Verify clicking on Upgrade membership button", priority = 76, groups = { "All" })
	public void clickOnUpgradeMembershipButton() {
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.signupOnboard(emailId, password);
		hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		accountPages.waitAndClickOn(AccountPage.UPGRADE_MEMBERSHIP_BUTTON);
		assertTrue(accountPages.isElementPresent(AccountPage.UPGRADE_TO_FAMILY_MEMBERSHIP_PAGE_HDR),
				"Upgrade to family membership page header is not present");
	}

	@SauronTest
	@Test(description = "TC79: Verify clicking on 'Cancel Upgrade' button", priority = 77, groups = { "All" })
	public void clickOnCancelUpgradeButton() {
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.signupOnboard(emailId, password);
		hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		accountPages.waitAndClickOn(AccountPage.UPGRADE_MEMBERSHIP_BUTTON);
		accountPages.waitAndClickOn(AccountPage.CANCELUPGRADE_BUTTON);
		WebUtil.sleep();
		assertTrue(accountPages.isElementPresent(AccountPage.ACCOUNT_HEADER), "Account settings header is not present");
		assertTrue(accountPages.isElementPresent(AccountPage.UPGRADE_MEMBERSHIP_BUTTON),
				"Upgrade membership button is not present");
	}

	@SauronTest
	@Test(description = "TC78: Verify clicking on 'Yes, upgrade now' button", priority = 78, groups = { "All" })
	public void clickOnYesUpgradeButton() {
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.signupOnboard(emailId, password);
		hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		accountPages.waitAndClickOn(AccountPage.UPGRADE_MEMBERSHIP_BUTTON);
		accountPages.waitAndClickOn(AccountPage.YESUPGRADENOWBTN);
		WebUtil.sleep();
		assertEquals(accountPages.waitAndGetText(AccountPage.SUCCESS_MSG_OF_UPGRADE_FAMILY_MEMBERSHIP).trim(),
				"You've successfully upgraded to the family plan!",
				"You've successfully upgraded to the family plan! message is not displayed");
	}

	@SauronTest
	@Test(description = "TC73: Verify clicking on Downgrade Membership", priority = 79, groups = { "All" })
	public void clickOnDowngradeMembershipButton() {
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.signupOnboard(emailId, password);
		hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		accountPages.waitAndClickOn(AccountPage.UPGRADE_MEMBERSHIP_BUTTON);
		accountPages.waitAndClickOn(AccountPage.YESUPGRADENOWBTN);
		WebUtil.scrollToElementUsingVisibleXpathText("Account Options");
		accountPages.waitAndClickOn(AccountPage.DOWNGRADE_MEMBERSHIP_BUTTON);
		WebUtil.sleep();
		assertTrue(accountPages.isElementPresent(AccountPage.DOWNGRADE_MEMBERSHIP_HDR),
				"Downgrade to family membership page header is not present");
	}

	@SauronTest
	@Test(description = "TC76: Verify clicking on Cancel Downgrade link", priority = 80, groups = { "All" })
	public void clickOnCancelDowngradeButton() {
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.signupOnboard(emailId, password);
		hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		accountPages.waitAndClickOn(AccountPage.UPGRADE_MEMBERSHIP_BUTTON);
		accountPages.waitAndClickOn(AccountPage.YESUPGRADENOWBTN);
		WebUtil.scrollToElementUsingVisibleXpathText("Account Options");
		accountPages.waitAndClickOn(AccountPage.DOWNGRADE_MEMBERSHIP_BUTTON);
		accountPages.waitAndClickOn(AccountPage.CANCELDOWNGRADE_BUTTON);
		WebUtil.sleep();
		assertTrue(accountPages.isElementPresent(AccountPage.ACCOUNT_HEADER), "Account settings header is not present");
	}

	@SauronTest
	@Test(description = "TC74: Verify clicking on 'Yes, downgrade now' button, without selecting check box of terms & aggrement'", priority = 81, groups = {
			"All" })
	public void clickOnyesDowngradeNowButtonWithoutSelectingCheckbox() {
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.signupOnboard(emailId, password);
		hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		accountPages.waitAndClickOn(AccountPage.UPGRADE_MEMBERSHIP_BUTTON);
		accountPages.waitAndClickOn(AccountPage.YESUPGRADENOWBTN);
		WebUtil.scrollToElementUsingVisibleXpathText("Account Options");
		accountPages.waitAndClickOn(AccountPage.DOWNGRADE_MEMBERSHIP_BUTTON);
		accountPages.waitAndClickOn(AccountPage.CANCELDOWNGRADE_BUTTON);
		WebUtil.scrollDownWeb(300);
		assertEquals(accountPages.waitAndGetText(AccountPage.IAGREETOTERMS_BEFOREDOWNGRADING_ERRORMSG).trim(),
				"Please agree to the terms before downgrading",
				"Please agree to the terms before downgrading is not present");
	}

	@SauronTest
	@Test(description = "TC75: Verify the success message after downgrading your plan", priority = 82, groups = {
			"All" })
	public void verifySuccessMsgAfterDowngradingThePlan() {
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.signupOnboard(emailId, password);
		hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		accountPages.waitAndClickOn(AccountPage.UPGRADE_MEMBERSHIP_BUTTON);
		accountPages.waitAndClickOn(AccountPage.YESUPGRADENOWBTN);
		WebUtil.scrollToElementUsingVisibleXpathText("Account Options");
		accountPages.waitAndClickOn(AccountPage.DOWNGRADE_MEMBERSHIP_BUTTON);
		accountPages.waitAndClickOn(AccountPage.DOWNGRADE_CHECKBOX);
		accountPages.waitAndClickOn(AccountPage.YESDOWNGRADE_NOW_BUTTON);
		WebUtil.sleep();
		assertEquals(accountPages.waitAndGetText(AccountPage.DOWNGRADE_PLAN_SUCCESS_MSG),
				"Your plan has successfully been downgraded",
				"Your plan has successfully been downgraded message is not present");
	}

	@SauronTest
	@Test(description = "TC81: Verify clicking on Pause Account button", priority = 83, groups = { "All" })
	public void testPauseAccountIsClickable() {
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.signupOnboard(emailId, password);
		hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		WebUtil.scrollToElementUsingVisibleXpathText("Account Options");
		signupPage.waitAndClickOn(SignupPage.PAUSEACCOUNT_BTN);
		WebUtil.sleep();
		assertEquals(signupPage.waitAndGetText(SignupPage.PAUSETEXTPAGE_TXT), "Pause Account",
				"Page not Navigates to Pause Account page");
	}

	@SauronTest
	@Test(description = "TC82: Verify clicking on Pause account button selecting any of check box", priority = 84, groups = {
			"All" })
	public void testPauseAccountAndVerifyWarnMessage() {
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.signupOnboard(emailId, password);
		hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		WebUtil.scrollToElementUsingVisibleXpathText("Account Options");
		signupPage.waitAndClickOn(SignupPage.PAUSEACCOUNT_BTN);
		signupPage.waitAndClickOn(SignupPage.SELECTREASON_CHK);
		signupPage.clickOnReasonButton();
		WebUtil.sleep();
		assertEquals(signupPage.waitAndGetText(SignupPage.ALERTMESSAGE2_TXT), "Account Paused",
				"Alert Meassage for Pause Account is not as Expected Message");
		assertEquals(signupPage.waitAndGetText(SignupPage.ALERTMESSAGE1_TXT).contains(
				"Your account has been paused. You will need to re-enable this account to continue receiving benefits."),
				true, "Alert Meassage for Pause Account is not as Expected Message");
	}

	@SauronTest
	@Test(description = "TC83: Verify clicking on 'Enable Account' button", priority = 85, groups = { "All" })
	public void testEnableAccount() {
		String emailId = DataConfigConstants.TEXTUSEREMAILFIRSTID + System.nanoTime()
				+ DataConfigConstants.TEXTUSEREMAILDOMAINID;
		String password = DataConfigConstants.TEXTUSERPASSWORD;
		signupPage.signupOnboard(emailId, password);
		hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		WebUtil.scrollToElementUsingVisibleXpathText("Account Options");
		signupPage.waitAndClickOn(SignupPage.PAUSEACCOUNT_BTN);
		signupPage.waitAndClickOn(SignupPage.SELECTREASON_CHK);
		signupPage.clickOnReasonButton();
		assertEquals(signupPage.waitAndGetText(SignupPage.ALERTMESSAGE2_TXT), "Account Paused",
				"Alert Meassage for Pause Account is not as Expected Message");
		hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		WebUtil.scrollToElementUsingVisibleXpathText("Account Options");
		signupPage.waitAndClickOn(SignupPage.ENABLEACCOUNT_BTN);
		signupPage.waitAndClickOn(SignupPage.ENABLEACCOUNTPAGE_BTN);
		WebUtil.sleep();
		assertEquals(
				signupPage.waitAndGetText(SignupPage.ENABLEACCOUNTPAGE_TXT).contains("Account successfully enabled!"),
				true, "Alert Meassage for Enable Account is not as Expected Message");

	}

}