package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.Base;

import java.util.List;

public class TestListener extends Base implements ITestListener {


    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        Object[] params=iTestResult.getParameters();
        logger.info("Starting {} test case with {} test data",iTestResult.getName(),params[0] );
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Object[] params=iTestResult.getParameters();
        logger.info("Completed {} test case with {} test data",iTestResult.getName(),params[0] );
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Object[] params=iTestResult.getParameters();
        logger.error("{} test case failed with {} test data",iTestResult.getName(),params[0] );
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }
}