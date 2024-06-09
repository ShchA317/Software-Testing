package com.example.lab3;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    private final static String EMAIL = "";
    private final static String PASSWORD = "";

    private WebDriver driver;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        Dimension dimension = new Dimension(1080, 1080);
        driver.manage().window().setSize(dimension);
        js = (JavascriptExecutor) driver;
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @SneakyThrows
    @Test
    public void loginTest() {
        driver.get("https://www.drive2.ru/");
        driver.findElement(By.linkText("Войти")).click();
        {
            WebElement element = driver.findElement(By.name("Login"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        {
            WebElement element = driver.findElement(By.name("Login"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.name("Login"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        driver.findElement(By.name("Login")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(EMAIL);
        driver.findElement(By.id("loginForm")).click();
        driver.findElement(By.name("Password")).click();
        driver.findElement(By.xpath("//input[@tabindex='2']")).sendKeys(PASSWORD);
        driver.findElement(By.xpath("//button[@tabindex='4']")).click();

        // ждем загрузки страницы
        Thread.sleep(5000);
        // Лента видна только залогиненому пользователю
        assertEquals("Лента", driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[1]/div[1]/header/h1")).getText());
    }
}
