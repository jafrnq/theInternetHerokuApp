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
        WebElement sliderElement = getSliderElement();
        
        //use arrow keys to control the slider
        for(int i = 0; i < (4 * 2); i++){
            sliderElement.sendKeys(Keys.ARROW_RIGHT);
        }
        
        //Assert value, for tomorrow 
        float currSliderValue = getSliderValue();
        assertEquals(currSliderValue, 4.0, "Slider value is incorrect");
    }

    //HELPER METHODS===================================================================================================
    public WebElement getSliderElement(){
        WebElement slider = driver.findElement(sliderElement);
        assertTrue(slider.isDisplayed());

        return slider;
        }
    
    public float getSliderValue(){
        float sliderValue = Float.parseFloat(driver.findElement(By.id("range")).getText());
        return sliderValue;
        }

    }
