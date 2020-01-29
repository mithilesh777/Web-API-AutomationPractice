package com.lulu.qa;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lulu.qa.web.BrowserStackClient;
import com.lulu.qa.web.ConfigConstants;
import com.lulu.qa.web.pages.AbstractGoodRxPage;
import com.lulu.qa.web.pages.AccountPage;
import com.lulu.qa.web.pages.CardPage;
import com.lulu.qa.web.pages.DrugLookUpPage;
import com.lulu.qa.web.pages.FooterPage;
import com.lulu.qa.web.pages.HamburgerPage;
import com.lulu.qa.web.pages.HomePage;
import com.lulu.qa.web.pages.LoginPage;
import com.lulu.qa.web.pages.LuluHomePage;
import com.lulu.qa.web.pages.LuluLoginPage;
import com.lulu.qa.web.pages.ManageMembersPage;
import com.lulu.qa.web.pages.PharmacyDirectorypage;
import com.lulu.qa.web.pages.PrescriptionPage;
import com.lulu.qa.web.pages.SignupPage;
import com.lulu.qa.web.pages.SupportPage;
import com.qapitol.sauron.configuration.Config;
import com.qapitol.sauron.internal.platform.grid.WebTestSession;
import com.qapitol.sauron.logger.SauronLogger;
import com.qapitol.sauron.platform.grid.Grid;
import com.qapitol.test.utilities.logging.SimpleLogger;

public abstract class AbstractGoldQaTest {

	protected static SimpleLogger log = SauronLogger.getLogger();
	protected HomePage homePage;
	protected SupportPage supportPage;
	protected PrescriptionPage prescriptionPage;
	protected HamburgerPage hamburgerPage;
	protected LoginPage loginPage;
	protected AccountPage accountPages;
	protected CardPage cardPage;
	protected SignupPage signupPage;
	protected FooterPage footerPage;
	protected DrugLookUpPage drugLookUpPage;
	protected PharmacyDirectorypage pharmacyDirectorypage;
	protected ManageMembersPage managemember;
	protected LuluLoginPage luluLogin;
	protected LuluHomePage luluhomepage;

	protected String[] signupUserNameLoginMember = new String[20];
	protected String signupPasswordLoginMember = null;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		homePage = new HomePage();
		homePage.load();
		supportPage = new SupportPage();
		supportPage.load();
		prescriptionPage = new PrescriptionPage();
		prescriptionPage.load();
		hamburgerPage = new HamburgerPage();
		hamburgerPage.load();
		loginPage = new LoginPage();
		loginPage.load();
		accountPages = new AccountPage();
		accountPages.load();
		cardPage = new CardPage();
		cardPage.load();
		pharmacyDirectorypage = new PharmacyDirectorypage();
		pharmacyDirectorypage.load();
		signupPage = new SignupPage();
		signupPage.load();
		footerPage = new FooterPage();
		footerPage.load();
		drugLookUpPage = new DrugLookUpPage();
		drugLookUpPage.load();
		managemember = new ManageMembersPage();
		managemember.load();
		luluLogin = new LuluLoginPage();
		luluLogin.load();
		luluhomepage = new LuluHomePage();
		luluhomepage.load();
		
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method) {
		if (AbstractGoodRxPage.getTargetClient().equalsIgnoreCase("android")) {
			log.info("Started Mobile session");
		} else {
			try {
				WebTestSession webTestSession = Grid.getWebTestSession();
				if (null != webTestSession) {
					Grid.driver().manage().window().maximize();
					Grid.driver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				}
				Grid.driver().get(Config.getConfigProperty(ConfigConstants.SERVER_URL));
			} catch (Exception e) {
				log.info("Error occured #################################");
				log.log(Level.SEVERE, "exception in before method: ", e);
			}
		}

	}

	@AfterMethod(alwaysRun = true)
	public void teardown(ITestResult result) {
		log.info("Ending Session");
		updateStatusInBS(result);
	}

	/**
	 * Update test status in browserstack
	 */
	private void updateStatusInBS(ITestResult result) {
		String userName = Config.getConfigProperty(ConfigConstants.BS_USERNAME);
		String accessKey = Config.getConfigProperty(ConfigConstants.BS_ACCESSKEY);
		BrowserStackClient automateClient = new BrowserStackClient(userName, accessKey);
		Map<String, String> data = new HashMap<String, String>();

		switch (result.getStatus()) {
		case ITestResult.SUCCESS:
			data.put("status", "PASSED");
			break;
		case ITestResult.FAILURE:
			data.put("status", "FAILED");
			break;
		default:
			data.put("status", "COMPLETED");
		}
		if (null != result.getThrowable()) {
			data.put("reason", result.getThrowable().getMessage());
		}
		try {
			ITestNGMethod method = result.getMethod();
			if (method.getCurrentInvocationCount() > 1) {
				data.put("name", getName() + "--@Retry-" + (method.getCurrentInvocationCount() - 1));
			}
			String status = automateClient.updateSessionStatus(Grid.driver().getSessionId().toString(), data);
			log.info("BS Status update response " + status);
		} catch (IOException e) {
			log.log(Level.SEVERE, "Failed to update BrowserStack with test status", e);
		}
	}

	private String getName() {
		// Check current method is test method, if not get first method parameter to get
		// actual test method
		Test annotation = Grid.getTestSession().getMethod().getAnnotation(Test.class);
		if (annotation != null) {
			return annotation.description();
		} else {
			Object[] methodParameters = Grid.getTestSession().getMethod().getMethodParameters();
			if (methodParameters != null && methodParameters.length > 0 && methodParameters[0] instanceof Method) {
				Test test = ((Method) methodParameters[0]).getAnnotation(Test.class);
				if (test != null) {
					return test.description();
				}
			}
		}
		return Grid.getTestSession().getTestName();
	}
}
