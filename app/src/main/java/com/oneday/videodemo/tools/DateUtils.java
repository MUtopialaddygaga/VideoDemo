package com.oneday.videodemo.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtils {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getCurrentTimeStamp()
    {
        return sdf.format(new Date());
    }
}
