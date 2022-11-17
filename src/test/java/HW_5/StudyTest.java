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

public class StudyTest {
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
        driver.findElement(By.xpath("//div[@class=\"ske-button header__button-link\"]")).click();

        driver.findElement(By.xpath("//form[@id=\"ske-order-form-freelesson-learn-english-modal\"]//input[@placeholder=\"Имя\"]")).sendKeys("Nicolay");

        driver.findElement(By.xpath("//form[@id=\"ske-order-form-freelesson-learn-english-modal\"]//input[@placeholder=\"Email\"]")).sendKeys("nick@mail.ru");

        driver.findElement(By.xpath("//form[@id=\"ske-order-form-freelesson-learn-english-modal\"]//input[@name=\"phone\"]")).sendKeys("(888)888-88-88");

        driver.findElement(By.xpath("//form[@id=\"ske-order-form-freelesson-learn-english-modal\"]//button[@type=\"submit\"]")).click();

        String originalTitle = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(originalTitle, "Уроки английского в онлайн-школе Skyeng" );


    }
    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}

