/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Brasha
 */
public class FriendshipDBWorkerTest {
    
    public FriendshipDBWorkerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of addRequest method, of class FriendshipDBWorker.
     */
    @Test
    public void testAddRequest() throws Exception {
        System.out.println("addRequest");
        int uID = 0;
        int rID = 0;
        FriendshipDBWorker instance = new FriendshipDBWorker("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
        instance.addRequest(uID, rID);
    }

    /**
     * Test of ApproveRequest method, of class FriendshipDBWorker.
     */
    @Test
    public void testApproveRequest() throws Exception {
        System.out.println("ApproveRequest");
        int uID = 0;
        int aID = 0;
        FriendshipDBWorker instance = new FriendshipDBWorker("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
        instance.ApproveRequest(uID, aID);
    }

    /**
     * Test of DeleteFriend method, of class FriendshipDBWorker.
     */
    /*@Test
    public void testDeleteFriend() throws Exception {
        System.out.println("DeleteFriend");
        int uID = 0;
        int aID = 0;
        FriendshipDBWorker instance = new FriendshipDBWorker();
        instance.DeleteFriend(uID, aID);
    }*/

}
