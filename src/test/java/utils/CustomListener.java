package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener {

    private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(getClass());

    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info("Test method " + iTestResult.getName() + " STARTED");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.info("Test method " + iTestResult.getName() + " PASSED");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.info("Test method " + iTestResult.getName() + " FAILED");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.info("Test method " + iTestResult.getName() + " SKIPPED");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        logger.info("Test method " + iTestResult.getName() + " success percentage");

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        logger.info("Test class " + iTestContext.getName() + " STARTED");

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        logger.info("Test class " + iTestContext.getName() + " FINISHED");

    }
}
