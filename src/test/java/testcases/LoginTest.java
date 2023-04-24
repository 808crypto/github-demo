package testcases;


import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

@Test
public class LoginTest extends BaseTest {

    public void titleTest() {

        Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");


    }
}
