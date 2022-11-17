package HW_5;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;


import java.time.Duration;
import java.util.List;
import java.util.Random;


public class AddToFavouritesTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);
    }

    @Test
    void moveTest() {
        driver.get("https://www.dns-shop.ru/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"v-confirm-city__buttons\"]//span[@class=\"base-ui-button-v2__text\" and contains(text(),\"Всё верно\")]")));
        driver.findElement(By.xpath("//div[@class=\"v-confirm-city__buttons\"]//span[@class=\"base-ui-button-v2__text\" and contains(text(),\"Всё верно\")]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"menu-desktop\"]//div[@class=\"menu-desktop__root-info\"]//a[text()=\"Бытовая техника\"]")));
        actions.moveToElement(driver.findElement(By.xpath("//div[@class=\"menu-desktop\"]//div[@class=\"menu-desktop__root-info\"]//a[text()=\"Бытовая техника\"]")))
                .perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"menu-desktop__submenu menu-desktop__submenu_top\"]//a[text()=\"Приготовление пищи\"]")));
        actions.moveToElement(driver.findElement(By.xpath("//div[@class=\"menu-desktop__submenu menu-desktop__submenu_top\"]//a[text()=\"Приготовление пищи\"]")))
                .perform();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\"Мультиварки\"]")));

        driver.findElement(By.xpath("//a[text()=\"Мультиварки\"]")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"button-ui button-ui_white button-ui_icon wishlist-btn\"]")));

        List<WebElement> allItems = driver.findElements(By.xpath("//button[@class=\"button-ui button-ui_white button-ui_icon wishlist-btn\"]"));
        Random rand = new Random();
        int randomItem = rand.nextInt(allItems.size());
        WebElement randomElem = allItems.get(randomItem);
        String expectedTitle = randomElem.getText();
        randomElem.click();
        String originalTitle = driver.findElement(By.xpath("//h1")).getText();
     //   Assert.assertNotEquals(originalTitle, expectedTitle);


    }
}


//    @AfterEach
//    void quitBrowser() {
//        driver.quit();
//    }
//}


