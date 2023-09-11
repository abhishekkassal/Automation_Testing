package brokenimages;
 
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import org.openqa.selenium.By;
import java.net.URL;
 
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class test_brokenimages
{
    /*  protected static ChromeDriver driver; */
    WebDriver driver = null;
    String URL = "https://the-internet.herokuapp.com/broken_images";
    @Test(description="Approach 2: Find broken images on a web page using Selenium WebDriver", enabled = true)
    protected void test_selenium_broken_images_appr_2()
    {
        Integer iBrokenImageCount = 0;
 
        driver.navigate().to(URL);
        driver.manage().window().maximize();
 
        try
        {
            iBrokenImageCount = 0;
            List<WebElement> image_list = driver.findElements(By.tagName("img"));
            /* Print the total number of images on the page */
            System.out.println("The page under test has " + image_list.size() + " images");
            for (WebElement img : image_list)
            {
                if (img != null)
                {
                    if (img.getAttribute("naturalWidth").equals("0"))
                    {
                        System.out.println(img.getAttribute("outerHTML") + " is broken.");
                        iBrokenImageCount++;
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            status = "failed";
            System.out.println(e.getMessage());
        }
        status = "passed";
        System.out.println("The page " + URL + " has " + iBrokenImageCount + " broken images");
    }
 
    @AfterClass
    public void tearDown()
    {
        if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit();
        }
    }
}