package utilityClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertTrue;

public class UtilityMethods{
    private WebDriver driver;
    private WebDriverWait wait;
    
      // Receive driver instance using constructor
      public UtilityMethods(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    
    //Navigation
    public void clickElement(String elementName){
        WebElement linkText = driver.findElement(By.linkText(elementName));
        linkText.click();
        System.out.println("Clicked on " + elementName);
    }

    //Print out methods 

    public void displayHeadingText(String text){
        System.out.println("==================================" + text + "==================================");
    }


    //Wait methods

    public void explicitWaitForSec(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //modalAlerts
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public String getAlertText(){
        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert text is: " + alertText);
        return alertText;
    }
}
