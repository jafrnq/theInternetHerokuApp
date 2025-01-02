package testClasses.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utilityClasses.BaseTest;

public class BrokenImages extends BaseTest{
    
    @Test
    public void testImages(){
        utils.clickElement("Broken Images");

        for (WebElement image: driver.findElements(By.cssSelector("img"))){
            isImageBroken(image);
        }
    }


    public void isImageBroken(WebElement imageElement){
        if (imageElement.getAttribute("naturalWidth").equals("0")){
            System.out.println("Element" + imageElement.getAttribute("outerHTML") + "Is broken");
        }

    }

}

