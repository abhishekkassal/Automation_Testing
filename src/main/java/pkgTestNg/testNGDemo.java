package pkgTestNg;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNGDemo {

    @BeforeTest
    public void beforeTest(){
        System.out.println("this is beforeTest method");
    }

    @Test
    public void test(){
        System.out.println("this is testing");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("this is afterTest method");
    }
}
