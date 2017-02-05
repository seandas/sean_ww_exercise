import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * Created by SDAS on 2/2/2017.
 */
public class AbstractStartWebDriver extends ReusableMethods {
    public static WebDriver wDriver = null;
    public static String testName = null;
    public static String url = System.getProperty("user.dir") + "\\src\\main\\resources\\webpage.html";
    public static String browserName = "Chrome";

    /*******************************************************************************/

    @BeforeSuite
    public static void beforeSuite() {
        setWebDriver(browserName);
        wDriver.get(url);
    }

    @BeforeMethod
    public static void beforeTest(Method method) {
        testName = method.getName();
        Reporter.log("Starting Test : " + testName, true);
    }

    @AfterMethod
    public static void afterTest(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            Reporter.log(testName + " : PASSED", true);
            Reporter.log("+++++++++++++++++++++++++++++++++++++++++++", true);
        } else {
            Assert.fail();
            Reporter.log(testName + " : FAILED!!!", true);
        }
    }

    @AfterSuite
    public static void afterSuite() throws InterruptedException {
        //wDriver.get(System.getProperty("user.dir")+"\\test-output\\index.html");
        //wDriver.findElement(By.linkText("Reporter output")).click();
        Thread.sleep(2000);
        wDriver.close();
        wDriver.quit();
        wDriver = null;
    }


    public static void setWebDriver(String browserName) {
        Reporter.log("Starting " + browserName + " Driver....", true);
        if (browserName.toLowerCase().contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "./src/main/resources/chromedriver.exe");
            wDriver = new ChromeDriver();
            wDriver.manage().window().maximize();
            wDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            wDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        } else {
            //Desired Driver.....
        }
    }

}
