package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.*;

public class herokuTest {
    public static void main(String[] args){
        checkBox();
    }
        public static void checkBox(){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\Compressed\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver=new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
            driver.get("https://the-internet.herokuapp.com/checkboxes");

            List <WebElement> l = driver.findElements(By.cssSelector("#checkboxes"));
            for(WebElement i:l){
                if(i.getText().equalsIgnoreCase("checkbox 2")){
                    i.click();
                }
            }
        }

}
