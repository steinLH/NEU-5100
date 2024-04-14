package PetMeetUp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test3 {
    public static void main(String[] args) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement selectStatement = null;
        PreparedStatement insertStatement = null;
        PreparedStatement updateStatement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/petmeet?useSSL=false&serverTimezone=UTC";
            String username = "root";
            String password = "Stein@123";
            connection = DriverManager.getConnection(url, username, password);


            String selectSql = "SELECT * FROM users WHERE user_id = ?";
            selectStatement = connection.prepareStatement(selectSql);
            selectStatement.setString(1, "10");

            ResultSet resultSet = selectStatement.executeQuery();
            if (resultSet.next()) {
                String updateSql = "UPDATE users SET email = ? WHERE user_id = ?";
                updateStatement = connection.prepareStatement(updateSql);
                updateStatement.setString(2, "1");
                updateStatement.setString(1, "kara33@gmail.com");
                
                updateStatement.executeUpdate();
            } else {
                String insertSql = "INSERT INTO users (username, email,password) VALUES (?, ?,?)";
                insertStatement = connection.prepareStatement(insertSql);
                insertStatement.setString(1, "zhuli");
                insertStatement.setString(2, "zhuli@qq.com");
                insertStatement.setString(3, "123456");
                
                insertStatement.executeUpdate();
            }
            System.out.print("SQLexe OK");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (selectStatement != null) selectStatement.close();
                if (insertStatement != null) insertStatement.close();
                if (updateStatement != null) updateStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
