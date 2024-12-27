package testClasses;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class HomePage {
    public WebDriver driver;
    public Actions actions;
    public WebDriverWait wait;

    @BeforeTest
    public void driverSetUp(){
        System.out.println("Driver set up");

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        
    }

    @AfterClass
    public void driverTearDown(){
        System.out.println("Driver tear down");
        driver.quit();
    }

    @Test
    public void homePageTest(){
        System.out.println("Tangina mo jehphoy dizon");

        assertTrue(driver.getTitle().equals("The Internet"), "Title is not correct");
    }
}
