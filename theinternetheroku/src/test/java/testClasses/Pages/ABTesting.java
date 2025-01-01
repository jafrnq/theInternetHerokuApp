// ABTesting.java
package testClasses.Pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilityClasses.*;
import org.testng.annotations.Test;

public class ABTesting extends BaseTest {

    String paragraphContent = "Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through).";
    
    
    @Test
    public void testElementsVisibility(){
        utils.clickElement("A/B Testing");  // Changed utility to utils

        WebElement heading = driver.findElement(By.cssSelector("div.example h3"));
        WebElement paragraph  = driver.findElement(By.cssSelector("div.example p"));
        
        assertTrue(driver.getCurrentUrl().contains("abtest"), "URL is not correct");
        assertTrue(heading.isDisplayed() && paragraph.isDisplayed(), "Heading or paragraph is not displayed");
        assertTrue(heading.getText().equals("A/B Test Control") && paragraph.getText().equals(paragraphContent), "Heading or paragraph text is not correct");
    }
}