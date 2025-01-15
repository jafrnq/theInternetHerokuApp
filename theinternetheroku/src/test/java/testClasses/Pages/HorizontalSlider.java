package testClasses.Pages;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilityClasses.BaseTest;

public class HorizontalSlider extends BaseTest{
    By sliderElement = By.cssSelector(".example .sliderContainer input[type='range']");
    

    @BeforeMethod
    public void navigateToPage(){
        String pageName = "Horizontal Slider";
        utils.clickElement(pageName);
        asserts.testHeaderContent(pageName);
    }
    
    
    @Test
    public void testSliderUsingArrowKeys(){
        int steps = (4*2);
        WebElement slider = driver.findElement(sliderElement);
        
        assertTrue(slider.isDisplayed());
        
        //use arrow keys to control the slider
        for(int i = 0; i < steps; i++){
            driver.findElement(sliderElement).sendKeys(Keys.ARROW_RIGHT);
        }
        
        //Assert value, for tomorrow 
        float currSliderValue = getSliderValue();
        assertEquals(currSliderValue, 4.0);
    }
    
    public float getSliderValue(){
        float sliderValue = Float.parseFloat(driver.findElement(By.id("range")).getText());
        return sliderValue;
    }
    
    // @Test
    // public void testSliderUsingClick(){
    //     // WebElement slider = driver.findElement(sliderElement);
    //     // actions.click(slider).perform();
    //     // utils.explicitWaitForSec(5);
    // }

    // @Test
    // public void testSliderUsingClickAndDrag(){
    //     WebElement slider = driver.findElement(sliderElement);
    //     actions.dragAndDropBy(slider, 10, 0); //notworking
    //     }
    }
