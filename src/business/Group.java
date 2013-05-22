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
public class Group {
    
    private int groupID;
    private int AdminID;
    private final String name;
    private String about;
    private ArrayList<User> members;
    private ArrayList<GroupMessage> messages;
    
    public Group(int id, String name, String about, int AdminID)
    {
        assert(name!=null);
        assert(about!=null);
        
        this.groupID=id;
        this.name=name;
        this.about=about;
        this.AdminID=AdminID;
        
        this.members =new ArrayList<>();
        this.messages = new ArrayList<>();
    }
    
    public int getID()
    {
        return this.groupID;
    }
    
    public int getAdminID()
    {
        return this.AdminID;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public String getAbout()
    {
        return this.about;
    }
    
    public ArrayList getMembers()
    {
        return this.members;
    }
    
    public ArrayList getMessages()
    {
        return this.members;
    }
}
