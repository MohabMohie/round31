package modularTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class A3BotSampleModularAbstractTests extends TestCase {
    @Test
    public void testMethod() {
        By revealButton = By.id("reveal");
        By revealedInput = By.id("revealed");

        bot.navigateTo("https://www.selenium.dev/selenium/web/dynamic.html");

        bot.click(revealButton);
        bot.type(revealedInput, "Hello!");

        String actualValue = bot.getDomProperty(revealedInput, "value");
        String expectedValue = "Hello!";

        Assert.assertEquals(actualValue, expectedValue, "The value in the input field is not as expected.");
    }
}
