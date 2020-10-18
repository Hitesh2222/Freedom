package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Plans {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div/div[3]/div[2]/div/div[2]/div/button")
    private WebElement plan;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div/div[3]/div[2]/div/div[2]/div/button")
    private WebElement cont;

    @FindBy(xpath = "//*[@id=\"skip-navigation\"]/div/div/div[2]/div[1]/div[4]/div[4]/div[1]/div[1]/button")
    private WebElement printSummary;

    public Plans(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void planClick(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(plan));
        this.plan.click();
    }
    public void contClick(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(cont));
        this.cont.click();
    }
    public void printSummaryClick(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(printSummary));
        this.printSummary.click();
    }
}
