package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.readXlsWithdraw;

public class WithdrawalTest extends BaseTest {

    @Test(dataProviderClass = readXlsWithdraw.class, dataProvider = "withdraw")
    public void withdraw(String acctNo, String withdAmt, String descr) {

        //click on withdraw
        driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[9]/a")).click();

        //input account no
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[6]/td[2]/input")).sendKeys(acctNo);

        //input amount
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/input")).sendKeys(withdAmt);

        //input descriptiom
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input")).sendKeys(descr);

        //submit
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[12]/td[2]/input[1]")).click();


    }
}
