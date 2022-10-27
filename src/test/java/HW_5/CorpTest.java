package HW_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class CorpTest {
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
    void corpTest() throws InterruptedException {
        driver.get("https://skyeng.ru/");
        Thread.sleep(6000);
        driver.findElement(By.xpath("//a[@href='https://corporate.skyeng.ru/?utm_source=skyeng-ru&utm_medium=referral&utm_campaign=main-page&utm_content=header']")).click();

        driver.findElement(By.xpath("\"//a[@class='tn-atom' and text()='Продукты']")).click();

        driver.findElement(By.xpath("//a[@class='tn-atom' and text()='Тестирование']")).click();

        driver.findElement(By.xpath("//div[@class=\\\"t396__elem tn-elem tn-elem__4594191981655158454012\\\"]")).click();

        driver.findElement(By.xpath("//div[@class=\\\"t396__elem tn-elem tn-elem__4594191981655158454012\\\"]")).click();

        driver.findElement(By.xpath("//div[@class=\"t396__elem tn-elem tn-elem__4594191981655158454012\"]")).click();

        driver.findElement(By.xpath("//input[@placeholder=\"Имя\"]")).sendKeys("Utya");

        driver.findElement(By.xpath("//input[@class=\"t-input t-input-phonemask\"]")).sendKeys("(373) 302-20-23");

        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("utya@mail.ru");

        driver.findElement(By.xpath("//input[@name=\"company\"]")).sendKeys("utya.com");

        driver.findElement(By.xpath("//select[@name=\"communication-by\"]")).click();

        driver.findElement(By.xpath("//option[@value=\"По телефону\"]")).click();

        driver.findElement(By.xpath("//button[text()=\"Записаться\"]"));


        String originalTitle = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(originalTitle, "Курсы английского для компаний " );


    }
    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}
