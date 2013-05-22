/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author Brasha
 */
public class GroupMessage extends Message{
    private Group to;
    
    public GroupMessage(int id, User from, Group to, String data){
        super(id, from, data);
        
        this.to=to;
    }
}
