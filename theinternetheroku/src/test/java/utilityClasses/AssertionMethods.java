package utilityClasses;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static org.testng.Assert.assertTrue;

public class AssertionMethods{

    private WebDriver driver;
    private WebDriverWait wait;
    public String downloadPath  = "G:\\CODES SA SSD\\Automation things\\Selenium\\theInternetHerokuApp\\theinternetheroku\\src\\test\\resources\\downloads";


    public AssertionMethods(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.downloadPath = downloadPath;
    }


// Assertion Methods
public void testHeaderContent(String expectedHeaderText) {
    try {
        WebElement headerTextH2 = driver.findElement(By.tagName("h2"));
        assertTrue(headerTextH2.getText().equals(expectedHeaderText), "Header is not displayed or incorrect");
    } catch (NoSuchElementException e) {
        // Do nothing if h2 is not found
        }

    try {
        WebElement headerTextH3 = driver.findElement(By.tagName("h3"));
        assertTrue(headerTextH3.getText().equals(expectedHeaderText), "Header is not displayed or incorrect");
    } catch (NoSuchElementException e) {
        // Do nothing if h3 is not found
        }

    try {
        WebElement headerTextH4 = driver.findElement(By.tagName("h4"));
        assertTrue(headerTextH4.getText().equals(expectedHeaderText), "Header is not displayed or incorrect");
    } catch (NoSuchElementException e) {
        // Do nothing if h4 is not found
        }
    }

    //Downloads Assertion
        public void assertFileInDownloads(String fileName){
        System.out.println("File name" + fileName);
        File downloadedFile = new File(downloadPath, fileName);
        assertTrue(downloadedFile.exists(), "File not found in downloads folder" + fileName);

        System.out.println(fileName + " is found in downloads folder");
    }
}
