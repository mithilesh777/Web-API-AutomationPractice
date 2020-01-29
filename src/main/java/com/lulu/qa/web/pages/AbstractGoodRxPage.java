package com.lulu.qa.web.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.lulu.qa.web.utils.WebUtil;
import com.qapitol.sauron.configuration.Config;
import com.qapitol.sauron.configuration.Config.ConfigProperty;
import com.qapitol.sauron.platform.AbstractPage;
import com.qapitol.sauron.platform.grid.Grid;
import com.qapitol.sauron.platform.utilities.WebDriverWaitUtils;

import io.qameta.allure.Step;

public class AbstractGoodRxPage extends AbstractPage {

	protected static boolean isMobilePage() {
		String pagedetail = Config.getConfigProperty(ConfigProperty.TARGET_CLIENT);
		return pagedetail.equalsIgnoreCase("mweb");
	}
	
	protected static boolean isBrowserEnable(String str) {
		String pagedetail = Config.getConfigProperty(ConfigProperty.TARGET_CLIENT);
		return pagedetail.equalsIgnoreCase(str);
	}

	public static String getTargetClient() {
		return Config.getConfigProperty(ConfigProperty.TARGET_CLIENT);
	}

	public static String getBrowser() {
		return Config.getConfigProperty(ConfigProperty.BROWSER);
	}

	protected void clickElement(String elementKey) {
		RemoteWebElement element = locateElement(elementKey);
		if (element.isEnabled() || element.isDisplayed()) {
			((JavascriptExecutor) Grid.driver()).executeScript("arguments[0].click();", element);
		}
		String pagedetail = Config.getConfigProperty(ConfigProperty.BROWSER);
		if ("safari".equalsIgnoreCase(pagedetail)) {
			WebUtil.sleep();
		}
	}

	protected void clickElement(WebElement element) {
		if (element.isEnabled() || element.isDisplayed()) {
			((JavascriptExecutor) Grid.driver()).executeScript("arguments[0].click();", element);
		}
		String pagedetail = Config.getConfigProperty(ConfigProperty.BROWSER);
		if ("safari".equalsIgnoreCase(pagedetail)) {
			WebUtil.sleep();
		}

	}

	public WebElement waitUntilElementIsPresent(String key) {
		return WebDriverWaitUtils.waitUntilElementIsPresent(getLocator(key), WebDriverException.class);
	}

	
	/**
	 * click on element
	 * 
	 * @param key
	 */
	@Step("Click on {key}")
	public void clickOn(String key) {
		WebDriverWaitUtils.waitUntilElementIsPresent(getLocator(key), WebDriverException.class).click();
	}
	
	/**
	 * Wait for WebElement and click on it
	 * 
	 * @param key
	 */
	@Step("Click on {key}")
	public void waitAndClickOn(String key) {
		WebDriverWaitUtils.waitUntilElementIsPresent(getLocator(key), WebDriverException.class).click();
	}

	/**
	 * Get element text
	 * 
	 * @param key
	 */
	@Step("Get text of {key}")
	public String waitAndGetText(String key) {
		return WebDriverWaitUtils.waitUntilElementIsPresent(getLocator(key), WebDriverException.class).getText();
	}
	
	/**
	 * Get element text
	 * 
	 * @param key
	 */
	@Step("Get text of {key}")
	public String waitAndGetTextByAttribute(String key, String attributeName) {
		return WebDriverWaitUtils.waitUntilElementIsPresent(getLocator(key), WebDriverException.class).getAttribute(attributeName);
	}

	/**
	 * Get element text
	 * 
	 * @param key
	 */
	@Step("Get text of {key}")
	public String getText(String key) {
		return locateElement(key).getText();
	}

	/**
	 * Set element text
	 * 
	 * @param key
	 */
	@Step("Set element text {text} for {key}")
	public void setText(String key, String text) {
		locateElement(key).sendKeys(text);
	}

	/**
	 * Set element text
	 * 
	 * @param key
	 */
	@Step("Set text {text} into {key} ")
	public void waitAndSetText(String key, String text) {
		WebDriverWaitUtils.waitUntilElementIsPresent(getLocator(key), WebDriverException.class).sendKeys(text);
	}

	/**
	 * Wait and and check is element is displayed
	 * 
	 * @param key
	 */
	@Step("Check element {key} is displayed")
	public boolean waitAndCheckIsElementDisplayed(String key) {
		return WebDriverWaitUtils.waitUntilElementIsPresent(getLocator(key), WebDriverException.class).isDisplayed();
	}
	
	

}
