package com.lulu.qa.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.lulu.qa.AbstractGoldQaTest;
import com.lulu.qa.web.ConfigConstants;
import com.lulu.qa.web.pages.HamburgerPage;
import com.lulu.qa.web.pages.HomePage;
import com.lulu.qa.web.pages.LoginPage;
import com.lulu.qa.web.pages.SignupPage;
import com.lulu.qa.web.pages.AbstractGoodRxPage;
import com.lulu.qa.web.pages.DrugLookUpPage;
import com.lulu.qa.web.utils.WebUtil;
import com.qapitol.sauron.annotations.SauronTest;
import com.qapitol.sauron.configuration.Config;
import com.qapitol.sauron.platform.grid.Grid;
import com.qapitol.sauron.platform.utilities.WebDriverWaitUtils;

public class TestHomePage extends AbstractGoldQaTest {

//	@SauronTest
//	@Test(description = "TC01: Verify clicking on Location Label, Location pop-up should open", alwaysRun = true, groups = {
//			"All" })
//	public void testClickOnLocationLabel() {
//		/*if ("chrome".equalsIgnoreCase(HomePage.getBrowser())) {
//			WebUtil.sleep();
//			homePage.waitAndClickOn(HomePage.POPUP_BTN);
//		}*/
//		//WebUtil.sleep();
//		homePage.waitAndClickOn(HomePage.LOCATIONLABEL_BTN);
//		assertTrue(homePage.isElementPresent(HomePage.DELIVERYLOCATION_DIALOG));
//
//	}
//
//	@SauronTest
//	@Test(description = "TC02: Verify selecting Country UAE, Country should be selected", alwaysRun = true, groups = {
//			"All" })
//	public void testClickOnUAECountry() {
//		/*if ("chrome".equalsIgnoreCase(HomePage.getBrowser())) {
//			WebUtil.sleep();
//			homePage.waitAndClickOn(HomePage.POPUP_BTN);
//		}
//		WebUtil.sleep();*/
//		homePage.waitAndClickOn(HomePage.LOCATIONLABEL_BTN);
//		assertTrue(homePage.isElementPresent(HomePage.DELIVERYLOCATION_DIALOG));
//		WebUtil.longSleepForOnboarding();
//		homePage.waitAndClickOn(HomePage.COUNTRYUAE_ICN);
//	}
//
//	@SauronTest
//	@Test(description = "TC03: Verify cities are populated according to Country", alwaysRun = true, groups = {
//			"All" })
//	public void testCityPopulated() {
//		/*if ("chrome".equalsIgnoreCase(HomePage.getBrowser())) {
//			WebUtil.sleep();
//			homePage.waitAndClickOn(HomePage.POPUP_BTN);
//		}
//		WebUtil.sleep();*/
//		homePage.waitAndClickOn(HomePage.LOCATIONLABEL_BTN);
//		assertTrue(homePage.isElementPresent(HomePage.DELIVERYLOCATION_DIALOG));
//		WebUtil.longSleepForOnboarding();
//		homePage.waitAndClickOn(HomePage.COUNTRYUAE_ICN);
//		homePage.waitAndClickOn(HomePage.UAECITY_DRDW);
//		List<WebElement> uaeCityList = Grid.driver().findElements(By.xpath("//button[@id='dzCountrySelection']"));
//		for (int i = 0; i < uaeCityList.size(); i++) {
//			Assert.assertNotEquals(uaeCityList.get(i).getText(), "Muscat");
//		}
//
//	}
	
	@SauronTest
	@Test(description = "TC04: Select a city", alwaysRun = true, groups = {
			"All" })
	public void testSelectCity() {
		if ("chrome".equalsIgnoreCase(HomePage.getBrowser())) {
			WebUtil.sleep();
			homePage.waitAndClickOn(HomePage.POPUP_BTN);
		}
		WebUtil.sleep();
		homePage.waitAndClickOn(HomePage.LOCATIONLABEL_BTN);
		assertTrue(homePage.isElementPresent(HomePage.DELIVERYLOCATION_DIALOG));
		WebUtil.longSleepForOnboarding();
		homePage.waitAndClickOn(HomePage.COUNTRYUAE_ICN);
		homePage.waitAndClickOn(HomePage.UAECITY_DRDW);
		WebUtil.sleep();
		WebUtil.scrollToElementUsingVisibleXpathText("Ajman");
		WebUtil.sleep();
		homePage.waitAndClickOn(HomePage.UAECITYAJMAN_BTN);
		
		
	}

}
