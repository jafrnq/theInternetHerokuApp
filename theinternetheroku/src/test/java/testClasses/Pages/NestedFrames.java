package testClasses.Pages;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.*;


import utilityClasses.BaseTest;


//di pa ayos potah
public class NestedFrames extends BaseTest{

    @BeforeMethod
    public void navigateToPage(){
        String pageName = "Nested Frames";
        utils.clickElement(pageName);
    }
    
    
    // @Test
    // public void testNestedFrames(){
    //     List<WebElement> frames = driver.findElements(By.tagName("iframe"));
    //     System.out.println("Frame Size: " + frames.size());

    //     for(WebElement frame : frames){
    //         driver.switchTo().frame(frame);
    //         String frameLabel = frame.getText();

    //         System.out.println("Frame is: " +  frameLabel);
    //     }
    // }


    @Test
    public void testtestse(){
        // Switch to the first iframe
        driver.switchTo().frame("frame-top");
        // displayFrameText();
        
        // Switch to the nested iframe within the first iframe
        driver.switchTo().frame("frame-left");
        displayFrameText();
        
        driver.switchTo().frame("frame-right");
        displayFrameText();
        
        driver.switchTo().frame("frame-bottom");
        displayFrameText();
    }

    public void displayFrameText(){
        // Now you are inside the nested iframe, target the body element
        WebElement bodyElement = driver.findElement(By.tagName("body"));
        System.out.println("Body text: " + bodyElement.getText());
    }
    

    
    
}
