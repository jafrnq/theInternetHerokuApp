package testClasses.Pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilityClasses.BaseTest;

public class DragandDrop extends BaseTest{

    @BeforeMethod
    public void navigateToPage(){
        utils.clickElement("Drag and Drop");
        asserts.testHeaderContent("Drag and Drop");
    }

    @Test
    public void testElementsVisivility(){
        WebElement columns = driver.findElement(By.id("columns"));
        WebElement columnA = columns.findElement(By.id("column-a"));
        WebElement columnB= columns.findElement(By.id("column-b"));
        
        assertTrue(columnA.isDisplayed() && columnB.isDisplayed(), "Columns are not displayed");
    }
    
    
    @Test
    public void testDraggingElements(){
        WebElement columns = driver.findElement(By.id("columns"));
        WebElement columnA = columns.findElement(By.id("column-a"));
        WebElement columnB= columns.findElement(By.id("column-b"));

        actions.dragAndDrop(columnA, columnB).perform();

        assertTrue(columnA.getText().equals("B") 
                && columnB.getText().equals("A")
                , "Columns are not swapped");
    
        actions.dragAndDrop(columnA, columnB).perform();

        assertTrue(columnA.getText().equals("A") 
                && columnB.getText().equals("B")
                , "Columns are not swapped back to its original place");
    
    }
    
}
