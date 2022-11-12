package HW_6.SkyEng;

import HW_6.DNS.MainPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SkyEngCorpPageSkyEng extends SkyEngBasePage {

    public SkyEngCorpPageSkyEng(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='tn-atom' and text()='Продукты']")
    private WebElement products;


    @FindBy(xpath = "//a[@class='tn-atom' and text()='Тестирование']")
    private WebElement toTest;

    @FindBy(xpath = "//div[@class=\"t396__elem tn-elem tn-elem__4594191981655158454012\"]")
    private  WebElement leaveApply;

    @FindBy(xpath = "//input[@placeholder=\"Имя\"]")
    private WebElement name;

    @FindBy(xpath = "//input[@class=\"t-input t-input-phonemask\"]")
    private WebElement phoneNumber;

    @FindBy(xpath = "//input[@name=\"email\"]")
    private WebElement email;

    @FindBy(xpath = "//input[@name=\"company\"]")
    private WebElement companyName;

    @FindBy(xpath = "//select[@name=\"communication-by\"]")
    private WebElement communicateBy;

    @FindBy(xpath = "//option[@value=\"По телефону\"]")
    private WebElement byPhone;

    @FindBy(xpath = "//button[text()=\"Записаться\"]")
    private WebElement signUp;

    @FindBy(xpath = "//h1")
    private WebElement title;


    public SkyEngCorpPageSkyEng clickProducts() {
        webDriverWait.until(ExpectedConditions.visibilityOf(products));
        products.click();
        return this;
    }

    public SkyEngCorpPageSkyEng clickToTest() {
        webDriverWait.until(ExpectedConditions.visibilityOf(toTest));
        toTest.click();
        return this;
    }

    public SkyEngCorpPageSkyEng clickLeaveApply() {
        webDriverWait.until(ExpectedConditions.visibilityOf(leaveApply));
        leaveApply.click();
        return this;
    }

    public SkyEngCorpPageSkyEng fillApplication(String myName, String number, String myEmail, String company) {
            name.sendKeys(myName);
            phoneNumber.sendKeys(number);
            email.sendKeys(myEmail);
            companyName.sendKeys(company);

            communicateBy.click();
            byPhone.click();
            signUp.click();
            return this;
        }


    public void assertTitle() {

        Assertions.assertEquals("Курсы английского для компаний", title.getText());

    }

}
