package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.readBalanceEnquiryXlsx;

public class BalanceInquiryTest extends BaseTest {

    @Test(dataProviderClass = readBalanceEnquiryXlsx.class, dataProvider = "balance")
    public void balance(String acct) {

        //click
        driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[12]/a")).click();

        //input account no
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[6]/td[2]/input")).sendKeys(acct);

        //submit
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input[1]")).click();

    }
}
