package com.herokku.internet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Elementstest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(" ** Test Started **");
        WebDriver driver = new ChromeDriver();
        System.out.println("Browser opened");
        driver.manage().window().maximize();

        driver.get("https://elementalselenium.com/");

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        Activities(driver, wait);
    }

    public static void Activities(WebDriver driver, Wait<WebDriver> wait) {
        driver.findElement(By.xpath("//a[normalize-space()='External Resources']")).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='External Resources']")));
        if (driver.getCurrentUrl().equals("https://elementalselenium.com/resources")) {
            System.out.println(driver
                    .findElement(By.xpath(
                            "//div[@class='content-text']//h2//a[@href='https://www.selenium.dev/documentation/']"))
                    .getText());

        } else {
            System.out.println("Code failed!!!>>>Retry");
        }

        driver.findElement(By.xpath("//a[@href='https://www.selenium.dev/documentation/']//span[contains(text(),'➔')]"))
                .click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[@href='https://www.selenium.dev/documentation/']//span[contains(text(),'➔')]")));

        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='td-content'] h1")).getText(),
                "The Selenium Browser Automation Project");

        driver.close();
    }

}
