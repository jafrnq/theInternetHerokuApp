// BaseTest.java
package utilityClasses;

import java.time.Duration;
import java.util.HashMap;
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

import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    protected UtilityMethods utils;  
    protected AssertionMethods asserts;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;
    public Actions actions;

    // protected String downloadPath  = "G:/CODES SA SSD/Automation things/Selenium/theInternetHerokuApp/theinternetheroku/src/test/resourcesdownloads";
    
    // HashMap<String, Object> chromePrefs = new HashMap<>();
    // chromePrefs.put("download.default_directory", downloadPath);
    // chromePrefs.put("download.prompt_for_download", false);
    // chromePrefs.put("download.directory_upgrade", true);
    // chromePrefs.put("safebrowsing.enabled" true);
    
    
    @BeforeTest
    public void driverSetUp() {
        System.out.println("Driver set up");
        driver = new ChromeDriver();
        actions = new Actions(driver);
        utils = new UtilityMethods(driver);  // Pass
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