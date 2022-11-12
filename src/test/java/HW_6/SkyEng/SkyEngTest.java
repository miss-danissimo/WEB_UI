package HW_6.SkyEng;

import HW_6.DNS.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SkyEngTest {

        WebDriver driver;
        SkyEngMainPageSkyEng skyEngMainPageSkyEng;


        @BeforeAll
        static void registerDriver() {
            WebDriverManager.chromedriver().setup();
        }

        @BeforeEach
        void initDriver() {
            driver = new ChromeDriver();
            driver.get("https://skyeng.ru/");
            driver.manage().window().maximize();
            skyEngMainPageSkyEng = new SkyEngMainPageSkyEng(driver);
        }


        @Test
        void applyForCorpTesting() {
            skyEngMainPageSkyEng.clickCorporateEnglish()
                    .skyEngCorpPageSkyEng.clickProducts()
                    .clickToTest()
                    .clickLeaveApply()
                    .fillApplication("Utya",
                            "(373) 302-20-23",
                            "utya@mail.ru",
                            "utya.com")
                    .assertTitle();

        }

        @Test
    void applyFreeLesson() throws InterruptedException {
          skyEngMainPageSkyEng.signUpForLesson("Nicolay","nick@mail.ru", "(888)888-88-88")
                  .assertTitle();

        }



//
//    @AfterEach
//    void killBrowser() {
//        driver.quit();}
//

    }

