package testClasses.Pages;

import static org.testng.Assert.assertEquals;
// import static org.testng.Assert.assertTrue;

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

    //Test Methods======================================================================================================
    @Test
    public void testDownloadFile(){
        List<WebElement> downloadButtons = driver.findElements(By.cssSelector(".example a"));
        WebElement firstDownloadFile = downloadButtons.get(0);
        
        firstDownloadFile.click();
        utils.explicitWaitForSec(1);

        String fileName = firstDownloadFile.getText();
        asserts.assertFileInDownloads(fileName);
        
    }
    
    @Test
    public void downloadRandomFile(){
        clickRandomItem();
    }

    @Test
    public void downloadMultipleRandomFile(){
        List<WebElement> downloadButtons = driver.findElements(By.cssSelector(".example a"));
        int itemCount = utils.ranIntGen(1, downloadButtons.size());

        for (int i = 0; i < itemCount; i++ ){
            clickRandomItem();
            System.out.println("Downloaded " + i + " files");
        }
    }

    //Helper Methods=========================================================================================================
    public void clickRandomItem(){
        List<WebElement> downloadButtons = driver.findElements(By.cssSelector(".example a"));
        System.out.println("Number of downloadable files" + downloadButtons.size());

        int randomInt = utils.ranIntGen(1, downloadButtons.size());
        WebElement randomItem = downloadButtons.get(randomInt);
        String fileName = randomItem.getText();

        System.out.println("Downloaded file: "+ randomItem);
        downloadButtons.get(randomInt).click();
        
        utils.explicitWaitForSec(1);
        asserts.assertFileInDownloads(fileName);
    }


    
}
