package com.lulu.qa.web.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.lulu.qa.web.DataConfigConstants;
import com.lulu.qa.web.utils.WebUtil;

import io.qameta.allure.Step;

public class ManageMembersPage extends AbstractGoodRxPage {
	public static String MANAGEMEMBERS_BTN = "manageMembersbtn";
	public static String MANAGEMEMBERS_TXT = "manageMembersTxt";
	public static String PRIMARYMEMBER_TXT = "primaryMemberTxt";
	public static String ADDMEMBER_BTN = "addMemberbtn";
	public static String EDITPRIMARYMEMBERDETAILS_BTN = "editPrimaryMemberDetailsbtn";
	public static String EDITADDEDMEMBERS_BTN = "editAddedMember";
	public static String PRIMARYACCOUNTNAME_TXT = "primaryaccountname";
	public static String FIRSTNAME_TXT = "firstNameTxt";
	public static String LASTNAME_TXT = "lastNametxt";
	public static String MEMBERTYPE_DRP = "membertypeinfodrp";
	public static String BIRTHMONTH_DRP = "birthMonthdrp";
	public static String BIRTHDAY_DRP = "birthDaydrp";
	public static String BIRTHYEAR_DRP = "birthYeardrp";
	public static String MEMBERSAVE_BTN = "addMemberSavebtn";
	public static String ADDMEMBERCANCEL_BTN = "addmemberCancelbtn";
	public static String ADDMEMBERTXT = "addmembertxt";
	public static String OKAY_BTN = "okaybtn";
	public static String IAGREE_BTN = "iagreebtn";
	public static String DELETE_BTN = "deletebtn";
	public static String FIRSTNAMEERRORMESSAGE_TXT = "firstNameErrorMessagetxt";
	public static String LASTNAMEERRORMESSAGE_TXT = "lastnameerrormessagetxt";
	public static String PRIMARYACCOUNTDETAILSUPDATED_TXT = "primaryaccountdetailsupdatetxt";
	public static String ADDMEMBERDELETE_BTN = "addMemberDeleteBtn";
	public static String CONFIRMDELETEMEMBERS_BTN = "confirmdeletememberbtn";
	public static String ADDEDMEMBERACCOUNTNAME_TXT = "addedmemberaccountname";
	public static String SPOUSEMINORERRORMESSAGE_TXT = "spouseminorerrortxt";
	public static String SHAREMYPERSONALINFO_ChECKBOX = "sharemypersonalinfocheckbx";
	public static String REVOKEACCESS_BTN = "revokeaccessbtn";
	public static String REVOKEACCESSSUCCESS_TXT = "revokeaccesssuccestxt";
	public static String MEMBERSUPDATESUCCES_TXT = "membersupdatesuccestxt";
	public static String INFOPOPUP_BTN = "infopopupbtn";
	public static String MEMBERSCOUNT_TXT = "memberscounttxt";
	public static String MAXMEMBERREACHED_TXT = "maxmembertxt";
	public static String MEMBERSHIPPAGE_HEADER = "memberShipHdr";

	/**
	 * @Desc:clearing the text and updating the FirstName and LastName of the
	 *                account details (Primary/Added Members)
	 * 
	 * @return firstname & lastname
	 */
	@Step("Method to Edit the first name and LastName of the account details")
	public String editFirstNameAndLastName(String firstname, String lastname) {
		try {
			waitAndSetText(FIRSTNAME_TXT,firstname);
		} catch (Exception e) {
		}
		try {
			waitAndSetText(LASTNAME_TXT,lastname);
		} catch (Exception e) {
		}
		return firstname + " " + lastname;
	}

	/**
	 * @Desc:Select Value from drop down
	 * @param xpath
	 * @param State Selection
	 */
	@Step("Select Value from Dropdown")
	public void selectByIndexFromDropDown(String xpath, int indexOfMember) {
		Select drpState = new Select(locateElement(xpath));
		List<WebElement> listOfItems = drpState.getOptions();
		int totalDropDownItems = listOfItems.size();
		drpState.selectByIndex((totalDropDownItems - indexOfMember));
	}

	/**
	 * @Desc:Select MemberType from drop down
	 * @param xpath
	 * @param State Selection
	 */
	@Step("Select MemberType from drop down")
	public void selectMemberTypeDropdown(int indexOfMember) {
		try {
			waitUntilElementIsPresent(MEMBERTYPE_DRP);
			selectByIndexFromDropDown(MEMBERTYPE_DRP, indexOfMember);
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
	public void selectDOBDropdown(int monthIndex, int dateIndex, int yearIndex) {
		try {
			selectByIndexFromDropDown(BIRTHMONTH_DRP, monthIndex);
		} catch (Exception e) {
		}
		try {
			selectByIndexFromDropDown(BIRTHDAY_DRP, dateIndex);
		} catch (Exception e) {
		}
		try {
			selectByIndexFromDropDown(BIRTHYEAR_DRP, yearIndex);
		} catch (Exception e) {
		}
	}


	/**
	 * @Desc:Deleting one Family Member
	 */
	@Step("Deleting  one Family Member from the Account")
	public String deleteOneFamilyMembers() {
		String[] h = new String[2];
		try {
			String h1 = waitAndGetText(ADDEDMEMBERACCOUNTNAME_TXT);
			waitAndClickOn(ADDMEMBERDELETE_BTN);
			waitAndClickOn(CONFIRMDELETEMEMBERS_BTN);
			return h1;
		} catch (Exception f) {
			for (int y = 0; y < 3; y++) {
				waitAndClickOn(ADDMEMBER_BTN);
				selectMemberTypeDropdown(Integer.parseInt(DataConfigConstants.MEMBERTYPEDRPDWN_TXT));
				selectDOBDropdown(WebUtil.getDropDownMonth(), WebUtil.getDateDropDown(),
						Integer.parseInt(DataConfigConstants.DATEOFBIRTHMAJORYEAR_TXT));
				h[y] = addMembersDetailsCommon(DataConfigConstants.SAVE_TXT, WebUtil.randomName(5),
						WebUtil.randomName(5), DataConfigConstants.NO_TXT);
			}
			waitAndClickOn(ADDMEMBERDELETE_BTN);
			waitAndClickOn(CONFIRMDELETEMEMBERS_BTN);
			return h[0];
		}
	}

	/**
	 * @Desc:Retrieving added member name from the Account
	 * 
	 * @return
	 */
	@Step("Retrieving added member name from the Account")
	public String getAddedMemberAccountName() {
		try {
			return waitAndGetText(ADDEDMEMBERACCOUNTNAME_TXT);
		} catch (Exception j) {
			return "";
		}
	}

	/**
	 * @Desc:Deleting all the Added Members
	 */
	@Step("Deleting all the added Members from the Account")
	public void deleteAddedMembers() {
		try {
			if (waitAndCheckIsElementDisplayed(ADDMEMBERDELETE_BTN)) {
				List<WebElement> l = locateElements(ADDMEMBERDELETE_BTN);
				for (int i = 0; i <= l.size(); i++) {
					locateElements(ADDMEMBERDELETE_BTN).get(0).click();
					waitAndClickOn(CONFIRMDELETEMEMBERS_BTN);
				}
			}
		} catch (Exception h) {

		}
	}

	/**
	 * @Desc:checking count of the Added Members Present
	 */
	@Step("Method to check count of the Added Members Present")
	public int checkCountOfAddedMembersPresent() {
		List<WebElement> l = new ArrayList<WebElement>();
		try {
			l = locateElements(ADDMEMBERDELETE_BTN);
			return l.size();
		} catch (Exception h) {
			waitAndClickOn(ADDMEMBER_BTN);
			selectMemberTypeDropdown(Integer.parseInt(DataConfigConstants.MEMBERTYPEDRPDWN_TXT));
			selectDOBDropdown(WebUtil.getDropDownMonth(), WebUtil.getDateDropDown(),
					Integer.parseInt(DataConfigConstants.DATEOFBIRTHMAJORYEAR_TXT));
			addMembersDetailsCommon(DataConfigConstants.SAVE_TXT, WebUtil.randomName(5), WebUtil.randomName(5),
					DataConfigConstants.NO_TXT);
			return 1;
		}
	}

	/**
	 * @Desc:checking count of the Added Members Present and update the Members
	 */
	@Step("Method to check count of the Added Members Present and update the Members")
	public void checkCountOfAddedMembersPresentAndUpdate() {
		List<WebElement> ele = new ArrayList<WebElement>();
		try {
			ele = locateElements(ADDMEMBERDELETE_BTN);
			if (ele.size() >= 1) {
				waitAndClickOn(EDITADDEDMEMBERS_BTN);
				addMembersDetailsCommon(DataConfigConstants.SAVE_TXT, WebUtil.randomName(5), WebUtil.randomName(5),
						DataConfigConstants.NO_TXT);
			}
		} catch (Exception j) {
			waitAndClickOn(ADDMEMBER_BTN);
			selectMemberTypeDropdown(Integer.parseInt(DataConfigConstants.MEMBERTYPEDRPDWN_TXT));
			selectDOBDropdown(WebUtil.getDropDownMonth(), WebUtil.getDateDropDown(),
					Integer.parseInt(DataConfigConstants.DATEOFBIRTHMAJORYEAR_TXT));
			addMembersDetailsCommon(DataConfigConstants.SAVE_TXT, WebUtil.randomName(5), WebUtil.randomName(5),
					DataConfigConstants.NO_TXT);
			waitAndClickOn(EDITADDEDMEMBERS_BTN);
			addMembersDetailsCommon(DataConfigConstants.SAVE_TXT, WebUtil.randomName(5), WebUtil.randomName(5),
					DataConfigConstants.NO_TXT);
		}

	}

	/**
	 * @Desc:Retrieve the count of the Members text
	 */
	@Step("Method to Retrieve the count of the Members text")
	public int getCountOfMembers() {
		try {
			String text = waitAndGetText(MEMBERSCOUNT_TXT);
			return Integer.parseInt(text);
		} catch (Exception exception) {
			return 0;
		}
	}

	


	/**
	 * @Desc:Clicking on Cancel button to add the member details
	 */
	@Step("Click on Cancel Button")
	public void addMemberClickOnCancel() {
		waitUntilElementIsPresent(ADDMEMBERCANCEL_BTN);
		locateElement(ADDMEMBERCANCEL_BTN).click();
	}

	/**
	 * @Desc:Clicking on Okay button to add the member details
	 */
	@Step("Click on Okay button")
	public void clickOnOkay() {
		WebUtil.sleep();
		waitAndClickOn(OKAY_BTN);
	}


	/**
	 * @Desc:Checkk whether the delete Primary Member is disabled
	 */
	@Step("Check the Delete Button is disabled")
	public String deleteButtonDisabled() {
		waitUntilElementIsPresent(DELETE_BTN);
		return locateElement(DELETE_BTN).getAttribute("class");
	}

	/**
	 * @Desc:Adding the details to add members
	 */
	@Step("Details to add the Members")
	public String addMembersDetailsCommon(String button, String firstName, String lastName,
			String shareMyPersonalInfoChckbx) {
		String j = editFirstNameAndLastName(firstName, lastName);
		if (shareMyPersonalInfoChckbx.equalsIgnoreCase("yes")) {
			waitAndClickOn(ManageMembersPage.SHAREMYPERSONALINFO_ChECKBOX);
		}
		if (button.equalsIgnoreCase("save")) {
			clickOn(MEMBERSAVE_BTN);
		} else {
			addMemberClickOnCancel();
		}
		return j;
	}
}