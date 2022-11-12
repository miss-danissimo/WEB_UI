package HW_6.DNS;

import HW_6.DNS.MainPage;
import HW_6.DNS.MenuBlock;
import HW_6.DNS.MultiCookerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class MultiCookerTest {
    WebDriver driver;
    MainPage mainPage;


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
    void addToFavouriteTest() throws InterruptedException {
        mainPage.clickConfirmCity()
                .menuBlock.hoverMouseToMenuAndClickMultiCooker()
                .multiCookerPage.findAndClickRandomWishListButton()
                .clickCloseModal()
                .assertTitleWishList();

    }

    @Test
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


//
//    @AfterEach
//    void killBrowser() {
//        driver.quit();}
//

}

