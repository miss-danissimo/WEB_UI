package HW_6.SkyEng;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SkyEngMainPageSkyEng extends SkyEngBasePage {
    public SkyEngMainPageSkyEng(WebDriver driver) {
        super(driver);
    }
    public SkyEngCorpPageSkyEng skyEngCorpPageSkyEng;

    @FindBy(xpath = "//div//button[@class=\"catalog-header-signin-button\"]")
    private WebElement signUp;

    @FindBy(xpath = "//form[@id=\"ske-order-form-freelesson-learn-english-modal\"]//input[@placeholder=\"Имя\"]")
    private WebElement name;

    @FindBy(xpath = "//form[@id=\"ske-order-form-freelesson-learn-english-modal\"]//input[@placeholder=\"Email\"]")
    private WebElement email;

    @FindBy(xpath = "//form[@id=\"ske-order-form-freelesson-learn-english-modal\"]//input[@name=\"phone\"]")
    private WebElement phone;

    @FindBy(xpath = "//form[@id=\"ske-order-form-freelesson-learn-english-modal\"]//button[@type=\"submit\"]")
    private WebElement submit;
    @FindBy(xpath = "//a[@href='https://corporate.skyeng.ru/?utm_source=skyeng-ru&utm_medium=referral&utm_campaign=main-page&utm_content=header']")
    private WebElement corporateEnglish;
    @FindBy(xpath = "//h1")
    private WebElement title;

    public SkyEngMainPageSkyEng clickCorporateEnglish() {
        webDriverWait.until(ExpectedConditions.visibilityOf(corporateEnglish));
        corporateEnglish.click();
        return this;
    }



    public SkyEngMainPageSkyEng signUpForLesson(String myName, String myEmail, String myPhone) throws InterruptedException {
        Thread.sleep(5000);
        signUp.click();

        name.sendKeys(myName);
        email.sendKeys(myEmail);
        phone.sendKeys(myPhone);

        return this;
    }

    public void assertTitle() {
        Assertions.assertEquals("Уроки английского в онлайн-школе Skyeng", title.getText());
    }
}
