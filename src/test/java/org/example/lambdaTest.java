package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class lambdaTest {
    public static void main(String[] args){
        lambdaSignup();
    }

    public static void lambdaSignup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\Compressed\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");

        WebElement ele = driver.findElement(By.cssSelector(".icon.fas.fa-user"));

        //mouse hover over action
        Actions action=new Actions(driver);
        action.moveToElement(ele).perform();

        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.name("firstname")).sendKeys("Saurabh");
        driver.findElement(By.name("lastname")).sendKeys("Kumar");
        driver.findElement(By.name("email")).sendKeys("krsaurabh123@gmail.com");
        driver.findElement(By.name("telephone")).sendKeys("+917870518604");
        driver.findElement(By.name("password")).sendKeys("sk123456");
        driver.findElement(By.name("confirm")).sendKeys("sk123456");
        WebElement CB = driver.findElement(By.cssSelector("div.custom-control.custom-checkbox.custom-control-inline"));
        CB.click();

        //42.15,

    }
}
