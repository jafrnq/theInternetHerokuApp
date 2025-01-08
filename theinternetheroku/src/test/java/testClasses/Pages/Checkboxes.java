package testClasses.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;


import static org.testng.Assert.assertTrue;

import utilityClasses.AssertionMethods;
import utilityClasses.BaseTest;


public class Checkboxes extends BaseTest{
    By checkboxesElement = By.cssSelector("#checkboxes input[type='checkbox']");
    AssertionMethods assertionMethods = new AssertionMethods(driver);

    @Test
    public void testElementsVisivility(){
        assertionMethods.testHeaderContent("Checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("#checkboxes input[type='checkbox']"));
        
        assertTrue(checkboxes.size() == 2, "Number of checkboxes is incorrect");
    } 
    
    @Test
    public void testClickCheckboxes(){
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("#checkboxes input[type='checkbox']"));

        for (WebElement checkbox : checkboxes) {
            checkbox.click();
            assertTrue(checkbox.isSelected(), "Checkbox is not selected");
            System.out.println(checkbox.getText() + " is selected");
        }
    } 
    
}
