package com.oneday.videodemo.model;

import com.oneday.videodemo.tools.DateUtils;

public class TestBean {
    private String mTime;
    private String mContent;

    public TestBean(String mContent){
        this.mTime = DateUtils.getCurrentTimeStamp();
        this.mContent = mContent;
    }

    public String getmTime() {
        return mTime;
    }

    public String getmContent() {
        return mContent;
    }
}
