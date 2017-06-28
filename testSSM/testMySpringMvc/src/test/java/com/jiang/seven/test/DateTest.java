package com.jiang.seven.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(new Date());
	        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
	        int currentMonth = calendar.get(Calendar.MONTH);
	        int currentYear = calendar.get(Calendar.YEAR);
	        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
	        System.out.println(currentHour+"===="+currentDay+"===="+currentMonth+"==="+currentYear);
	        System.out.println(sdf.format(calendar.getTime())+"eeee");
	        if(currentHour >=8 && currentHour <=23){
	            Calendar calendarOld = Calendar.getInstance();
	            calendarOld.clear();
	            calendarOld.set(Calendar.YEAR, currentYear);
	            calendarOld.set(Calendar.MONTH, currentMonth);
	            calendarOld.set(Calendar.DAY_OF_MONTH, currentDay);
	            System.out.println(sdf.format(calendarOld.getTime())+"aaaaaa");
	            calendarOld.add(Calendar.DATE, -1);
	            System.out.println(sdf.format(calendarOld.getTime())+"bbbbbbb");
	            calendarOld.set(Calendar.HOUR_OF_DAY, 8);
	            calendarOld.set(Calendar.MINUTE,0);
	            calendarOld.set(Calendar.SECOND,1);
	            System.out.println(sdf.format(calendarOld.getTime())+"cccc");

	        }else{
	        	Calendar calendarOld = Calendar.getInstance();
	            calendarOld.clear();
	            calendarOld.set(Calendar.YEAR, currentYear);
	            calendarOld.set(Calendar.MONTH, currentMonth);
	            calendarOld.set(Calendar.DAY_OF_MONTH, currentDay);
	            System.out.println(calendarOld.getTime()+"aaaaaa");
	            calendarOld.add(Calendar.DATE, -1);
	            System.out.println(calendarOld.getTime()+"bbbbbbb");
	            calendarOld.set(Calendar.HOUR_OF_DAY, 8);
	            calendarOld.set(Calendar.MINUTE,0);
	            calendarOld.set(Calendar.SECOND,1);
	            System.out.println(sdf.format(calendarOld.getTime())+"cccc");
	        }
	    
	}

}
