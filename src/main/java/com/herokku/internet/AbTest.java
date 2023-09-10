package com.herokku.internet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(" ** Test Started **");
        WebDriver driver = new ChromeDriver();
        System.out.println("Browser opened");
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/");
        // Explicit Wait
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".heading")));

        Herokku(driver, wait);
    }

    public static void Herokku(WebDriver driver, Wait<WebDriver> wait) {
        driver.findElement(By.cssSelector("a[href='/abtest']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='example'] h3")));

        System.out.println(driver.findElement(By.cssSelector("div[class='example'] p")).getText());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[target='_blank']")));

        driver.findElement(By.cssSelector("a[target='_blank']")).click();

        if (driver.getCurrentUrl().equals("https://elementalselenium.com/")) {
            System.out.println(driver.findElement(By.cssSelector(".home-header")).getText());
        } else {
            System.out.println("Code failed!!!>>>Retry");
        }

        // driver.close();

        System.out.println(" ** Test Completed **");
    }

}
