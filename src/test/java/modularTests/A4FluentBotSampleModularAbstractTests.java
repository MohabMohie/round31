package modularTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class A4FluentBotSampleModularAbstractTests extends FluentBotTestCase {
    @Test
    public void testMethod() {
        By revealButton = By.id("reveal");
        By revealedInput = By.id("revealed");

        String actualValue = bot.navigateTo("https://www.selenium.dev/selenium/web/dynamic.html")
                .click(revealButton)
                .type(revealedInput, "Hello!")
                .getDomProperty(revealedInput, "value");

        String expectedValue = "Hello!";
        Assert.assertEquals(actualValue, expectedValue, "The value in the input field is not as expected.");
    }
}
