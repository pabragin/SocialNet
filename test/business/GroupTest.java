/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Brasha
 */
public class GroupTest {
    
    public GroupTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of getID method, of class Group.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Group instance = new Group(99,"Avtovaz", "Auto", 4);
        int expResult = 99;
        int result = instance.getID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAdminID method, of class Group.
     */
    @Test
    public void testGetAdminID() {
        System.out.println("getAdminID");
        Group instance = new Group(99,"Avtovaz", "Auto", 4);
        int expResult = 4;
        int result = instance.getAdminID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Group.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Group instance = new Group(99,"Avtovaz", "Auto", 4);
        String expResult = "Avtovaz";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAbout method, of class Group.
     */
    @Test
    public void testGetAbout() {
        System.out.println("getAbout");
        Group instance = new Group(99,"Avtovaz", "Auto", 4);
        String expResult = "Auto";
        String result = instance.getAbout();
        assertEquals(expResult, result);
    }
}
