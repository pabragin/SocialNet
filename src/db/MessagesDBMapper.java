/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import business.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brasha
 */
public class MessagesDBMapper {
    
     private Statement statement = null;
    private ResultSet resultSet = null;
    
    public void createMessagesTable() throws DataDBException {
        Connection connect = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
            String query = "CREATE TABLE APP.MESSAGES (\"ID\" INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 0, INCREMENT BY 1),\"FROMID\" INT,\"TOID\" INT,\"TYPE\" INT,\"DATA\" VARCHAR(400))";
            PreparedStatement stat = connect.prepareStatement(query);
            stat.executeUpdate();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            throw new DataDBException("Error occurred while creating messages table", e);
        } finally {
            close();
            try {
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void deleteMessagesTable() throws DataDBException {
        Connection connect = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
            String query = "DROP TABLE APP.MESSAGES";
            PreparedStatement stat = connect.prepareStatement(query);
            stat.executeUpdate();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            throw new DataDBException("Error occurred while deleting messages table", e);
        } finally {
            close();
            try {
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void DeleteMessage(int ID) throws DataDBException{
        Connection connect = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
            String query = "DELETE FROM APP.MESSAGES WHERE ID=?";
            PreparedStatement stat = connect.prepareStatement(query);

            stat.setInt(1, ID);
            stat.executeUpdate();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            throw new DataDBException("Error occurred while deleting message", e);
        } finally {
            try {
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            close();
        }
    }
    
    public PrivateMessage GetPrivateMessageById(final int ID) throws DataDBException{
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");

            String query = "SELECT * from APP.MESSAGES where ID=? AND TYPE=0";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setInt(1, ID);
            ResultSet result = stat.executeQuery();

            int id=0;
            int fid=-1;//From
            int tid=-1;//To
            User From=null;
            User to=null;
            String Data=null;
            UserDBMapper udb = new UserDBMapper();
            
            while (result.next()) {
                id = result.getInt("ID");
                fid = result.getInt("FROMID");
                tid = result.getInt("TOID");
                Data = result.getString("DATA");
                }
                if(fid!=-1 && tid!=-1)
                {
                    From = udb.findById(fid);
                    to = udb.findById(tid);
                }
            
                return new PrivateMessage(  id,
                                            From,
                                            to,
                                            Data);
            }
            catch (SQLException e) {
            throw new DataDBException("Error occurred while finding private message by ID", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            close();
        }
    }
    
    public GroupMessage GetGroupMessageById(final int ID) throws DataDBException{
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");

            String query = "SELECT * from APP.MESSAGES where ID=? AND TYPE=1";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setInt(1, ID);
            ResultSet result = stat.executeQuery();

            int id=0;
            int fid=-1;//From
            int tid=-1;//To
            User From=null;
            Group to=null;
            String Data=null;
            UserDBMapper udb = new UserDBMapper();
            GroupDBMapper gdb = new GroupDBMapper();
            
            while (result.next()) {
                id = result.getInt("ID");
                fid = result.getInt("FROMID");
                tid = result.getInt("TOID");
                Data = result.getString("DATA");
                }
                if(fid!=-1 && tid!=-1)
                {
                    From = udb.findById(fid);
                    to = gdb.findById(tid);
                    return new GroupMessage(  id,
                                            From,
                                            to,
                                            Data);
                }
                return null;
            }
            catch (SQLException e) {
            throw new DataDBException("Error occurred while finding group message by ID", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            close();
        }
    }
    
    public ArrayList<PrivateMessage> GetPrivateMessageFrom(final int fromid) throws DataDBException{
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");

            String query = "SELECT * from APP.MESSAGES where FROMID=? AND TYPE=0";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setInt(1, fromid);
            ResultSet result = stat.executeQuery();
            
            int id=0;
            int fid=-1;//From
            int tid=-1;//To
            User From=null;
            User to=null;
            String Data=null;
            ArrayList<PrivateMessage> LP = new ArrayList<>();
            
            UserDBMapper udb = new UserDBMapper();
            
            while (result.next()) {
                id = result.getInt("ID");
                fid = result.getInt("FROMID");
                tid = result.getInt("TOID");
                Data = result.getString("DATA");
                if(fid!=-1 && tid!=-1)
                {
                    From = udb.findById(fid);
                    to = udb.findById(tid);
                    LP.add(new PrivateMessage(id,From,to,Data));
                }
                }
                return LP;
            }
            catch (SQLException e) {
            throw new DataDBException("Error occurred while finding groups by name", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            close();
        }
    }
    
    public ArrayList<PrivateMessage> GetPrivateMessageTo(final int toid) throws DataDBException{
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");

            String query = "SELECT * from APP.MESSAGES where TOID=? AND TYPE=0";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setInt(1, toid);
            ResultSet result = stat.executeQuery();
            
            int id=0;
            int fid=-1;//From
            int tid=-1;//To
            User From=null;
            User to=null;
            String Data=null;
            ArrayList<PrivateMessage> LP = new ArrayList<>();
            
            UserDBMapper udb = new UserDBMapper();
            
            while (result.next()) {
                id = result.getInt("ID");
                fid = result.getInt("FROMID");
                tid = result.getInt("TOID");
                Data = result.getString("DATA");
                if(fid!=-1 && tid!=-1)
                {
                    From = udb.findById(fid);
                    to = udb.findById(tid);
                    LP.add(new PrivateMessage(id,From,to,Data));
                }
                }
                return LP;
            }
            catch (SQLException e) {
            throw new DataDBException("Error occurred while finding groups by name", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            close();
        }
    }
    
    public ArrayList<GroupMessage> GetGroupMessageFrom(final int fromid) throws DataDBException{
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");

            String query = "SELECT * from APP.MESSAGES where FROMID=? AND TYPE=1";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setInt(1, fromid);
            ResultSet result = stat.executeQuery();
            
            int id=0;
            int fid=-1;//From
            int tid=-1;//To
            User From=null;
            Group to=null;
            String Data=null;
            ArrayList<GroupMessage> LG = new ArrayList<>();
            
            UserDBMapper udb = new UserDBMapper();
            GroupDBMapper gdb = new GroupDBMapper();
            
            while (result.next()) {
                id = result.getInt("ID");
                fid = result.getInt("FROMID");
                tid = result.getInt("TOID");
                Data = result.getString("DATA");
                if(fid!=-1 && tid!=-1)
                {
                    From = udb.findById(fid);
                    to = gdb.findById(tid);
                    LG.add(new GroupMessage(id,From,to,Data));
                }
                }
                return LG;
            }
            catch (SQLException e) {
            throw new DataDBException("Error occurred while finding groups by name", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            close();
        }
    }
    
    public ArrayList<GroupMessage> GetGroupMessageTo(final int toid) throws DataDBException{
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");

            String query = "SELECT * from APP.MESSAGES where TOID=? AND TYPE=1";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setInt(1, toid);
            ResultSet result = stat.executeQuery();
            
            int id=0;
            int fid=-1;//From
            int tid=-1;//To
            User From=null;
            Group to=null;
            String Data=null;
            ArrayList<GroupMessage> LG = new ArrayList<>();
            
            UserDBMapper udb = new UserDBMapper();
            GroupDBMapper gdb = new GroupDBMapper();
            
            while (result.next()) {
                id = result.getInt("ID");
                fid = result.getInt("FROMID");
                tid = result.getInt("TOID");
                Data = result.getString("DATA");
                if(fid!=-1 && tid!=-1)
                {
                    From = udb.findById(fid);
                    to = gdb.findById(tid);
                    LG.add(new GroupMessage(id,From,to,Data));
                }
                }
                return LG;
            }
            catch (SQLException e) {
            throw new DataDBException("Error occurred while finding groups by name", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            close();
        }
    }
    
    public int insertPrivateMessage(User from, User to, String message) throws DataDBException{
        Connection connect = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
            String query = "INSERT into APP.MESSAGES (FROMID, TOID, DATA, TYPE) VALUES (?, ?, ?, 0)";
            PreparedStatement stat = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            stat.setInt(1, from.getID());
            stat.setInt(2, to.getID());
            stat.setString(3, message);
            stat.executeUpdate();
            
            ResultSet res = stat.getGeneratedKeys();
            int ret=0;
            while (res.next())
                ret=res.getInt(1);
            return ret;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            throw new DataDBException("Error occurred while adding new private message", e);
        } finally {
            try {
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            close();
        }
    }
    
    public int insertGroupMessage(User from, Group to, String message) throws DataDBException{
        Connection connect = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
            String query = "INSERT into APP.MESSAGES (FROMID, TOID, DATA, TYPE) VALUES (?, ?, ?, 1)";
            PreparedStatement stat = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            stat.setInt(1, from.getID());
            stat.setInt(2, to.getID());
            stat.setString(3, message);
            stat.executeUpdate();
            
            ResultSet res = stat.getGeneratedKeys();
            int ret=0;
            while (res.next())
                ret=res.getInt(1);
            return ret;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            throw new DataDBException("Error occurred while adding new group message", e);
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
