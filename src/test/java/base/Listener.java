package base;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import utilities.testUtils;

import java.io.IOException;

public class Listener extends testUtils implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        Reporter.log("Method name is " + result.getName());
        System.out.println("Test case is starting...");
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.log("Status of execution is " + result.getStatus());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Capture screenshot...");
        try {
            getScreenshot();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }
}
