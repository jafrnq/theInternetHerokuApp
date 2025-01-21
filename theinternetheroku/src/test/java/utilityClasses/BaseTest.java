// BaseTest.java
package utilityClasses;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected UtilityMethods utils;  
    protected AssertionMethods asserts;
    
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;
    public Actions actions;
    
    @BeforeTest
    public void driverSetUp() {
        System.out.println("Driver set up");
        driver = new ChromeDriver();
        actions = new Actions(driver);
        utils = new UtilityMethods(driver);  // Pass s
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        driver.get("https://the-internet.herokuapp.com/");
    }
    
    @AfterMethod
    public void postTestActions(){
        System.out.println("Test Completed" + "\n");
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterClass
    public void driverTearDown(){
        System.out.println("Driver tear down");
        
        driver.quit();
    }


    //waitmethods
}