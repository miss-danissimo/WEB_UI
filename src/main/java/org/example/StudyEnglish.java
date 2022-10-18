package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class StudyEnglish {
    public static void main(String[] args)  {

        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        chromeDriver.get("https://magazine.skyeng.ru/");

        chromeDriver.findElement(By.xpath("//div[@class=\"ske-button header__button-link\"]")).click();

        chromeDriver.findElement(By.xpath("//form[@id=\"ske-order-form-freelesson-learn-english-modal\"]//input[@placeholder=\"Имя\"]")).sendKeys("Nicolay");

        chromeDriver.findElement(By.xpath("//form[@id=\"ske-order-form-freelesson-learn-english-modal\"]//input[@placeholder=\"Email\"]")).sendKeys("nick@mail.ru");

        chromeDriver.findElement(By.xpath("//form[@id=\"ske-order-form-freelesson-learn-english-modal\"]//input[@name=\"phone\"]")).sendKeys("(888)888-88-88");

        chromeDriver.findElement(By.xpath("//form[@id=\"ske-order-form-freelesson-learn-english-modal\"]//button[@type=\"submit\"]")).click();


        chromeDriver.quit();

    }
}
