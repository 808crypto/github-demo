package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.readXlsFundTransfer;

public class FundTransferTest extends BaseTest {

    @Test(dataProviderClass = readXlsFundTransfer.class, dataProvider = "fundTransfer")
    public void transferFund(String payer, String payee, String amt, String descrip){

        //click on fund transfer
        driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[10]/a")).click();

        //input payer details
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")).sendKeys(payer);

        //input payee details
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input")).sendKeys(payee);

        //input amount
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[6]/td[2]/input")).sendKeys(amt);

        //input description
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/input")).sendKeys(descrip);

        //click on submit
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input[1]")).click();


    }


}
