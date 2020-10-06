package testcases;

import config.Config;
import drivermanager.DriverManager;
import listener.ScreenshotListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    @Test(enabled = false)
    public void dummyTest(){
        logger.fatal("here is I am with {} FATAL","Hitesh");
        logger.info("here is I am with {} INFO","Hitesh");
        logger.error("here is I am with {} ERROR","Hitesh");
        logger.debug("here is I am with {} DEBUG","Hitesh");
        logger.trace("here is I am with {} TRACE","Hitesh");
    }
    @Test
    public void testBrowserProperty() throws InterruptedException, IOException {
//        System.out.println(Config.getProperty("firefox.executable"));
//        Assert.assertEquals(Config.getProperty("browser.name"),"chrome","Name Mismatch");

        driver.get(Config.getProperty("app.url"));
        driver.manage().window().maximize();

        Thread.sleep(5000);

//        Utility.captureScreenShot("testBrowserProperty",DriverManager.getDriver(),false);
        //To Find Username Field
        WebElement username = driver.findElement(By.xpath("//div[@class = 'form-group']/input[@id='email']"));
        Actions actions = new Actions(driver);
        actions.sendKeys(username,"tomsmith").build().perform();

        //To Find password field
        WebElement password = driver.findElement(By.cssSelector("//div[@class = 'form-group']/input[@id='password']"));
        actions.sendKeys(password,"SuperSecretPassword").build().perform();

        WebElement login = driver.findElement(By.xpath("//div[@class='col-md-offset-3 col-md-6 col-sm-offset-2 col-sm-8']/input[@type='submit'])"));
        login.click();
        Thread.sleep(10000);
        Assert.assertEquals(login,"login successful !");

        WebElement checkbox = driver.findElement(By.xpath(""));
        System.out.println(checkbox.isSelected());

        Thread.sleep(5000);
//        DriverManager.getDriver().quit();
    }

    @AfterSuite
    public void tearDown() {
        DriverManager.getDriver().quit();
    }
}
