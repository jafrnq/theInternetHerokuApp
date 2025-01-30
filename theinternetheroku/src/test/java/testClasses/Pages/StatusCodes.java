package testClasses.Pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.RestAssured;

import java.net.HttpURLConnection;

import utilityClasses.BaseTest;

public class StatusCodes extends BaseTest{

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
        
        assertInPageStatusCode("200");
        assertInPageStatusCode("301");
        assertInPageStatusCode("404");
        assertInPageStatusCode("500");
        
    }

    @Test 
    public void testRestAssured(){}
    
    
    //Selenium doesnt have a build in method to handle HTTP status codes
    //Using RestAssured
    @Test
    public void assertHTTPcode(){
        assertHTTPcode(200);
        assertInPageStatusCode("301");
        assertHTTPcode(404);
        assertHTTPcode(500);
    }
    
    
    //Helper Methods
    public void assertInPageStatusCode(String codeName){
        WebElement code = driver.findElement(By.linkText(codeName));
        code.click();

        String statusCodetext = driver.findElement(By.cssSelector(".example p")).getText();
        System.out.println(statusCodetext);

        assertTrue(driver.getCurrentUrl().endsWith("status_codes/" + codeName));
        driver.navigate().back();
    }

    public void assertHTTPcode(int codeName){
        Response response = RestAssured.get("https://the-internet.herokuapp.com/status_codes/" + codeName);
        System.out.println("HTTP Response: " + response.getStatusCode());
        assertTrue(response.getStatusCode() == codeName);

        // WebElement code = driver.findElement(By.linkText(codeName));
        // code.click();
        // Response response = RestAssured.get(driver.getCurrentUrl());
    }

    
}

