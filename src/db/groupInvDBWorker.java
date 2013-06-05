/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import business.Group;
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
public class groupInvDBWorker {
    private Statement statement = null;
    private ResultSet resultSet = null;
    
    private Connection cConnection;
    
    public groupInvDBWorker(String adress, String name, String password)
    {
        try {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            } catch (    InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(groupInvDBWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                cConnection = DriverManager.getConnection(adress, name, password);
            } catch (SQLException ex) {
                Logger.getLogger(groupInvDBWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(groupInvDBWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addInvolve(int uID,int gID) throws DataDBException{
        Connection connect = cConnection;
        try {
            String query = "INSERT into APP.INVOLVE (USERID, GROUPID) VALUES (?, ?)";
            PreparedStatement stat = connect.prepareStatement(query);

            stat.setInt(1, uID);
            stat.setInt(2, gID);
            stat.executeUpdate();
            
        } catch (SQLException e) {
            throw new DataDBException("Error occurred while requesting friendship", e);
        } finally {
            close();
        }
    }
  
    
    public void DeleteInvolve(int uID,int gID) throws DataDBException{
        Connection connect = cConnection;
        try {
            String query = "DELETE FROM APP.INVOLVE WHERE (USERID=? AND GROUPID=?)";
            PreparedStatement stat = connect.prepareStatement(query);

            stat.setInt(1, uID);
            stat.setInt(2, gID);
            stat.executeUpdate();
            
        } catch (SQLException e) {
            throw new DataDBException("Error occurred while Deleting involve", e);
        } finally {
            close();
        }
    }
    
    
         public void deleteInvolveTable() throws DataDBException {
        Connection connect = cConnection;
        try {
            String query = "DROP TABLE APP.INVOLVE";
            PreparedStatement stat = connect.prepareStatement(query);
            stat.executeUpdate();
            
        } catch (SQLException e) {
            throw new DataDBException("Error occurred while deleting friendship table", e);
        } finally {
            close();
        }
    }
         
    public void createInvolveTable() throws DataDBException {
        Connection connect = cConnection;
        try {
            String query = "CREATE TABLE APP.INVOLVE (\"USERID\" INT,\"GROUPID\" INT)";
            PreparedStatement stat = connect.prepareStatement(query);//STATUS 0 - zayavka, 1 - friens
            stat.executeUpdate();
            
        } catch (SQLException e) {
            throw new DataDBException("Error occurred while creating involve table", e);
        } finally {
            close();
        }
    }
    
    public ArrayList<User> GetAllUser(final int toid) throws DataDBException{
        Connection conn = cConnection;
        try {
            String query = "SELECT * from APP.INVOLVE where GROUPID=?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setInt(1, toid);
            ResultSet result = stat.executeQuery();
            
            int status=0;
            int fid=-1;//From
            User From=null;
            User to=null;
            String Data=null;
            ArrayList<User> LU = new ArrayList<>();
            
            UserDBWorker udb = new UserDBWorker();
            
            while (result.next()) {
                fid = result.getInt("USERID");
                if(fid!=-1)
                {
                    From = udb.findById(fid);
                    LU.add(new User(From.getID(), From.getFirstName(),From.getLastName(),From.getCity(),From.getAbout(),From.getPass()));
                }
                }
                return LU;
            }
            catch (SQLException e) {
            throw new DataDBException("Error occurred while finding request by GROUPID", e);
        } finally {
            close();
        }
    }
    
    public ArrayList<Group> GetAllGroups(final int id) throws DataDBException{
        Connection conn = cConnection;
        try {
            String query = "SELECT * from APP.INVOLVE where USERID=?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setInt(1, id);
            ResultSet result = stat.executeQuery();
            
            int status=0;
            int fid=-1;//From
            int tid=-1;//To
            User From=null;
            Group to=null;
            String Data=null;
            ArrayList<Group> LG = new ArrayList<>();
            
            GroupDBWorker gdb = new GroupDBWorker();
            
            while (result.next()) {
                //fid = result.getInt("USERID");
                tid = result.getInt("GROUPID");
                if(tid!=-1)
                {
                    //From = udb.findById(fid);
                    to = gdb.findById(tid);
                    LG.add(new Group(to.getID(), to.getName(),to.getAbout(),to.getAdminID()));
                }
                }
                return LG;
            }
            catch (SQLException e) {
            throw new DataDBException("Error occurred while finding request by GROUPID", e);
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
