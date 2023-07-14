package com.crbs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 李英
 * @date 2021年3月14日11:18:35
 * @category 获得时间的工具类
 */
public class DateUtil {
    public static Date getDate(String str){
        String time = str.replaceAll("T"," ");
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        long s = 0;
        try {
            s =dft.parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        date.setTime(s);
        return date;
    }
}
