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
public class User {
    protected int userID;
    protected String firstName;
    protected String lastName;
    protected String city;
    protected String about;
    protected ArrayList<User> friends;
    protected ArrayList<PrivateMessage> inMessages;
    protected ArrayList<PrivateMessage> outMessages;
    protected ArrayList<Request> regs;
    protected ArrayList<Group> groups;
    
    public User(int uID, String firstName, String lastName, String city, String about)
    {
        assert(firstName!=null);
        assert(lastName!=null);
        assert(city!=null);
        assert(about!=null);
        
        this.userID=uID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.about=about;
        
        this.friends =new ArrayList<>();
        this.inMessages = new ArrayList<>();
        this.outMessages = new ArrayList<>();
        this.regs = new ArrayList<>();
        this.groups = new ArrayList<>();
    }
    
    public int getID()
    {
        return this.userID;
    }
    
    public String getFirstName()
    {
        return this.firstName;
    }
    
    public String getLastName()
    {
        return this.lastName;
    }
    
    public String getCity()
    {
        return this.city;
    }
    
    public String getAbout()
    {
        return this.about;
    }
    
    public ArrayList getFriends()
    {
        return this.friends;
    }
    
    public ArrayList getInMessages()
    {
        return this.inMessages;
    }
    
    public ArrayList getOutMessages()
    {
        return this.outMessages;
    }
    
    public ArrayList getRequest()
    {
        return this.regs;
    }
    
    public ArrayList getGroups()
    {
        return this.groups;
    }
    
    public void addFriend(User user){
        friends.add(user);
    }
    
    public void addRequest(Request reg)
    {
        regs.add(reg);
    }
    
    public void confirmReq(int regNum)
    {
        if(regNum<regs.size())
        {
            regs.get(regNum).confirm();
        }
        else
            throw new IllegalArgumentException("There is no such request");
    }
}
