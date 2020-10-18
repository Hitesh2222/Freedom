package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DevicesList {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"skip-navigation\"]/div/div/div[2]/ul/li[6]/a/div/div[3]/img")
    private WebElement iPhoneSE;

    @FindBy(xpath = "//*[@id=\"skip-navigation\"]/div/div/div[1]/div[1]/div[10]/button")
    private WebElement plan;
    public DevicesList(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void iPhoneSEClick(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(iPhoneSE));
        this.iPhoneSE.click();

    }
    public void planClick(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(plan));
        this.plan.click();
    }
}
