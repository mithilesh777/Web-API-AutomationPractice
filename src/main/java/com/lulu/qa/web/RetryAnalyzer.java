package com.lulu.qa.web;

import java.util.concurrent.atomic.AtomicInteger;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.qapitol.sauron.configuration.Config;

public class RetryAnalyzer implements IRetryAnalyzer {

	private AtomicInteger retryCount = new AtomicInteger(0);
	private Integer retryLimit = null;

	/**
	 * Returns true if the test method has to be retried, false otherwise.
	 * 
	 * @param result The result of the test method that just ran.
	 * @return true if the test method has to be retried, false otherwise.
	 */

	public boolean retry(ITestResult result) {
		if (null == retryLimit) {
			retryLimit = Config.getIntConfigProperty("goldqa.retry.limit");
		} else {
			retryLimit = 0;
		}

		if (retryCount.get() < retryLimit.intValue()) {
			retryCount.getAndIncrement();
			return true;
		}
		return false;
	}

	public int getRetryCount() {
		return retryCount.get();
	}
}
