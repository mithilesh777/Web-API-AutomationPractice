package com.lulu.qa.web.pages;

import static org.testng.Assert.assertTrue;

import com.lulu.qa.web.utils.WebUtil;
import io.qameta.allure.Step;

public class DrugLookUpPage extends AbstractGoodRxPage {
	public static final String DRUGLOOKUP_LNK = "druglookuplink";
	public static final String DRUGNAME_TFLD = "drugnametextfield";
	public static final String SEARCH_ICN = "searchicn";
	public static final String RESULT_TXT = "resulttext";
	public static final String DRUGINFORMATION_TXT = "druginformationtext";
	public static final String SIGNUPFREETRIAL_BTN = "signUpFreeTrialBtn";
	public static final String DRUG_LOOKUP_PAGE = "drugLookUpPage";	

	/**
	 * @Desc:Get the text of warning message
	 */
	@Step("Get the information of Drug")
	public String getInformationOfDrug() {
		WebUtil.scrollToElementUsingVisibleXpathText("Atorvastatin");
		return waitAndGetText(DRUGINFORMATION_TXT);
	}


	/**
	 * @Desc: Verify if text is present
	 */
	public void verifyIfTextIsPresent() {
		waitUntilElementIsPresent(RESULT_TXT);
		assertTrue(isElementPresent(RESULT_TXT), "'No Search Results' message is not displayed");
	}

}
