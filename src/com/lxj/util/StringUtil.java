package com.lxj.util;

/**
 * StringUtil
 */
public class StringUtil {
    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str) {
        if(str.equals("") || str ==null) {
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(String str) {
        if (!"".equals(str) && str != null) {
            return true;
        } else {
            return false;
        }
    }
    
}