package PetMeetUp;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
	public static void main(String[] args) throws ParseException {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM-dd HH:mm");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("MMM-dd-YYYY HH:mm");
		String formatedDate = dateFormat.format(now);
		System.out.println("date:  "+formatedDate);
		String formatedDate2 = dateFormat2.format(now);
		System.out.println("date2:  "+formatedDate2);
    	Event event = new Event();
		SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	event.date = dateFormat3.parse("2024-03-15 12:30");
		System.out.println("date3:  "+dateFormat3.format(event.date));
		
		Time time1 = Time.valueOf("11:30:00");
		Time time2 = Time.valueOf("14:30:00");
        SimpleDateFormat dateFormat4 = new SimpleDateFormat("h:mm a"); // 指定时间格式，a表示AM/PM
		System.out.println("date4:  "+dateFormat4.format(time1));
		System.out.println("date4:  "+dateFormat4.format(time2));
		System.out.println("date4:  "+formatedDate2.toString()); 


	}

}
