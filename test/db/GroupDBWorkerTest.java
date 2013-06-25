/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import business.Group;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Brasha
 */
public class GroupDBWorkerTest {
    
    public GroupDBWorkerTest() {
    }
    private int groupId=0;
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of createGroupTable method, of class GroupDBWorker.


    /**
     * Test of DeleteGroup method, of class GroupDBWorker.
     */
    public void testInsertGroup() throws Exception {
        System.out.println("insertGroup");
        String Name = "Lol";
        String About = "Lol";
        int AdminId = 0;
        GroupDBMapper instance = new GroupDBMapper();
        groupId = instance.insertGroup(Name, About, AdminId);
    }
    
    @Test
    public void testDeleteGroup() throws Exception {
        System.out.println("DeleteGroup");
        int ID = 0;
        GroupDBMapper instance = new GroupDBMapper();
        instance.DeleteGroup(groupId);
    }
}
