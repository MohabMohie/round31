package testPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeMethodTests {

    @Test
    public void testCreate() {
        // This is a test for the create functionality
        Assert.fail();
        System.out.println("Create test executed");
    }

    @Test
    public void testRead() {
        // This is a test for the read functionality
        System.out.println("Read test executed");
    }

    @Test
    public void testUpdate() {
        // This is a test for the update functionality
        System.out.println("Update test executed");
    }

    @Test
    public void testDelete() {
        // This is a test for the delete functionality
        System.out.println("Delete test executed");
    }
}
