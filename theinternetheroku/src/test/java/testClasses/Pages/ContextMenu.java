package testClasses.Pages;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilityClasses.BaseTest;

public class ContextMenu extends BaseTest{
    String expectedModalMessage = "You selected a context menu";


    @BeforeMethod
    public void navigateToPage(){
        utils.clickElement("Context Menu");
        asserts.testHeaderContent("Context Menu");
    }

    @Test
    public void testElementsVisivility(){
        
        WebElement hotSpot = driver.findElement(By.id("hot-spot"));
        assertTrue(hotSpot.isDisplayed(), "Hotspot is not displayed");
    }
    
    @Test
    public void rightClickHotspotTest(){
        WebElement hotSpot = driver.findElement(By.id("hot-spot"));
        
        actions.contextClick(hotSpot).perform(); // Right clicks on the hotspot

        String modalMessage = utils.getAlertText();
        assertTrue(modalMessage.equals(expectedModalMessage), "Modal message is not as expected");
        utils.acceptAlert();
    }
}
