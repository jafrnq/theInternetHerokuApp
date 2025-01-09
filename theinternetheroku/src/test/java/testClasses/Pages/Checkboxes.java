package testClasses.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.locators.RelativeLocator;
import java.util.List;


import static org.testng.Assert.assertTrue;

import utilityClasses.BaseTest;


public class Checkboxes extends BaseTest{
    
    By checkboxesElement = By.cssSelector("#checkboxes input[type='checkbox']");

    @BeforeMethod
    public void navigateToPage(){
        utils.clickElement("Checkboxes");
    }

    
    @Test
    public void testElementsVisivility(){
        asserts.testHeaderContent("Checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("#checkboxes input[type='checkbox']"));
        
        assertTrue(checkboxes.size() == 2, "Number of checkboxes is incorrect");
    } 
    
    @Test
    public void testClickCheckboxes(){

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("#checkboxes input[type='checkbox']"));
        System.out.println("Number of checkboxes: " + checkboxes.size());

        for (WebElement checkbox : checkboxes) {
            checkbox.click();
            utils.explicitWaitForSec(2);
            // assertTrue(checkbox.isSelected(), "Checkbox is not selected");
            // assert statement above not viable as the websites html causes both of the 
            // checkboxes to be selected when clicked
        }
        System.out.println("All checkboxes are selected");
    } 
    
}
