package testClasses.Pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilityClasses.BaseTest;

public class FloatingMenu extends BaseTest{
    By FloatingMenu = By.cssSelector(".example");

    @BeforeMethod
    public void navigateToPage(){
        utils.clickElement("Floating Menu");
    }
    
    
    @Test
    public void testElementsVisibility(){
        asserts.testHeaderContent("Floating Menu");
        
        WebElement floatingMenuPage = driver.findElement(FloatingMenu);
        WebElement menu = floatingMenuPage.findElement(By.cssSelector(" #menu"));
        WebElement paragraphs = floatingMenuPage.findElement(By.cssSelector(".row"));

        //Asserts visibility of Elements
        assertTrue(floatingMenuPage.isDisplayed(), "Floating Menu Page is not visible");
        assertTrue(menu.isDisplayed() && paragraphs.isDisplayed(), "Menu or Paragraphs are not visible");

        //Assert menuItem's visibility
        List<WebElement> menuItems = menu.findElements(By.cssSelector("ul li"));
        assertTrue(menuItems.size() == 4, "Menu items are incomplete");

        for(WebElement menuItem : menuItems){
            System.out.println(menuItem.getText() + " is visibile");
            assertTrue(menuItem.isDisplayed(), "Menu item is not visible");
        }

        //Assert paragraphs visibility
        List<WebElement> paragraphsList = paragraphs.findElements(By.cssSelector("div p"));
        assertTrue(paragraphsList.size() == 10, "Paragraphs are incomplete");
        System.out.println("All elements in the page are visible");
    }
    
    @Test
    public void testMenuButtons(){
        clickAllMenuButtons();
    }
    
    @Test
    public void testMenuStickyness(){
        //navigate to the bottom of the page
        WebElement finalParagraph = driver.findElement(By.cssSelector(".example .row div p:nth-of-type(10)"));
        js .executeScript("arguments[0].scrollIntoView();", finalParagraph);
        
        clickAllMenuButtons();
        System.out.println("Menu is working at the bottom of the page");
     
    }

    public void clickAllMenuButtons(){
        List<WebElement> menuItems = driver.findElements(By.cssSelector(".example #menu ul li"));
        assertTrue(menuItems.size() == 4, "Menu items are incomplete");

        //Assert menuItem's visibilityz
        for(WebElement menuItem : menuItems){
            menuItem.click();

            assertTrue(menuItem.isDisplayed() && menuItem.isEnabled(), "Menu item is not visible");
            System.out.println(menuItem.getText() + " is visibile and clickable");
        }
    }

    
    
}
