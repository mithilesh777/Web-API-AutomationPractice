package com.lulu.qa.web;

import java.lang.reflect.Method;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.qapitol.sauron.configuration.Config;
import com.qapitol.sauron.platform.grid.Grid;
import com.qapitol.sauron.platform.grid.browsercapabilities.DefaultCapabilitiesBuilder;

public class BrowserStackCapability extends DefaultCapabilitiesBuilder {

	public static final String BROWSERSTACK_PROJECT = "bsProjectName";
	public static final String BROWSERSTACK_BUILD = "bsBuildName";

	@Override
	public DesiredCapabilities getCapabilities(DesiredCapabilities capabilities) {

		String bsProjectName = Config.getConfigProperty(BROWSERSTACK_PROJECT);
		String bsBuild = Config.getConfigProperty(BROWSERSTACK_BUILD);

		if (StringUtils.isNotEmpty(bsProjectName)) {
			capabilities.setCapability("project", bsProjectName);
		}
		if (StringUtils.isNotEmpty(bsBuild)) {
			capabilities.setCapability("build", bsBuild);
		}
		capabilities.setCapability("name", getName());

		return capabilities;
	}

	private String getName() {
		//Check current method is test method, if not get first method parameter to get actual test method
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