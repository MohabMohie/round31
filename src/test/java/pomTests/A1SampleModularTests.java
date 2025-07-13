package pomTests;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DynamicHtml;

import java.time.Duration;

public class A1SampleModularTests {
    WebDriver driver;
    Wait<WebDriver> wait;

    @Test
    public void testMethod() {
        DynamicHtml dynamicHtml;
        dynamicHtml = new DynamicHtml(driver, wait);
        dynamicHtml.navigate();
        dynamicHtml.revealHiddenInput();
        dynamicHtml.insertTextIntoRevealedInput("Hello!");
        String actualValue = dynamicHtml.getRevealedInputValue();
        String expectedValue = "Hello!";
        Assert.assertEquals(actualValue, expectedValue, "The value in the input field is not as expected.");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
