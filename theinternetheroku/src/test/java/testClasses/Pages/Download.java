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
        WebElement downloadLogo = utils.waitForElementToAppear(By.linkText("logo.png"));

        downloadLogo.click();
        utils.explicitWaitForSec(5);

        //Code directory 
    }

    @Test
    public void downloadRandomFile(){
        utils.clickElement("logo.png"); 
    }

    @Test
    public void downloadMultipleRandomFile(){
        int rere = utils.ranIntGen(1, 48);

        for (int i = 0; i < rere; i++ ){
            clickRandomItem();
        }
    }


    public void clickRandomItem(){
        List<WebElement> downloadButtons = driver.findElements(By.cssSelector(".example a"));

        int randomInt = utils.ranIntGen(1, downloadButtons.size());
        WebElement randomItem = downloadButtons.get(randomInt);

        System.out.println("Random item is: "+ randomItem.getText());
        downloadButtons.get(randomInt).click();
    }


    public void assertFileInDownloads(){}//to do 
    
}
