package testClasses;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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


    By liElements = By.cssSelector("ul li");


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
    public void elementsVisibilityTest (){ //Test if the elements are visible
        System.out.println("Starting test");

        WebElement headingMessage = driver.findElement(By.className("heading"));
        WebElement subheadingMessage = driver.findElement(By.tagName("h2"));
        // int liElements = driver.findElements(liElements).size(); 
    

        assertTrue(driver.getTitle().equals("The Internet"), "Title is not correct");
        assertTrue(headingMessage.isDisplayed() && 
                   subheadingMessage.isDisplayed() && 
                   liElements == 44, "Elements are not visible");
    }

    @Test
    public void elementsClickTest (){ //Test if the elements are clickable

    }


}