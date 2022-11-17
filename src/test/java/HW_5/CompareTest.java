package HW_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class CompareTest {
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
    void dnsTest() throws InterruptedException {
        driver.get("https://www.dns-shop.ru/");
        Thread.sleep(6000);
        driver.findElement(By.xpath("//div[@class=\"v-confirm-city__buttons\"]//span[@class=\"base-ui-button-v2__text\" and contains(text(),\"Всё верно\")]")).click();
        Thread.sleep(6000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class=\"menu-desktop\"]//div[@class=\"menu-desktop__root-info\"]//a[text()=\"Бытовая техника\"]")))
                .perform();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"menu-desktop__submenu menu-desktop__submenu_top\"]//a[text()=\"Приготовление пищи\"]")));

        actions.moveToElement(driver.findElement(By.xpath("//div[@class=\"menu-desktop__submenu menu-desktop__submenu_top\"]//a[text()=\"Приготовление пищи\"]")))
                .perform();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\"Мультиварки\"]")));

        driver.findElement(By.xpath("//a[text()=\"Мультиварки\"]")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"catalog-product__name ui-link ui-link_black\"]")));

        List<WebElement> allItems = driver.findElements(By.xpath("//a[@class=\"catalog-product__name ui-link ui-link_black\"]"));
        Random rand = new Random();
        int randomItem = rand.nextInt(allItems.size());
        WebElement randomElem = allItems.get(randomItem);
        randomElem.click();


        driver.findElement(By.xpath("//span[@class=\"compare-checkbox\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"base-modal__container\"]//i[@data-base-modal-action=\"close\"]")));

        driver.findElement(By.xpath("//div[@class=\"base-modal__container\"]//i[@data-base-modal-action=\"close\"]")).click();

        driver.findElement(By.xpath("//span[text()=\"Мультиварки\"]")).click();

        List<WebElement> newItems = driver.findElements(By.xpath("//a[@class=\"catalog-product__name ui-link ui-link_black\"]"));
        int newRandomItem = rand.nextInt(newItems.size());
        WebElement newRandomElem = newItems.get(newRandomItem);
        newRandomElem.click();

        driver.findElement(By.xpath("//span[@class=\"compare-checkbox\"]")).click();

        driver.findElement(By.xpath("//div[@class=\"buttons\"]//a[@href=\"/compare/\"]")).click();

        String originalTitle = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(originalTitle, "Сравнение товаров" );


    }
    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}
