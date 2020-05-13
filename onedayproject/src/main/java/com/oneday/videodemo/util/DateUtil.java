package com.oneday.videodemo.util;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateUtil {
    private static final String TAG = "DateUtil";
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    /**
     *
     * @param date
     * @return
     */
    public static int parseTimeStamp(String date) {
        Log.e(TAG, "######parseTimeStamp, date :" + date);

        if (date == null || date.equals("")) {
            return -1;
        }

        Date tmpDate = null;
        try {
            tmpDate = sdf.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return -1;
        }

        if (tmpDate == null) {
            return -1;
        }

        long tmpTime = tmpDate.getTime();
        long currentTime = System.currentTimeMillis();

        Log.d(TAG, "tmpTime :" + tmpTime + ", currentTime :" + currentTime);

        if (tmpTime > currentTime) {
            Calendar mCalendar = Calendar.getInstance();
            mCalendar.setTime(tmpDate);
            mCalendar.add(Calendar.MONTH, -1);

            Date mDate = mCalendar.getTime();

            boolean isOutOfMonth = mDate.getTime() >= currentTime ? true : false;

            Log.e(TAG, "isOutOfMonth :"  + isOutOfMonth + ", mDate.getTime() :" + mDate.getTime() + ", currentTime :" + currentTime);
            if (isOutOfMonth) {
                return 0;
            }

            return 1;
        }

        return 2;
    }
}
