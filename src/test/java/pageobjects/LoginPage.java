package pageobjects;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;



public class LoginPage extends BaseTest {



    public void loginPage() {



        //login to bank

        driver.findElement(By.xpath(loc.getProperty("userID"))).sendKeys(log.getProperty("username"));
        driver.findElement(By.xpath(loc.getProperty("passwordfield"))).sendKeys(log.getProperty("password"));

        driver.findElement(By.xpath(loc.getProperty("loginButton"))).click();

        System.out.println(driver.getTitle());
        Assert.assertTrue(true);


        //Invalid Logins

    }


   /* public void invalidLogin() {

        driver.findElement(By.xpath(loc.getProperty("userID"))).sendKeys(log.getProperty("invUsername"));
        driver.findElement(By.xpath(loc.getProperty("passwordfield"))).sendKeys(log.getProperty("invPassword"));

        driver.findElement(By.xpath(loc.getProperty("loginButton"))).click();

        Assert.assertFalse(false);
    }

    */



}
