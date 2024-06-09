package com.example.lab3;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FindTest {
    private WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    @SneakyThrows
    public void goToDromTest() {
        driver.get("https://www.drive2.ru/");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1000); // страница прогружается
        driver.findElement(By.linkText("Посмотреть больше машин на Дроме")).click();

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

        wait.until(ExpectedConditions.urlContains("spb.drom.ru"));
    }

    @Test
    @SneakyThrows
    public void goToDromFirstCarTest() {
        driver.get("https://www.drive2.ru/");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1000); // страница прогружается
        driver.findElement(By.xpath("/html/body/main/div[3]/div[2]/a[1]/x-img/img")).click();

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

        wait.until(ExpectedConditions.urlContains("drom.ru"));
    }

    @Test
    public void mercedesExperienceTest() {
        driver.get("https://www.drive2.ru/");
        driver.findElement(By.xpath("//a[contains(@style, 'mercedes')]")).click();

        wait.until(ExpectedConditions.urlContains("https://www.drive2.ru/experience/mercedes/"));
        assertEquals("Mercedes-Benz",
                driver.findElement(By.xpath("/html/body/main/div/div[2]/div[1]/div/header/h1"))
                        .getText());
    }
}
