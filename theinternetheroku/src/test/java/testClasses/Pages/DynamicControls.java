package testClasses.Pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilityClasses.BaseTest;

public class DynamicControls extends BaseTest{
    By checkboxExample = By.id("checkbox-example");
    By inputExample = By.id("input-example");

    @BeforeMethod
    public void navigateToPage(){
        utils.clickElement("Dynamic Controls");
        asserts.testHeaderContent("Dynamic Controls");
    }

    @Test
    public void addingAndRemovingElement(){
        WebElement checkboxDiv = driver.findElement(checkboxExample);
        WebElement checkboxButton = checkboxDiv.findElement(By.id("checkbox"));
        WebElement removeButton = checkboxDiv.findElement(By.tagName("button"));

        //Tests the checkbox before removing it
        clickAndAssertCheckbox(checkboxButton);

        assertTrue(checkboxDiv.isDisplayed() 
                && checkboxButton.isDisplayed() 
                && removeButton.isDisplayed(), "Checkbox div is not visible");

        assertTrue(checkboxButton.isDisplayed() 
                && checkboxButton.getText().equals("A checkbox"));


        //Removes the checkbox and asserts that it is removed
        removeButton.click();
        utils.waitForElementToDisappear(checkboxButton);
        assertTrue(driver.findElement(By.id("message")).getText().equals("It's gone!"), "Message is not displayed");
    }
    
    
    
    @Test 
    public void enablingAndDisablingElement(){
        WebElement inputDiv = driver.findElement(inputExample);
        WebElement inputField = inputDiv.findElement(By.tagName("input"));
        WebElement enableButton = inputDiv.findElement(By.tagName("button"));

        //Assert that the input field is disabled before enabling it
        assertTrue(inputField.isEnabled() == false, "Input field is enabled");
        
        //Enables the input field and asserts that it is enabled
        clickButtonAndAssertMessage(enableButton, "It's enabled!");
        assertTrue(inputField.isEnabled() == true, "Input field is not enabled");
        inputField.sendKeys("Hello World");

        //Disables the input field and asserts that it is disabled
        clickButtonAndAssertMessage(enableButton, "It's disabled!");

    }

    public void clickAndAssertCheckbox(WebElement checkbox){
        WebElement checkboxInput = checkbox.findElement(By.tagName("input"));
        checkboxInput.click();
        System.out.println("Checkbox is selected: " + checkboxInput.isSelected());
    }

    public void clickButtonAndAssertMessage(WebElement button, String expectedMessage){
        button.click();
        utils.waitForElementToAppear(By.cssSelector("#input-example #message"));
        assertTrue(driver.findElement(By.cssSelector("#input-example #message")).getText().equals(expectedMessage), "Message is not displayed");
    }

    
}
