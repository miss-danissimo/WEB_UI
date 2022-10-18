package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;

public class TeachersApplication  {

        public static void main(String[] args) {

            WebDriverManager.chromedriver().setup();
            WebDriver chromeDriver = new ChromeDriver();

            chromeDriver.manage().window().maximize();
            chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            chromeDriver.get("https://skyeng.ru/");

            chromeDriver.findElement(By.xpath("//a[text()=\"Учителям\"]")).click();

            String oldTab = chromeDriver.getWindowHandle();

            chromeDriver.findElement(By.xpath("//div[@data-elem-id=\"1659039102499\"]")).click();

            ArrayList<String> newTab = new ArrayList<String>(chromeDriver.getWindowHandles());
            newTab.remove(oldTab);
            chromeDriver.close();

            chromeDriver.switchTo().window(newTab.get(0));

            chromeDriver.findElement(By.xpath("//div[@data-input-lid=\"1661430864050\"]//select")).click();

            chromeDriver.findElement(By.xpath("//div[@data-input-lid=\"1661430864050\"]//option[@value=\"Программирование для детей\"]")).click();

            chromeDriver.findElement(By.xpath("//div[@data-input-lid=\"1661430864051\"]//input")).sendKeys("Victor");

            chromeDriver.findElement(By.xpath("//div[@data-input-lid=\"1661430864052\"]//input")).sendKeys("Vito");

            chromeDriver.findElement(By.xpath("//div[@data-input-lid=\"1661430864053\"]//input")).sendKeys("vi.to@mail.ru");

            chromeDriver.findElement(By.xpath("//div[@data-elem-id=\"1661430864050\"]//button")).click();


            chromeDriver.quit();

        }
    }
