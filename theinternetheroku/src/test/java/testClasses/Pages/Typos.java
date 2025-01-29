package testClasses.Pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;

import utilityClasses.BaseTest;

public class Typos extends BaseTest{

    @BeforeMethod
    public void navigateToPage(){
        String pageName = "Status Codes";
        utils.clickElement(pageName);
        asserts.testHeaderContent(pageName);
        assertTrue(driver.getCurrentUrl().endsWith("status_codes"));
    }

    @Test
    public void checkElementsVisibility(){
        System.out.println("Tangina mo jephoy dizon");
    }


    @Test
    public void assertInPageCode(){
        //click code 200
        //Assert url end 
        
        assertInPageStatusCode("200");
        assertInPageStatusCode("301");
        assertInPageStatusCode("404");
        assertInPageStatusCode("500");
        
    }
    //Selenium doesnt have a build in method to handle HTTP status codes
    public void assertHTTPcode(){}
    
    
    //Helper Methods
    public void assertInPageStatusCode(String codeName){
        WebElement code = driver.findElement(By.linkText(codeName));
        code.click();

        String statusCodetext = driver.findElement(By.cssSelector(".example p")).getText();
        System.out.println(statusCodetext);

        assertTrue(driver.getCurrentUrl().endsWith("status_codes/" + codeName));
        driver.navigate().back();
    }

    // public int  assertStatusCodes(){
    //     HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
    //     connection.setRequestMethod("GET");
    //     connection.connect();
    //     return connection.getResponseCode();
    // }
    
}

