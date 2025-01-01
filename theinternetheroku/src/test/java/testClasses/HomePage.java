package testClasses;
import static org.testng.Assert.assertTrue;
import utilityClasses.BaseTest;
import utilityClasses.UtilityMethods;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class HomePage extends BaseTest{
    // public WebDriver driver;
    public Actions actions;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    By liElements = By.cssSelector("ul li");

    @Test
    public void elementsVisibilityTest (){ //Test if the elements are visible
        System.out.println("Starting test");

        WebElement headingMessage = driver.findElement(By.className("heading"));
        WebElement subheadingMessage = driver.findElement(By.tagName("h2"));

        int liElementsCount= driver.findElements(liElements).size(); 
    

        assertTrue(driver.getTitle().equals("The Internet"), "Title is not correct");
        assertTrue(headingMessage.isDisplayed() && 
                   subheadingMessage.isDisplayed() && 
                   liElementsCount== 44, "Elements are not visible");

    }

    @Test
    public void elementsClickTest (){ //Test if the elements are clickable

        List<WebElement> liContainer = driver.findElements(liElements);
        System.out.println(liContainer.size());

        for (WebElement li : liContainer){
            WebElement link = wait.until(ExpectedConditions.elementToBeClickable(li));
            System.out.println(link.getText());
        }
    }
}