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
    int messageId=0;
    int groupMessageId=0;
    
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
        MessagesDBMapper instance = new MessagesDBMapper();
        messageId=instance.insertPrivateMessage(from, to, message);
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
        MessagesDBMapper instance = new MessagesDBMapper();
        groupMessageId=instance.insertGroupMessage(from, to, message);
    }

    /**
     * Test of GetGroupMessageById method, of class MessegesDBWorker.
     */
    @Test
    public void testGetGroupMessageById() throws Exception {
        System.out.println("GetGroupMessageById");
        int ID = 0;
        MessagesDBMapper instance = new MessagesDBMapper();
        GroupMessage result = instance.GetGroupMessageById(groupMessageId);
    }

    /**
     * Test of GetPrivateMessageFrom method, of class MessegesDBWorker.
     */
    @Test
    public void testGetPrivateMessageFrom() throws Exception {
        System.out.println("GetPrivateMessageFrom");
        int fromid = 0;
        MessagesDBMapper instance = new MessagesDBMapper();
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
        MessagesDBMapper instance = new MessagesDBMapper();
        String expResult = "Hello Sergey";
        ArrayList<PrivateMessage> result = instance.GetPrivateMessageTo(toid);
        assertEquals(expResult, result.get(result.size()-1).getMessageData());
    }
    
    @Test
    public void testDeleteMessage() throws Exception {
        MessagesDBMapper instance = new MessagesDBMapper();
        instance.DeleteMessage(messageId);
        instance.DeleteMessage(groupMessageId);
    }
}
