package HW_6.DNS;

import HW_7.JunitExtension;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.ByteArrayInputStream;


public class MultiCookerTest {

    @ExtendWith(JunitExtension.class)

    WebDriver driver;
    MainPage mainPage;
    @RegisterExtension
    JunitExtension testWatcher = new JunitExtension();


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get("https://www.dns-shop.ru/");
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
    }

    @Test
    @Flaky
    @Severity(value = SeverityLevel.CRITICAL)
    @Description("Наведение курсором мыши на раскрывающийся список, " +
            "и добавление рандомной мультиварки в избранное")
    void addToFavouriteTest() throws InterruptedException {
        mainPage.clickConfirmCity()
                .menuBlock.hoverMouseToMenuAndClickMultiCooker()
                .multiCookerPage.findAndClickRandomWishListButton()
                .clickCloseModal()
                .assertTitleWishList();

    }

    @Test
    @Severity(value = SeverityLevel.CRITICAL)
    @Description("Наведение курсором мыши на раскрывающийся список, " +
            "добавление рандомной мультиварки в список сравнения")
    void compareMultiCookers() throws InterruptedException {
        mainPage.clickConfirmCity()
                .menuBlock.hoverMouseToMenuAndClickMultiCooker()
                .multiCookerPage.findAndClickRandomMultiCooker()
                .clickCompareCheckbox()
                .closeCompareListPopUp()
                .clickMultiCooker()
                .findAndClickRandomMultiCooker()
                .clickCompareCheckbox()
                .clickCompareButton()
                .assertTitle();
    }

    @AfterEach
    void killBrowser() {
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry log: logs) {
            Allure.addAttachment("Элемент лога браузера", log.getMessage());
        }

        testWatcher.setScreenshot(new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        driver.quit();
    }

}

