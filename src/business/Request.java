/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author Brasha
 */
public class Request {

    private boolean confirm = false;
    private final User from;
    private final User to;
    Request(User from, User to){
        assert(from!=null);
        assert(to!=null);
        this.from=from;
        this.to =to;
    };
    
    public void confirm()
    {
        confirm = true;
    }
}
