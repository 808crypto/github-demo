package utilities;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static base.BaseTest.driver;
import static testcases.NewCustomerTest.randomString;

public class testUtils extends BaseTest {

    public void getScreenshot() throws IOException {

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".//screenshotFail//" + randomString() + "/.png"));
    }
}
