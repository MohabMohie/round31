package testPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeScenarioTests {

    @Test
    public void login() {
        // This is a test for the create functionality
        System.out.println("Create test executed");
    }

    @Test(dependsOnMethods = "login")
    public void addItemsToCart() {
        // This is a test for the read functionality
        System.out.println("Read test executed");
    }

    @Test(groups = "checkout", dependsOnMethods = {"login","addItemsToCart"})
    public void checkout() {
        // This is a test for the update functionality
        System.out.println("Update test executed");
    }

    @Test(groups = "completeOrder", dependsOnMethods = {"login","addItemsToCart","checkout"})
    public void completeOrder() {
        // This is a test for the delete functionality
        System.out.println("Delete test executed");
    }
}
