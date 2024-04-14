package PetMeetUp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test2 {
    public static void main(String[] args) {
        Connection connection = null;
        java.sql.Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/petmeet?useSSL=false&serverTimezone=UTC";
            String username = "root";
            String password = "Stein@123";
            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                System.out.println("Connected to the database!");                
                statement = connection.createStatement();
                String query = "SELECT * FROM USERS";
                resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    int id = resultSet.getInt("user_id");
                    String name = resultSet.getString("username");
                    System.out.println("ID: " + id + ", Name: " + name);
                }
                
            } else {
                System.out.println("Failed to connect to the database!");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection to the database failed!");
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Failed to close connection to the database!");
                e.printStackTrace();
            }
        }
    }
}
