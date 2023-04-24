package pageobjects;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class AddCustomer extends BaseTest {

    public void addCustomerPage() throws InterruptedException {

        driver.findElement(By.xpath(loc.getProperty("newcustomer"))).click();

        //add new customer credentials
        driver.findElement(By.xpath(loc.getProperty("name"))).sendKeys("Dwayne Johnson");
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
        driver.findElement(By.xpath(loc.getProperty("email"))).sendKeys("ddwayne@aol.com");
        //password
        driver.findElement(By.xpath(loc.getProperty("pass"))).sendKeys("12345");
        //submit
        driver.findElement(By.xpath(loc.getProperty("submitBtn"))).click();

    }

}
