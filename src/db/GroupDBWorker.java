/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import business.Group;
import business.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brasha
 */
public class GroupDBWorker {
    private Statement statement = null;
    private ResultSet resultSet = null;
    
    public void createGroupTable() throws DataDBException {
        Connection connect = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
            String query = "CREATE TABLE APP.GROUPS (\"ID\" INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 0, INCREMENT BY 1),\"NAME\" VARCHAR(50),\"ADMINID\" INT,\"ABOUT\" VARCHAR(400))";
            PreparedStatement stat = connect.prepareStatement(query);
            stat.executeUpdate();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            throw new DataDBException("Error occurred while creating group table", e);
        } finally {
            close();
            try {
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void deleteGroupTable() throws DataDBException {
        Connection connect = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
            String query = "DROP TABLE APP.GROUPS";
            PreparedStatement stat = connect.prepareStatement(query);
            stat.executeUpdate();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            throw new DataDBException("Error occurred while deleting groups table", e);
        } finally {
            close();
            try {
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void DeleteGroup(int ID) throws DataDBException{
        Connection connect = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
            String query = "DELETE FROM APP.GROUPS WHERE ID=?";
            PreparedStatement stat = connect.prepareStatement(query);

            stat.setInt(1, ID);
            stat.executeUpdate();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            throw new DataDBException("Error occurred while deleting friend", e);
        } finally {
            try {
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
            close();
        }
    }
    
    public Group findById(final int ID) throws DataDBException{
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");

            String query = "SELECT * from APP.GROUPS where ID=?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setInt(1, ID);
            ResultSet result = stat.executeQuery();

            int id=0;
            String Name=null;
            int AdminId=0;
            String About=null;
            
            while (result.next()) {
                id = result.getInt("ID");
                Name = result.getString("NAME");
                AdminId = result.getInt("ADMINID");
                About = result.getString("ABOUT");
                }
            
                return new Group(            id,
                                            Name,
                                            About,
                                            AdminId);
            }
            catch (SQLException e) {
            throw new DataDBException("Error occurred while finding group by ID", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
            close();
        }
    }
    
    public ArrayList<Group> findByName(final String Name) throws DataDBException{
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");

            String query = "SELECT * from APP.GROUPS where NAME=?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, Name);
            ResultSet result = stat.executeQuery();
            
            int id=0;
            String N=null;
            String About=null;
            int AdminId=0;
            ArrayList<Group> LG = new ArrayList<>();
            
            while (result.next()) {
                id = result.getInt("ID");
                N = result.getString("NAME");
                About = result.getString("ABOUT");
                AdminId = result.getInt("ADMINID");
                LG.add(new Group(id,N,About,AdminId));
                }
                return LG;
            }
            catch (SQLException e) {
            throw new DataDBException("Error occurred while finding groups by name", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
            close();
        }
    }
    
    public int insertGroup(String Name, String About, int AdminId) throws DataDBException{
        Connection connect = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
            String query = "INSERT into APP.GROUPS (NAME, ABOUT, ADMINID) VALUES (?, ?, ?)";
            PreparedStatement stat = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            stat.setString(1, Name);
            stat.setString(2, About);
            stat.setInt(3, AdminId);
            stat.executeUpdate();
            
            ResultSet res = stat.getGeneratedKeys();
            int ret=0;
            while (res.next())
                ret=res.getInt(1);
            return ret;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            throw new DataDBException("Error occurred while adding new group", e);
        } finally {
            try {
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
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
