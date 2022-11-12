package HW_6.DNS;

import HW_6.SkyEng.SkyEngBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MenuBlock extends SkyEngBasePage {
    public MenuBlock(WebDriver driver) {
        super(driver);

    }
    @FindBy(xpath = "//div[@class=\"menu-desktop\"]//div[@class=\"menu-desktop__root-info\"]//a[text()=\"Бытовая техника\"]")
    private WebElement menuAppliences;

    @FindBy(xpath = "//div[@class=\"menu-desktop__submenu menu-desktop__submenu_top\"]//a[text()=\"Приготовление пищи\"]")
    private WebElement menuCookingFood;

    @FindBy(xpath = "//a[text()=\"Мультиварки\"]")
    private WebElement multiCooker;

    public MainPage hoverMouseToMenuAndClickMultiCooker () throws InterruptedException {

        Thread.sleep(5000);
        actions.moveToElement(menuAppliences)
                .perform();

        Thread.sleep(5000);
        actions.moveToElement(menuCookingFood)
                .perform();

        Thread.sleep(3000);
        multiCooker.click();

        return new MainPage(driver);

         }


}
