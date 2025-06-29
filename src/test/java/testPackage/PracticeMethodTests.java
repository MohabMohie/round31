package testPackage;

import org.testng.Assert;
import org.testng.annotations.*;

public class PracticeMethodTests {

    @Test
    public void testCreate() {
        // This is a test for the create functionality
//        Assert.assertEquals(1,1);
//        Assert.assertNotEquals(1,1);
//        Assert.assertTrue(true);
//        Assert.assertFalse(false);
//        Assert.fail();
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


    @BeforeMethod
    public void beforeMethod() {
        // This method will run many times, once before each test method in this class
        System.out.println("Before method execution");
    }

    @AfterMethod
    public void afterMethod() {
        // This method will run many times, once after each test method in this class
        System.out.println("After method execution");
    }
}
