package com.framework.listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.framework.base.BasePage;
import com.framework.commons.WebCommons;

public class TestListener extends BasePage implements ITestListener {

	public void onTestStart(ITestResult result) {
		startReporting(result.getMethod().getMethodName());
		logger.info(result.getMethod().getMethodName() + " execution is started");
	}

	public void onTestSuccess(ITestResult result) {
		logger.pass(result.getMethod().getMethodName() + " execution is successfully completed");
		stopReporting();
	}

	public void onTestFailure(ITestResult result) {
		logger.fail(result.getThrowable().getMessage());
		logger.fail(result.getMethod().getMethodName() + " execution is failed");
		try {
			logger.addScreenCaptureFromPath(WebCommons.takeScreenshotOfWindow(BasePage.getDriver(),result.getMethod().getMethodName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		stopReporting();
	}

}
