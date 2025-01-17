package testClasses.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import utilityClasses.BaseTest;

public class Hovers extends BaseTest{
    By profileImages = By.className("figure");

    @BeforeTest
    public void navigateToPage(){
        String pageName = "Hovers";
        utils.clickElement(pageName);
        asserts.testHeaderContent(pageName);
        
    }

    @Test
    public void hoverOverAllImages(){
        List<WebElement> profiles = driver.findElements(profileImages);
        
        for(WebElement profile : profiles){
            hoverProfileAndAssertContents(profile);
        }
    }
    
    @Test
    public void hoverOverRandomImage(){
        List<WebElement> profiles = driver.findElements(profileImages);

        WebElement randomProfile = profiles.get(utils.ranIntGen(0, 2));
        hoverProfileAndAssertContents(randomProfile);
    }


    public void hoverProfileAndAssertContents(WebElement profile){
        actions.moveToElement(profile).perform();

        WebElement figCaption = profile.findElement(By.cssSelector(".figcaption"));
        String profileName = figCaption.findElement(By.tagName("h5")).getText();
        assertTrue(profile.findElement(By.tagName("img")).isDisplayed() 
                && figCaption.isDisplayed() 
                && figCaption.findElement(By.linkText("View profile")).isEnabled());    

        System.out.println(profileName);

    }
    
}
