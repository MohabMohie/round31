package seleniumFlatTestPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class AssignmentsFlatTests {
    WebDriver driver;
//    Wait<WebDriver> wait;

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

//    #7
//    ________________ Moderate ________________
//    Open Google Chrome
//    Navigate to [https://www.w3schools.com/html/html_tables.asp]
//    Assert that the Country for the Company [Ernst Handel] is [Austria]
//    Close Google Chrome
    public void navigateToW3SchoolsAndCheckCountryForErnstHandel() {
       driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
       // find the cell which has the text Austria.
        By countryNameLabel = By.xpath("(//td[text()='Ernst Handel']/parent::tr/td)[3]");
//        String actualCountryName = driver.findElement(countryNameLabel).getText();
//        String expectedCountryName = "Austria";
//        Assert.assertEquals(actualCountryName, expectedCountryName, "The country for Ernst Handel is not Austria.");

        Assert.assertEquals(driver.findElement(countryNameLabel).getText(), "Austria", "The country for Ernst Handel is not Austria.");

        // don't use the country text to find this cell.
        // you can use the company name Ernst Handel.
        // get the text from the cell.
        // assert that the text is Austria.

//        (//td[text()='Ernst Handel']/parent::tr/td)[3]
//        (//td[text()='Ernst Handel']/following-sibling::td)[2]
//
//        // safe type casting
//        if (driver instanceof JavascriptExecutor javascriptExecutorDriver){
//            javascriptExecutorDriver.executeScript("arguments[0].scrollIntoView();", driver.findElement(countryNameLabel));
//            javascriptExecutorDriver.executeScript("arguments[0].click();", driver.findElement(countryNameLabel));
//        } else {
//            System.out.println("Cannot cast driver to JavascriptExecutor.");
//        }

//        // unsafe type casting
//         ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");

//        waitUntilTyping(By.xpath(""), "");
//        waitUntilClicking(By.xpath(""));


    }

//    private void waitUntilTyping(By locator, CharSequence... text) {
//        wait.until(d -> {
//            d.findElement(locator).sendKeys(text);
//            return true;
//        });
//    }
//
//    private void waitUntilClicking(By locator) {
//        wait.until(d -> {
//            d.findElement(locator).click();
//            return true;
//        });
//    }

    //TODO: project design (POM) and architecture.

    @BeforeMethod
    public void beforeMethod() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        options.setImplicitWaitTimeout(Duration.ofSeconds(5));
        driver = new ChromeDriver(options);
//        wait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(5))
//                .pollingEvery(Duration.ofMillis(300))
//                .ignoring(ElementNotInteractableException.class)
//                .ignoring(StaleElementReferenceException.class)
//                .ignoring(NotFoundException.class)
//        ;
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
