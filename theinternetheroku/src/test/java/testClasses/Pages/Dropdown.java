package testClasses.Pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilityClasses.BaseTest;

public class Dropdown extends BaseTest{

    @BeforeMethod
    public void navigateToPage(){
        utils.clickElement("Dropdown");
        asserts.testHeaderContent("Dropdown List");

    }    


    @Test
    public void testDropdown(){
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        dropdownElement.click();
        utils.explicitWaitForSec(3);

        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue("1");
        printAndAssertSelectedOption(dropdown, "Option 1");
        
        dropdown.selectByValue("2");
        printAndAssertSelectedOption(dropdown, "Option 2");

    }

    public void printAndAssertSelectedOption(Select dropdown, String expectedOptionText){
        String selectedOption = dropdown.getFirstSelectedOption().getText();
        System.out.println("Selected option is: " + selectedOption);
        assertTrue(selectedOption.equals(expectedOptionText));

    }
}
