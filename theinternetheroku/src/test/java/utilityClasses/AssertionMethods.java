package utilityClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static org.testng.Assert.assertTrue;

public class AssertionMethods {

    private WebDriver driver;
    private WebDriverWait wait;

    public AssertionMethods(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    //Assertion Methods
    public void testHeaderContent(String expectedHeaderText){
        try {
            WebElement headerTextH3 = driver.findElement(By.tagName("h3"));
        } catch (NoSuchElementException e) {
            String headerTextH4 = driver.findElement(By.tagName("h4")).getText();
            assertTrue(headerTextH4.equals(expectedHeaderText), "Header is not displayed or incorrect");
        }
        
        try {
            WebElement headerTextH4 = driver.findElement(By.tagName("h4"));
        } catch (NoSuchElementException e) {
            String headerTextH3 = driver.findElement(By.tagName("h3")).getText();
            assertTrue(headerTextH3.equals(expectedHeaderText), "Header is not displayed or incorrect");
        }


    }
}
