package testcases;

import config.Config;
import drivermanager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest {
    private static Logger logger = LogManager.getLogger(HomeTest.class);

    @Test(enabled = false)
    public void dummyTest(){
        logger.fatal("here is I am with {} FATAL","Hitesh");
        logger.info("here is I am with {} INFO","Hitesh");
        logger.error("here is I am with {} ERROR","Hitesh");
        logger.debug("here is I am with {} DEBUG","Hitesh");
        logger.trace("here is I am with {} TRACE","Hitesh");
    }
    @Test
    public void testBrowserProperty() throws InterruptedException {
//        System.out.println(Config.getProperty("firefox.executable"));
//        Assert.assertEquals(Config.getProperty("browser.name"),"chrome","Name Mismatch");
        DriverManager.getDriver().get(Config.getProperty("app.url"));
        Thread.sleep(5000);
        DriverManager.getDriver().quit();
    }
    
}
