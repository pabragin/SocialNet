/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import business.User;
import db.DataDBException;
import db.FriendshipDBMapper;
import db.UserDBMapper;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brasha
 */
public class UserCatalog {
    
    public void addRequest(User user, User friend) throws UserException{
        FriendshipDBMapper udb = new FriendshipDBMapper("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
        try {
            udb.addRequest(user.getID(), friend.getID());
        } catch (DataDBException ex) {
            throw new UserException("Can't add request!");
        }
    }
    
    public void deleteRequest(User user, User approve) throws UserException{
        FriendshipDBMapper udb = new FriendshipDBMapper("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
        try {
            udb.DeleteRequest(user.getID(), approve.getID());
        } catch (DataDBException ex) {
            throw new UserException("Can't delete request!");
        }
    }
    
    public void approveRequest(User user, User approve) throws UserException{
        FriendshipDBMapper udb = new FriendshipDBMapper("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
        try {
            udb.ApproveRequest(user.getID(), approve.getID());
        } catch (DataDBException ex) {
            throw new UserException("Can't approve request!");
        }
    }
    
    public ArrayList<User> getFriends(User user) throws UserException{
        FriendshipDBMapper udb = new FriendshipDBMapper("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
        try {
            return udb.GetFriends(user.getID());
        } catch (DataDBException ex) {
            throw new UserException("Can't get friends!");
        }
    }
    
    public void deleteFriend(User user, User delete) throws UserException{
        FriendshipDBMapper udb = new FriendshipDBMapper("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
        try {
            udb.DeleteFriend(user.getID(), delete.getID());
        } catch (DataDBException ex) {
            throw new UserException("Can't delete friend");
        }
    }
    
    public ArrayList<User> getRequestTo(User user) throws UserException{
        FriendshipDBMapper udb = new FriendshipDBMapper("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
        try {
            return udb.GetRequestTo(user.getID());
        } catch (DataDBException ex) {
            throw new UserException("Can't get request to user!");
        }
    }
    
    public boolean IdExist(final int ID) throws UserException{
        UserDBMapper udb = new UserDBMapper();
        try {
            return udb.IdExist(ID);
        } catch (DataDBException ex) {
            throw new UserException("Can't check id!");
        }
    }
    
    public boolean passCompare(final int ID, final String pass) throws UserException{
        UserDBMapper udb = new UserDBMapper();
        try {
            return udb.passCompare(ID, pass);
        } catch (DataDBException ex) {
            throw new UserException("Can't check password!");
        }
    }
    
    public User findById(final int ID) throws UserException{
        UserDBMapper udb = new UserDBMapper();
        try {
            return udb.findById(ID);
        } catch (DataDBException ex) {
            throw new UserException("Can't find user by id!");
        }
    }
    
    public int insertUser(String FName, String LName, String City, String About, String pass) throws UserException{
        UserDBMapper udb = new UserDBMapper();
        try {
            return udb.insertUser(FName, LName, City, About, pass);
        } catch (DataDBException ex) {
            throw new UserException("Can't add user!");
        }
    }
    
    public ArrayList<User> getAllUsers() throws UserException{
        UserDBMapper udb = new UserDBMapper();
        try {
            return udb.getAllUsers();
        } catch (DataDBException ex) {
            throw new UserException("Can't get all users!");
        }
    }
}
