/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brasha
 */
public class FriendshipDBWorker {
    private Statement statement = null;
    private ResultSet resultSet = null;
    
    public void addRequest(int uID,int rID) throws DataDBException{
        Connection connect = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
            String query = "INSERT into APP.FRIENDSHIP (USERID, RECIPIENTID, STATUS) VALUES (?, ?, ?)";
            PreparedStatement stat = connect.prepareStatement(query);

            stat.setInt(1, uID);
            stat.setInt(2, rID);
            stat.setInt(3, 0);
            stat.executeUpdate();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            throw new DataDBException("Error occurred while requesting friendship", e);
        } finally {
            try {
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
            close();
        }
    }
    
    public void ApproveRequest(int uID,int aID) throws DataDBException{
        Connection connect = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
            String query = "UPDATE APP.FRIENDSHIP SET STATUS=1 WHERE USERID=? AND RECIPIENTID=?";
            PreparedStatement stat = connect.prepareStatement(query);

            stat.setInt(1, aID);
            stat.setInt(2, uID);
            stat.executeUpdate();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            throw new DataDBException("Error occurred while Approving friend", e);
        } finally {
            try {
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
            close();
        }
    }
    
    public void DeleteFriend(int uID,int aID) throws DataDBException{
        Connection connect = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
            String query = "DELETE FROM APP.FRIENDSHIP WHERE (USERID=? AND RECIPIENTID=?) OR (USERID=? AND RECIPIENTID=?)";
            PreparedStatement stat = connect.prepareStatement(query);

            stat.setInt(1, aID);
            stat.setInt(2, uID);
            stat.setInt(3, uID);
            stat.setInt(4, aID);
            stat.executeUpdate();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            throw new DataDBException("Error occurred while Approving friend", e);
        } finally {
            try {
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
            close();
        }
    }
    
         public void deleteFriendshipTable() throws DataDBException {
        Connection connect = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
            String query = "DROP TABLE APP.FRIENDSHIP";
            PreparedStatement stat = connect.prepareStatement(query);
            stat.executeUpdate();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            throw new DataDBException("Error occurred while deleting friendship table", e);
        } finally {
            close();
            try {
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
         
    public void createFriendshipTable() throws DataDBException {
        Connection connect = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
            String query = "CREATE TABLE APP.FRIENDSHIP (\"USERID\" INT,\"RECIPIENTID\" INT,\"STATUS\" INT)";
            PreparedStatement stat = connect.prepareStatement(query);//STATUS 0 - zayavka, 1 - friens
            stat.executeUpdate();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            throw new DataDBException("Error occurred while creating friendship table", e);
        } finally {
            close();
            try {
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
     private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (Exception e) {
            System.out.println("Connection to database lost");
        }
    }
    
}
