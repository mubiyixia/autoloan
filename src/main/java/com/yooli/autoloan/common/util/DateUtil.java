package com.yooli.autoloan.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理的工具类
 * @author TomXu
 * @since 2012-05-23
 */
public class DateUtil {

	/**
	* 获取当月最后一天
	* 
	* @param yearMonth
	* @return
	*/
	public static String getLastDayOfThisMonth() {
		
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
		} catch (Exception ex) {
			return null;
		}
	}
	
	public static String getLastDayOfLastMonth(){
		Calendar calendar = Calendar.getInstance();
		//设置为本月第一天
		calendar.set(Calendar.DATE, 1);
		//日期减一，上月最后一天
		calendar.add(Calendar.DATE, -1);
		return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
	}
	
	/**
	 * 如果当前日期超过15号，则取最后一天，如果是小于等于15号，则取15号作为最近的还款日
	 * @author TomXu
	 * @return
	 * @since 2012-05-24
	 */
	public static String getNearestReturnDate(){
		
		Calendar calendar = Calendar.getInstance();
		//取当前日期
		int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
		if(currentDay > 15){
			return getLastDayOfThisMonth();
		} else {
			calendar.set(Calendar.DATE, 15);
			return new SimpleDateFormat("yyyy-mm-dd").format(calendar.getTime());
		}
	}
	
	/**
	 * 
	 * Description: 
	 * 根据出生日期求年龄
	 * @param 
	 * @return String
	 * @throws ParseException 
	 * @throws 
	 * @Author ZYM
	 * Create Date: 2013-2-21 上午11:39:38
	 */
	public static String getAge(String myDate) throws ParseException{
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd"); 
		   java.util.Date date = new Date();
		   java.util.Date mydate= myFormatter.parse(myDate);
		   //算出总共多少天
		   Long day =  ((date.getTime()-mydate.getTime())/(24*60*60*1000) + 1);
		   //格式化保留两位小数
		   String year = new java.text.DecimalFormat("#.##").format(day/365f);
		   return year;
	}
	
	public static String getSysTime(){
	     Calendar now=Calendar.getInstance();
	     String time=now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH)+1)+"-"+now.get(Calendar.DAY_OF_MONTH)+" "+now.get(Calendar.HOUR_OF_DAY)+":"+now.get(Calendar.MINUTE)+":"+now.get(Calendar.SECOND);
		 return time;
	}
	
	/**获取系统当前时间
	 * 
	 * @return
	 */
	public static String getCurrentTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date());
		
	}
	
	
	
	/** 
     * 计算两个日期之间相差的天数 
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
	 * @throws ParseException 
     */  
    public static int daysBetween(Date smdate,Date bdate) throws ParseException  
    {  
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    	smdate=sdf.parse(sdf.format(smdate));
    	bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();  
        cal.setTime(smdate);  
        long time1 = cal.getTimeInMillis();               
        cal.setTime(bdate);  
        long time2 = cal.getTimeInMillis();       
        long between_days=(time2-time1)/(1000*3600*24);
          
       return Integer.parseInt(String.valueOf(between_days));         
    }  
    
	
	
	
}
