package PetMeetUp;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class Profile {
	public int id;
	public String name;
	public String email;
	public String phone;
	public String location;
	public String password;
	public String personPicUrl;
	public String bio;
	public int petId;
	public String petName;
	public String petAge;
	public String petBreed;
	public String petPicUrl;
	public String status;
	
	public static void main(String[] args) throws ParseException, ClassNotFoundException, SQLException {
		
	}
	
	
	public static void updateProfile(Connection connection,Profile profile) {
		
	}
	
	public static void cancelProfile(Connection connection,Profile profile) {
		
	}
	
	public static Profile  getProfile(Connection connection,String queryStr) {
		Profile A = null;
		
		return A;
	}
	
	public static void getProfile(Connection connection,Event event) throws IllegalArgumentException {
        PreparedStatement selectStatement = null;
        try {
            
            String selectSql = "SELECT * FROM event WHERE eventid = ?";
            selectStatement = connection.prepareStatement(selectSql);
            selectStatement.setString(1, "2");

            ResultSet resultSet = selectStatement.executeQuery();
            if (resultSet.next()) {
            	String table_cols= "eventtitle, eventdetail, eventpicurl, date, timestart, timeend, place, sponsorid, sponsorname,sponsorpetid, "
            			+ "sponsorpetname, partnum, partidlist, partnamelist, partstatuslist, likenum, unlikenum, favoritenum, createdate,upatedate, status";
                System.out.println("ID: " + resultSet.getInt("eventid"));
                System.out.println("eventtitle: " + resultSet.getString("eventtitle"));
                System.out.println("eventdetail: " + resultSet.getString("eventdetail"));
                System.out.println("date" + resultSet.getDate("date"));
                System.out.println("timestart: " + resultSet.getTime("timestart"));
                System.out.println("timeend: " + resultSet.getTime("timeend"));
                System.out.println("place: " + resultSet.getString("place"));
                System.out.println("sponsorid: " + resultSet.getInt("sponsorid"));
                System.out.println("sponsorname: " + resultSet.getString("sponsorname"));
                System.out.println(" ");

                
                Field[] fields = event.getClass().getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true); // 设置可访问私有字段
                    System.out.println(field.getName() + ": " + field.get(event));
                }

                
            } else {
            	//
            }
            System.out.print("SQLquery OK");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
		
	} 

}
