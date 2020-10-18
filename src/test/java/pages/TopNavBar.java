package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopNavBar {
    private WebDriver driver;

    @FindBy(xpath = "//picture/img[@class='sc-htoDjs dyLAwc']")
    private WebElement logo;

    @FindBy(xpath = "//ul[@id=\"main-menu\"]/li[1]/button/span")
    private WebElement shop;

    @FindBy(xpath = "//ul[@id=\"Shop\"]/li[1]/a")
    private WebElement devices;

    public TopNavBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void shopClick(){

        this.shop.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(shop));

    }
    public void deviceClick(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(devices));
        this.devices.click();
    }
}
