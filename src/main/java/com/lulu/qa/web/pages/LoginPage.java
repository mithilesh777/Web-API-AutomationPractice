package com.lulu.qa.web.pages;

import static org.testng.Assert.assertTrue;
import java.util.Arrays;
import java.util.List;
import com.lulu.qa.web.utils.WebUtil;
import com.qapitol.sauron.appium.platform.grid.SauronAppiumAndroidDriver;
import com.qapitol.sauron.platform.grid.Grid;
import com.qapitol.sauron.platform.utilities.WebDriverWaitUtils;
import io.qameta.allure.Step;

public class LoginPage extends AbstractGoodRxPage {
	public static final String MAINLOGIN_BTN = "mainLoginBtn";
	public static final String LOGIN_BTN = "loginBtn";
	public static final String FORGOTPASSWORD_LNK = "forgotPwdLink";
	public static final String FACEBOOK_BTN = "faceBookBtn";
	public static final String FACEBOOKEMAIL_TFLD = "faceBookEmailField";
	public static final String FACEBOOKPASSWORD_TFLD = "faceBookPwdField";
	public static final String FACEBOOKLOGIN_BTN = "faceBookLoginBtn";
	public static final String CONTINUE_BTN = "continueBtn";
	public static final String LOGINUSINGGOOGLE_BTN = "googleLoginBtn";
	public static final String EMAIL_TFLD = "googleEmailField";
	public static final String NEXTBUTTON_BTN = "gmailNextButton";
	public static final String GOOGLEPASSWORD_TFLD = "googlePwdField";
	public static final String ERRORMESSAGE_TXT = "errorMessageTxt";
	public static final String SIGNUPFREETRIAL_BTN = "signUpFreeTrailBtn";
	public static final String LOGINH_BTN = "loginhBtn";
	public static final String EMAIL_TXT = "emailTxt";
	public static final String PASSWORD_TXT = "passwordTxt";
	public static final String FORGOT_PWD_HDR = "forgotpwdhdr";

	/**
	 * @Desc: Method used to click on login button
	 */
	@Step("Click on login button")
	public void clickOnMainLogin() {
		waitAndClickOn(MAINLOGIN_BTN);
	}

	/**
     * @Desc: Method used to enter emailId
     * @param userName
     */
    @Step("Enter emailId {emailId}")
    public void enterEmail(String emailId) {
    	waitAndClickOn(EMAIL_TXT);
       waitAndSetText(EMAIL_TXT, emailId);
    }
    /**
     * @Desc: Method used to enter Password
     * @param Password
     */
    @Step("Enter Password {password}")
    public void enterPassword(String password) {
    	waitAndClickOn(PASSWORD_TXT);
        waitAndSetText(PASSWORD_TXT, password);
    }
	/**
	 * @Desc: Method used to click on login button
	 */
	@Step("Click on Login btn")
	public void clickOnLogin() {
		waitAndClickOn(LOGIN_BTN);
	}

	/**
	 * @Desc: Method used to click on forgot password link
	 */
	@Step("click on Forgot Password Link")
	public void clickOnForgotYourPassword() {
		waitAndClickOn(FORGOTPASSWORD_LNK);
	}

	/**
	 * @Desc: Verify if email field exists in forget password page
	 */
	@Step("Verify if email field exists in forget password page")
	public boolean isEmailFieldExist() {
		waitUntilElementIsPresent(EMAIL_TFLD);
		return isElementPresent(EMAIL_TFLD);
	}

	/**
	 * @Desc: Method used to get error message using xpath
	 * @param xpath
	 * @return String
	 */
	@Step("Get error message")
	public String getErrorMessage(String xpath) {
		waitUntilElementIsPresent(xpath);
		return locateElement(xpath).getAttribute("validationMessage");
	}

	/**
	 * @Desc: Method used to click on login using facebook
	 */
	@Step("click on login using facebook")
	public void clickOnLoginUsingFacebook() {
		waitAndClickOn(FACEBOOK_BTN);
	}

	/**
     * @Desc: Method used to enter facebook email
     * @param facebookEmail
     */
    @Step("enter facebook email {}")
    public void enterFacebookEmail(String facebookEmail) {
        waitAndSetText(FACEBOOKEMAIL_TFLD,facebookEmail);
        
    }
    /**
     * @Desc: Method used to enter facebook password
     * @param facebookPassword
     */
    @Step("enter facebook password")
    public void enterFacebookPassword(String facebookPassword) {
        waitAndSetText(FACEBOOKPASSWORD_TFLD,facebookPassword);
   }

	/**
	 * @Desc: Method used to click on facebook login button
	 */
	@Step("click on facebook login button")
	public void clickOnFacebookLoginBtn() {
		waitAndClickOn(FACEBOOKLOGIN_BTN);
	}

	/**
	 * @Desc: Method used to click on continue button
	 */
	@Step("click on continue button")
	public void clickOnContinueBtn() {
		waitAndClickOn(CONTINUE_BTN);
	}

	/**
	 * Method used to click on login using google
	 */
	@Step("click on login using Google")
	public void clickOnLoginUsingGoogle() {
		waitAndClickOn(LOGINUSINGGOOGLE_BTN);
	}

	/**
	 * @Desc: Method used to enter google email
	 * @param googleEmail
	 */
	@Step("enter Google email")
	public void enterGoogleEmail(String googleEmail) {
		waitAndSetText(EMAIL_TFLD,googleEmail);
		waitAndClickOn(NEXTBUTTON_BTN);
		WebUtil.sleep();

	}
	/**
	 * @Desc: Used to click on Next button
	 */
	@Step("Click on the Next Button")
	public void clickOnGmailNextButton() {
		waitAndClickOn(NEXTBUTTON_BTN);
		WebUtil.sleep();
	}

	/**
	 * @@Desc: Method used to enter google password
	 * @param googlePassword
	 */
	@Step("enter Google password")
	public void enterGooglePassword(String googlePassword) {

		WebDriverWaitUtils.waitUntilElementIsVisible(getLocator(GOOGLEPASSWORD_TFLD));
		WebUtil.setTextUsingAction(googlePassword);
		waitAndClickOn(NEXTBUTTON_BTN);
		WebUtil.longSleepForOnboarding();

	}

	/**
	 * @Desc: Fetch error message
	 * @return String
	 */
	@Step("get error message when logged in with google account in normal log in")
	public String fetchErrorMessage() {
		return getText(ERRORMESSAGE_TXT);
	}

	/**
	 * Method used to click on sign up for a free trial button
	 */
	@Step("click on signup for a free trial button")
	public void clickOnSignUpForAFreeTrialBtn() {
		waitAndClickOn(SIGNUPFREETRIAL_BTN);
	}

	/**
	 * @Desc: Method used to assert login header
	 * @return boolean
	 */
	@Step("check login page header")
	public boolean isLogInHeaderPresent() {
		return waitAndCheckIsElementDisplayed(LOGINH_BTN);
	}

	/**
	 * @Desc: Login to application
	 */
	@Step("Login to application")
	public void loginMethod(String email, String pwd) {
		clickOnMainLogin();
		enterEmail(email);
		enterPassword(pwd);
		clickOnLogin();
	}

	/**
	 * @Desc: Login to google account
	 */
	@Step("Login to google account")
	public void loginMethodUsingGoogle(String googleEmail, String googlePwd) {
		clickOnMainLogin();
		clickOnLoginUsingGoogle();
		enterGoogleEmail(googleEmail);
		clickOnGmailNextButton();
		WebUtil.sleep();
		enterGooglePassword(googlePwd);
		clickOnGmailNextButton();
	}

	/**
	 * @Desc: Login to Application Mobile App
	 */
	@Step("Login to application")
	public void loginMethodForMobile(String email, String pwd) {
		clickOnMainLogin();
		WebDriverWaitUtils.waitUntilElementIsPresent(getLocator(EMAIL_TXT));
		locateElement(EMAIL_TXT).sendKeys(email);
		WebDriverWaitUtils.waitUntilElementIsPresent(getLocator(PASSWORD_TXT));
		locateElement(PASSWORD_TXT).sendKeys(pwd);
		try {
			((SauronAppiumAndroidDriver) Grid.driver()).hideKeyboard();
		} catch (Exception e) {
		}
		clickOnLogin();

	}

	/**
	 * @Desc: Method used to get error message using xpath
	 */
	@Step("Get error message")
	public void verifyErrorMessage(String xpath) {
		String[] expectedErrorMsg = { "Fill out this field", "Please fill out this field.",
				"Please fill in this field.", "This is a required field" };
		List<String> errorMsgList = Arrays.asList(expectedErrorMsg);
		String errorMsgActual = getErrorMessage(xpath);
		assertTrue(errorMsgList.contains(errorMsgActual), "Error message displayed is not as expected");
	}

	/**
	 * @Desc: Click on Forgot Password link
	 */
	@Step("click on Forgot Password Link")
	public boolean assertForgotYourPasswordHdr() {
		return waitAndCheckIsElementDisplayed(FORGOT_PWD_HDR);
	}
}