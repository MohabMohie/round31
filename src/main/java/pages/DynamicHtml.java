package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class DynamicHtml {
    String url = "https://www.selenium.dev/selenium/web/dynamic.html";
    By revealButton = By.id("reveal");
    By revealedInput = By.id("revealed");
    WebDriver driver;
    Wait<WebDriver> wait;

    public DynamicHtml(WebDriver driver, Wait<WebDriver> wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void navigate(){
        this.driver.navigate().to(url);
    }

    public void revealHiddenInput() {
        this.driver.findElement(revealButton).click();
    }

    public void insertTextIntoRevealedInput(String text) {
        wait.until(d -> {
            d.findElement(revealedInput).sendKeys(text);
            return true;
        });
    }

    public String getRevealedInputValue() {
        return this.driver.findElement(revealedInput).getDomProperty("value");
    }
}
