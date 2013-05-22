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
public class RequestTest {
    
    public RequestTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of confirm method, of class Request.
     */
    @Test
    public void testConfirm() {
        System.out.println("confirm");
        Request instance = new Request(new User(0,"Pavel","Bragin", "Sosnovy Bor", "Student"), new User(1,"Sergey","Tkachenko", "Hanty", "AnimeFan"));
        instance.confirm();
    }
}
