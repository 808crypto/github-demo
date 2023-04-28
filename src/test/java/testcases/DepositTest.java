package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.readXlsDepo;

public class DepositTest extends BaseTest {


    @Test(dataProviderClass = readXlsDepo.class, dataProvider = "depo")
    public void deposit(String acctNo, String depoAmt, String desc) {

        //click on deposit
        driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[8]/a")).click();

        //input account number
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[6]/td[2]/input")).sendKeys(acctNo);

        //input amount
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/input")).sendKeys(depoAmt);

        //input description
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input")).sendKeys(desc);

        //submit
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[12]/td[2]/input[1]")).click();

    }
}
