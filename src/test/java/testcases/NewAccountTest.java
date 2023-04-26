package testcases;

import base.BaseTest;
import base.RetryAnalyzer;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.readXlsData;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import static testcases.NewCustomerTest.randomString;

public class NewAccountTest extends BaseTest {

    @Test(dataProviderClass = readXlsData.class, dataProvider = "bvtData", retryAnalyzer = RetryAnalyzer.class)
    public void addNewAccount(String custId, String initAmt) throws IOException {


        //add new account button

        driver.findElement(By.xpath(loc.getProperty("addaccount"))).click();

        //input customerId
        driver.findElement(By.xpath(loc.getProperty("customerid"))).sendKeys(custId);

        //Select drop down


        //input inital amount
        driver.findElement(By.xpath(loc.getProperty("deposit"))).sendKeys(initAmt);

        //submit
        driver.findElement(By.xpath(loc.getProperty("submit2"))).click();


        boolean res = driver.getPageSource().contains("Account Generated Successfully");

        if(res == true) {

            Assert.assertTrue(true);
            logger.info("Testing passed");
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(".//screenshotAccount/" + randomString() + ".png"));

        } else {

            Assert.assertTrue(false);
            logger.info("Test Failed");
            //handle alert
            Alert alert = driver.switchTo().alert();
            alert.accept();

        }

    }
}
