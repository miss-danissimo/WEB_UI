package HW_6.SkyEng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SkyEngBasePage {
    public Actions actions;
    public WebDriver driver;
   public WebDriverWait webDriverWait;


    public SkyEngBasePage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
}
