package com.lulu.qa.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.lulu.qa.AbstractGoldQaTest;
import com.lulu.qa.web.ConfigConstants;
import com.lulu.qa.web.DataConfigConstants;
import com.lulu.qa.web.pages.AbstractGoodRxPage;
import com.lulu.qa.web.pages.AccountPage;
import com.lulu.qa.web.pages.ManageMembersPage;
import com.lulu.qa.web.utils.WebUtil;
import com.qapitol.sauron.annotations.SauronTest;
import com.qapitol.sauron.configuration.Config;
import com.qapitol.sauron.platform.utilities.WebDriverWaitUtils;

public class TestManageMembers extends AbstractGoldQaTest {

	@SauronTest
	@Test(description = " TC54: Verify clicking on Manage members option", groups = { "All" })
	public void clickOnManageMembers() {
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
		if (!AbstractGoodRxPage.getTargetClient().equalsIgnoreCase("mweb")) {
			hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		}		
		managemember.waitAndClickOn(ManageMembersPage.MANAGEMEMBERS_BTN);
		assertTrue(managemember.waitAndCheckIsElementDisplayed(ManageMembersPage.ADDMEMBER_BTN),
				"Add Member button is not present in the Members Page");
		assertEquals(managemember.waitAndGetText(ManageMembersPage.PRIMARYMEMBER_TXT),
				DataConfigConstants.PRIMARY_MEMBER, "Primary Member text is not displayed in the Members page");
		assertEquals(managemember.getText(ManageMembersPage.MANAGEMEMBERS_TXT), "Manage Members",
				"Manage Member header text is not displayed in the Members page");
		assertTrue(managemember.waitAndCheckIsElementDisplayed(ManageMembersPage.EDITPRIMARYMEMBERDETAILS_BTN),
				"Edit Primary account details button is not present");
	}

	@SauronTest
	@Test(description = " TC55: Verify user can delete primary account", groups = { "All" })
	public void deletePrimaryAccount() {
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
		if (!AbstractGoodRxPage.getTargetClient().equalsIgnoreCase("mweb")) {
			hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		}
		managemember.waitAndClickOn(ManageMembersPage.MANAGEMEMBERS_BTN);
		assertEquals(managemember.waitAndGetText(ManageMembersPage.PRIMARYMEMBER_TXT),
				DataConfigConstants.PRIMARY_MEMBER);
		assertEquals(managemember.deleteButtonDisabled(), "action icon icon-delete-trashcan disabled text-neutral",
				"Delete button is enabled for Primary Account");

	}

	@SauronTest
	@Test(description = " TC56: Verify editing/updating primary account", groups = { "All" })
	public void updatePrimaryAccount() {
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
		if (!AbstractGoodRxPage.getTargetClient().equalsIgnoreCase("mweb")) {
			hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		}
		managemember.waitAndClickOn(ManageMembersPage.MANAGEMEMBERS_BTN);
		managemember.waitAndClickOn(ManageMembersPage.EDITPRIMARYMEMBERDETAILS_BTN);
		managemember.selectDOBDropdown(WebUtil.getDropDownMonth(), WebUtil.getDateDropDown(),
				Integer.parseInt(DataConfigConstants.DATEOFBIRTHMAJORYEAR_TXT));
		WebUtil.scrollDownWeb(300);
		managemember.waitAndClickOn(ManageMembersPage.MEMBERSAVE_BTN);
		assertTrue(managemember.waitAndCheckIsElementDisplayed(ManageMembersPage.MEMBERSUPDATESUCCES_TXT));

	}

	@SauronTest
	@Test(description = " TC57: Verify clicking on Add a member button", groups = { "All" })
	public void addingtheFamilymembers() {
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
		if (!AbstractGoodRxPage.getTargetClient().equalsIgnoreCase("mweb")) {
			hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		}
		managemember.waitAndClickOn(ManageMembersPage.MANAGEMEMBERS_BTN);
		managemember.deleteAddedMembers();
		managemember.waitAndClickOn(ManageMembersPage.ADDMEMBER_BTN);
		managemember.selectMemberTypeDropdown(Integer.parseInt(DataConfigConstants.MEMBERTYPEDRPDWN_TXT));
		managemember.selectDOBDropdown(WebUtil.getDropDownMonth(), WebUtil.getDateDropDown(),
				Integer.parseInt(DataConfigConstants.DATEOFBIRTHMAJORYEAR_TXT));
		String addedMemberName = managemember.addMembersDetailsCommon(DataConfigConstants.SAVE_TXT,
				WebUtil.randomName(5), WebUtil.randomName(5), DataConfigConstants.NO_TXT);
		assertEquals(managemember.getAddedMemberAccountName(), addedMemberName,
				"Added Member details are not updated in the Members page");

	}

	@SauronTest
	@Test(description = " TC59: Verify Cancel functionality of Add member page", groups = { "All" })
	public void clickOnCancelButtonbyAddingDetailsofMember() {
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
		if (!AbstractGoodRxPage.getTargetClient().equalsIgnoreCase("mweb")) {
			hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		}
		managemember.waitAndClickOn(ManageMembersPage.MANAGEMEMBERS_BTN);
		managemember.deleteAddedMembers();
		managemember.waitAndClickOn(ManageMembersPage.ADDMEMBER_BTN);
		String addedMemberName = managemember.addMembersDetailsCommon("cancel", WebUtil.randomName(4),
				WebUtil.randomName(5), DataConfigConstants.NO_TXT);
		assertNotEquals(managemember.getAddedMemberAccountName(), addedMemberName,
				"Member gets added when user click on Cancel button after entering the details");
	}

	@SauronTest
	@Test(description = " TC60: Verify Adding Member keeping Fname blank", groups = { "All" })
	public void addMemberWithFnameBlank() {
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
		if (!AbstractGoodRxPage.getTargetClient().equalsIgnoreCase("mweb")) {
			hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		}
		managemember.waitAndClickOn(ManageMembersPage.MANAGEMEMBERS_BTN);
		managemember.deleteAddedMembers();
		managemember.waitAndClickOn(ManageMembersPage.ADDMEMBER_BTN);
		managemember.selectMemberTypeDropdown(Integer.parseInt(DataConfigConstants.MEMBERTYPEDRPDWN_TXT));
		managemember.selectDOBDropdown(WebUtil.getDropDownMonth(), WebUtil.getDateDropDown(),
				Integer.parseInt(DataConfigConstants.DATEOFBIRTHMAJORYEAR_TXT));
		managemember.addMembersDetailsCommon(DataConfigConstants.SAVE_TXT, "", WebUtil.randomName(5),
				DataConfigConstants.NO_TXT);
		assertEquals(managemember.waitAndGetText(ManageMembersPage.FIRSTNAMEERRORMESSAGE_TXT),
				"First Name: Please enter a value",
				"Erorr message is not displayed while adding the member by keeping FName blank");

	}

	@SauronTest
	@Test(description = " TC61: Verify Adding Member keeping Lname blank", groups = { "All" })
	public void addMemberWithLnameBlank() {
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
		if (!AbstractGoodRxPage.getTargetClient().equalsIgnoreCase("mweb")) {
			hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		}
		managemember.waitAndClickOn(ManageMembersPage.MANAGEMEMBERS_BTN);
		managemember.deleteAddedMembers();
		managemember.waitAndClickOn(ManageMembersPage.ADDMEMBER_BTN);
		managemember.selectMemberTypeDropdown(Integer.parseInt(DataConfigConstants.MEMBERTYPEDRPDWN_TXT));
		managemember.selectDOBDropdown(WebUtil.getDropDownMonth(), WebUtil.getDateDropDown(),
				Integer.parseInt(DataConfigConstants.DATEOFBIRTHMAJORYEAR_TXT));
		managemember.addMembersDetailsCommon(DataConfigConstants.SAVE_TXT, WebUtil.randomName(5), "",
				DataConfigConstants.NO_TXT);
		assertEquals(managemember.waitAndGetText(ManageMembersPage.LASTNAMEERRORMESSAGE_TXT),
				"Last Name: Please enter a value",
				"Erorr message is not displayed while adding the member by keeping LName blank");

	}

	@SauronTest
	@Test(description = " TC62: Verify adding Member as a spouse selecting DOB less than 18 yrs", priority = 48, groups = {
			"All"})
	public void addingtheMemberspouseMinor() {
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
		if (!AbstractGoodRxPage.getTargetClient().equalsIgnoreCase("mweb")) {
			hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		}
		managemember.waitAndClickOn(ManageMembersPage.MANAGEMEMBERS_BTN);
		managemember.deleteAddedMembers();
		managemember.waitAndClickOn(ManageMembersPage.ADDMEMBER_BTN);
		managemember.selectMemberTypeDropdown(3);
		managemember.addMembersDetailsCommon(DataConfigConstants.SAVE_TXT, WebUtil.randomName(5), WebUtil.randomName(5),
				DataConfigConstants.NO_TXT);
		managemember.selectDOBDropdown(WebUtil.getDropDownMonth(), WebUtil.getDateDropDown(),
				Integer.parseInt(DataConfigConstants.DATEOFBIRTHMINORYEAR_TXT));
		WebUtil.sleep();
		managemember.waitAndClickOn(ManageMembersPage.OKAY_BTN);
		assertTrue(managemember.waitAndCheckIsElementDisplayed(ManageMembersPage.SPOUSEMINORERRORMESSAGE_TXT),
				"Error message is not displayed while adding the Spouse by selecting DOB less than 18");
	}

	@SauronTest
	@Test(description = " TC63: Verify deleting existing profile", groups = { "All" })
	public void deleteExistingProfile() {
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
		if (!AbstractGoodRxPage.getTargetClient().equalsIgnoreCase("mweb")) {
			hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		}
		managemember.waitAndClickOn(ManageMembersPage.MANAGEMEMBERS_BTN);
		String deleteAccountName = managemember.deleteOneFamilyMembers();
		assertNotEquals(deleteAccountName, managemember.getAddedMemberAccountName(),
				"Deleted Account is still displaying in the Members Page");
	}

	@SauronTest
	@Test(description = " TC65: Verify editing the additional member profile", groups = { "All" })
	public void editingAdditionalMembersProfile() {
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
		if (!AbstractGoodRxPage.getTargetClient().equalsIgnoreCase("mweb")) {
			hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		}
		managemember.waitAndClickOn(ManageMembersPage.MANAGEMEMBERS_BTN);
		managemember.checkCountOfAddedMembersPresent();
		managemember.clickOn(ManageMembersPage.EDITADDEDMEMBERS_BTN);
		managemember.addMembersDetailsCommon(DataConfigConstants.SAVE_TXT, WebUtil.randomName(5), WebUtil.randomName(5),
				DataConfigConstants.NO_TXT);
		assertTrue(managemember.waitAndCheckIsElementDisplayed(ManageMembersPage.MEMBERSUPDATESUCCES_TXT),
				"No success message is displayed after updating the members profile and members details are not updated");

	}

	@SauronTest
	@Test(description = " TC66: Verify Revoke Access", groups = { "All" })
	public void revokeAccessFromMembers() {
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
		if (!AbstractGoodRxPage.getTargetClient().equalsIgnoreCase("mweb")) {
			hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		}
		managemember.waitAndClickOn(ManageMembersPage.MANAGEMEMBERS_BTN);
		managemember.deleteAddedMembers();
		managemember.waitAndClickOn(ManageMembersPage.ADDMEMBER_BTN);
		managemember.selectMemberTypeDropdown(2);
		managemember.addMembersDetailsCommon(DataConfigConstants.SAVE_TXT, WebUtil.randomName(5), WebUtil.randomName(5),
				DataConfigConstants.YES_TXT);
		managemember.selectDOBDropdown(WebUtil.getDropDownMonth(), WebUtil.getDateDropDown(),
				Integer.parseInt(DataConfigConstants.DATEOFBIRTHMAJORYEAR_TXT));
		WebUtil.sleepForAccount();
		managemember.waitAndClickOn(ManageMembersPage.OKAY_BTN);
		WebUtil.longSleepForOnboarding();
		managemember.waitAndClickOn(ManageMembersPage.REVOKEACCESS_BTN);
		assertTrue(managemember.waitAndCheckIsElementDisplayed(ManageMembersPage.REVOKEACCESSSUCCESS_TXT),
				"No success message is displayed after clicking on Revoke Access button");

	}

	@SauronTest
	@Test(description = " TC67: Verify the info icons displayed", groups = { "All" })
	public void checkInfoIconsPresence() {
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
		if (!AbstractGoodRxPage.getTargetClient().equalsIgnoreCase("mweb")) {
			hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		}
		managemember.waitAndClickOn(ManageMembersPage.MANAGEMEMBERS_BTN);
		managemember.deleteAddedMembers();
		managemember.waitAndClickOn(ManageMembersPage.ADDMEMBER_BTN);
		managemember.selectMemberTypeDropdown(Integer.parseInt(DataConfigConstants.MEMBERTYPEDRPDWN_TXT));
		managemember.addMembersDetailsCommon(DataConfigConstants.SAVE_TXT, WebUtil.randomName(4), WebUtil.randomName(5),
				DataConfigConstants.NO_TXT);
		managemember.selectDOBDropdown(WebUtil.getDropDownMonth(), WebUtil.getDateDropDown(),
				Integer.parseInt(DataConfigConstants.DATEOFBIRTHMAJORYEAR_TXT));
		assertTrue(managemember.waitAndCheckIsElementDisplayed(ManageMembersPage.INFOPOPUP_BTN),
				"Info popup is not displayed in the Members Page");

	}

	@SauronTest
	@Test(description = " TC70: Verify the count of members added is displayed", groups = { "All" })
	public void checkCountOfMembers() {
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
		if (!AbstractGoodRxPage.getTargetClient().equalsIgnoreCase("mweb")) {
			hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		}
		managemember.waitAndClickOn(ManageMembersPage.MANAGEMEMBERS_BTN);
		int i = managemember.checkCountOfAddedMembersPresent();
		hamburgerPage.clickOnHamburgerIcon();
		hamburgerPage.clickOnAccountLink();
		assertEquals(managemember.getCountOfMembers() - 1, i, "Count of members added is displayed incorrectly");
	}

	@SauronTest
	@Test(description = "TC:04 -> Verify Page Navigating to Plan Selection Page", groups = { "Android" })
	public void testChooseMembershipHighlighted() throws Exception {
		loginPage.loginMethodForMobile("mt@qapitol.com", "Qwerty1985");
		WebDriverWaitUtils.waitUntilElementIsPresent(managemember.getLocator(ManageMembersPage.MEMBERSHIPPAGE_HEADER));
		assertTrue(managemember.waitAndCheckIsElementDisplayed(ManageMembersPage.MEMBERSHIPPAGE_HEADER),
				"Membership Page was not displayed");
	}

	// TC 58 and 68 are blocked for Execution because of 500 Error
	// @SauronTest
	// @Test(description = " TC58: Verify Adding Member using valid
	// details(including a pet, or partner or child)")
	public void addingTheMemberUsingValidDetails() {
		loginPage.loginMethod(Config.getConfigProperty(ConfigConstants.lulu_USERNAME),
				Config.getConfigProperty(ConfigConstants.lulu_PASSWORD));
		hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		managemember.waitAndClickOn(ManageMembersPage.MANAGEMEMBERS_BTN);
		managemember.waitAndClickOn(ManageMembersPage.ADDMEMBER_BTN);
		managemember.selectMemberTypeDropdown(3);
		managemember.selectDOBDropdown(WebUtil.getDropDownMonth(), WebUtil.getDateDropDown(),
				Integer.parseInt(DataConfigConstants.DATEOFBIRTHMAJORYEAR_TXT));
		managemember.addMembersDetailsCommon(DataConfigConstants.SAVE_TXT, WebUtil.randomName(5), "",
				DataConfigConstants.NO_TXT);

	}

	// @SauronTest
	// @Test(description = " TC68: Verify if the additional member is less than 13
	// yrs old")
	public void verifyByAddingAMemberLessThan13YrsOld() {
		loginPage.loginMethod(Config.getConfigProperty(ConfigConstants.lulu_USERNAME),
				Config.getConfigProperty(ConfigConstants.lulu_PASSWORD));
		hamburgerPage.clickOnHamburgerIconAndClickOnAccount();
		managemember.waitAndClickOn(ManageMembersPage.MANAGEMEMBERS_BTN);
		managemember.waitAndClickOn(ManageMembersPage.ADDMEMBER_BTN);
		managemember.selectMemberTypeDropdown(2);
		managemember.selectDOBDropdown(WebUtil.getDropDownMonth(), WebUtil.getDateDropDown(),
				Integer.parseInt(DataConfigConstants.DATEOFBIRTHMINORYEAR_TXT));
		managemember.addMembersDetailsCommon(DataConfigConstants.SAVE_TXT, WebUtil.randomName(5), "",
				DataConfigConstants.NO_TXT);
	}

}
