package com.oneday.videodemo.dispatchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;

import com.oneday.videodemo.util.LogContants;

public class TestDispatchActivity extends ViewGroup {

    public TestDispatchActivity(Context context) {
        super(context);
    }

    public TestDispatchActivity(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestDispatchActivity(Context context, AttributeSet attrs,
                                int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(LogContants.TAG_DISPATCH_EVENT, "TestDispatchViewGroup-dispatchTouchEvent, ev :" + ev.toString());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
