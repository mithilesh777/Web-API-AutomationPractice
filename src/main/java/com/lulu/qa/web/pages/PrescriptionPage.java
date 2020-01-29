package com.lulu.qa.web.pages;

import io.qameta.allure.Step;

public class PrescriptionPage extends AbstractGoodRxPage {

	public static final String GETAPRESCRIPTION_TAB = "getPrescriptionTab";
	public static final String HEADER_TXT = "headerTxt";
	public static final String LOGO_TXT = "logoTxt";

	/**
	 * @Desc: Click on Get a Prescription link
	 */
	@Step("Click on the Get A Prescription Link")
	public void clickOngetAPrescriptionLink() {
		waitAndClickOn(GETAPRESCRIPTION_TAB);
	}

	/**
	 * @Desc: Get the header prescription name
	 * 
	 * @Return: String
	 */
	@Step("Get the information of the prescriptions")
	public String getHeaderOfPrescription() {
		return getText(HEADER_TXT);
	}

	/**
	 * @Desc: Get the header of Lemonaid
	 * 
	 * @Return: boolen
	 */
	@Step("Get the information of the Lemonaid")
	public boolean getHeaderOfLemonaid() {
		return waitAndCheckIsElementDisplayed(LOGO_TXT);
	}

}
