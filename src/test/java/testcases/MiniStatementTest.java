package testcases;

import base.BaseTest;
import org.openqa.selenium.By;

public class MiniStatementTest extends BaseTest {

    public void miniStatementTest(String acctNo) {

        //click
        driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[13]/a")).click();

        //input account no.
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[6]/td[2]/input")).sendKeys(acctNo);

        //submit
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input[1]")).click();
    }
}
