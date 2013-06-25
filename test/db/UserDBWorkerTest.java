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
        UserDBMapper instance = new UserDBMapper();
        int id1, id2;
        String FName = "Pavel";
        String LName = "Bragin";
        String City = "Sosnovy Bor";
        String About = "Student";
        String pass = "123";
        id1= instance.insertUser(FName, LName, City, About, pass);
        FName = "Sergey";
        LName = "Tkachenko";
        City = "Hanty";
        About = "AnimeFan";
        id2 = instance.insertUser(FName, LName, City, About, pass);
        instance.DeleteUser(id1);
        instance.DeleteUser(id2);
    }
    
    /**
     * Test of findById method, of class UserDBWorker.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        int ID = 0;
        UserDBMapper instance = new UserDBMapper();
        User result = instance.findById(ID);
    }

    /**
     * Test of findByFName method, of class UserDBWorker.
     */
    @Test
    public void testFindByFName() throws Exception {
        System.out.println("findByFName");
        String Name = "Pavel";
        UserDBMapper instance = new UserDBMapper();
        ArrayList result = instance.findByFName(Name);
    }

    /**
     * Test of findByLastName method, of class UserDBWorker.
     */
    @Test
    public void testFindByLastName() throws Exception {
        System.out.println("findByLastName");
        String Name = "Bragin";
        UserDBMapper instance = new UserDBMapper();
        ArrayList result = instance.findByLastName(Name);
    }

    /**
     * Test of findByCity method, of class UserDBWorker.
     */
    @Test
    public void testFindByCity() throws Exception {
        System.out.println("findByCity");
        String Ci = "Sosnovy Bor";
        UserDBMapper instance = new UserDBMapper();
        ArrayList result = instance.findByCity(Ci);
    }
    
}
