package testClasses.Pages;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.NoSuchElementException;
import utilityClasses.BaseTest;

public class BasicAuthentication extends BaseTest{
    String domain = "the-internet.herokuapp.com/basic_auth";


    
    @Test //Test using valid login credentials
    public void validLogin(){
        login("admin", "admin");
        
        assertLoginScreen();        
    }
    
    @Test //Test using invalid login credentials
    public void invalidLogin(){
        login("admin", "admins");
        
        assertLoginScreen();        
    }
    
    @Test //Test using empty login fields
    public void emptyLogin(){
    login("", "");
    
    assertLoginScreen();     
    }

//Utility Methods
    public void login(String username, String password){
        String loginUrl = "https://" + username + ":" + password + "@" + domain;
        driver.get(loginUrl);
    }

    public void assertLoginScreen(){
        try {
            WebElement heading  = driver.findElement(By.cssSelector("h3"));
            WebElement paragraph = driver.findElement(By.cssSelector("p"));


            assertTrue(heading.isDisplayed() 
            && paragraph.isDisplayed(), "Heading is not displayed");
            
            assertTrue(heading.getText().equals("Basic Auth") 
            && paragraph.getText().equals("Congratulations! You must have the proper credentials."), "Heading or paragraph text is not correct");
    
        } catch(NoSuchElementException e){
            System.out.println("Login screen is not displayed, Login credentials incorrect");
        }
    }
}
