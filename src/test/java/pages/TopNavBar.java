package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopNavBar {
    private WebDriver driver;


    public TopNavBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void click(){

    }

}
