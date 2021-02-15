package com.dip.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public final class DateUtil {

    private static final String DEFAULT_TIMESTAMP_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static Map<String, ThreadLocal<SimpleDateFormat>> localMap = new HashMap<String, ThreadLocal<SimpleDateFormat>>();
    /**
     * 锁对象
     */
    private static final Object lock = new Object();

    private DateUtil() {

    }

    /**
     * @param pattern
     * @return
     */
    private static SimpleDateFormat getSimpleDateFormat(String pattern) {
        ThreadLocal<SimpleDateFormat> local = localMap.get(pattern);
        // 此处的双重判断和同步是为了防止local这个单例被多次put重复的sdf
        if (local == null) {
            synchronized (lock) {
                local = localMap.get(pattern);
                if (local == null) {
                    local = new ThreadLocal<SimpleDateFormat>() {
                        @Override
                        protected SimpleDateFormat initialValue() {
                            // TODO Auto-generated method stub
                            return new SimpleDateFormat(pattern);
                        }
                    };
                    localMap.put(pattern, local);
                }
            }
        }
        return local.get();
    }

    public static Date getCurrentDate() {
    	return new Date(System.currentTimeMillis());
    }
    
    public static void main(String[] args) {
        String s = getSimpleDateFormat(DEFAULT_TIMESTAMP_PATTERN).format(new java.sql.Date(System.currentTimeMillis()));
//        System.out.println(s);
        System.out.println(getCurrentDate());
    }
}
