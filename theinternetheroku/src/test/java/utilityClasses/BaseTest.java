// BaseTest.java
package utilityClasses;

import static org.testng.Assert.assertTrue;

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

import io.restassured.response.Response;
import io.restassured.RestAssured;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    //Other Methods
    protected UtilityMethods utils;  
    protected AssertionMethods asserts;

    //Libraries
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;
    public Actions actions;
    protected Response response;

    protected String downloadPath  = "G:\\CODES SA SSD\\Automation things\\Selenium\\theInternetHerokuApp\\theinternetheroku\\src\\test\\resources\\downloads";
    
    @BeforeTest
    public void driverSetUp() {
        //Setup Chrome
        HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("download.default_directory", downloadPath);
            chromePrefs.put("download.prompt_for_download", false);
            chromePrefs.put("download.directory_upgrade", true);
            chromePrefs.put("safebrowsing.enabled", true);
        
        //Setting download path
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);
        
        System.out.println("Driver set up");
        actions = new Actions(driver);
        utils = new UtilityMethods(driver);  // Pass
        asserts = new AssertionMethods(driver); // Pass
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        

        driver.get("https://the-internet.herokuapp.com/");
        
        // Response response = RestAssured.get("https://the-internet.herokuapp.com/");
        // assertTrue(response.getStatusCode() == 200, "Page is not accessible");

    }
    
    @AfterMethod
    public void postTestActions(){
        System.out.println("Test Completed" + "\n");
        driver.get("https://the-internet.herokuapp.com/");
        utils.deleteAllFileInDirectory(downloadPath);
    }

    @AfterClass
    public void driverTearDown(){
        System.out.println("Driver tear down");
        
        driver.quit();
    }


    
    
}