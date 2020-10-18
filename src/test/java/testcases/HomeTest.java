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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.TopNavBar;
import utils.Utility;

import java.io.IOException;

@Listeners(ScreenshotListener.class)
public class HomeTest {
    private static Logger logger = LogManager.getLogger(HomeTest.class);
    WebDriver driver = DriverManager.getDriver();

    @BeforeSuite
    public void testBrowserProperty() throws InterruptedException, IOException {
        driver.get(Config.getProperty("app.url"));
        driver.manage().window().maximize();
    }
        @Test
        public void testShop () throws InterruptedException, IOException {

            TopNavBar navBar = new TopNavBar(driver);
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
        public void tearDown () {
            DriverManager.getDriver().quit();
        }
    }
