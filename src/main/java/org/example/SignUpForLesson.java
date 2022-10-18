package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class SignUpForLesson {

    public static void main(String[] args)  {

        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        chromeDriver.get("https://skyeng.ru/");

        chromeDriver.findElement(By.xpath("//button[text()=\"Записаться на урок\"]")).click();


        chromeDriver.findElement(By.xpath("//div[@id=\"form-box-top2-holder\"]//input[@placeholder=\"Имя\"]")).sendKeys("Ivan");

        chromeDriver.findElement(By.xpath("//div[@id=\"form-box-top2-holder\"]//input[@placeholder=\"Телефон\"]")).sendKeys("+7 (986) 254-72-83");

        chromeDriver.findElement(By.xpath("//div[@id=\"form-box-top2-holder\"]//input[@placeholder=\"Почта\"]")).sendKeys("iv.an@mail.ru");

        chromeDriver.findElement(By.xpath("//div[@id=\"form-box-top2-holder\"]//span[text()=\"Оставить заявку\"]")).click();


        chromeDriver.quit();

    }
}
