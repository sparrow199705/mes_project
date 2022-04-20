package com.drs.mes.util;

import sun.applet.Main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {
    public static List<String> getAllTheDateOftheMonth(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        List<String> list = new ArrayList<String>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DATE, 1);
        int month = cal.get(Calendar.MONTH);

        while(cal.get(Calendar.MONTH) == month){
            list.add(df.format(cal.getTime()));
            cal.add(Calendar.DATE, 1);
        }
        return list;
    }

    public static List<String> getAllTheDateOftheYear(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");//设置日期格式
        List<String> list = new ArrayList<String>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MONTH, 0);
        int YEAR = cal.get(Calendar.YEAR);

        while(cal.get(Calendar.YEAR) == YEAR){
            list.add(df.format(cal.getTime()));
            cal.add(Calendar.MONTH, 1);
        }
        return list;
    }

    //获取月天数
    public static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");//设置日期格式
        List<String> list = DateUtil.getAllTheDateOftheYear(new Date());
        for(String date: list) {
            int day = getDaysOfMonth(df.parse(date));
            System.out.println(day);
        }


    }
}
