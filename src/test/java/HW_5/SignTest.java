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

public class SignTest {
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
    void signTest() throws InterruptedException {
        driver.get("https://skyeng.ru/");
        Thread.sleep(6000);
        driver.findElement(By.xpath("//button[text()=\"Записаться на урок\"]")).click();

        driver.findElement(By.xpath("//div[@id=\"form-box-top2-holder\"]//input[@placeholder=\"Имя\"]")).sendKeys("Ivan");

        driver.findElement(By.xpath("//div[@id=\"form-box-top2-holder\"]//input[@placeholder=\"Телефон\"]")).sendKeys("+7 (986) 254-72-83");

        driver.findElement(By.xpath("//div[@id=\"form-box-top2-holder\"]//input[@placeholder=\"Почта\"]")).sendKeys("iv.an@mail.ru");

        driver.findElement(By.xpath("//div[@id=\"form-box-top2-holder\"]//span[text()=\"Оставить заявку\"]")).click();


        String originalTitle = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(originalTitle, "Уроки английского в онлайн-школе Skyeng" );


    }
    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}

