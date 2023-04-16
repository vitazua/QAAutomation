package org.example.hillelautomation;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {
    @BeforeMethod
    public void testStartedLog(Method method) {
        String methodName = method.getName();
        System.out.println("INFO: Test " + methodName + " started");
    }

    @AfterMethod
    public void testFinishedLog(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        if (result.getStatus() == ITestResult.SUCCESS) {
            System.out.println("INFO: Test " + methodName + " finished with result SUCCESS");
        } else {
            System.out.println("INFO: Test " + methodName + " finished with result FAIL");
        }
    }
}
