package com.lulu.qa.web.pages;

import static org.testng.Assert.assertTrue;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.remote.server.handler.GetCurrentUrl;

import com.lulu.qa.web.pages.AbstractGoodRxPage;
import com.lulu.qa.web.utils.WebUtil;
import com.qapitol.sauron.appium.platform.grid.SauronAppiumAndroidDriver;
import com.qapitol.sauron.platform.grid.Grid;
import com.qapitol.sauron.platform.utilities.WebDriverWaitUtils;
import io.qameta.allure.Step;



public class LuluHomePage extends AbstractGoodRxPage {
	public static final String GROCERY_CATEGORY = "groceryCategory";
	public static final String GROCERY_TEXT = "groceryText";
	public static final String NEXT_BTN_PAGINATION = "nextBtnPagination";
	public static final String FILTER_SELECT = "filterSelect";
	public static final String FIRST_PRODUCT_NAME = "productNameFirst";
	public static final String BRAND_LIST_FILTER = "brandsinFilter";
	public static final String FILTER_SELECT_2 = "filterSelect2";
	public static final String MULTIPE_FILTER_PRODUCT = "productNameMultipleFilters";
	public static final String FILTEREXPANSION_BTN = "brandFiltersExpansion";
	public static final String BRANDSEARCHFIELD = "brandSearchField"; 
	
	
	@Step("Click on Grocery category")
	public void categorySelect() {
		waitAndClickOn(GROCERY_CATEGORY);
		
	}
	@Step("Apply Filters")
	public void filterSelect() {
		waitAndClickOn(FILTER_SELECT);
	}
	@Step("Apply Multiple Filters")
	public void filterSelect2() {
		waitAndClickOn(FILTER_SELECT_2);
	}
	@Step("Click on filter expansions")
	public void filterExpansionBtn() {
		waitAndClickOn(LuluHomePage.FILTEREXPANSION_BTN);
	}
}
