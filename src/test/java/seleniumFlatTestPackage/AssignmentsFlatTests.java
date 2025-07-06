package seleniumFlatTestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

        // method #1
//        String duckDuckGoLogoXpath = "//*[@id='duckduckgologo']";
//        boolean isDisplayed1 = driver.findElement(By.xpath(duckDuckGoLogoXpath)).isDisplayed();

//        //method #2
//        WebElement duckDuckGoLogoElement = driver.findElement(By.xpath("//div[contains(@class,'Desktop')]//img"));
//        boolean isDisplayed2 = duckDuckGoLogoElement.isDisplayed();

        //method #3
//        By duckDuckGoLogoLocator = By.xpath("//div[contains(@class,'Desktop')]//img");
//        boolean isDisplayed3 = driver.findElement(duckDuckGoLogoLocator).isDisplayed();
//        // Assertion to check if the logo is displayed
//        Assert.assertTrue(isDisplayed3, "DuckDuckGo logo is not displayed on the page.");

        //method #3
        By duckDuckGoLogoLocator = By.xpath("//div[contains(@class,'Desktop')]//img");
        // Assertion to check if the logo is displayed
        Assert.assertTrue(driver.findElement(duckDuckGoLogoLocator).isDisplayed(), "DuckDuckGo logo is not displayed on the page.");
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
