package engine;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Bot {
    WebDriver driver;
    Wait<WebDriver> wait;

    public Bot(){
        try {
            driver = initialize();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class);
        System.out.println("Bot initialized with ChromeDriver and FluentWait.");
    }

    private WebDriver initialize() throws MalformedURLException {
        WebDriver driver;
        String browser = System.getProperty("browser", "chrome").toLowerCase();
        String executionMode = System.getProperty("executionMode", "local").toLowerCase();
        if (executionMode.equals("local")) {
            switch (browser) {
                case "firefox" -> driver = new FirefoxDriver();
                case "safari" -> driver = new SafariDriver();
                case "edge" -> driver = new EdgeDriver();
                default -> driver = new ChromeDriver();
            }
        } else {
            switch (browser) {
                case "firefox" -> driver = new FirefoxDriver();
                case "safari" -> driver = new SafariDriver();
                case "edge" -> driver = new EdgeDriver();
                default -> {
                    ChromeOptions options = new ChromeOptions();
                    driver = new RemoteWebDriver(new URL("http://www.example.com"), options);
                }
            }
        }
        return driver;
    }

    public void quit (){
        driver.quit();
        System.out.println("Bot quit and driver closed.");
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
        System.out.println("Navigated to: " + url);
    }

    public void click (By locator) {
        wait.until(d -> {
            d.findElement(locator).click();
            return true;
        });
        System.out.println("Clicked: " + locator);
    }

    public void scrollUsingJavaScript(By locator, String behavior) {
        wait.until(d -> {
            ((JavascriptExecutor) d).executeScript("""
                 arguments[0].scrollIntoView({behavior: arguments[1], block: "center", inline: "center"});""", d.findElement(locator), behavior);
            return true;
        });
        System.out.println("Clicked using JavaScript: " + locator);
    }

    public void type (By locator, CharSequence... text) {
        wait.until(d -> {
            d.findElement(locator).clear();
            d.findElement(locator).sendKeys(text);
            return true;
        });
        System.out.println("Typed into: " + locator + " Text: " + String.join("", text));
    }

    public String getDomProperty(By locator, String property) {
        String value = wait.until(d -> d.findElement(locator).getDomProperty(property));
        System.out.println("Got DOM property: " + property + " from: " + locator + " Value: " + value);
        return value;
    }
}
