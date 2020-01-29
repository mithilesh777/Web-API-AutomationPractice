package com.lulu.qa.web.utils;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qapitol.sauron.appium.platform.grid.SauronAppiumAndroidDriver;
import com.qapitol.sauron.configuration.Config;
import com.qapitol.sauron.platform.AbstractPage;
import com.qapitol.sauron.platform.grid.Grid;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class WebUtil extends AbstractPage {
	private static final String DEFAULT_SLEEP = "goldqa.default.sleep";
	private static final String LONG_SLEEP = "goldqa.default.longsleep";
	private static final String SLEEPFORCARD = "goldqa.default.cardsleep";
	private static String currentDateRequired = null;
	private static Format formatterMonth;
	private static Random random = new Random();

	public static void setTextUsingJS(RemoteWebElement element, String value) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) Grid.driver();
			js.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
		} catch (Exception e) {
			//log.error("Error occured in setText", e);
		}
	}

	public static void clickUsingJS(RemoteWebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) Grid.driver();
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			//log.error("Error occured in setText", e);
		}
	}

	public static void setTextUsingAction(String text) {
		Actions action = new Actions(Grid.driver());
		action.sendKeys(text).build().perform();
	}

	public static void clickUsingAction(RemoteWebElement element) {
		Actions action = new Actions(Grid.driver());
		action.moveToElement(element).click().perform();
	}
		
	public static void scrollToElementUsingVisibleText(RemoteWebElement element) {
		try {
			JavascriptExecutor js = Grid.driver();
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			//log.error("Error occured while scrolling", e);
		}
	}

	public static void scrollToElementUsingVisibleXpathText(String text) {
		JavascriptExecutor js = Grid.driver();
		try {
			js.executeScript("arguments[0].scrollIntoView();",
					Grid.driver().findElement(By.xpath("//*[contains(text(),'" + text + "')]")));
		} catch (Exception e) {
		}
	}

	public static String switchToNewTab() {
		WebUtil.sleep();
		Set<String> ids = Grid.driver().getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentId = it.next();
		String childId = it.next();
		try {
			Grid.driver().switchTo().window(childId);
		} catch (Exception h) {
		}
		return parentId;
	}

	public static void close() {
		Grid.driver().close();
	}

	public static void switchToParent(String parentID) {
		Grid.driver().switchTo().window(parentID);
	}

	public static void sleep() {
		try {
			Thread.sleep(Config.getIntConfigProperty(DEFAULT_SLEEP));
		} catch (InterruptedException e) {
		}
	}

	public static void longSleepForOnboarding() {
		try {
			Thread.sleep(Config.getIntConfigProperty(LONG_SLEEP));
		} catch (InterruptedException e) {
		}
	}

	public static void sleepForAccount() {
		try {
			Thread.sleep(Config.getIntConfigProperty(SLEEPFORCARD));
		} catch (InterruptedException e) {
		}
	}

	public static String todayDateUtil() {
		currentDateRequired = " " + getDateUtil("EEEE") + "," + " " + getDateUtil("dd") + " " + getDateUtil("MMMM")
				+ " " + getDateUtil("YYYY");
		return currentDateRequired;
	}

	/**
	 *
	 * @param str as getCurrentWeekOfTheDay("EEEE), getCurrentDate("dd"),
	 *            getCurrentMonth("MMMM"), getCurrentYear("YYYY")
	 * @return
	 */
	public static String getDateUtil(String str) {
		formatterMonth = new SimpleDateFormat(str);
		return formatterMonth.format(new Date());
	}

	public static void clickElementUsingCss(String css) {
		if (!css.isEmpty()) {
			new WebDriverWait(Grid.driver(), 30)
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css))).click();
		}
	}

	public static String randomName(int sizeOfName) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sizeOfName; i++) {
			sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
		}
		alphabet = sb.toString();
		return alphabet.substring(0, 1).toUpperCase() + alphabet.substring(1);
	}

	public static String getPreviousYear(int noOfYearsback, String format) {
		DateFormat dfmt = new SimpleDateFormat(format);
		Date dateobj = new Date();
		String date = dfmt.format(dateobj);
		Calendar cal = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat(format);
		try {
			cal.setTime(df.parse(date));
		} catch (ParseException e) {
		}
		cal.add(Calendar.YEAR, -noOfYearsback);
		Date oneDayBefore = cal.getTime();
		return df.format(oneDayBefore);
	}

	public static String getFutureYear(int noOfYears, String format) {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		int futureYear = (Integer.parseInt(dateTime.format(formatter)) + noOfYears)%100;
		return String.valueOf(futureYear);
	}

	public static int getRandomNumber() {
		return random.nextInt(9999);
	}

	public static int getRandomNumberOneToTweleve() {
		OptionalInt randomNumberMonth = random.ints(0, 11).findFirst();
		return randomNumberMonth.getAsInt();
	}

	public static String getExpiryMonth() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
		int currentMonth = (Integer.parseInt(dateTime.format(formatter)) + 1);
		return String.valueOf(currentMonth);
	}

	public static String getDayNumeric() {
		return Integer.toString(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
	}

	public static String getTimeNumeric() {
		return (Integer.toString(Calendar.getInstance().get(Calendar.HOUR))
				+Integer.toString(Calendar.getInstance().get(Calendar.MINUTE))
				+Integer.toString(Calendar.getInstance().get(Calendar.SECOND)));
	}

	public static String getDayOfWeek() {
		return Integer.toString(Calendar.getInstance().get(Calendar.DAY_OF_WEEK));
	}

	public static int getDropDownMonth() {
		return getRandomNumberOneToTweleve();
	}

	public static int getDateDropDown() {
		OptionalInt randomNumberMonth = random.ints(1, 27).findFirst();
		return randomNumberMonth.getAsInt();
	}

	public static String getExpiryMonthPastYear() {
		return (getExpiryMonth() + getPreviousYear(5, "yy"));
	}

	public static String getExpiryMonthFutureYear() {
		return (getExpiryMonth() + getFutureYear(5, "yyyy"));
	}

	public static String getCvcNumber() {
		return new DecimalFormat("00").format(getRandomNumberOneToTweleve());
	}

	public static String getThreeOrFourDigitRandomNumber() {
		OptionalInt randomNumberCvv = random.ints(100, 1200).findFirst();
		return Integer.toString(randomNumberCvv.getAsInt());
	}

	public static String getSixteenDigitRandomNumber() {
		long number = (long) Math.floor(Math.random() * 9000_0000_0000_0000L) + 1000_0000_0000_0000L;
		if ((number == 4242424242424242L) || (number == 8888888888888888L)) {
			return Long.toString(1212121212121212L);
		} else {
			return Long.toString(number);
		}
	}

	/**
	 * @Desc: returns the color code
	 * @param color
	 * @return colorCode
	 */
	public static String colorCodeReturnAsString(String color) {
		String[] numbers = color.replace("rgba(", "").replace("rgb(", "").replace(")", "").split(",");
		int r = Integer.parseInt(numbers[0].trim());
		int g = Integer.parseInt(numbers[1].trim());
		int b = Integer.parseInt(numbers[2].trim());
		if (r > g && r > b) {
			return "RED";
		} else if (g > b) {
			return "GREEN";
		} else if ((r == g) && (g == b)) {
			return "BLACK";
		} else {
			return "UN-DEFINED COLOR";
		}
	}

	public static int getCurrentYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}

	public static int getCurrentMonth() {
		int month = Calendar.getInstance().get(Calendar.MONTH);
		if (month <= 12) {
			month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		}
		return month;
	}

	public static int getCurrentDay() {
		int date = Calendar.getInstance().get(Calendar.DATE);
		if (date < 29) {
			date = Calendar.getInstance().get(Calendar.DATE) + 1;
		}
		return date;
	}

	public static void scrollDownWeb(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) Grid.driver();
		js.executeScript("window.scrollBy(0," + pixel + ")");
	}

	public void waitForFrameToBeLoaded(String frameName) {
		long timeoutsec = Grid.getExecutionTimeoutValue() / 1000;
		WebDriverWait wait = new WebDriverWait(Grid.driver(), timeoutsec);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
	}

	public static int getRangeNumber(int StartNum, int EndNum) {
		OptionalInt randomNumberMonth = random.ints(StartNum, EndNum).findFirst();
		return randomNumberMonth.getAsInt();
	}

	/**
	 * @Desc: Vertical swipe mobile app
	 */
	public static boolean verticalSwipe(String ele, int noofswipe) throws Exception {
		int width = Grid.driver().manage().window().getSize().getWidth();
		int height = Grid.driver().manage().window().getSize().getHeight();
		int startx = width / 2;
		int starty = (int) (height * 0.80);
		int endy = (int) (height / 2);
		boolean flag = false;
		for (int i = 0; i < noofswipe; i++) {
			try {
				Grid.driver().findElement(By.xpath(ele));
				flag = true;
				break;
			} catch (Exception e1) {
				@SuppressWarnings("rawtypes")
				TouchAction act = new TouchAction((SauronAppiumAndroidDriver) Grid.driver());
				act.press(PointOption.point(startx, starty)).moveTo(PointOption.point(startx, endy))
						.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).perform().release();
			}
		}
		return flag;
	}

	/**
	 * @Desc: Single swipe down
	 */
	public static void verticalSwipe() throws InterruptedException {
		int width = Grid.driver().manage().window().getSize().getWidth();
		int height = Grid.driver().manage().window().getSize().getHeight();
		int startx = width / 2;
		int starty = (int) (height * 0.80);
		int endy = (int) (height / 2);
		try {
			@SuppressWarnings("rawtypes")
			TouchAction act = new TouchAction((SauronAppiumAndroidDriver) Grid.driver());
			act.press(PointOption.point(startx, starty)).moveTo(PointOption.point(startx, endy))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).perform().release();
		} catch (Exception e1) {
		}
	}

	/**
	 * @Desc: Single swipe reverse
	 */
	public static void verticalSwipereverse() throws InterruptedException {
		int width = Grid.driver().manage().window().getSize().getWidth();
		int height = Grid.driver().manage().window().getSize().getHeight();
		int startx = width / 2;
		int starty = (int) (height * 0.80);
		int endy = (int) (height / 2);
		try {
			@SuppressWarnings("rawtypes")
			TouchAction act = new TouchAction((SauronAppiumAndroidDriver) Grid.driver());
			act.press(PointOption.point(startx, endy)).moveTo(PointOption.point(startx, starty))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).perform().release();
		} catch (Exception e1) {
		}
	}

	public static String getToastMessage() {
		try {
			try {
				((SauronAppiumAndroidDriver) Grid.driver()).hideKeyboard();
			} catch (Exception e) {
			}
			WebDriverWait wait = new WebDriverWait(((SauronAppiumAndroidDriver) Grid.driver()), 3);
			WebElement toastView = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath(".//*[contains(@text,'Please fill out this field')]")));
			String text = toastView.getText();
			return text;
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Toast Message not found!!");
		}
	}

	/**
	 * @Desc: Hide status bar
	 */
	public static void immersiveModeAndroid() throws IOException {
		Runtime.getRuntime().exec("adb shell settings put global policy_control immersive.status=*");
	}

	/**
	 * @Desc: Vertical swipe reverse
	 */
	public static boolean verticalSwipereverse(String ele, int noofswipe) throws InterruptedException {
		int width = Grid.driver().manage().window().getSize().getWidth();
		int height = Grid.driver().manage().window().getSize().getHeight();
		int startx = width / 2;
		int starty = (int) (height * 0.80);
		int endy = (int) (height / 2);
		boolean flag = false;
		for (int i = 0; i < noofswipe; i++) {
			try {
				Grid.driver().findElement(By.xpath(ele));
				flag = true;
				break;
			} catch (Exception e1) {
				@SuppressWarnings("rawtypes")
				TouchAction act = new TouchAction((SauronAppiumAndroidDriver) Grid.driver());
				act.press(PointOption.point(startx, endy)).moveTo(PointOption.point(startx, starty))
						.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).perform().release();
			}
		}
		return flag;
	}

	public static void scrollAndClickLink(String text, RemoteWebElement element) {
		WebUtil.scrollToElementUsingVisibleXpathText(text);
		element.click();
	}

	public static void selectDropdownbyValue(RemoteWebElement element, String text) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(text);
		} catch (Exception e) {
		}
	}

	public static void scrollUpWeb(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) Grid.driver();
		js.executeScript("window.scrollBy(" + pixel + ",0)");
	}
	public static String getDateTime() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		return dateTime.format(formatter);
	}
	
	public static String getFileNamewithDateTime(String fileName) {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		return System.getProperty("user.dir")+"\\PrintGoldCard\\"+fileName+dateTime.format(formatter)+".pdf";
	}
	
	public static String copyTextToClipBoard(String fileName) {
		StringSelection stringSelection = new StringSelection(getFileNamewithDateTime(fileName));
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, stringSelection);
		return fileName;
	}
	
	public static boolean verifyPrint(String fileName) {
		String pdfLoc = WebUtil.copyTextToClipBoard(fileName);
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			WebUtil.sleep();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
		} catch (Exception e) {
		}
		File file = new File(pdfLoc);
		return file.exists();
	}
}