package utilityClasses;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
// import static org.testng.Assert.assertTrue;

public class UtilityMethods extends BaseTest{
    private WebDriver driver;
    private WebDriverWait wait;
    private Random random;
    
    // Receive driver instance using constructor
    public UtilityMethods(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.random = new Random();
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

    public void waitForElementToDisappear(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    // public void waitForElementToAppear(By element){
    //     wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    // }
    
    public WebElement waitForElementToAppear(By element){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

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

    //randomGenerators
    public int ranIntGen (int min, int max){
        return random.nextInt(max - min + 1) + min;
    }


    //file management
    public void deleteAllFileInDirectory(String directoryPath){
        File folder = new File(directoryPath);

        if(folder.exists() && folder.isDirectory()){
            try {
            FileUtils.cleanDirectory(folder);
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Failed to clean directory: " + directoryPath);
            }
        } else {
            System.out.println("Directory does not exist or path is incorrect");
        } 
    }



    //End of utility class
}
