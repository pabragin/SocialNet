/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Brasha
 */
public class UserTest {
    
    public UserTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of getID method, of class User.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        User instance = new User(0,"Pavel","Bragin", "Sosnovy Bor", "Student", "123");
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirstName method, of class User.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        User instance = new User(0,"Pavel","Bragin", "Sosnovy Bor", "Student", "123");
        String expResult = "Pavel";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class User.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        User instance = new User(0,"Pavel","Bragin", "Sosnovy Bor", "Student", "123");
        String expResult = "Bragin";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCity method, of class User.
     */
    @Test
    public void testGetCity() {
        System.out.println("getCity");
        User instance = new User(0,"Pavel","Bragin", "Sosnovy Bor", "Student", "123");
        String expResult = "Sosnovy Bor";
        String result = instance.getCity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAbout method, of class User.
     */
    @Test
    public void testGetAbout() {
        System.out.println("getAbout");
        User instance = new User(0,"Pavel","Bragin", "Sosnovy Bor", "Student", "123");
        String expResult = "Student";
        String result = instance.getAbout();
        assertEquals(expResult, result);
    }

    /**
     * Test of addFriend method, of class User.
     */
    @Test
    public void testAddFriend() {
        System.out.println("addFriend");
        User user = new User(0,"Pavel","Bragin", "Sosnovy Bor", "Student", "123");
        User instance = new User(1,"Sergey","Tkachenko", "Hanty", "AnimeFan", "123");
        instance.addFriend(user);
    }

    /**
     * Test of addRequest method, of class User.
     */
    @Test
    public void testAddRequest() {
        System.out.println("addRequest");
        Request reg = new Request(new User(0,"Pavel","Bragin", "Sosnovy Bor", "Student", "123"), new User(1,"Sergey","Tkachenko", "Hanty", "AnimeFan", "123"));
        User instance = new User(1,"Sergey","Tkachenko", "Hanty", "AnimeFan", "123");
        instance.addRequest(reg);
    }

    /**
     * Test of confirmReq method, of class User.
     */
    @Test
    public void testConfirmReq() {
        System.out.println("confirmReq");
        int regNum = 0;
        Request reg = new Request(new User(0,"Pavel","Bragin", "Sosnovy Bor", "Student", "123"), new User(1,"Sergey","Tkachenko", "Hanty", "AnimeFan", "123"));
        User instance = new User(1,"Sergey","Tkachenko", "Hanty", "AnimeFan", "123");
        instance.addRequest(reg);
        instance.confirmReq(regNum);
    }
}
