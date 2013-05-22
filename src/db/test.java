

package db;

import business.User;
import java.sql.*;
/**
 *
 * @author Brasha
 */
public class test {
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    public test() throws Exception {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
            String query = "INSERT into APP.USERS (FIRSTNAME, LASTNAME, CITY, ABOUT) VALUES (?, ?, ?, ?)";
            PreparedStatement stat = connect.prepareStatement(query);
            User user = new User(1, "Pavel", "Bragin", "Sosnovy Bor", "Student");

            //stat.setInt(1, user.getID());
            stat.setString(1, user.getFirstName());
            stat.setString(2, user.getLastName());
            stat.setString(3, user.getCity());
            stat.setString(4, user.getAbout());
            stat.executeUpdate();
            
            /*statement=connect.createStatement();
                        resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE");
            while (resultSet.next()) {
                String user = resultSet.getString("name");
                String number = resultSet.getString("number");
                System.out.println("User: " + user);
                System.out.println("ID: " + number);
            }*/
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
    
    /*public void insert(User user){
        Connection conn = null;
        try {
            conn = connectionManager_.getConnection();

            String query = "INSERT into Users VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);

            statement.setInt(1, 2);
            statement.setString(2, user.getLogin());
            statement.setInt(3, user.getPasswordHash());
            statement.setString(4, user.getName());
            statement.setString(5, user.getSecondName());
            statement.setString(6, user.getEmail());
            statement.setInt(7, 0);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DataMapperException("Error occurred while inserting a user", e);
        } finally {
            if (conn != null) {
                try {
                    connectionManager_.closeConnection(conn);
                } catch (SQLException e2) {}
            }
        }
    }*/
    
    
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
            System.out.println("Connection to database lost");
        }
    }
    /*public static void main(String[] args) throws Exception {
        test dao = new test();
    }*/
}
