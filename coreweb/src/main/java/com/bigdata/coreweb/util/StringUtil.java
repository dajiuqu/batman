package com.bigdata.coreweb.util;

public class StringUtil {
    public static boolean isNullOrEmpty(String msg){
        if(msg==null||msg.equals("")) return true;
        return false;
    }
}
