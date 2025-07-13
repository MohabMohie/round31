package modularTests;

import engine.Bot;
import engine.FluentBot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class FluentBotTestCase {
    FluentBot bot;
    @BeforeMethod
    public void beforeMethod() {
        bot = new FluentBot();
        System.out.println("Bot start.");
    }
    @AfterMethod
    public void afterMethod() {
        bot.quit();
        bot = null;
        System.out.println("Bot quit.");
    }
}
