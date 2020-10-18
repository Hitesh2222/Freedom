package drivermanager;

import config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager {
    private WebDriver driver;
    private static DriverManager instance;

    //class is private because we don't want to open multiple browser
    private DriverManager(){
            if (Config.getProperty("browser.name").equalsIgnoreCase(BrowserType.CHROME)){
                        System.setProperty(BrowserType.CHROME_PROPERTY,Config.getProperty("chrome.executable"));//set up the property
                        // set up a driver
                        driver = new ChromeDriver();
                WebDriverWait wait = new WebDriverWait(driver,20);
            }
            else if (Config.getProperty("browser.name").equalsIgnoreCase(BrowserType.FIREFOX)){
                System.setProperty(BrowserType.FIREFOX_PROPERTY,Config.getProperty("firefox.executable"));
                driver = new FirefoxDriver();
            }
            //default browser
            else {
                System.setProperty(BrowserType.CHROME_PROPERTY,Config.getProperty("chrome.executable"));
                driver = new ChromeDriver();
                WebDriverWait wait = new WebDriverWait(driver,20);
            }

    }
    //use synchronized method so we can not open two browser
    //our driver constructor is private.so we need to write a instance method to write a driver
    public synchronized static WebDriver getDriver(){
                if (instance==null){
                    instance = new DriverManager();
                }
                return instance.driver;
    }
}
