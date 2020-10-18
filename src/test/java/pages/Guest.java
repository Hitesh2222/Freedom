package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Guest {
    private WebDriver driver;

    @FindBy(xpath = "/html/body/div[3]/div/div/div/div[2]/div/div[2]/div[2]/button")
    private WebElement guest;
    public Guest(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void guestClick(){

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(guest));
        this.guest.click();
    }
}
