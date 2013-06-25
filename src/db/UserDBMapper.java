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
public class UserDBMapper {
    private Statement statement = null;
    private ResultSet resultSet = null;
    
    public void createUserTable() throws DataDBException {
        Connection connect = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
            String query = "CREATE TABLE APP.USERS (\"ID\" INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 0, INCREMENT BY 1),\"FIRSTNAME\" VARCHAR(50),\"LASTNAME\" VARCHAR(50),\"CITY\" VARCHAR(50),\"ABOUT\" VARCHAR(400), \"PASS\" VARCHAR(50))";
            PreparedStatement stat = connect.prepareStatement(query);
            stat.executeUpdate();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            throw new DataDBException("Error occurred while creating users table", e);
        } finally {
            close();
            try {
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void deleteUserTable() throws DataDBException {
        Connection connect = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
            String query = "DROP TABLE APP.USERS";
            PreparedStatement stat = connect.prepareStatement(query);
            stat.executeUpdate();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            throw new DataDBException("Error occurred while deleting users table", e);
        } finally {
            close();
            try {
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public User findById(final int ID) throws DataDBException{
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");

            String query = "SELECT * from APP.USERS where ID=?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, ID);
            ResultSet result = statement.executeQuery();

            int id=0;
            String FName=null;
            String LName=null;
            String City=null;
            String About=null;
            String pass = null;
            
            while (result.next()) {
                id = result.getInt("ID");
                FName = result.getString("FIRSTNAME");
                LName = result.getString("LASTNAME");
                City = result.getString("CITY");
                About = result.getString("ABOUT");
                pass = result.getString("PASS");
                
                return new User(            id,
                                            FName,
                                            LName,
                                            City,
                                            About,
                                            pass);
                }
                return null;
            }
            catch (SQLException e) {
            throw new DataDBException("Error occurred while finding users by ID", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            close();
        }
    }
    
    public boolean passCompare(final int ID, String password) throws DataDBException{
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");

            String query = "SELECT * from APP.USERS where ID=?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, ID);
            ResultSet result = statement.executeQuery();

            String pass = null;
            
            while (result.next()) {
                pass = result.getString("PASS");
                }
            
            return pass.contentEquals(password);
            }
            catch (SQLException e) {
            throw new DataDBException("Error occurred while finding users by ID", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            close();
        }
    }
    
    public boolean IdExist(final int ID) throws DataDBException{
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");

            String query = "SELECT COUNT(ID) from APP.USERS where ID=?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, ID);
            ResultSet result = statement.executeQuery();

            int count=0;
            result.next();
            count = result.getInt(1);
            if (count == 0)
                return false;
            else
                return true;
            }
            catch (SQLException e) {
            throw new DataDBException("Error occurred while finding users by ID", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            close();
        }
    }
    
    public ArrayList<User> findByFName(final String Name) throws DataDBException{
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");

            String query = "SELECT * from APP.USERS where FIRSTNAME=?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, Name);
            ResultSet result = stat.executeQuery();

            int id=0;
            String FName=null;
            String LName=null;
            String City=null;
            String About=null;
            String pass=null;
            ArrayList<User> LU = new ArrayList<>();
            
            while (result.next()) {
                id = result.getInt("ID");
                FName = result.getString("FIRSTNAME");
                LName = result.getString("LASTNAME");
                City = result.getString("CITY");
                About = result.getString("ABOUT");
                pass = result.getString("PASS");
                LU.add(new User(id,FName,LName,City,About, pass));
                }
                return LU;
            }
            catch (SQLException e) {
            throw new DataDBException("Error occurred while finding users by First Name", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            close();
        }
    }
    
    
    public ArrayList<User> findByLastName(final String Name) throws DataDBException{
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");

            String query = "SELECT * from APP.USERS where LASTNAME=?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, Name);
            ResultSet result = stat.executeQuery();

            int id=0;
            String FName=null;
            String LName=null;
            String City=null;
            String About=null;
            String pass = null;
            ArrayList<User> LU = new ArrayList<>();
            
            while (result.next()) {
                id = result.getInt("ID");
                FName = result.getString("FIRSTNAME");
                LName = result.getString("LASTNAME");
                City = result.getString("CITY");
                About = result.getString("ABOUT");
                pass = result.getString("PASS");
                LU.add(new User(id,FName,LName,City,About, pass));
                }
            
                return LU;
            }
            catch (SQLException e) {
            throw new DataDBException("Error occurred while finding users by last name", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            close();
        }
    }
    
    public ArrayList<User> findByCity(final String Ci) throws DataDBException{
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");

            String query = "SELECT * from APP.USERS where CITY=?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, Ci);
            ResultSet result = stat.executeQuery();

            int id=0;
            String FName=null;
            String LName=null;
            String City=null;
            String About=null;
            String pass = null;
            ArrayList<User> LU=new ArrayList<>();
            
            while (result.next()) {
                id = result.getInt("ID");
                FName = result.getString("FIRSTNAME");
                LName = result.getString("LASTNAME");
                City = result.getString("CITY");
                About = result.getString("ABOUT");
                pass = result.getString("PASS");
                LU.add(new User(id,FName,LName,City,About, pass));
                }
            
                return LU;
            }
            catch (SQLException e) {
            throw new DataDBException("Error occurred while finding users by city", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            close();
        }
    }
    
    public ArrayList<User> getAllUsers() throws DataDBException{
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");

            String query = "SELECT * from APP.USERS";
            PreparedStatement stat = conn.prepareStatement(query);
            ResultSet result = stat.executeQuery();

            int id=0;
            String FName=null;
            String LName=null;
            String City=null;
            String About=null;
            String pass = null;
            ArrayList<User> LU=new ArrayList<>();
            
            while (result.next()) {
                id = result.getInt("ID");
                FName = result.getString("FIRSTNAME");
                LName = result.getString("LASTNAME");
                City = result.getString("CITY");
                About = result.getString("ABOUT");
                pass = result.getString("PASS");
                LU.add(new User(id,FName,LName,City,About, pass));
                }
            
                return LU;
            }
            catch (SQLException e) {
            throw new DataDBException("Error occurred while finding users by city", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            close();
        }
    }
    
    public int insertUser(String FName, String LName, String City, String About, String pass) throws DataDBException{
        Connection connect = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
            String query = "INSERT into APP.USERS (FIRSTNAME, LASTNAME, CITY, ABOUT, PASS) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stat = connect.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

            stat.setString(1, FName);
            stat.setString(2, LName);
            stat.setString(3, City);
            stat.setString(4, About);
            stat.setString(5, pass);
            stat.executeUpdate();
            
            ResultSet res = stat.getGeneratedKeys();
            int ret=0;
            while (res.next())
                ret=res.getInt(1);
            return ret;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            throw new DataDBException("Error occurred while adding new user", e);
        } finally {
            try {
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            close();
        }
    }
    
    public void DeleteUser(int ID) throws DataDBException{
        Connection connect = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
            String query = "DELETE FROM APP.USERS WHERE ID=?";
            PreparedStatement stat = connect.prepareStatement(query);

            stat.setInt(1, ID);
            stat.executeUpdate();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            throw new DataDBException("Error occurred while deleting user", e);
        } finally {
            try {
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
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
