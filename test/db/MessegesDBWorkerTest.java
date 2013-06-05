/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import business.Group;
import business.GroupMessage;
import business.PrivateMessage;
import business.User;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Brasha
 */
public class MessegesDBWorkerTest {
    
    int id1=0, id2=0;
    
    public MessegesDBWorkerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

     /**
     * Test of insertPrivateMessage method, of class MessegesDBWorker.
     */
    @Test
    public void testInsertPrivateMessage() throws Exception {
        System.out.println("insertPrivateMessage");
        User from = new User(0,"Pavel","Bragin", "Sosnovy Bor", "Student", "123");
        User to = new User(1,"Sergey","Tkachenko", "Hanty", "AnimeFan", "123");
        String message = "Hello Sergey";
        MessagesDBWorker instance = new MessagesDBWorker();
        instance.insertPrivateMessage(from, to, message);
    }

    /**
     * Test of insertGroupMessage method, of class MessegesDBWorker.
     */
    @Test
    public void testInsertGroupMessage() throws Exception {
        System.out.println("insertGroupMessage");
        User from = new User(0,"Pavel","Bragin", "Sosnovy Bor", "Student", "123");
        Group to = new Group(0, "Avtovaz", "avto auto", 0);
        String message = "Hello Avtovaz";
        MessagesDBWorker instance = new MessagesDBWorker();
        instance.insertGroupMessage(from, to, message);
    }
    
    /**
     * Test of GetPrivateMessageById method, of class MessegesDBWorker.
     */
    @Test
    public void testGetPrivateMessageById() throws Exception {
        System.out.println("GetPrivateMessageById");
        int ID = 0;
        MessagesDBWorker instance = new MessagesDBWorker();
        PrivateMessage result = instance.GetPrivateMessageById(ID);
    }

    /**
     * Test of GetGroupMessageById method, of class MessegesDBWorker.
     */
    @Test
    public void testGetGroupMessageById() throws Exception {
        System.out.println("GetGroupMessageById");
        int ID = 0;
        MessagesDBWorker instance = new MessagesDBWorker();
        GroupMessage result = instance.GetGroupMessageById(ID);
    }

    /**
     * Test of GetPrivateMessageFrom method, of class MessegesDBWorker.
     */
    @Test
    public void testGetPrivateMessageFrom() throws Exception {
        System.out.println("GetPrivateMessageFrom");
        int fromid = 0;
        MessagesDBWorker instance = new MessagesDBWorker();
        String expResult = "Hello Sergey";
        ArrayList<PrivateMessage> result = instance.GetPrivateMessageFrom(fromid);
        assertEquals(expResult, result.get(result.size()-1).getMessageData());
    }

    /**
     * Test of GetPrivateMessageTo method, of class MessegesDBWorker.
     */
    @Test
    public void testGetPrivateMessageTo() throws Exception {
        System.out.println("GetPrivateMessageTo");
        int toid = 1;
        MessagesDBWorker instance = new MessagesDBWorker();
        String expResult = "Hello Sergey";
        ArrayList<PrivateMessage> result = instance.GetPrivateMessageTo(toid);
        assertEquals(expResult, result.get(result.size()-1).getMessageData());
    }

    /**
     * Test of GetGroupMessageFrom method, of class MessegesDBWorker.
     */
    @Test
    public void testGetGroupMessageFrom() throws Exception {
        System.out.println("GetGroupMessageFrom");
        int fromid = 0;
        MessagesDBWorker instance = new MessagesDBWorker();
        String expResult = "Hello Avtovaz";
        ArrayList<GroupMessage> result = instance.GetGroupMessageFrom(fromid);
        assertEquals(expResult, result.get(result.size()-1).getMessageData());
    }

    /**
     * Test of GetGroupMessageTo method, of class MessegesDBWorker.
     */
    @Test
    public void testGetGroupMessageTo() throws Exception {
        System.out.println("GetGroupMessageTo");
        int toid = 0;
        MessagesDBWorker instance = new MessagesDBWorker();
        String expResult = "Hello Avtovaz";
        ArrayList<GroupMessage> result = instance.GetGroupMessageTo(toid);
        assertEquals(expResult, result.get(result.size()-1).getMessageData());
    }
}
