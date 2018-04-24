package com.epam.starikov.tat.module4.listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

/**
 * Created by Klim_Starykau on 4/12/2018.
 */
public class Listener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        System.out.println("iInvokedMethod  [" + iInvokedMethod.getTestMethod().getMethodName() + "]");
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        System.out.println("Method finished  [" + iTestResult.getStatus() + "]" + iInvokedMethod.getTestMethod().getMethodName() + "\n");
    }
}
