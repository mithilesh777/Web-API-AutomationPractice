package com.lulu.qa.testpractice;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.lulu.qa.AbstractGoldQaTest;
import com.lulu.qa.web.ConfigConstants;
import com.lulu.qa.web.pages.HomePage;
import com.lulu.qa.web.pages.LuluHomePage;
import com.lulu.qa.web.pages.LuluLoginPage;
import com.lulu.qa.web.utils.WebUtil;
import com.qapitol.sauron.annotations.SauronTest;
import com.qapitol.sauron.configuration.Config;
import com.qapitol.sauron.platform.grid.Grid;


public class ProductListingPage extends AbstractGoldQaTest {

	@SauronTest
	@Test(description = "TC071: Select a city", alwaysRun = true, groups = {
			"All" })
	public void navigateProductListingPage() {
		homePage.waitAndClickOn(HomePage.POPUP_BTN);
		luluLogin.loginFn();
		
		
		
		luluhomepage.waitAndClickOn(LuluHomePage.GROCERY_CATEGORY);
		String categoryNameInPage = luluhomepage.getText(LuluHomePage.GROCERY_TEXT);
		assertEquals(categoryNameInPage.contains("GROCERY"),true, "Grocery header is not present");
		
	}
	@SauronTest
	@Test(description = "TC072: Select a city", alwaysRun = true, groups = {
			"All" })
	public void checkPaginationInCategory() {
		homePage.waitAndClickOn(HomePage.POPUP_BTN);
		luluLogin.loginFn();
		
		luluhomepage.waitAndClickOn(LuluHomePage.GROCERY_CATEGORY);
		WebUtil.scrollToElementUsingVisibleXpathText(">>");
		luluhomepage.waitAndClickOn(LuluHomePage.NEXT_BTN_PAGINATION);
		String URL = Grid.driver().getCurrentUrl();
		System.out.println(URL);
	}
	@SauronTest
	@Test(description = "TC073: Select a city", alwaysRun = true, groups = {
			"All" })
	public void categoryPageNavBack() {
		homePage.waitAndClickOn(HomePage.POPUP_BTN);
		luluLogin.loginFn();
		luluhomepage.waitAndClickOn(LuluHomePage.GROCERY_CATEGORY);
		WebUtil.scrollToElementUsingVisibleXpathText(">>");
		luluhomepage.waitAndClickOn(LuluHomePage.NEXT_BTN_PAGINATION);
		Grid.driver().navigate().back();
	}
	@SauronTest
	@Test(description = "TC074: Select a city", alwaysRun = true, groups = {
			"All" })
	public void filterProducts() {
		homePage.waitAndClickOn(HomePage.POPUP_BTN);
		luluLogin.loginFn();
		luluhomepage.waitAndClickOn(LuluHomePage.GROCERY_CATEGORY);
		luluhomepage.waitAndClickOn(LuluHomePage.FILTER_SELECT);
		String productName = luluhomepage.getText(LuluHomePage.FIRST_PRODUCT_NAME);
		assertEquals(productName.contains("L'Oreal Excellence Creme Brown 4 1 Packet"),true, "Product is present");
	}
	@SauronTest
	@Test(description = "TC075: Select a city", alwaysRun = true, groups = {
			"All" })
	public void filterProductsRelatedProductsShownOrNot() {
		homePage.waitAndClickOn(HomePage.POPUP_BTN);
		luluLogin.loginFn();
		luluhomepage.waitAndClickOn(LuluHomePage.GROCERY_CATEGORY);
		luluhomepage.waitAndClickOn(LuluHomePage.FILTER_SELECT);
		String productName = luluhomepage.getText(LuluHomePage.FIRST_PRODUCT_NAME);
		assertEquals(productName.contains("\r\n" + 
				"Oldenburger Evaporated Milk 10 X 15g"),false, "Product is not present");
	}
	@SauronTest
	@Test(description = "TC076: Select a city", alwaysRun = true, groups = {
			"All" })
	public void filterBrandsShown() {
		homePage.waitAndClickOn(HomePage.POPUP_BTN);
		luluLogin.loginFn();
		luluhomepage.waitAndClickOn(LuluHomePage.GROCERY_CATEGORY);
		String list = luluhomepage.getText(LuluHomePage.BRAND_LIST_FILTER);
		System.out.println(list);
	}
	@SauronTest
	@Test(description = "TC077: Select a city", alwaysRun = true, groups = {
			"All" })
	public void filterMultipleProducts() {
		homePage.waitAndClickOn(HomePage.POPUP_BTN);
		luluLogin.loginFn();
		luluhomepage.waitAndClickOn(LuluHomePage.GROCERY_CATEGORY);
		luluhomepage.waitAndClickOn(LuluHomePage.FILTER_SELECT);
		luluhomepage.waitAndClickOn(LuluHomePage.FILTER_SELECT_2);
		String productName = luluhomepage.getText(LuluHomePage.FIRST_PRODUCT_NAME);
		assertEquals(productName.contains("L'Oreal Excellence Creme Brown 4 1 Packet"),true, "Product is present");
		String productName2 = luluhomepage.getText(LuluHomePage.MULTIPE_FILTER_PRODUCT);
		assertEquals(productName2.contains("Alyoum Chicken Mixed Parts 1000g"),true, "Product is present");
	}
	@SauronTest
	@Test(description = "TC078: Select a city", alwaysRun = true, groups = {
			"All" })
	public void filterExpansionBtnCollapse() {
		homePage.waitAndClickOn(HomePage.POPUP_BTN);
		luluLogin.loginFn();
		luluhomepage.waitAndClickOn(LuluHomePage.GROCERY_CATEGORY);
		luluhomepage.filterExpansionBtn();
		String brandSearchField = luluhomepage.getText(LuluHomePage.BRANDSEARCHFIELD);
		assertEquals(brandSearchField.contains("Search"),false, "The search field is not visible");
	}
	@SauronTest
	@Test(description = "TC079: Select a city", alwaysRun = true, groups = {
			"All" })
	public void filterExpansionBtnExpand() {
		homePage.waitAndClickOn(HomePage.POPUP_BTN);
		luluLogin.loginFn();
		luluhomepage.waitAndClickOn(LuluHomePage.GROCERY_CATEGORY);
		luluhomepage.filterExpansionBtn();
		String brandSearchField = luluhomepage.getText(LuluHomePage.BRANDSEARCHFIELD);
		assertEquals(brandSearchField.contains("Search"),true, "The search field is not visible");
	}
}
