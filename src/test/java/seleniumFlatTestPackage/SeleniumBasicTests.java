package seleniumFlatTestPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void chromeOptionsTest() {
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        // https://developer.chrome.com/docs/chromedriver/capabilities
        // https://peter.sh/experiments/chromium-command-line-switches/
        // capabilities, arguments, and experimental options

        // Set mobile emulation for Pixel 7
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Pixel 7");

        // Set Chrome options
        options.setAcceptInsecureCerts(true)
                .enableBiDi()
                .setImplicitWaitTimeout(Duration.ofSeconds(30))
                .setEnableDownloads(true)
//                .addArguments("start-maximized")
                .addArguments("window-name=\"My custom title\"")
                .addArguments("window-size=500,1000")
                .addArguments("window-position=0,0")
//                .addArguments("headless")
                .setExperimentalOption("mobileEmulation", mobileEmulation)
        // Optional: Add other useful options
                .addArguments("--disable-blink-features=AutomationControlled")
                .setExperimentalOption("excludeSwitches", new String[]{"enable-automation"})
        ;

        // iPhone 16 specifications (custom device metrics)
//        Map<String, Object> deviceMetrics = new HashMap<>();
//        deviceMetrics.put("width", 393);
//        deviceMetrics.put("height", 852);
//        deviceMetrics.put("pixelRatio", 3.0);
//
//        Map<String, Object> mobileEmulation = new HashMap<>();
//        mobileEmulation.put("deviceMetrics", deviceMetrics);
//        mobileEmulation.put("userAgent", "Mozilla/5.0 (iPhone; CPU iPhone OS 18_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/18.0 Mobile/15E148 Safari/604.1");
//


        driver = new ChromeDriver(options);
        driver.navigate().to("https://www.google.com");
        driver.quit();
    }
}
