package com.oneday.videodemo.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.oneday.videodemo.BR;

public class TestObservable extends BaseObservable {
    public String mTime;//必须时public，否则databinding会报错。
    public String mContent;

    public void setmTime(String mTime) {
        this.mTime = mTime;
        notifyPropertyChanged(BR.mTestObservable);
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
        notifyPropertyChanged(BR.mTestObservable);
    }

    @Bindable
    public String getmContent() {
        return mContent;
    }

    @Bindable
    public String getmTime() {
        return mTime;
    }
}
