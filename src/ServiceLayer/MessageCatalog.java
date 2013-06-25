/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import business.*;
import db.DataDBException;
import db.MessagesDBMapper;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brasha
 */
public class MessageCatalog {
    
     public int insertGroupMessage(User from, Group to, String message) throws MessageException
    {
        MessagesDBMapper mdb = new MessagesDBMapper();
        try {
            return mdb.insertGroupMessage(from, to, message);
        } catch (DataDBException ex) {
            throw new MessageException("Can't insert group!");
        }
    }
     
     public ArrayList<GroupMessage>GetGroupMessageTo(Group group) throws MessageException
     {
         MessagesDBMapper mdb = new MessagesDBMapper();
        try {
            return mdb.GetGroupMessageTo(group.getID());
        } catch (DataDBException ex) {
            throw new MessageException("Can't insert group!");
        }
     }
     public void DeleteMessage(Message message) throws MessageException
     {
         MessagesDBMapper mdb = new MessagesDBMapper();
        try {
            mdb.DeleteMessage(message.getMessageID());
        } catch (DataDBException ex) {
            throw new MessageException("Can't insert group!");
        }
     }
     public ArrayList<PrivateMessage> GetPrivateMessageTo(User user) throws MessageException
     {
         MessagesDBMapper mdb = new MessagesDBMapper();
        try {
            return mdb.GetPrivateMessageTo(user.getID());
        } catch (DataDBException ex) {
            throw new MessageException("Can't insert group!");
        }
     }
     
     public void insertPrivateMessage(User from, User to, String message) throws MessageException
     {
         MessagesDBMapper mdb = new MessagesDBMapper();
        try {
            mdb.insertPrivateMessage(from, to, message);
        } catch (DataDBException ex) {
            throw new MessageException("Can't insert group!");
        }
     }
}
