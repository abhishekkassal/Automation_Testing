package pkgTestNg;

import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class testNGDemo {

    WebDriver driver;
    @BeforeTest
    public void beforeTest(){
        System.out.println("this is beforeTest method");
        // System.setProperty("webdriver.chrome.driver", "/workspaces/Automation_Testing/chromedriver/chromedriver.exe");
        // driver = new ChromeDriver();

        
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--no-sandbox");

        options.addArguments("--disable-dev-shm-usage");

        options.addArguments("--headless");

        options.setBinary("/workspaces/Automation_Testing/chromedriver/chromedriver.exe");

        driver = new ChromeDriver(options);
        
    }

    @Test
    public void test(){
        System.out.println("this is testing");
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

    @AfterTest
    public void afterTest(){
        System.out.println("this is afterTest method");
        driver.quit();
    }
}
