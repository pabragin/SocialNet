/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import business.Group;
import business.User;
import db.DataDBException;
import db.GroupDBMapper;
import db.GroupInvDBMapper;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brasha
 */
public class GroupCatalog {
    
    public ArrayList<User> getAllUsers(Group group) throws GroupException
    {
        
        GroupInvDBMapper gdb = new GroupInvDBMapper("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
        try
        {
            return gdb.GetAllUser(group.getID());
        }
        catch(DataDBException e)
        {
            throw new GroupException("Can't get users!");
        }
    }
    
    public void addInvolve(User user, Group group) throws GroupException
    {
        GroupInvDBMapper gdb = new GroupInvDBMapper("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
        try
        {
            gdb.addInvolve(user.getID(), group.getID());
        }
        catch(DataDBException e)
        {
            throw new GroupException("Can't involve users!");
        }
    }
    
    public int insertGroup(String Name, String About, int AdminId) throws GroupException
    {
        GroupDBMapper gdb = new GroupDBMapper();
        try {
            return gdb.insertGroup(Name, About, AdminId);
        } catch (DataDBException ex) {
            throw new GroupException("Can't involve users!");
        }
    }
    
    public Group getGroupById(int ID) throws GroupException
    {
        GroupDBMapper gdb = new GroupDBMapper();
        try {
            return gdb.findById(ID);
        } catch (DataDBException ex) {
            throw new GroupException("Can't find group by id");
        }
    }
    
    public ArrayList<Group> getAllGroups() throws GroupException
    {
        GroupDBMapper gdb = new GroupDBMapper();
        try {
            return gdb.getAllGroups();
        } catch (DataDBException ex) {
            throw new GroupException("Can't get groups!");
        }
    }
    
    public void DeleteGroup(Group group) throws GroupException
    {
        GroupDBMapper gdb = new GroupDBMapper();
        try {
            gdb.DeleteGroup(group.getID());
        } catch (DataDBException ex) {
            throw new GroupException("Can't delete group!");
        }
    }
    public boolean contains(Group group, User user) throws GroupException
    {
        GroupCatalog gidb =new GroupCatalog();
        boolean contains = false;
        int i=0;
        for(i=0;i<gidb.getAllUsers(group).size();i++)
        {
            if(gidb.getAllUsers(group).get(0).getID()==user.getID())
                contains = true;
        }
        return contains;
    }
}
