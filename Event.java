package PetMeetUp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.reflect.Field;

public class Event {
	//时间、地点、活动人数、发起人ID、发起人名字、发起人动物ID、发起人动物名称、发起时间、活动时间、、活动状态（草稿、未来、历史、取消）、参与人ID列表,参与人ID列表状态

	public int eventId; 
	public String eventTitle; 
	public String eventDetail;
	public String eventPicUrl; 
	public Date date;	
	public Time timeStart;
	public Time timeEnd;
	public String place;
	public int sponsorId;
	public String sponsorName;
	public int sponsorPetId;
	public String sponsorPetName;
	public int partNum;
	public String partIdList; //Use commas to separate
	public String partNameList; //Use commas to separate
	public String partStatusList; //Use commas to separate // Draft/Active/His/Cancel
	public int likeNum; 
	public int unLikeNum; 
	public int favoriteNum; 
	public Date createDate;
	public Date upateDate;
	public String status;
	
    public static void main(String[] args) throws ParseException, ClassNotFoundException, SQLException {
        
    	Event event = new Event();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	event.date = dateFormat.parse("2024-03-15 12:30:00"); 
    	// SimpleDateFormat dateFormat2 = new SimpleDateFormat("MMM-dd-YYYY HH:mm"); dateFormat.format(now)
    	event.eventId = 5;
    	event.eventTitle = "kara's happy time @moutain view!";
    	event.eventDetail = "On March 20th, Mountain View will host an enchanting gathering where our four-legged friends come together for a special doggy date. Set against the scenic backdrop of the city's parks and green spaces, this event promises a day of tail-wagging excitement and furry camaraderie. From playful pups to wise old souls, dogs of all ages and breeds will converge to socialize, sniff, and strut their stuff. As their human companions mingle, dogs will romp and frolic, exchanging playful barks and friendly sniffs. Attendees can look forward to a variety of activities, including dog-friendly games, agility courses, and perhaps even a doggy fashion show. Throughout the event, local shelters and rescue organizations will be on hand, showcasing adoptable dogs in search of loving forever homes. It's a chance for dog lovers to connect, share stories, and celebrate the unconditional love and joy that our canine companions bring into our lives. So mark your calendars, grab your leashes, and join us for a day filled with laughter, tail wags, and unforgettable moments in the heart of Mountain View.\r\n";
		event.eventPicUrl = "";
		event.timeStart = Time.valueOf("11:30:00");
		event.timeEnd = Time.valueOf("14:30:00");
		event.place = "Mountain View Park";
		event.sponsorId = 1;
		event.sponsorName = "kara2";
		event.sponsorPetId = 1;
		event.sponsorPetName = "Wangcai2";
		event.partNum = 15;
		event.partIdList ="2,3,5";
		event.partNameList = "stein,yuga,andy";
		event.partStatusList = "Draft,Active,Cancel";
		event.likeNum = 200;
		event.favoriteNum = 10;
		event.unLikeNum = 2;
		event.createDate = dateFormat.parse("2024-03-10 12:30:00"); 
		event.upateDate = dateFormat.parse("2024-03-12 18:30:00"); 
		event.status = "Active";
		
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/petmeet?useSSL=false&serverTimezone=UTC";
            String username = "root";
            String password = "Stein@123";
            connection = DriverManager.getConnection(url, username, password);

            updateEvent(connection, event);
            getEvent(connection,event);
            //cancelEvent(connection,event);

 
            System.out.print("SQLexe OK");
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

    //update and insert 
	public static void updateEvent(Connection connection,Event event) {
        PreparedStatement selectStatement = null;
        PreparedStatement insertStatement = null;
        PreparedStatement updateStatement = null;
        try {
        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	
            String selectSql = " SELECT * FROM event WHERE eventid = ? ";
            selectStatement = connection.prepareStatement(selectSql);
            selectStatement.setString(1, String.valueOf(event.eventId));

            ResultSet resultSet = selectStatement.executeQuery();
            if (resultSet.next()) {
            	// update 
                System.out.println("SQLexe UPDATE");

                String updateSql = "update  event  set  "
                		+" eventtitle = ?, eventdetail = ?, eventpicurl = ?, date = ?, timestart = ?, "
            			+ "timeend = ?, place = ?, sponsorid = ?, sponsorname = ?,sponsorpetid = ?, "
            			+ "sponsorpetname = ?, partnum = ?, partidlist = ?, partnamelist = ?, partstatuslist = ?, "
            			+ "likenum = ?, unlikenum = ?, favoritenum = ?, createdate = ?,upatedate = ?, status = ?"
            			+ "where eventId = ?";
                updateStatement = connection.prepareStatement(updateSql);
                updateStatement.setString(1, event.eventTitle);
                updateStatement.setString(2, event.eventDetail);
                updateStatement.setString(3, "");
                updateStatement.setString(4, "2024-03-10 12:36:00");
                updateStatement.setString(5, String.valueOf(event.timeStart));
                updateStatement.setString(6, String.valueOf(event.timeEnd));
                updateStatement.setString(7, event.place);
                updateStatement.setString(8, Integer.toString(event.sponsorId) );
                updateStatement.setString(9, event.sponsorName);
                updateStatement.setString(10, Integer.toString(event.sponsorPetId) );
                updateStatement.setString(11, event.sponsorPetName);
                updateStatement.setString(12, Integer.toString(event.sponsorPetId));
                updateStatement.setString(13, event.partIdList);
                updateStatement.setString(14, event.partNameList);
                updateStatement.setString(15, event.partStatusList);
                updateStatement.setString(16, Integer.toString(event.likeNum));
                updateStatement.setString(17, Integer.toString(event.favoriteNum));
                updateStatement.setString(18, Integer.toString(event.unLikeNum));
                updateStatement.setString(19, dateFormat.format(event.createDate));
                updateStatement.setString(20, dateFormat.format(event.upateDate));
                updateStatement.setString(21, event.status);
                updateStatement.setString(22, Integer.toString(event.eventId));

                
                updateStatement.executeUpdate();
            } else {
            	//insert 
                System.out.println("SQLexe INSERT");

            	String table_cols= "eventtitle, eventdetail, eventpicurl, date, timestart, timeend, place, sponsorid, sponsorname,sponsorpetid, "
            			+ "sponsorpetname, partnum, partidlist, partnamelist, partstatuslist, likenum, unlikenum, favoritenum, createdate,upatedate, status";
                String insertSql = "INSERT INTO event ("+table_cols+") VALUES (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?)";
                insertStatement = connection.prepareStatement(insertSql);
                insertStatement.setString(1, "zhuli222 pet happy@moutain view park");
                insertStatement.setString(2, "zhuli222 pet happy  @moutain view park ahahahahahahahahahahahahahahahahahahahahahaha");
                insertStatement.setString(3, "");
                insertStatement.setString(4, "2024-03-10 12:35:00");
                insertStatement.setString(5, "11:00:00");
                insertStatement.setString(6, "14:00:00");
                insertStatement.setString(7, "Mountain View Park");
                insertStatement.setString(8, "1" );
                insertStatement.setString(9, "kara");
                insertStatement.setString(10, "1");
                insertStatement.setString(11, "Wangcai");
                insertStatement.setString(12, "10");
                insertStatement.setString(13, "2,3");
                insertStatement.setString(14, "stein,yuga");
                insertStatement.setString(15, "Active,Active");
                insertStatement.setString(16, "200");
                insertStatement.setString(17, "10");
                insertStatement.setString(18, "2");
                insertStatement.setString(19, "2024-03-15 12:31:00");
                insertStatement.setString(20, "2024-03-18 18:31:00");
                insertStatement.setString(21, "Active");
        		
                insertStatement.executeUpdate();
            }
            System.out.println("SQL exe OK");
        } catch (SQLException e) {
            e.printStackTrace();
        } 

		
	} 
	
	public static void cancelEvent(Connection connection,Event event)  {
        PreparedStatement selectStatement = null;
        PreparedStatement cancelStatement = null;
        try {
            String selectSql = "SELECT * FROM event WHERE eventid = ?";
            selectStatement = connection.prepareStatement(selectSql);
            selectStatement.setString(1, String.valueOf(event.eventId));

            ResultSet resultSet = selectStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("SQLexe UPDATE");

                String cancelSql = "update  event  set status = 'Cancel' "
            			+ "where eventId = ?";
                cancelStatement = connection.prepareStatement(cancelSql);
            	
            }
        	
        System.out.println("cancel Event  OK");
        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	} 
	
	public void setEvent(Event event) {
		this.eventId = event.eventId;
		this.eventTitle = event.eventTitle;
		this.eventDetail = event.eventDetail;
		this.eventPicUrl = event.eventPicUrl;
		this.date = event.date;
		this.timeStart = event.timeStart;
		this.timeEnd = event.timeEnd;
		this.place = event.place;
		this.sponsorId = event.sponsorId;
		this.sponsorName = event.sponsorName;
		this.sponsorPetId = event.sponsorPetId;
		this.sponsorPetName = event.sponsorPetName;
		this.partNum = event.partNum;
		this.partIdList = event.partIdList;
		this.partNameList = event.partNameList;
		this.partStatusList = event.partStatusList;
		this.likeNum = event.likeNum;
		this.favoriteNum = event.favoriteNum;
		this.unLikeNum = event.unLikeNum;
		this.createDate = event.createDate;
		this.upateDate = event.upateDate;
		this.status = event.status;
	} 
	public PreparedStatement setEventSql(Event event) {
		PreparedStatement Statement = null;
		this.eventId = event.eventId;
		this.eventTitle = event.eventTitle;
		this.eventDetail = event.eventDetail;
		this.eventPicUrl = event.eventPicUrl;
		this.date = event.date;
		this.timeStart = event.timeStart;
		this.timeEnd = event.timeEnd;
		this.place = event.place;
		this.sponsorId = event.sponsorId;
		this.sponsorName = event.sponsorName;
		this.sponsorPetId = event.sponsorPetId;
		this.sponsorPetName = event.sponsorPetName;
		this.partNum = event.partNum;
		this.partIdList = event.partIdList;
		this.partNameList = event.partNameList;
		this.partStatusList = event.partStatusList;
		this.likeNum = event.likeNum;
		this.favoriteNum = event.favoriteNum;
		this.unLikeNum = event.unLikeNum;
		this.createDate = event.createDate;
		this.upateDate = event.upateDate;
		this.status = event.status;
		
		return Statement;
	} 
	
	public static void getEvent(Connection connection,Event event) throws IllegalArgumentException {
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
