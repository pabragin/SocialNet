/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Date;

/**
 *
 * @author Brasha
 */
public class Message {
    protected int messageID;
    protected User from;
    protected String data;
    protected final Date date = new Date();
    
    public Message(int ID, User from, String data)
    {
        assert(data!=null);
        assert(from!=null);
        this.messageID=ID;
        this.from=from;
        this.data=data;
    }
    
    public int getMessageID()
    {
        return messageID;
    }
    
    public String getMessageData()
    {
        return data;
    }
    
    public Date getMessageDate()
    {
        return date;
    }
}
