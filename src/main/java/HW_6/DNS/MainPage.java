package HW_6.DNS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    public MenuBlock  menuBlock;
    public MultiCookerPage multiCookerPage;

    public MainPage(WebDriver driver) {
        super(driver);
        menuBlock = new MenuBlock(driver);
        multiCookerPage = new MultiCookerPage(driver);
    }

    @FindBy(xpath = "//div[@class=\"v-confirm-city__buttons\"]//span[@class=\"base-ui-button-v2__text\" and contains(text(),\"Всё верно\")]")
    private WebElement confirmCity;

    public MainPage clickConfirmCity() {
        webDriverWait.until(ExpectedConditions.visibilityOf(confirmCity));
        confirmCity.click();
        return this;
    }





}
