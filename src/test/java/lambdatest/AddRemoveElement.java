package lambdatest;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddRemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver = new ChromeDriver();
		
		
		System.out.println("Browser opened");
		driver.manage().window().maximize();
		
		Set<String> windows = driver.getWindowHandles();
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 
		 
		 Addremove(driver, wait, windows);
	}
	public static void Addremove(WebDriver driver,Wait<WebDriver> wait, Set<String> windows )
	{
		driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
		 
		driver.findElement(By.cssSelector("button[onclick='addElement()']")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector(".added-manually")).getText(),"Delete");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".added-manually")));
	
		driver.findElement(By.cssSelector(".added-manually")).click();
		
		for(int i=0;i<3;i++)
		{
			
			driver.findElement(By.cssSelector("button[onclick='addElement()']")).click();
			}
		
		driver.findElement(By.cssSelector("a[target='_blank']")).click();
		
		
		Iterator<String>it = windows.iterator();
		
		String parentId = it.next();
		
		String childId = it.next();
		
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.cssSelector("img[alt='Elemental Selenium Logo']")).getText());
		driver.close();
	}
}