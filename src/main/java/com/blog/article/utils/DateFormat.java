package com.blog.article.utils;

 
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** 
* @ClassName: DateFormat 
* @Description: 日期时间格式转换
* @author zbb 
* @date 2017??12??13?? 下午4:34:53 
*  
*/
public class DateFormat {
	
	/** 
	* by zbb
	* @title: DateToString
	* @Description: 日期转String
	* @param date
	* @return
	* String      
	* @throws 
	*/
	public static String DateToString(Date date) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		return sim.format(date);
	}
	
 
	/** 
	* by zbb
	* @title: DateToNow
	* @Description: 计算 date 到现在的时长（分钟）
	* @param date
	* @return
	* @throws Exception
	* Long      
	* @throws 
	*/
	public static Long DateToNow(String date) throws Exception {
		Calendar calendar = Calendar.getInstance();
		Calendar oldcalendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date arr = sdf.parse(date);
		oldcalendar.setTime(arr);		
		return (calendar.getTimeInMillis()-oldcalendar.getTimeInMillis())/(1000 * 60 ) ;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(DateToNow("2017-11-18 15:44:44"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
