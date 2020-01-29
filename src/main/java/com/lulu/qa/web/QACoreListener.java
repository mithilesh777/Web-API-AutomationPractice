package com.lulu.qa.web;

import java.util.HashMap;
import java.util.logging.Level;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.browserstack.local.Local;
import com.qapitol.sauron.configuration.Config;
import com.qapitol.sauron.configuration.Config.ConfigProperty;
import com.qapitol.sauron.logger.SauronLogger;
import com.qapitol.sauron.testng.LinkedListener;
import com.qapitol.test.utilities.logging.SimpleLogger;

public class QACoreListener implements ISuiteListener, ITestListener, IInvokedMethodListener, LinkedListener {

	private static SimpleLogger log = SauronLogger.getLogger();
	private Local bsLocal;

	@Override
	public void onStart(ISuite suite) {

		boolean enableBrowserStackLocal = Config.getBoolConfigProperty(ConfigProperty.BROWSERSTACK_LOCAL);

		if (enableBrowserStackLocal) {
			log.info("Start Browserstack local server");

			bsLocal = new Local();
			// replace <browserstack-accesskey> with your key. You can also set an
			// environment variable - "BROWSERSTACK_ACCESS_KEY".
			HashMap<String, String> bsLocalArgs = new HashMap<String, String>();
			bsLocalArgs.put("key", Config.getConfigProperty(ConfigConstants.BS_ACCESSKEY));
			bsLocalArgs.put("forcelocal", "true");
			// starts the Local instance with the required arguments
			try {
				bsLocal.start(bsLocalArgs);
			} catch (Exception e) {
				log.log(Level.SEVERE, "Error in setting up browserstack localserver", e);
			}

		}
	}

	@Override
	public void onFinish(ISuite suite) {
		try {
			if (bsLocal != null && bsLocal.isRunning()) {
				bsLocal.stop();
			}
		} catch (Exception e) {
			log.log(Level.SEVERE, "Error in stopping browserstack localserver", e);
		}
	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult result) {
		log.info(result.getInstanceName() + " - " + result.getMethod().getMethodName() + "");

	}

	public void afterInvocation(IInvokedMethod method, ITestResult result) {

	}

	@Override
	public void onTestStart(ITestResult result) {
		log.info(result.getInstanceName() + " - " + result.getMethod().getMethodName() + " Test Started");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info(result.getInstanceName() + " - " + result.getMethod().getMethodName() + " Test Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.info(result.getInstanceName() + " - " + result.getMethod().getMethodName()
				+ " Test Failed ********************");
		log.log(Level.SEVERE, "FAILED", result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log.info(result.getInstanceName() + " - " + result.getMethod().getMethodName()
				+ " Test Skipped *********************");
		log.log(Level.SEVERE, "SKIPPED", result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		log.info(result.getInstanceName() + " - " + result.getMethod().getMethodName()
				+ " Test Failed but within Success %");
	}

	@Override
	public void onStart(ITestContext context) {
		log.info(context.getName() + " - " + " Execution Started");
	}

	@Override
	public void onFinish(ITestContext context) {
		log.info(context.getName() + " - " + " Execution finished");
	}

}
