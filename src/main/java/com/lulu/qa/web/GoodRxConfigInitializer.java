package com.lulu.qa.web;

import org.testng.ISuite;
import org.testng.ITestContext;

import com.qapitol.sauron.configuration.AbstractConfigInitializer;
import com.qapitol.sauron.configuration.Config;

public class GoodRxConfigInitializer extends AbstractConfigInitializer {

	private static final String PROP_FILENAME = "gold-qa.properties";

	@Override
	public int getPriority() {
		return 0;
	}

	@Override
	public void initialize(ITestContext context) {
		Config.loadProperties(PROP_FILENAME);
	}

	@Override
	public void initialize(ISuite suite) {
		Config.loadProperties(PROP_FILENAME);
	}
}