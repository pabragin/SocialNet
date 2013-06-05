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
public class MessageTest {
    
    public MessageTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of getMessageID method, of class Message.
     */
    @Test
    public void testGetMessageID() {
        System.out.println("getMessageID");
        Message instance = new Message(0, new User(0,"Pavel", "Bragin", "Sosnovy Bor", "Student", "123"),"Hello world");
        int expResult = 0;
        int result = instance.getMessageID();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of getMessageID method, of class Message.
     */
    @Test
    public void testGetMessageData() {
        System.out.println("getMessageData");
        Message instance = new Message(0, new User(0,"Pavel", "Bragin", "Sosnovy Bor", "Student", "123"),"Hello world");
        String expResult = "Hello world";
        String result = instance.getMessageData();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetMessageDate() {
        System.out.println("getMessageDate");
        Message instance = new Message(0, new User(0,"Pavel", "Bragin", "Sosnovy Bor", "Student", "123"),"Hello world");
        System.out.println(instance.getMessageDate().toString());
    }
}
