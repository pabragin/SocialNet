/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

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
public class UserDBWorkerTest {
    
    int id1=0, id2=0;
    
    public UserDBWorkerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

     /**
     * Test of insertUser method, of class UserDBWorker.
     */
    @Test
    public void testInsertUser() throws Exception {
        System.out.println("insertUser");
        UserDBWorker instance = new UserDBWorker();
        String FName = "Pavel";
        String LName = "Bragin";
        String City = "Sosnovy Bor";
        String About = "Student";
        id1= instance.insertUser(FName, LName, City, About);
        FName = "Sergey";
        LName = "Tkachenko";
        City = "Hanty";
        About = "AnimeFan";
        id2 = instance.insertUser(FName, LName, City, About);
    }
    
    /**
     * Test of findById method, of class UserDBWorker.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        int ID = 0;
        UserDBWorker instance = new UserDBWorker();
        User result = instance.findById(ID);
    }

    /**
     * Test of findByFName method, of class UserDBWorker.
     */
    @Test
    public void testFindByFName() throws Exception {
        System.out.println("findByFName");
        String Name = "Pavel";
        UserDBWorker instance = new UserDBWorker();
        ArrayList result = instance.findByFName(Name);
    }

    /**
     * Test of findByLastName method, of class UserDBWorker.
     */
    @Test
    public void testFindByLastName() throws Exception {
        System.out.println("findByLastName");
        String Name = "Bragin";
        UserDBWorker instance = new UserDBWorker();
        ArrayList result = instance.findByLastName(Name);
    }

    /**
     * Test of findByCity method, of class UserDBWorker.
     */
    @Test
    public void testFindByCity() throws Exception {
        System.out.println("findByCity");
        String Ci = "Sosnovy Bor";
        UserDBWorker instance = new UserDBWorker();
        ArrayList result = instance.findByCity(Ci);
    }
    
    @Test
    public void testDeleteUser() throws Exception {
        System.out.println("DeleteUser");
        UserDBWorker instance = new UserDBWorker();
        instance.DeleteUser(id1);
        instance.DeleteUser(id2);
    }
    
}
