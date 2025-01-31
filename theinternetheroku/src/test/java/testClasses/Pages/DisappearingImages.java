package testClasses.Pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilityClasses.BaseTest;

public class DisappearingImages extends BaseTest{
    

    @BeforeMethod
    public void navigateToPage(){
        String pageName = "Disappearing Elements";
        utils.clickElement(pageName);
        asserts.testHeaderContent(pageName);
    }


    @Test
    public void testOriginalElements(){
        assertPageElements();
    }

    @Test
    public void testRefreshElements(){
        assertPageElements();
        
        driver.navigate().refresh();
        
        assertNavBarContents();        

    }


    //Helper methods
    public void assertPageElements(){

        String expectedHeader = "Disappearing Elements";
        String expectedBody= "This example demonstrates when elements on a page change by disappearing/reappearing on each page load.";

        WebElement textElements = driver.findElement(By.cssSelector(".example"));
        WebElement navBar = textElements.findElement(By.cssSelector(".example ul"));

        String actualHeader = textElements.findElement(By.cssSelector("h3")).getText();
        String actualBody = textElements.findElement(By.cssSelector("p")).getText();

        System.out.println("Actual Header: " + actualHeader);
        System.out.println("Actual Body: " + actualBody);
        
        
        assertTrue(textElements.isDisplayed() && navBar.isDisplayed());
        assertEquals(actualHeader, expectedHeader, "Header is not as expected");
        assertEquals(actualBody, expectedBody, "Body is not as expected");
    }

    public void assertNavBarContents(){
        
        WebElement navBar = driver.findElement(By.cssSelector(".example ul"));
        List<WebElement> navBarElements = navBar.findElements(By.cssSelector("li"));
        List<String> expectedNavbarElements = List.of("Home", "About", "Contact Us", "Portfolio", "Gallery");

        
        for(WebElement li : navBarElements){
            try {
                assertTrue(navBarElements.size() == 5, "There is a missing element in the list");
                assertTrue(expectedNavbarElements.contains(li.getText()), "Element not found in the list:");

            } catch (Exception e) {
                System.out.println("Element not found in the list: " + li.getText());
            }
        }
    }
}
