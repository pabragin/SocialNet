/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author Brasha
 */
public class PrivateMessage extends Message{
    
    private User to;
    public PrivateMessage(int id, User from, User to,String data){
        super(id, from, data);
        this.to=to;
    }
    
    public User getDest()
    {
        return this.to;
    }
}
