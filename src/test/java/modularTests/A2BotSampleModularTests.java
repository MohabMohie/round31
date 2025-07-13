package modularTests;

import engine.Bot;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class A2BotSampleModularTests {
    Bot bot;

    @Test
    public void testMethod() {
        bot.navigateTo("https://www.selenium.dev/selenium/web/dynamic.html");

        By revealButton = By.id("reveal");
        By revealedInput = By.id("revealed");

        bot.click(revealButton);
        bot.type(revealedInput, "Hello!");

        String actualValue = bot.getDomProperty(revealedInput, "value");
        String expectedValue = "Hello!";

        Assert.assertEquals(actualValue, expectedValue, "The value in the input field is not as expected.");
    }

    @BeforeMethod
    public void beforeMethod() {
        bot = new Bot();
    }

    @AfterMethod
    public void afterMethod() {
        bot.quit();
    }
}
