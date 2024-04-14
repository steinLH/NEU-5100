package PetMeetUp;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Profile {
	public int id;
	public String name;
	public String email;
	public String phone;
	public String location;
	public String password; //需要做加密字段，暂时明文
	public String personPicUrl;
	public String bio;
	public int petId;
	public String petName;
	public int petAge;
	public String petBreed;
	public String petPicUrl;
	public String status;
	
	public static void main(String[] args) throws ParseException, ClassNotFoundException, SQLException {
		
    	Profile profile = new Profile();
    	profile.id = 5;
    	profile.name ="laohai5";
    	profile.email="lao@qq.com";
    	profile.phone="1234567890";
    	profile.location="los angels ";
    	profile.password="555555"; //需要做加密字段，暂时明文
    	profile.personPicUrl="";
    	profile.bio="";
    	profile.petId=1;
    	profile.petName="zhuli555";
    	profile.petAge=2;
    	profile.petBreed="Alaskan";
    	profile.petPicUrl="";
    	profile.status="Cancle";
    	
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/petmeet?useSSL=false&serverTimezone=UTC";
            String username = "root";
            String password = "Stein@123";
            connection = DriverManager.getConnection(url, username, password);

            //getProfile(connection,profile);
            //cancelProfile(connection,profile);
            updateProfile(connection,profile);
 
            System.out.println("SQLexe OK");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    	
    	
		
	}
	
	
	public static void updateProfile(Connection connection,Profile profile) {
		
    PreparedStatement selectStatement = null;
    PreparedStatement insertStatement = null;
    PreparedStatement updateStatement = null;
    try {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	
        String selectSql = " SELECT * FROM profile WHERE id = ? ";
        selectStatement = connection.prepareStatement(selectSql);
        selectStatement.setString(1, String.valueOf(profile.id));

        ResultSet resultSet = selectStatement.executeQuery();
        if (resultSet.next()) {
        	// update 
            System.out.println("SQLexe UPDATE");

            String updateSql = "update  profile  set  "
            		+" name = ?, email = ?, phone = ?, location = ?, password = ?, "
        			+ "petId = ?, petName = ?,petAge = ?,petBreed = ?, status = ? "
        			+ "where id = ?";
            updateStatement = connection.prepareStatement(updateSql);
            updateStatement.setString(1, profile.name);
            updateStatement.setString(2, profile.email);
            updateStatement.setString(3, profile.phone);
            updateStatement.setString(4, profile.location);
            updateStatement.setString(5, profile.password);
            updateStatement.setInt(6, profile.petId);
            updateStatement.setString(7, profile.petName);
            updateStatement.setInt(8, profile.petAge );
            updateStatement.setString(9, profile.petBreed);
            updateStatement.setString(10, profile.status );
            updateStatement.setInt(11, profile.id );
            
            updateStatement.executeUpdate();
        } else {
        	//insert 
            System.out.println(" INSERT profile");

        	String table_cols= 
        			"name, email, phone, location, password, personPicUrl, bio, petId, petName,petAge, petBreed, petPicUrl, status";
            String insertSql = "INSERT INTO profile ("+table_cols+") VALUES (?,?,?,?,?, ?,?,?,?,?, ?,?,?)";
            insertStatement = connection.prepareStatement(insertSql);
		    insertStatement.setString(1, profile.name);
            insertStatement.setString(2, profile.email);
            insertStatement.setString(3, profile.phone);
            insertStatement.setString(4, profile.location);
            insertStatement.setString(5, profile.password);
            insertStatement.setString(6, profile.personPicUrl );
            insertStatement.setString(7, profile.bio );
            insertStatement.setString(8, String.valueOf(profile.petId));
            insertStatement.setString(9, profile.petName);
            insertStatement.setString(10, String.valueOf(profile.petAge) );
            insertStatement.setString(11, profile.petBreed);
            insertStatement.setString(12, profile.petPicUrl );
            insertStatement.setString(13, profile.status );
    		            
            insertStatement.executeUpdate();
        }
        System.out.println("SQL exe OK");
    } catch (SQLException e) {
        e.printStackTrace();
    } 

	
} 
	public static void cancelProfile(Connection connection,Profile profile) {
        PreparedStatement selectStatement = null;
        PreparedStatement updateStatement = null;

        try {
            
            String selectSql = "SELECT * FROM profile WHERE id = ?";
            selectStatement = connection.prepareStatement(selectSql);
            selectStatement.setString(1, String.valueOf(profile.id));

            ResultSet resultSet = selectStatement.executeQuery();
            if (resultSet.next()) {
            	
                System.out.println("cancel  profile  " + profile.status);

            	String updateSql = "update  profile  set  status = ? where id = ?";
                updateStatement = connection.prepareStatement(updateSql);
                updateStatement.setString(1, profile.status);
                updateStatement.setString(2, Integer.toString(profile.id));
                
                updateStatement.executeUpdate();
                
            } else {
            	System.out.println("profile not find");
            }
            System.out.println("SQLquery OK");
        } catch (SQLException e) {
            e.printStackTrace();
        } 
		
	}
	
	public static void getProfile(Connection connection,Profile profile) throws IllegalArgumentException {
        PreparedStatement selectStatement = null;
        try {
            System.out.println("get Profile ");

            String selectSql = "SELECT * FROM profile WHERE id = ?";
            selectStatement = connection.prepareStatement(selectSql);
            selectStatement.setString(1, String.valueOf(profile.id));

            ResultSet resultSet = selectStatement.executeQuery();
            
            if (resultSet.next()) {
            	
                Field[] fields = profile.getClass().getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true); // 设置可访问私有字段
                    System.out.println(field.getName() + ": " + field.get(profile));
                }

                
            } else {
            	//
            }
            System.out.println("SQLquery OK");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
		
	} 

}
