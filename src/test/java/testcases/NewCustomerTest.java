package testcases;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AddCustomer;

import java.io.File;
import java.io.IOException;

@Test
public class NewCustomerTest extends BaseTest {

    public void addNewCustomer() throws InterruptedException, IOException {

        driver.findElement(By.xpath(loc.getProperty("newcustomer"))).click();

        //add new customer credentials
        driver.findElement(By.xpath(loc.getProperty("name"))).sendKeys("Dwayne Johnson");
        logger.info("Entered name");
        //radio button gender
        driver.findElement(By.xpath(loc.getProperty("radiomale"))).click();
        //hover mouse birthdate

        driver.findElement(By.xpath(loc.getProperty("calender"))).sendKeys("11/04/1980");
        Thread.sleep(2000);
        //Address

        WebElement adrre = driver.findElement(By.cssSelector(loc.getProperty("address")));
        adrre.click();
        adrre.sendKeys("254 Hemingway Rd");
        //driver.findElement(By.xpath(log.getProperty("address"))).sendKeys("254 Hemingway Rd");
        Thread.sleep(2000);

        //City
        driver.findElement(By.xpath(loc.getProperty("city"))).sendKeys("Nairobi");

        //state
        driver.findElement(By.xpath(loc.getProperty("state"))).sendKeys("Hurlingham");
        //pin
        driver.findElement(By.xpath(loc.getProperty("pin"))).sendKeys("9911911");
        //mobile no
        driver.findElement(By.xpath(loc.getProperty("mobile"))).sendKeys("078494962");
        //email
        driver.findElement(By.xpath(loc.getProperty("email"))).sendKeys(randomString() + "@gmail.com");
        //password
        driver.findElement(By.xpath(loc.getProperty("pass"))).sendKeys("12345");
        //submit
        driver.findElement(By.xpath(loc.getProperty("submitBtn"))).click();

        Thread.sleep(3000);

        boolean res = driver.getPageSource().contains("Customer Registered Successfully");

        if (res == true ) {

            Assert.assertTrue(true);
            logger.info("Testing passed");
            System.out.println("passed");
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(".//screenshotPass/" + randomString() + ".png"));
        } else {

            Assert.assertTrue(false);
            System.out.println("failed");
            logger.info("Testing failed");
        }
    }

    //generate random string for unique emails
    //or .randomNumeric
    public static String randomString() {


        String generatedString = RandomStringUtils.randomAlphabetic(8);
        return generatedString;
    }

}
