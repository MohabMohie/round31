package seleniumFlatTestPackage;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Test public class SeleniumBasicTests {

    public void testMethod(){
        WebDriver driver;
        driver = new ChromeDriver();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.navigate().to("https://www.google.com");
        driver.get("https://www.google.com");
        driver.close();
        driver.quit();
        // method 1, explicit declaration and assignation
//        String currentUrl;
//        currentUrl = driver.getCurrentUrl();
        // method 2, inline declaration and assignation
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.google.com";
        // assertion to check if the current URL is as expected
        Assert.assertEquals(currentUrl, expectedUrl);

        // condensing the three lines down to one line
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com");
        Assert.assertNotEquals(driver.getCurrentUrl(), "");

        // method 3, inline declaration and assignation with type inference
//        var currentUrl2 = driver.getCurrentUrl();
        driver.getPageSource();
        driver.getTitle();

        // manipulating multiple windows
        var windowHandle = driver.getWindowHandle();
        var secondWindow = driver.switchTo().newWindow(WindowType.WINDOW).getWindowHandle();
        driver.getWindowHandles();
        driver.switchTo().window(windowHandle);
        var windowDimensions = new Dimension(1920,1080);

        // manipulating cookies
        var sessionCookie = driver.manage().getCookieNamed("JSESSIONID");
        driver.manage().addCookie(sessionCookie);

        driver.manage().window().setSize(windowDimensions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // TODO: ChromeOptions()
        // TODO: findelements vs findelement
//        driver.findElement()
//        driver.findElements()


        WebElement element = null;

        boolean isElementDisplayed = element.isDisplayed();
        Assert.assertTrue(isElementDisplayed);


        Assert.assertTrue(element.isDisplayed());


//        ((JavascriptExecutor) driver).executeScript("");
//        ((HasBiDi) driver).getBiDi();
//
//        WebDriver driver2;
//        driver2 = new WebDriver();

//        RemoteWebDriver driver2;
//        driver2 = new ChromeDriver();

//        ChromeDriver driver3;
//        driver3 = new ChromeDriver();
//        driver3.

        // navigating to a URL
        driver.get("https://www.example.com");
        driver.navigate().to("https://www.example.com/");
    }
}
