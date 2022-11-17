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
import java.util.ArrayList;

public class TeachersAppTest {
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
        driver.findElement(By.xpath("//a[text()=\"Учителям\"]")).click();

        String oldTab = driver.getWindowHandle();

        driver.findElement(By.xpath("//div[@data-elem-id=\"1659039102499\"]")).click();

        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        driver.close();

        driver.switchTo().window(newTab.get(0));

        driver.findElement(By.xpath("//div[@data-input-lid=\"1661430864050\"]//select")).click();

        driver.findElement(By.xpath("//div[@data-input-lid=\"1661430864050\"]//option[@value=\"Программирование для детей\"]")).click();

        driver.findElement(By.xpath("//div[@data-input-lid=\"1661430864051\"]//input")).sendKeys("Victor");

        driver.findElement(By.xpath("//div[@data-input-lid=\"1661430864052\"]//input")).sendKeys("Vito");

        driver.findElement(By.xpath("//div[@data-input-lid=\"1661430864053\"]//input")).sendKeys("vi.to@mail.ru");

        driver.findElement(By.xpath("//div[@data-elem-id=\"1661430864050\"]//button")).click();


        String originalTitle = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(originalTitle, "Level up  your teaching experience" );


    }
    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}

