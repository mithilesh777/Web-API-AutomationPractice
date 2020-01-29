package com.lulu.qa.web.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.lulu.qa.web.DataConfigConstants;
import com.lulu.qa.web.utils.WebUtil;
import com.qapitol.sauron.logger.SauronLogger;
import com.qapitol.sauron.platform.grid.Grid;
import com.qapitol.sauron.platform.html.support.HtmlElementUtils;
import com.qapitol.test.utilities.logging.SimpleLogger;

import io.qameta.allure.Step;

public class SignupPage extends AbstractGoodRxPage {

	private static SimpleLogger log = SauronLogger.getLogger();

	public static final String STARTFREE_BTN = "startfreeBtn";
	public static final String USEASITIS_TXT = "useAsItIsTxt";
	public static final String LOGINWARNMESSAGEWITHDELETEACCOUNT_TXT = "loginWarnMessageWithDeleteAccount";
	// SignUp Form Details in Step-1
	public static final String STEPONEOUT_TXT = "stepOneOutTxt";
	public static final String EMAILADDRESS_TFLD = "emailAddressTfld";
	public static final String PASSWORD_TFLD = "passwordTfld";
	public static final String CREATEMYACCOUNT_BTN = "createMyAccountBtn";
	public static final String STARTFREETRIALV2_BTN = "startFreeTrialV2Btn";
	// SignUp Form Details in Step-2
	public static final String STEPTWO_TXT = "stepTwoTxt";
	public static final String TWOCHOOSE_TXT = "twoChooseTxt";
	public static final String RADIOIND_BTN = "radioIndBtn";
	public static final String INDIVIDUALMEM_BTN = "individualMemBtn";
	public static final String FAMILYMEM_TXT = "familyMemTxt";
	public static final String FAMILYRADION_BTN = "familyRadionBtn";
	public static final String CONTINUE_BTN = "continueBtn";
	public static final String CONTINUETWO_BTN = "continueTwoBtn";
	// SignUp Form Details in Step-3
	public static final String FIRSTNAME_TFLD = "firstNameTfld";
	public static final String LASTNAME_TFLD = "lastNameTfld";
	public static final String MONTH_DDS = "monthDds";
	public static final String DAY_DDS = "dayDds";
	public static final String YEAR_DDS = "yearDds";
	public static final String CONTINUENEXTSTEP_BTN = "continueNextStepBtn";
	// SignUp Form Details in Step-4
	public static final String STREETNAME_TFLD = "streetNameTfld";
	public static final String CITY_TFLD = "cityTfld";
	public static final String ZIPCODE_TFLD = "zipcodeTfld";
	public static final String STATE_DDS = "stateDds";
	public static final String STARTTRIAL_BTN = "startTrialBtn";
	// UI-2 Variants
	public static final String MEMBERSHIPPLANS_TXT = "membershipPlansTxt";
	public static final String SELECTDATEWARNING_TXT = "selectDateWarningTxt";
	public static final String NEXTSTEPCONTINUEV1_BTN = "nextStepContinuev1Btn";
	public static final String BACK_BTN = "backbutton";
	// SignUp Form Your Card Details
	public static final String CARDNUMBER_TFLD = "cardNumber";
	public static final String CARDEXPIRY_TFLD = "cardExpiry";
	public static final String CARDCVC_TFLD = "cardCVC";
	public static final String CARDCVC_ICN = "cvcInfoIcon";
	public static final String CARDCVCINFO_TXT = "cvcInfoText";
	public static final String FINISH_BTN = "finshBtn";
	public static final String CREATEACCOUNT_BTN = "createAccountBtn";
	public static final String CARDNUMBERWARNING_TXT = "cardNumberWarningMessage";
	public static final String CARDNUMBERBLANK_TXT = "cardNumberBlankMessage";
	public static final String CARDEXPIRYWARNING_TXT = "cardExpiryWarningMessage";
	public static final String CARDCVCWARNING_TXT = "cardCvcWarningMessage";
	public static final String PAYMENTINFO_TXT = "getTextAsPaymentInfo";
	// SignUp Form Create Your Card Terms and Conditions
	public static final String GOODRXGOLDTERMSANDCONDITIONS_TXT = "goodRxGoldTermsConditions";
	public static final String IAGREE_BTN = "iAgreeButton";
	public static final String IDONOTAGREE_BTN = "iDonotAgreeButton";
	// Pause Account
	public static final String ACCOUNT_ICN = "navbarAccount";
	public static final String PAUSEACCOUNT_BTN = "pauseAccount";
	public static final String SELECTREASON_CHK = "reasonCheckbox";
	public static final String PAUSEREASONPAGE_BTN = "pauseButtonReasonPage";
	public static final String PAUSETEXTPAGE_TXT = "pauseButtonTextlabel";
	public static final String ALERTMESSAGE1_TXT = "alertPauseMessage1";
	public static final String ALERTMESSAGE2_TXT = "alertPauseMessage2";
	public static final String ENABLEACCOUNT_BTN = "enableAccount";
	public static final String ENABLEACCOUNTPAGE_BTN = "enableAccountBtn";
	public static final String ENABLEACCOUNTPAGE_TXT = "alertEnableMessage";
	// Delete Account
	public static final String CANCELDELETE_BTN = "deleteButton";
	public static final String CHECKBOXDELETEREASON = "checkboxReasonToDelete";
	public static final String PASSWORD_TXT = "passwordTextField";
	public static final String CANCELANDDELETEPAGE_BTN = "cancelAndDeletePageButton";
	// LogOut
	public static final String MENULOGIN_BTN = "mainLoginBtn";
	public static final String LOGOUT_BTN = "logout";
	public static final String GOODRXLOGO_BTN = "goodRxLogo";
	public static final String SIGNUPFIRSTSCREENHEADER = "signupfirstscreenheader";
	public static final String TEXTFROMHOMEPAGETHANKS = "clickIAgreeHomePageTxt";

	public Select drpDown;

	/**
	 * @Desc: Checking whether users are redirected to membership page or not
	 */
	@Step("User is able navigate to the next screen Choose Membership in Two UI variants")
	public void checkChooseMembershipPageHighlighted(String emailId, String password) {
		try {
			if (isElementPresent(STEPONEOUT_TXT)) {
				locateElement(EMAILADDRESS_TFLD).click();
				locateElement(EMAILADDRESS_TFLD).sendKeys(emailId);
				locateElement(PASSWORD_TFLD).click();
				locateElement(PASSWORD_TFLD).sendKeys(password);
				waitAndClickOn(CREATEMYACCOUNT_BTN);
				assertTrue(isElementPresent(TWOCHOOSE_TXT));
			} else {
				locateElement(EMAILADDRESS_TFLD).click();
				locateElement(EMAILADDRESS_TFLD).sendKeys(emailId);
				locateElement(PASSWORD_TFLD).click();
				locateElement(PASSWORD_TFLD).sendKeys(password);
				waitAndClickOn(STARTFREETRIALV2_BTN);
				assertEquals(locateElement(MEMBERSHIPPLANS_TXT).getText(), "Choose the plan that's right for you");
			}
		} catch (Exception e) {

		}
	}

	/**
	 * @Desc: Clicking on Membership plans
	 * 
	 */
	@Step("User is able navigate to the next screen Choose Membership in Two UI variants")
	public void changeChooseMembershipPageHighlighted() {
		waitUntilElementIsPresent(INDIVIDUALMEM_BTN);
		if (locateElement(INDIVIDUALMEM_BTN).isSelected()) {
			waitAndClickOn(FAMILYRADION_BTN);
			assertTrue(waitAndGetText(FAMILYMEM_TXT).contains("Family"));
			waitAndClickOn(INDIVIDUALMEM_BTN);
			assertTrue(waitAndGetText(RADIOIND_BTN).contains(DataConfigConstants.INDIVIDUAL_TEXT));
		}
	}

	/**
	 * @Desc: Verify Membership Page
	 * 
	 */
	@Step("Verify Membership Page")
	public void verifyMembershipPage() {
		waitUntilElementIsPresent(MEMBERSHIPPLANS_TXT);
		assertEquals(locateElement(MEMBERSHIPPLANS_TXT).getText().contains("Choose the plan that's right for you"),
				true);
	}

	/**
	 * @Desc: Checking whether default radio button is selected on Individual
	 *        Membership
	 */
	@Step("Default Individual Radio Button Selected For Individual Membership Page")
	public void validatingDefaultRadioTextAsIndividual() {
		try {
			if (isElementPresent(STEPONEOUT_TXT)) {
				waitUntilElementIsPresent(RADIOIND_BTN);
				assertTrue(waitAndGetText(RADIOIND_BTN).contains(DataConfigConstants.INDIVIDUAL_TEXT),
						"Individual Radio Button Not Selected");
			} else {
				assertTrue(waitAndGetText(RADIOIND_BTN).contains(DataConfigConstants.INDIVIDUAL_TEXT),
						"Individual Radio Button Not Selected");
			}
		} catch (NoSuchElementException e) {
			assertTrue(waitAndGetText(RADIOIND_BTN).contains(DataConfigConstants.INDIVIDUAL_TEXT),
					"Individual Radio Button Not Selected");
		}
	}

	/**
	 * @Desc:Click on Continue to Navigate User Details Step
	 */
	@Step("Click on Continue to Navigate User Details Step")
	public void clickOnContinue() {
		if (isElementPresent(STEPONEOUT_TXT)) {
			if (isElementPresent(CONTINUE_BTN)) {
				waitAndClickOn(CONTINUE_BTN);
				assertTrue(isElementPresent(CONTINUENEXTSTEP_BTN), "Page is Not Navigating to User Details Step");
			} else if (isElementPresent(CONTINUENEXTSTEP_BTN)) {
				if (isElementPresent(CONTINUENEXTSTEP_BTN)) {
					waitAndClickOn(CONTINUENEXTSTEP_BTN);
					assertTrue(isElementPresent(CONTINUENEXTSTEP_BTN), "Page is Not Navigating to User Details Step");
				}
			}
		} else {
			assertTrue(false, "Sign-up Form UI-2 Present. there is No Scope to test Click on Continue Button here");
		}
	}

	/**
	 * @Desc:Click on PopUp Alert Use as it is
	 */
	@Step("Click on PopUp Alert Use as it is")
	public void clickPopupUseAsItIs() {
		if (isElementPresent(USEASITIS_TXT)) {
			waitAndClickOn(USEASITIS_TXT);
		}
	}

	/**
	 * @Desc:Set Text Fields with Firstname and Lastname
	 */
	@Step("Set Text Fields with firstname and lastname")
	public void enterUserNameIntoTextFields() {
		waitAndSetText(FIRSTNAME_TFLD, DataConfigConstants.TEXTUSERFIRSTNAME);
		waitAndSetText(LASTNAME_TFLD, DataConfigConstants.TEXTUSERLASTNAME);
	}

	/**
	 * 
	 * @param xpath
	 * @param State Selection
	 */
	@Step("Select State from Dropdown")
	public void selectStateFromDropDown(String xpath, String value) {
		if (getTargetClient().equals("ie")) {
			Select drpState = new Select(locateElement(xpath));
			List<WebElement> listOfItems = drpState.getOptions();
			int totalDropDownItems = listOfItems.size();
			drpState.selectByIndex(totalDropDownItems - 3);
		} else {
			WebUtil.selectDropdownbyValue(locateElement(xpath), value);
		}
	}

	/**
	 * @Desc:Fill User Address Details
	 */
	@Step("Fill User Address Details")
	public void fillUserAddressDetails() {
		waitAndSetText(STREETNAME_TFLD, DataConfigConstants.TEXTSTREETNAME);
		waitAndSetText(CITY_TFLD, DataConfigConstants.TEXTCITYNAME);
		waitAndSetText(ZIPCODE_TFLD, DataConfigConstants.TEXTZIPCODE);
		try {
			waitUntilElementIsPresent(STATE_DDS);
			selectStateFromDropDown(STATE_DDS, DataConfigConstants.DROPDOWNSTATECODE);
		} catch (Exception e) {
		}
	}

	/**
	 * @Desc:Set DOB by selecting Month Day Year from Dropdown
	 * @param month
	 * @param date
	 * @param year
	 */
	@Step("Set DOB by selecting Month Day Year from Dropdown")
	public void selectDOBDropdown(String startsRange, String endRange, String year) {
		if (getTargetClient().equals("ie") || getBrowser().equalsIgnoreCase("safari")) {
			try {
				selectDropDownByIndex(MONTH_DDS, WebUtil.getCurrentMonth(), Integer.parseInt(startsRange),
						Integer.parseInt(endRange));
			} catch (Exception e) {
			}
			try {
				selectDropDownByIndex(DAY_DDS, WebUtil.getCurrentDay(), Integer.parseInt(startsRange),
						Integer.parseInt(endRange));
			} catch (Exception e) {
			}
			try {
				selectDropDownByIndex(YEAR_DDS, WebUtil.getCurrentYear(), Integer.parseInt(startsRange),
						Integer.parseInt(endRange));
			} catch (Exception e) {
			}
		} else {
			waitUntilElementIsPresent(MONTH_DDS);
			WebUtil.selectDropdownbyValue(locateElement(MONTH_DDS), WebUtil.getDateUtil("MMM"));
			waitUntilElementIsPresent(DAY_DDS);
			WebUtil.selectDropdownbyValue(locateElement(DAY_DDS), WebUtil.getDateUtil("d"));
			waitUntilElementIsPresent(YEAR_DDS);
			WebUtil.selectDropdownbyValue(locateElement(YEAR_DDS), year);
		}
	}

	/**
	 * Assert DropDown Age Warning Messages for Signup Both UI Variants
	 * 
	 * @param selector
	 * @param year
	 */
	@Step("Drop Down Date Past/Present/Future")
	public void assertIsElementPresentAndWarningMessageEquals(String selector) {
		try {
			if (isElementPresent(selector)) {
				waitUntilElementIsPresent(selector);
				if (locateElement(selector).getText().contains("You must be at least 18 years old to register.")) {
					assertEquals(locateElement(selector).getText(), "You must be at least 18 years old to register.");
				} else if (locateElement(selector).getText().contains("Date must be before")) {
					assertEquals(locateElement(selector).getText(), "Date must be before" + WebUtil.todayDateUtil());
				}
			} else if (locateElement(selector).getText().contains("Please enter the date in the form MM/DD/YYYY")) {
				assertEquals(locateElement(selector).getText(), "Please enter the date in the form MM/DD/YYYY");
			}
		} catch (Exception e) {
			log.info("ErrorMessage is not Present for Age Greater than 18");
		}
	}

	/**
	 * @Desc:Select year from drop down-V2
	 * @param year
	 */
	@Step("Select date from drop down :{rangeStarts}  -  {rangeEnds}")
	public void selectDropDownDateV2(String rangeStarts, String rangeEnds, String year) {
		selectDOBDropdown(rangeStarts, rangeEnds, year);
		waitAndClickOn(CONTINUETWO_BTN);
		clickPopupUseAsItIs();
		assertIsElementPresentAndWarningMessageEquals(SELECTDATEWARNING_TXT);
	}

	/**
	 * @Desc: Select year from drop down-V1
	 * @param year
	 */
	@Step("Select date from drop down :{rangeStarts}  -  {rangeEnds}")
	public void selectDropDownDateV1(String rangeStarts, String rangeEnds, String year) {
		selectDOBDropdown(rangeStarts, rangeEnds, year);
		if (isElementPresent(CONTINUENEXTSTEP_BTN)) {
			waitAndClickOn(CONTINUENEXTSTEP_BTN);
		}
		assertIsElementPresentAndWarningMessageEquals(SELECTDATEWARNING_TXT);
		if (!isElementPresent(SELECTDATEWARNING_TXT)) {
			fillUserAddressDetails();
			waitAndClickOn(CONTINUENEXTSTEP_BTN);
			clickPopupUseAsItIs();
		}
	}

	/**
	 * @Desc:Select DOB and Enter FirstName LastName
	 * @param year
	 */
	@Step("Select DOB and Enter FirstName LastName")
	public void selectDropDownEnterNameFields(String rangeStarts, String rangeEnds, String year) {
		try {
			if (isElementPresent(STEPTWO_TXT)) {
				waitAndClickOn(CONTINUETWO_BTN);
				enterUserNameIntoTextFields();
				selectDropDownDateV1(rangeStarts, rangeEnds, year);
			} else {
				enterUserNameIntoTextFields();
				fillUserAddressDetails();
				selectDropDownDateV2(rangeStarts, rangeEnds, year);
			}
		} catch (Exception e) {
		}
	}

	/**
	 * @Desc:Continue Next Step is Clickable
	 * @param year
	 */
	@Step("Continue Next Step is Clickable")
	public void continueNextStepClickabe(String rangeStarts, String rangeEnds, String year) {
		if (isElementPresent(STEPTWO_TXT)) {
			waitAndClickOn(CONTINUETWO_BTN);
			enterUserNameIntoTextFields();
			selectDropDownDateV1(rangeStarts, rangeEnds, year);
		} else {
			assertTrue(false, "UI-2 Signup Form is Present, here Noscope to validate Continue Next Step Button.");
		}
	}

	public void signUpFormGoodRxEnterNoTextFirstNameLastName() {

		if (isElementPresent(STEPTWO_TXT)) {
			waitAndClickOn(CONTINUETWO_BTN);
			assertToastMessages();
		} else {
			waitAndClickOn(CONTINUETWO_BTN);
			clickPopupUseAsItIs();
			WebUtil.scrollUpWeb(500);
			assertToastMessages();
		}
	}

	public void assertToastMessages() {
		String[] expectedErrorMsg = { "Fill out this field.", "Please fill out this field.",
				"Please fill in this field.", "This is a required field" };
		List<String> errorMsgList = Arrays.asList(expectedErrorMsg);
		String errorMsgActual = waitAndGetTextByAttribute(FIRSTNAME_TFLD, "validationMessage");
		assertTrue(errorMsgList.contains(errorMsgActual), "Error message displayed is not as expected");
	}

	/**
	 * @Desc: click on back button
	 * 
	 */
	@Step("click on back button")
	public void clickOnBackButton() {
		if (isElementPresent(STEPTWO_TXT)) {
			waitAndClickOn(CONTINUETWO_BTN);
			enterUserNameIntoTextFields();
			waitAndClickOn(BACK_BTN);
			waitUntilElementIsPresent(RADIOIND_BTN);
			assertTrue(waitAndGetText(RADIOIND_BTN).contains(DataConfigConstants.INDIVIDUAL_TEXT),
					"Individual Radio Button Not Selected");
		} else {
			assertTrue(false, "Sign-up Form UI-2. Present there is No Scope to test Back Button here");
		}

	}

	/**
	 * Reason check box is Enabled
	 */
	@Step("Reason check box is Enabled")
	public boolean isSelectedReasonCheckBox() {
		waitUntilElementIsPresent(SELECTREASON_CHK);
		return locateElement(SELECTREASON_CHK).isEnabled();
	}

	/**
	 * Click on Pause Button
	 */
	@Step("Click on Pause Account Button")
	public void clickOnReasonButton() {
		WebUtil.scrollToElementUsingVisibleXpathText("Pause Account");
		waitAndClickOn(PAUSEREASONPAGE_BTN);
	}

	/**
	 * Switch to Frame by Name or ID
	 * 
	 * @param frameNameOrId
	 */
	public void switchToFrameByString(String frameNameOrId) {
		try {
			Grid.driver().switchTo().frame(frameNameOrId);
		} catch (Exception e) {
		}
	}

	/**
	 * Enter Numeric values as text into CardNumber TextField
	 */
	@Step("Enter Numeric values as text into CardNumber TextField")
	public void enterTextCardNumber(String cardNumber) {
		switchToFrameByString("__privateStripeFrame5");
		enterCCDetails(CARDNUMBER_TFLD, cardNumber);
		Grid.driver().switchTo().defaultContent();
	}

	public void enterCCDetails(String element, String ccNumber) {
		if (isMobilePage()) {
			try {
				WebUtil.longSleepForOnboarding();
				waitAndClickOn(element);
				Actions action = new Actions(Grid.driver());
				WebUtil.longSleepForOnboarding();
				action.moveToElement(locateElement(element)).sendKeys(ccNumber).build().perform();
			} catch (Exception e) {
			}
		} else if (isBrowserEnable("iexplore")) {
			WebUtil.sleep();
			WebElement webElement = waitUntilElementIsPresent(element);
			webElement.click();
			webElement.clear();
			webElement.sendKeys(ccNumber);
		} else {
			WebUtil.sleep();
			WebElement webElement = waitUntilElementIsPresent(element);
			for (int i = 0; i < ccNumber.length(); i++) {
				char n = ccNumber.charAt(i);
				webElement.sendKeys(String.valueOf(n));
			}
		}
	}

	/**
	 * Get Numeric values as text from CardNumber TextField
	 */
	@Step("Get Numeric values as text from CardNumber TextField")
	public String getTextCardNumber() {
		switchToFrameByString("__privateStripeFrame5");
		String text = locateElement(CARDNUMBER_TFLD).getText();
		Grid.driver().switchTo().defaultContent();
		return text;
	}

	@Step("Get Color of CardNumber TextField")
	public String getTextColorCardNumber() {
		switchToFrameByString("__privateStripeFrame5");
		String color = locateElement(CARDNUMBER_TFLD).getCssValue("color");
		Grid.driver().switchTo().defaultContent();
		return color;
	}

	/**
	 * Enter Date/Month as text into CardExpiry TextField
	 */
	@Step("Enter Date/Month as text into CardExpiry TextField")
	public void enterTextExpiryDate(String cardExpiry) {
		switchToFrameByString("__privateStripeFrame6");
		enterCCDetails(CARDEXPIRY_TFLD, cardExpiry);
		Grid.driver().switchTo().defaultContent();
	}

	/**
	 * Get Color of CardExpiry TextField
	 */
	@Step("Get Color of CardExpiry TextField")
	public String getTextColorCardExpiry() {
		switchToFrameByString("__privateStripeFrame6");
		String color = locateElement(CARDEXPIRY_TFLD).getCssValue("color");
		Grid.driver().switchTo().defaultContent();
		return color;
	}

	/**
	 * Enter 3-4 Digit Numeric as text into CVC TextField
	 */
	@Step("Enter Numeric values as text into CardNumber TextField : {cardCvc}")
	public void enterTextCVC(String cardCvc) {
		switchToFrameByString("__privateStripeFrame7");
		enterCCDetails(CARDCVC_TFLD, cardCvc);
		Grid.driver().switchTo().defaultContent();
	}

	@Step("Get Color of CVC TextField")
	public String getTextColorCVC() {
		switchToFrameByString("__privateStripeFrame7");
		String color = locateElement(CARDCVC_TFLD).getCssValue("color");
		Grid.driver().switchTo().defaultContent();
		return color;
	}

	/**
	 * Click on Finish Button
	 */
	@Step("Click on Finish Button")
	public void clickOnFinishButton() {
		if (isElementPresent(FINISH_BTN)) {
			waitAndClickOn(FINISH_BTN);
		} else if (isElementPresent(CREATEACCOUNT_BTN)) {
			waitAndClickOn(CREATEACCOUNT_BTN);
		} else {
			WebUtil.scrollDownWeb(500);
			if (isElementPresent(FINISH_BTN)) {
				waitAndClickOn(FINISH_BTN);
			} else if (isElementPresent(CREATEACCOUNT_BTN)) {
				waitAndClickOn(CREATEACCOUNT_BTN);
			}
		}
	}

	/**
	 * GetText on Finish Button
	 */
	@Step("GetText on Finish Button")
	public String getTextOnFinishButton() {
		if (isElementPresent(FINISH_BTN)) {
			return waitAndGetText(FINISH_BTN);
		} else if (isElementPresent(CREATEACCOUNT_BTN)) {
			return waitAndGetText(CREATEACCOUNT_BTN);
		} else {
			WebUtil.scrollDownWeb(500);
			if (isElementPresent(FINISH_BTN)) {
				return waitAndGetText(FINISH_BTN);
			} else if (isElementPresent(CREATEACCOUNT_BTN)) {
				return waitAndGetText(CREATEACCOUNT_BTN);
			}
		}
		return "No Text Captured From Button";
	}

	/**
	 * Common Method Used to Pass Card Details
	 * 
	 * @param string
	 * @param cardExpiryDate
	 * @param cardCvc
	 */
	public void enterCardDetails(String cardNum, String cardExpiryDate, String cardCvc) {
		enterTextCardNumber(cardNum);
		enterTextExpiryDate(cardExpiryDate);
		enterTextCVC(cardCvc);
		clickOnFinishButton();
	}

	/**
	 * Get text From Terms and Conditions pop-up page
	 */
	@Step("Get text From Terms and Conditions pop-up page")
	public String getTextFromTermsAndConditions() {
		if (HtmlElementUtils.isElementPresent(GOODRXGOLDTERMSANDCONDITIONS_TXT)) {
			return waitAndGetText(GOODRXGOLDTERMSANDCONDITIONS_TXT);
		} else {
			return null;
		}
	}

	/**
	 * Click on I Agree Button
	 */
	@Step("Click on I Agree Button")
	public void clickOnIagreeButton() {
		WebUtil.sleep();
		WebUtil.scrollUpWeb(300);
		waitUntilElementIsPresent(IAGREE_BTN);
		WebUtil.clickUsingAction(locateElement(IAGREE_BTN));
	}

	/**
	 * Get Text From HomePage For Assertion
	 */
	@Step("Get Text From HomePage For Assertion")
	public String getTextThanksHomePage() {
		WebUtil.longSleepForOnboarding();
		return waitAndGetText(TEXTFROMHOMEPAGETHANKS);
	}

	/**
	 * Click on I Don't Agree Button
	 */
	@Step("Click on I Don't Agree Button")
	public void clickOnIDonotAgreeButton() {
		WebUtil.scrollToElementUsingVisibleXpathText("I do not agree");
		waitAndClickOn(IDONOTAGREE_BTN);
	}

	public void selectDropDownByIndex(String locator, int currentDayMonthYear, int rangeStart, int rangeEnd) {
		drpDown = new Select(locateElement(locator));
		if (String.valueOf(currentDayMonthYear).length() > 3) {
			drpDown.selectByIndex((currentDayMonthYear + 1 - Integer.parseInt(DataConfigConstants.DROPDOWNSTARTYEAR))
					- WebUtil.getRangeNumber(rangeStart, rangeEnd));

		} else if (String.valueOf(currentDayMonthYear).length() < 3
				&& String.valueOf(currentDayMonthYear).length() > 0) {
			drpDown.selectByIndex(currentDayMonthYear);
		}
	}

	public void logoutAfterMethod() {
		try {
			waitAndClickOn(MENULOGIN_BTN);
			if (isElementPresent(LOGOUT_BTN))
				waitAndClickOn(LOGOUT_BTN);
			waitAndClickOn(GOODRXLOGO_BTN);
		} catch (Exception e) {
			log.info("Account Already Logout for this Account");
			waitAndClickOn(GOODRXLOGO_BTN);
		}
	}

	public boolean isCardNumberFieldDisplayed() {
		return waitAndCheckIsElementDisplayed(CARDNUMBER_TFLD);
	}

	public void signupOnboard(String userName, String password) {
		waitAndClickOn(STARTFREE_BTN);
		checkChooseMembershipPageHighlighted(userName, password);
		selectDropDownEnterNameFields(DataConfigConstants.DROPDOWNRANGESTARTS, DataConfigConstants.DROPDOWNRANGEENDS,
				WebUtil.getPreviousYear(20, "yyyy"));
		enterCardDetails(DataConfigConstants.VALIDCARDNUBER, WebUtil.getExpiryMonthFutureYear(),
				Integer.toString(WebUtil.getRangeNumber(Integer.parseInt(DataConfigConstants.CVCMINLRANGESTARTS),
						Integer.parseInt(DataConfigConstants.CVCMAXLRANGEEND))));
		clickOnIagreeButton();
		assertEquals(getTextThanksHomePage(), "Thank you for joining GoodRx Gold!",
				"Expected text not present on Home Page :" + getTextThanksHomePage());
	}

}