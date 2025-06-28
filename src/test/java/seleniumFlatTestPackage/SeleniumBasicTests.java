package seleniumFlatTestPackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.HasBiDi;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

@Test public class SeleniumBasicTests {

    public void testMethod(){
        WebDriver driver;
        driver = new ChromeDriver();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.navigate().to("https://www.google.com");
        driver.get("https://www.google.com");


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

        driver.get("https://www.example.com");
        driver.navigate().to("https://www.example.com/");
    }
}
