package seleniumFlatTestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class AssignmentsFlatTests {
    WebDriver driver;

    public void navigateToDuckDuckGoAndCheckPageTitle(){
        driver.navigate().to("https://duckduckgo.com");
//        String pageTitle = driver.getTitle();
//        String expectedTitle = "Google";
//        // Assertion to check if the page title is as expected
//        Assert.assertEquals(pageTitle, expectedTitle);
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    public void navigateToDuckDuckGoAndCheckLogoIsDisplayed(){
        driver.navigate().to("https://duckduckgo.com");
        driver.findElement(By.xpath("//div[contains(@class,'Desktop')]//img")).isDisplayed();
    }

    //TODO: cover explicit wait.

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
