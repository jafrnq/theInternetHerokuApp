package utilityClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import static org.testng.Assert.assertTrue;

public class AssertionMethods {

    private WebDriver driver;
    private WebDriverWait wait;

    public AssertionMethods(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    //Assertion Methods
    public void testHeaderContent(String expectedHeaderText){
        String headerText = driver.findElement(By.tagName("h3")).getText();
        assertTrue(headerText.equals(expectedHeaderText), "Header is not displayed or incorrect");
    }
}
