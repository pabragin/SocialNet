/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;

/**
 *
 * @author Brasha
 */
public class Admin extends User{
    
    public Admin(String firstName, String lastName, String city, String about, int oldID, ArrayList<User> friends, ArrayList<PrivateMessage> inMess, ArrayList<PrivateMessage> outMess, ArrayList<Group> groups){
        super(oldID, firstName, lastName, city, about);
        
        this.friends=friends;
        this.inMessages=inMess;
        this.outMessages=outMess;
        this.groups=groups;
    }
}
