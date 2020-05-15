package com.oneday.videodemo.dispatchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.oneday.videodemo.util.LogContants;

public class TestDispatchViewGroup extends LinearLayout {

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(LogContants.TAG_DISPATCH_EVENT, "TestDispatchViewGroup-onInterceptTouchEvent, ev :" + ev.toString());
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(LogContants.TAG_DISPATCH_EVENT, "dispatchTouchEvent-onInterceptTouchEvent, ev :" + ev.toString());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(LogContants.TAG_DISPATCH_EVENT, "onTouchEvent-onInterceptTouchEvent, ev :" + event.toString());
        return super.onTouchEvent(event);
    }

    public TestDispatchViewGroup(Context context) {
        super(context);
    }

    public TestDispatchViewGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TestDispatchViewGroup(Context context,
                                 @Nullable AttributeSet attrs,
                                 int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
