package testClasses.Pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilityClasses.BaseTest;

public class ForgotPassword  extends BaseTest{
    By emailfield = By.cssSelector(".example #forgot_password .row div input");
    By retrievePassword = By.cssSelector(".example #form_submit ");


    @BeforeTest
    public void navigateToPage(){
        String pageName = "Forgot Password";
        utils.clickElement(pageName);
        // asserts.testHeaderContent(pageName);
    }

    @Test
    public void assertElements(){
        // asser
        WebElement emailInputField = driver.findElement(emailfield);
        WebElement retrievePasswordButton = driver.findElement(emailfield);
        
        assertTrue( emailInputField.isEnabled()
        && emailInputField.isDisplayed(), "Email input field is not visible or enabled");
        
        assertTrue( retrievePasswordButton.isEnabled()
        && retrievePasswordButton.isDisplayed(), "Email input field is not visible or enabled");
    }
    
    @Test
    public void testForgotPassword(){
        WebElement emailInputField = driver.findElement(emailfield);
        WebElement retrievePasswordButton = driver.findElement(retrievePassword);

        emailInputField.click();
        emailInputField.sendKeys("sampleEmail@gmail.com");
        retrievePasswordButton.click();

        String newPageHeader =driver.findElement(By.tagName("h1")).getText();
        assertTrue(newPageHeader.equals("Internal Server Error"));
    }
    
}
