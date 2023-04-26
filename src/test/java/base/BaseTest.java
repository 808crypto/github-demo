package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.core.config.properties.PropertiesConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseTest {


    public static WebDriver driver;
    public static Properties con = new Properties();
    public static Properties loc = new Properties();
    public static Properties log = new Properties();
    public static FileReader fr;
    public static FileReader fr1;
    public static FileReader fr2;
    public static FileHandler fileHandler;

    //create logger object
    public static Logger logger = Logger.getLogger("ebanking");



    @BeforeMethod
    public void setUp() throws IOException {



        if(driver == null) {

            fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
            fr1 = new FileReader( System.getProperty("user.dir")+ "\\src\\test\\resources\\configfiles\\locators.properties");
            fr2 = new FileReader( System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\logins.properties");
            con.load(fr);
            loc.load(fr1);
            log.load(fr2);

        }

        if(con.getProperty("browser").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(con.getProperty("url"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.findElement(By.xpath(loc.getProperty("userID"))).sendKeys(log.getProperty("username"));
            driver.findElement(By.xpath(loc.getProperty("passwordfield"))).sendKeys(log.getProperty("password"));

            driver.findElement(By.xpath(loc.getProperty("loginButton"))).click();





        } else if (con.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get(con.getProperty("url"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            
        } else if (con.getProperty("browser").equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.get(con.getProperty("url"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        }

        System.out.println("Browser Launched Successfully");
        //set logging level
        logger.setLevel(Level.INFO);

        //create FileHandler object
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            String timeStamp = dateFormat.format(new Date());
            File logsFolder = new File("logs");

            if(!logsFolder.exists()) {
                logsFolder.mkdirs();
            }
            fileHandler = new FileHandler(  "logs/logDemo_" + timeStamp + ".log");
            logger.addHandler(fileHandler);
            logger.info("File created");
        }catch (IOException e) {

            logger.log(Level.SEVERE, "Failed to create log file", e);
        }

        fileHandler.close();
    }


    @AfterMethod
    public void tearDown() {


        driver.close();
        System.out.println("TearDown Successful");


    }


}
