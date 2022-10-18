package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CorpApplication {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        chromeDriver.get("https://skyeng.ru/");

        chromeDriver.findElement(By.xpath("//a[@href='https://corporate.skyeng.ru/?utm_source=skyeng-ru&utm_medium=referral&utm_campaign=main-page&utm_content=header']")).click();

        chromeDriver.findElement(By.xpath("//a[@class='tn-atom' and text()='Продукты']")).click();

        chromeDriver.findElement(By.xpath("//a[@class='tn-atom' and text()='Тестирование']")).click();

        chromeDriver.findElement(By.xpath("//div[@class=\"t396__elem tn-elem tn-elem__4594191981655158454012\"]")).click();

        chromeDriver.findElement(By.xpath("//input[@placeholder=\"Имя\"]")).sendKeys("Utya");

        chromeDriver.findElement(By.xpath("//input[@class=\"t-input t-input-phonemask\"]")).sendKeys("(373) 302-20-23");

        chromeDriver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("utya@mail.ru");

        chromeDriver.findElement(By.xpath("//input[@name=\"company\"]")).sendKeys("utya.com");

        chromeDriver.findElement(By.xpath("//select[@name=\"communication-by\"]")).click();

        chromeDriver.findElement(By.xpath("//option[@value=\"По телефону\"]")).click();

        chromeDriver.findElement(By.xpath("//button[text()=\"Записаться\"]"));

        chromeDriver.quit();

    }
}
