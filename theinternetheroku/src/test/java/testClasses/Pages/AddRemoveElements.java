package testClasses.Pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import utilityClasses.*;
import org.testng.annotations.Test;


public class AddRemoveElements extends BaseTest{
    By addElement = By.cssSelector("button[onclick='addElement()']");
    By deleteElementsContainer = By.id("elements");

    @Test
    public void testElementsVisibility(){
        goToPage();

        WebElement heading = driver.findElement(By.cssSelector("h3"));
        WebElement addElementButton = driver.findElement(addElement);

        assertTrue(heading.isDisplayed() && addElementButton.isDisplayed(), "Heading or Add Element button is not displayed");
        assertTrue(heading.getText().equals(("Add/Remove Elements")) && 
                   addElementButton.getText().equals("Add Element"), "Content Texts are incorrect");

    }
    
    @Test
    public void AddElement(){
        goToPage();

        clickButton(5);
    }
    
    @Test
    public void RemoveElement(){
        goToPage();

        clickButton(5);
        
        deleteAllElements();
    }
    
//Utility Methods=============================================================================================================================

    public void goToPage(){
        utils.clickElement("Add/Remove Elements");
        assertTrue(driver.getCurrentUrl().contains("add_remove_elements/"), "URL is incorrect");
    }

    public void clickButton(int index){
        WebElement AddElementButton = driver.findElement(addElement);
    
        for (int i = 0; i < index; i++){
            AddElementButton.click();
        }

        WebElement deleteButtons = driver.findElement(deleteElementsContainer);
        int numberOfDeleteElements = deleteButtons.findElements(By.tagName("button")).size();

        System.out.println("Number of elements to delete: " + numberOfDeleteElements);
        assertTrue(numberOfDeleteElements == index, "Number of elements is incorrect");
    }

    public void deleteAllElements(){
        WebElement deleteButtons = driver.findElement(deleteElementsContainer);
        int numberOfDeleteElements = deleteButtons.findElements(By.tagName("button")).size();

        System.out.println("Number of elements to delete: " + numberOfDeleteElements);
        deleteButtons.findElements(By.tagName("button")).forEach(WebElement::click);
        
        try{
            WebElement deleteButton = driver.findElement(By.cssSelector("button[onclick='deleteElement()']"));
        } catch(NoSuchElementException e){
            System.out.println("All elements have been deleted");
        }
    }

}
