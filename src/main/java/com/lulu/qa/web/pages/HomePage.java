package com.lulu.qa.web.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.lulu.qa.web.ConfigConstants;
import com.lulu.qa.web.utils.WebUtil;
import com.qapitol.sauron.configuration.Config;

import io.qameta.allure.Step;

public class HomePage extends AbstractGoodRxPage {

	public static final String LOCATIONLABEL_BTN = "locationLabelBtn";
	public static final String DELIVERYLOCATION_DIALOG = "deliveryLocationDialog";
	public static final String POPUP_BTN = "popupBtn";
	public static final String COUNTRYBAHRAIN_ICN = "countryBahrainIcon";
	public static final String COUNTRYUAE_ICN = "countryUAEIcon";
	public static final String UAECITY_DRDW = "uaeCityDropDown";
	public static final String UAECITYAJMAN_BTN = "uaeCityAjmanBtn";
	public static final String STARTYOURFREETRAIL_BTN = "startFreeTrailBtn";
	public static final String PHARMACYDIRECTORY_TAB = "pharmacyDirectoryTab";
	public static final String FULLLISTOFPHARMACY_LINK = "fullListOfPharmacy";
	public static final String ALBERTSONS_TXT = "albertsons";
	public static final String EMAILFIELD_TFLD = "emailTxt";
	public static final String NEXTBUTTON_BTN = "gmailNextButton";
	public static final String PASSWORD_TFLD = "passwordTxt";
	public static final String LOGIN_BTN = "loginBTN";
	public static final String LOGINENTER_BTN = "logInButton";
	public static final String LOGOGOOD_BTN = "goodRxLogo";
	public static final String HAMBURGER_ICN = "hamburgerIcon";
	public static final String GETSTARTEDGOLD_TXT = "getStartedWithGoodRx";
	public static final String ERROMESSAGEINVALID_TXT = "invalidErrorMessage";
	public static final String HAMBURGERADDITIONAL_TXT = "additionalBenefits";
	public static final String GOOGLE_ICN = "googleIcon";
	public static final String INDIVIDUAL_TXT = "individualTxt";
	public static final String ACME_TXT = "acmeMarkets";
	public static final String KING_SOOOPERS_TXT = "krogerPharmacy";
	public static final String JAYC_TXT = "jayC";
	public static final String WINN_TXT = "winnDixie";
	public static final String EMAIL_TXT = "googleEmail";
	public static final String PASSWORD_TXT = "gmailPassword";
	public static final String CREATEACCOUNT_LNK = "createAccountLnk";
	public static final String LOGINTOPRIGHT_BTN = "logInButton";
	public static final String LIST_OF_PHARMACHIES = "lisofpharmacies";
	public static final String PHARMACY_LINK_TEXT = "pharmacyLinkText";
	public static final String FIND_A_DRUG_PRICE = "findADrugPrice";
	public static final String TYPEAHEAD_SUGGESTION = "typeaheadSuggestion";
	/**
	 * @Desc: Enter the email id
	 * 
	 * @Param: Email
	 **/
	@Step("enter email")
	public void enterUserName(String userName) {
		setText(EMAIL_TXT, userName);
	}

	/**
	 * @Desc: Enter the Password
	 * 
	 * @Param: Password
	 **/
	@Step("enter password")
	public void enterPassword(String password) {
		setText(PASSWORD_TXT, password);
	}

	/**
	 * @Desc: Click on Start Button
	 **/
	@Step("Click on 'Start your trial'")
	public void clickOnStartButton() {
		waitAndClickOn(STARTYOURFREETRAIL_BTN);
	}

	/**
	 * @Desc: Click on 'Pharmacy Directory'
	 **/
	@Step("Click on 'Pharmacy Directory'")
	public void clickOnPharmacy() {
		waitAndClickOn(PHARMACYDIRECTORY_TAB);
	}

	/**
	 * @Desc: Click on 'Google' icon
	 **/
	@Step("Click on the 'Google' icon")
	public void clickOnGoogle() {
		waitAndClickOn(GOOGLE_ICN);
	}

	/**
	 * @Desc: Click on Full List of Pharmacy
	 **/
	@Step("Click on full list of Pharmacy")
	public void clickOnFullListOfPharamcy() {
		waitAndClickOn(FULLLISTOFPHARMACY_LINK);
	}

	/**
	 * @Desc: Click on 'Login' hyperlink text
	 **/
	@Step("Click on 'Login' hyperlink text")
	public void clickOnLogin() {
		waitAndClickOn(LOGIN_BTN);
	}

	/**
	 * @Desc: Click on Login Button at right top
	 **/
	@Step("Click on Login Button at right top")
	public void clickOnLoginRightTop() {
		waitAndClickOn(LOGINTOPRIGHT_BTN);
	}

	/**
	 * @Desc: Click on 'Create Account' button
	 **/
	@Step("Click on 'Create Account' hyperlink")
	public void clickOnCreateAccount() {		
		waitAndClickOn(CREATEACCOUNT_LNK);
	}

	/**
	 * @Desc: Enter the email id in email field
	 * 
	 * @Param: Email ID
	 **/
	@Step("Enter the email id in the email field")
	public void enterEmailID() {
		waitUntilElementIsPresent(EMAIL_TXT);
		setText(EMAIL_TXT, Config.getConfigProperty(ConfigConstants.EMAILIDMEMBERSHIP));
	}

	/**
	 * @Desc: Enter the invalid id in email field
	 * 
	 * @Param: Invalid Email ID
	 **/
	@Step("Enter the Invalid email id in the email field")
	public void enterEmailIDInvalid() {
		waitUntilElementIsPresent(EMAILFIELD_TFLD);
		setText(EMAILFIELD_TFLD ,Config.getConfigProperty(ConfigConstants.EMAILID));
	}

	/**
	 * @Desc: Enter the password in password field
	 * 
	 * @Param: Password
	 **/
	@Step("Enter the password in the password field")
	public void enterPassword() {
		waitUntilElementIsPresent(PASSWORD_TXT);
		setText(PASSWORD_TXT, Config.getConfigProperty(ConfigConstants.LOGINPASSWORD));
	}

	/**
	 * @Desc: Get text of Message of type of Membership
	 * 
	 * @Return: String
	 **/
	@Step("Get text of Message of type of Membership")
	public String getTextOfMessage() {
		return waitAndGetText(INDIVIDUAL_TXT);
	}

	/**
	 * @Desc: Enter the invalid password in password field
	 * 
	 * @Param: InValidPassword
	 **/
	@Step("Enter the password in the invalid password field")
	public void enterPasswordInvalid() {
		waitUntilElementIsPresent(PASSWORD_TFLD);
		setText(PASSWORD_TFLD, Config.getConfigProperty(ConfigConstants.LOGINPASSWORDINVALID));
	}

	/**
	 * @Desc: Click on Login Button
	 **/
	@Step("Click on 'Login' hyperlink")
	public void clickOnLoginButton() {
		waitAndClickOn(LOGINENTER_BTN);
	}

	/**
	 * @Desc: Click on logo of GoodRx
	 **/
	@Step("Click on the logo of GoodRx")
	public void clickOnGoodRxLogo() {
		waitAndClickOn(LOGOGOOD_BTN);
	}

	/**
	 * @Desc: Click on the hamburger icon of GoodRx
	 **/
	@Step("Click on the Hamburger of GoodRx")
	public void clickOnHamburger() {
		waitAndClickOn(HAMBURGER_ICN);
	}

	/**
	 * @Desc: Fetching the Text of Error message
	 * 
	 * @Return: String
	 **/
	@Step("Fetching the Text from Error message")
	public String getTextOfElementOfErrorMessage() {
		return waitAndGetText(ERROMESSAGEINVALID_TXT);
	}

	/**
	 * @Desc: Fetching the value of Additional Benefits
	 * 
	 * @Return: String
	 **/
	@Step("Fetching the value from addition benefits")
	public String getTextOfAdditionalBenefits() {
		return waitAndGetText(HAMBURGERADDITIONAL_TXT);
	}

	/**
	 * @Desc: Method is used to get text of Drug Name
	 * @return: String
	 */
	@Step("Get text of Drug Name")
	public String getTextOfDrugName() {
		return waitAndGetText(ALBERTSONS_TXT);
	}

	/**
	 * @Desc: Used to click on Next button
	 */
	@Step("Click on the Next Button")
	public void clickOnGmailNextButton() {
		waitAndClickOn(NEXTBUTTON_BTN);
	}

	/**
	 * @Desc: Used to get text of Landing page
	 * @return: String
	 */
	@Step("Get the information of the prescriptions")
	public String getTextOfLandingPage() {
		return waitAndGetText(GETSTARTEDGOLD_TXT);
	}

	/**
	 * @Desc: get Text Of element
	 * @return: String
	 */
	@Step("get Text Of element")
	public String getText(String element) {
		return waitAndGetText(element);
	}

	/**
	 * @Desc: Common Method which is used for Gmail Login
	 * @return: String
	 */
	@Step("Common method for Gmail Login")
	public void commonGmailAccount() {
		waitAndClickOn(STARTYOURFREETRAIL_BTN);
		waitAndClickOn(LOGIN_BTN);
		waitAndClickOn(GOOGLE_ICN);
		enterEmailID();
		waitAndClickOn(NEXTBUTTON_BTN);
		WebUtil.sleep();
		enterPassword();
		waitAndClickOn(NEXTBUTTON_BTN);
		WebUtil.sleep();
	}

	/**
	 * @Desc: Verifying if hamburger menu is open
	 * 
	 * @Return: boolean
	 **/
	@Step("Verifying if hamburger menu is open")
	public void verifyIfHamBurgerMenuIsOpen() {
		waitUntilElementIsPresent("navbarSupportedContent");
		String attributevalue = locateElement("navbarSupportedContent").getAttribute("class");
		assertEquals(attributevalue, "navbar-collapse show");
	}

	/**
	 * @Desc: Get List of Pharmacies
	 * @return: List
	 */
	public List<String> getpharmacyListtext() {
		List<WebElement> elements = locateElements(LIST_OF_PHARMACHIES);
		ArrayList<String> pharmacyText = new ArrayList<String>();
		if (getTargetClient().equalsIgnoreCase("android")) {
		for (int i = 0; i < elements.size(); i++) {
			String text = elements.get(i).getText();
			pharmacyText.add(text);
		}
		} else {
			for (int i = 0; i < elements.size(); i++) {
				String text = elements.get(i).getAttribute("alt");
				System.out.println(text);
				pharmacyText.add(text);
			}
		}
		return pharmacyText;
	}

	/**
	 * @Desc: Verify The List Of Pharmacies
	 * @return: boolean
	 */
	@Step("Verify The List Of Pharmacies")
	public void verifyListOFParmacies(String[] expectedPharmacy) {
		List<String> expectedList = Arrays.asList(expectedPharmacy);
		List<String> actualList = getpharmacyListtext();
		assertTrue(actualList.equals(expectedList), "The List of Pharmacies is not as expected");
	}

	/**
	 * @Desc: Click Pharmacy link
	 */
	@Step("Click on Pharmacy Link Text")
	public void clickPharmacyLinkText() {
		waitAndClickOn(PHARMACY_LINK_TEXT);
	}

}
