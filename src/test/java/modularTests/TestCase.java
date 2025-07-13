package modularTests;

import engine.Bot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestCase {
    Bot bot;
    @BeforeMethod
    public void beforeMethod() {
        bot = new Bot();
        System.out.println("Bot start.");
    }
    @AfterMethod
    public void afterMethod() {
        bot.quit();
        bot = null;
        System.out.println("Bot quit.");
    }
}
