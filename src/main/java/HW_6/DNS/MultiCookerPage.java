package HW_6.DNS;

import HW_6.SkyEng.SkyEngBasePage;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class MultiCookerPage extends SkyEngBasePage {

    public MultiCookerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1")
    private WebElement title;
    @FindBy(xpath = "//div[@class=\"base-modal__container\"]//b[text()=\"Товар добавлен в Избранное\"]")
    private WebElement titleWishList;
    @FindBy(xpath = "//button[@class=\"button-ui button-ui_white button-ui_icon wishlist-btn\"]")
    private List<WebElement> multiCookerWishListButton;
    @FindBy(xpath = "//span[@class=\"compare-checkbox\"]")
    private WebElement compareCheckbox;
    @FindBy(xpath = "//div[@class=\"buttons\"]//a[@href=\"/compare/\"]")
    private WebElement compareButton;
    @FindBy(xpath = "//div[@class=\"base-modal__container\"]//i[@data-base-modal-action=\"close\"]")
    private WebElement closePopUp;
    @FindBy(xpath = "//a[@class=\"catalog-product__name ui-link ui-link_black\"]")
    private List<WebElement> multiCookersList;
    @FindBy(xpath = "//span[text()=\"Мультиварки\"]")
    private WebElement multiCooker;

    @FindBy(xpath = "//div[@class=\"base-modal__container\"]//a")
    private WebElement closeModal;

    public MultiCookerPage findAndClickRandomWishListButton() {

        Random rand = new Random();
        int randomItem = rand.nextInt(multiCookerWishListButton.size());
        multiCookerWishListButton.get(randomItem).click();
        return this;
    }

    public void assertTitleWishList() {
        Assertions.assertEquals("Мультиварки", title.getText());

    }

    public MultiCookerPage findAndClickRandomMultiCooker() {
        Random rand = new Random();
        int randomItem = rand.nextInt(multiCookersList.size());
        multiCookersList.get(randomItem).click();
        return this;
    }

    public MultiCookerPage clickCompareCheckbox() {
        webDriverWait.until(ExpectedConditions.visibilityOf(compareCheckbox));
        compareCheckbox.click();
        return this;
    }

    public MultiCookerPage closeCompareListPopUp() {
        webDriverWait.until(ExpectedConditions.visibilityOf(closePopUp));
        closePopUp.click();
        return this;
    }

    public MultiCookerPage clickCompareButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(compareButton));
        compareButton.click();
        return this;
    }

    public MultiCookerPage clickMultiCooker() {
        webDriverWait.until(ExpectedConditions.visibilityOf(multiCooker));
        multiCooker.click();
        return this;
    }

    public MultiCookerPage clickCloseModal() {
        webDriverWait.until(ExpectedConditions.visibilityOf(closeModal));
        closeModal.click();
        return this;
    }
    public void assertTitle() {
        Assertions.assertEquals("Сравнение товаров", title.getText());

    }
}