package testcases;

import config.Config;
import drivermanager.DriverManager;
import listener.ScreenshotListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.DevicesList;
import pages.Guest;
import pages.Plans;
import pages.TopNavBar;
import utils.Utility;

import java.io.IOException;

@Listeners(ScreenshotListener.class)
public class HomeTest {
    private static Logger logger = LogManager.getLogger(HomeTest.class);
    WebDriver driver = DriverManager.getDriver();
//    @Test(enabled = false)
//    public void dummyTest(){
//        logger.fatal("here is I am with {} FATAL","Hitesh");
//        logger.info("here is I am with {} INFO","Hitesh");
//        logger.error("here is I am with {} ERROR","Hitesh");
//        logger.debug("here is I am with {} DEBUG","Hitesh");
//        logger.trace("here is I am with {} TRACE","Hitesh");
//    }
    @BeforeSuite
    public void testBrowserProperty() throws InterruptedException, IOException {
//        System.out.println(Config.getProperty("firefox.executable"));
//        Assert.assertEquals(Config.getProperty("browser.name"),"chrome","Name Mismatch");

        driver.get(Config.getProperty("app.url"));
        driver.manage().window().maximize();
//        Utility.captureScreenShot("testBrowserProperty",DriverManager.getDriver(),false);
//        Assert.assertEquals(driver.getTitle(),"Facebook");
//        Thread.sleep(5000);
//        WebDriverWait wait = new WebDriverWait(driver,20);
//        DriverManager.getDriver().quit();
    }

    @Test
    public void testShop() throws InterruptedException, IOException {

        TopNavBar navBar= new TopNavBar(driver);
        navBar.shopClick();
        navBar.deviceClick();

        DevicesList devicesList = new DevicesList(driver);
        devicesList.iPhoneSEClick();
        devicesList.planClick();

        Guest guest = new Guest(driver);
        guest.guestClick();

        Plans plans = new Plans(driver);
        plans.planClick();
        plans.contClick();
        plans.printSummaryClick();

    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        DriverManager.getDriver().quit();
    }
}
