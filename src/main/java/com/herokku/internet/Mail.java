package com.herokku.internet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Mail {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String id = "rahul7178@gmail.com";
        System.out.println(" ** Test Started **");
        WebDriver driver = new ChromeDriver();
        System.out.println("Browser opened");
        driver.manage().window().maximize();

        driver.get("https://elementalselenium.com/");

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        list(driver, wait, id);
    }

    public static void list(WebDriver driver, Wait<WebDriver> wait, String id) {
        driver.get("https://elementalselenium.com/");

        driver.findElement(By.cssSelector("input[value='Join the mailing list']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector(".pb-2")).getText(), "Elemental Selenium Newsletter");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pb-2")));
        driver.navigate().back();

        driver.findElement(By.cssSelector(".navbar__item.navbar__link.nav-button")).click();

        Assert.assertEquals(driver
                .findElement(By.xpath("//p[normalize-space()='One email every tuesday, nothing else.']")).getText(),
                "One email every tuesday, nothing else.");

        driver.findElement(By.cssSelector("input#email")).sendKeys(id);

        driver.findElement(By.cssSelector("select[name='fields[programming_language]']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("select[name='fields[programming_language]'] > option[value='Java']")));

        driver.findElement(By.cssSelector("select[name='fields[programming_language]'] > option[value='Java']"))
                .click();

        driver.findElement(By.xpath("//div[@id='docusaurus_skipToContent_fallback']")).click();

        driver.findElement(By.cssSelector("input[value='Send me Selenium tips']")).click();

        System.out.println(driver.findElement(By.cssSelector("div[class='thanks-container'] h1")).getText());

        driver.close();

    }
}
