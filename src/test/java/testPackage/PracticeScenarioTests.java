package testPackage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PracticeScenarioTests {

    @Test
    public void login() {
        // This is a test for the create functionality
        System.out.println("login test executed");
    }

    @Test(dependsOnMethods = "login")
    public void addItemsToCart() {
        // This is a test for the read functionality
        System.out.println("addItemsToCart test executed");
    }

    @Test(groups = "checkout", dependsOnMethods = {"login","addItemsToCart"})
    public void checkout() {
        // This is a test for the update functionality
        System.out.println("checkout test executed");
    }

    @Test(groups = "completeOrder", dependsOnMethods = {"login","addItemsToCart","checkout"})
    public void completeOrder() {
        // This is a test for the delete functionality
        System.out.println("completeOrder test executed");
    }

    @BeforeClass
    public void beforeClass() {
        // This method will run only one time before any test methods in this class
        System.out.println("Setting up tests");
    }

    @AfterClass
    public void afterClass() {
        // This method will run after only one time all test methods in this class
        System.out.println("Tearing down tests");
    }
}
