package testClasses.Pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilityClasses.BaseTest;

public class ExitIntent extends BaseTest{
    By page = By.cssSelector("#content .example");
    // By flashMessZone = By.cssSelector("#flash-messages");
    By flashMessZone = By.cssSelector(".row #flash-messages");

    @BeforeMethod
    public void navigateToPage(){
        String pageName = "Exit Intent";

        utils.clickElement(pageName);
        asserts.testHeaderContent(pageName);
    }

    @Test
    public void assertElements(){
        WebElement pageContent = driver.findElement(page);
        WebElement header =  pageContent.findElement(By.tagName("h3"));
        WebElement paragraph = pageContent.findElement(By.tagName("p"));

        String expectedParagraphContent = "Mouse out of the viewport pane and see a modal window appear.";

        assertTrue(header.isDisplayed() && paragraph.isDisplayed());
        assertTrue(paragraph.getText().equals(expectedParagraphContent));
        
    }
    
    @Test
    public void testExitIntent(){
        WebElement exitZone = driver.findElement(flashMessZone);
        WebElement messageModal = driver.findElement(By.id("ouibounce-modal"));

        assertTrue(messageModal.getCssValue("display").equals("none"),"Modal is not initially hidden");
        
        WebElement modal = driver.findElement(By.cssSelector(".modal"));
        switchToModal(modal);

        WebElement modalHeader = modal.findElement(By.cssSelector(".modal-title h3"));
        System.out.println(modalHeader.getText());
        /*Note: Selenium has no existing command that allows you move the mouse outside the viewport so automating 
         the move mouse at -y axis would cause it to go outside the viewport forcing me to use js to change the
         display attribute of the modal element */
    }

    public void switchToModal(WebElement element){
        js.executeScript("arguments[0].style.display='block';", element);
    }
    
}
