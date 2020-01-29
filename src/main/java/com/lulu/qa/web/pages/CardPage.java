package com.lulu.qa.web.pages;

import io.qameta.allure.Step;

public class CardPage extends AbstractGoodRxPage {
	public static final String YOURCARD_TAB = "yourCardTab";
	public static final String PRINTCARD_BTN = "printCardBtn";
	public static final String TEXTMYCARD_BTN = "textMyCardBtn";
	public static final String EMAILMYCARD_BTN = "emailMyCard";
	public static final String REQUESTANEW_LNK = "requestANewCardLnk";
	public static final String YOURGOODRXGOLD_TXT = "yourGoodRxGoldTxt";
	public static final String GETCARDINFOBYTEXT_TXT = "getCardInfoByText";
	public static final String GETCARDINFOBYEMAIL_TXT = "getCardInfoByEmail";
	public static final String PRINTCARD_PREVIEW = "printpreview";
	public static final String EXPECTTOSEE_MSG = "expectgetMessageTxt";


	/***
	 * @Desc: Fetching placeholder text of "Your GoodRx Gold"
	 * @Return: String
	 */
	@Step("Fetching placeholder text of Your GoodRx Gold")
	public String getTextOfPlaceHolder() {
		waitUntilElementIsPresent(YOURGOODRXGOLD_TXT);
		return locateElement(YOURGOODRXGOLD_TXT).getAttribute("placeholder");
	}

	/***
	 * @Desc: Clicking on 'Print Card' button
	 */
	
	/**
	 * @Desc: Fetching Text Of Color Code
	 * @Return: String
	 */
	@Step("Fetching Text Of Color Code")
	public String getTextOfColorCode() {
		waitUntilElementIsPresent(EXPECTTOSEE_MSG);
		return locateElement(EXPECTTOSEE_MSG).getCssValue("background-color");

	}

}
