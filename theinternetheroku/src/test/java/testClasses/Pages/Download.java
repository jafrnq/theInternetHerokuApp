package testClasses.Pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// import org.openqa.selenium.time;

import utilityClasses.BaseTest;

public class Download extends BaseTest{

    @BeforeMethod
    public void navigateToPage(){
        String pageName = "File Download";

        utils.clickElement(pageName);
        assertEquals(driver.findElement(By.tagName("h3")).getText(), "File Downloader");
    }


    @Test
    public void testDownloadFile(){
        WebElement downloadLogo = utils.waitForElementToAppear(By.linkText("min.jpeg"));
        downloadLogo.click();
        
        //Code directory 
    }
    
    @Test
    public void downloadRandomFile(){
        clickRandomItem();
        utils.explicitWaitForSec(5);
    }

    @Test
    public void downloadMultipleRandomFile(){
        List<WebElement> downloadButtons = driver.findElements(By.cssSelector(".example a"));
        int itemCount = utils.ranIntGen(1, downloadButtons.size());

        for (int i = 0; i < itemCount; i++ ){
            clickRandomItem();
        }
    }


    public void clickRandomItem(){
        List<WebElement> downloadButtons = driver.findElements(By.cssSelector(".example a"));
        System.out.println("Number of downloadable files" + downloadButtons.size());

        int randomInt = utils.ranIntGen(1, downloadButtons.size());
        WebElement randomItem = downloadButtons.get(randomInt);

        System.out.println("Random item is: "+ randomItem.getText());
        downloadButtons.get(randomInt).click();
    }


    public void assertFileInDownloads(){}//to do tomorrow
    
}
