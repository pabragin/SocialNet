/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import business.PrivateMessage;
import business.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brasha
 */
public class FriendshipDBMapper {
    private Statement statement = null;
    private ResultSet resultSet = null;
    
    private Connection cConnection;
    
    public FriendshipDBMapper(String adress, String name, String password)
    {
        try {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            } catch (    InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(FriendshipDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                cConnection = DriverManager.getConnection(adress, name, password);
            } catch (SQLException ex) {
                Logger.getLogger(FriendshipDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FriendshipDBMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addRequest(int uID,int rID) throws DataDBException{
        Connection connect = cConnection;
        try {
            String query = "INSERT into APP.FRIENDSHIP (USERID, RECIPIENTID, STATUS) VALUES (?, ?, ?)";
            PreparedStatement stat = connect.prepareStatement(query);

            stat.setInt(1, uID);
            stat.setInt(2, rID);
            stat.setInt(3, 0);
            stat.executeUpdate();
            
        } catch (SQLException e) {
            throw new DataDBException("Error occurred while requesting friendship", e);
        } finally {
            close();
        }
    }
    
    public void ApproveRequest(int uID,int aID) throws DataDBException{
        Connection connect = cConnection;
        try {
            try {
                try {
                    Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                } catch (        InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(FriendshipDBMapper.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FriendshipDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            String query = "UPDATE APP.FRIENDSHIP SET STATUS=1 WHERE (USERID=? AND RECIPIENTID=?)";
            PreparedStatement stat = connect.prepareStatement(query);

            stat.setInt(1, aID);
            stat.setInt(2, uID);
            stat.executeUpdate();
            
        } catch (SQLException e) {
            throw new DataDBException("Error occurred while Approving friend", e);
        } finally {
            close();
        }
    }
    
    public void DeleteFriend(int uID,int aID) throws DataDBException{
        Connection connect = cConnection;
        try {
            String query = "DELETE FROM APP.FRIENDSHIP WHERE (USERID=? AND RECIPIENTID=? AND STATUS=1) OR (USERID=? AND RECIPIENTID=? AND STATUS=1)";
            PreparedStatement stat = connect.prepareStatement(query);

            stat.setInt(1, aID);
            stat.setInt(2, uID);
            stat.setInt(3, uID);
            stat.setInt(4, aID);
            stat.executeUpdate();
            
        } catch (SQLException e) {
            throw new DataDBException("Error occurred while Approving friend", e);
        } finally {
            close();
        }
    }
    
    public void DeleteRequest(int uID,int aID) throws DataDBException{
        Connection connect = cConnection;
        try {
            String query = "DELETE FROM APP.FRIENDSHIP WHERE (USERID=? AND RECIPIENTID=? AND STATUS=0)";
            PreparedStatement stat = connect.prepareStatement(query);

            stat.setInt(1, aID);
            stat.setInt(2, uID);
            stat.executeUpdate();
            
        } catch (SQLException e) {
            throw new DataDBException("Error occurred while Delete Request", e);
        } finally {
            close();
        }
    }
    
         public void deleteFriendshipTable() throws DataDBException {
        Connection connect = cConnection;
        try {
            String query = "DROP TABLE APP.FRIENDSHIP";
            PreparedStatement stat = connect.prepareStatement(query);
            stat.executeUpdate();
            
        } catch (SQLException e) {
            throw new DataDBException("Error occurred while deleting friendship table", e);
        } finally {
            close();
        }
    }
         
    public void createFriendshipTable() throws DataDBException {
        Connection connect = cConnection;
        try {
            String query = "CREATE TABLE APP.FRIENDSHIP (\"USERID\" INT,\"RECIPIENTID\" INT,\"STATUS\" INT)";
            PreparedStatement stat = connect.prepareStatement(query);//STATUS 0 - zayavka, 1 - friens
            stat.executeUpdate();
            
        } catch (SQLException e) {
            throw new DataDBException("Error occurred while creating friendship table", e);
        } finally {
            close();
        }
    }
    
    public ArrayList<User> GetRequestTo(final int toid) throws DataDBException{
        Connection conn = cConnection;
        try {
            String query = "SELECT * from APP.FRIENDSHIP where RECIPIENTID=? AND STATUS=0";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setInt(1, toid);
            ResultSet result = stat.executeQuery();
            
            int status=0;
            int fid=-1;//From
            int tid=-1;//To
            User From=null;
            User to=null;
            String Data=null;
            ArrayList<User> LU = new ArrayList<>();
            
            UserDBMapper udb = new UserDBMapper();
            
            while (result.next()) {
                status = result.getInt("STATUS");
                fid = result.getInt("USERID");
                tid = result.getInt("RECIPIENTID");
                if(fid!=-1 && tid!=-1)
                {
                    From = udb.findById(fid);
                    to = udb.findById(tid);
                    LU.add(new User(From.getID(), From.getFirstName(),From.getLastName(),From.getCity(),From.getAbout(),From.getPass()));
                }
                }
                return LU;
            }
            catch (SQLException e) {
            throw new DataDBException("Error occurred while finding request by recipientid", e);
        } finally {
            close();
        }
    }
    
    public ArrayList<User> GetFriends(final int toid) throws DataDBException{
        Connection conn = cConnection;
        try {
            String query = "SELECT * from APP.FRIENDSHIP where (RECIPIENTID=? or USERID=?) AND STATUS=1";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setInt(1, toid);
            stat.setInt(2, toid);
            ResultSet result = stat.executeQuery();
            
            int status=0;
            int fid=-1;//From
            int tid=-1;//To
            User From=null;
            User to=null;
            String Data=null;
            ArrayList<User> LU = new ArrayList<>();
            
            UserDBMapper udb = new UserDBMapper();
            
            while (result.next()) {
                status = result.getInt("STATUS");
                fid = result.getInt("USERID");
                tid = result.getInt("RECIPIENTID");
                if(fid!=-1 && tid!=-1)
                {
                    From = udb.findById(fid);
                    to = udb.findById(tid);
                    if(toid==to.getID())
                        LU.add(new User(From.getID(), From.getFirstName(),From.getLastName(),From.getCity(),From.getAbout(),From.getPass()));
                    else
                        LU.add(new User(to.getID(), to.getFirstName(),to.getLastName(),to.getCity(),to.getAbout(),to.getPass()));
                }
                }
                return LU;
            }
            catch (SQLException e) {
            throw new DataDBException("Error occurred while finding friends by recipientid", e);
        } finally {
            close();
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
