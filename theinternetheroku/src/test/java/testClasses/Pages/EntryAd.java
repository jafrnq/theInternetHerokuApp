package testClasses.Pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilityClasses.BaseTest;

public class EntryAd extends BaseTest{

    @BeforeTest
    public void navigateToPage(){
        String pageName ="Entry Ad";
        utils.clickElement(pageName);
        // asserts.testHeaderContent(pageName);
    }
    
    @Test
    public void testEntryModal(){
        String expectedBodyText = "It's commonly used to encourage a user to take an action (e.g., give their e-mail address to sign up for something or disable their ad blocker)";
        WebElement modal = utils.waitForElementToAppear(By.cssSelector("#modal .modal"));

        WebElement modalHeader = modal.findElement(By.className("modal-title"));
        WebElement modalBody= modal.findElement(By.className("modal-body"));
        WebElement modalFooter = modal.findElement(By.className("modal-footer"));

        assertTrue(modalHeader.getText().equals("THIS IS A MODAL WINDOW"), "Modal title text not visible");
        
        System.out.println(modalBody.getText());
        assertTrue(modalBody.getText().contains(expectedBodyText), "Incorrect modal body text");
        
        assertTrue(modalFooter.getText().equals("Close"),"Footer button text is incorrect");
        System.out.println("Done testing entry modal");
    }
    
}
