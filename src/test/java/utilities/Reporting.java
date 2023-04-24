package utilities;

import org.testng.Reporter;
import org.testng.annotations.Test;


public class Reporting {



    @Test
    public void reporterTest1() {

        Reporter.log("This is test 1");
    }

    @Test
    public void reporterTest2() {

        Reporter.log("This is test 2");
    }
}
