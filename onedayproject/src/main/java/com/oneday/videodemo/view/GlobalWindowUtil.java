package com.oneday.videodemo.view;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

public final class GlobalWindowUtil {
    private WindowManager globalWindowManager;
    private WindowManager.LayoutParams globalLayoutParams;
    private View globalView;

    public GlobalWindowUtil(){
        new Throwable(new Exception("the GlobalWindowUtil can`t be instantiated!!!!"));
    }

    public void displayGlobalWindow(Context context, View view){
        if (context == null || view == null){
            return ;
        }

        this.globalView = view;
        globalWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        globalLayoutParams = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            globalLayoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else {
            globalLayoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        }
        //
        globalLayoutParams.flags = WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
        //窗口的绝对x y位置
        globalLayoutParams.x = 0;
        globalLayoutParams.y = 0;

        // 不设置这个弹出框的透明遮罩显示为黑色
        globalLayoutParams.format = PixelFormat.TRANSLUCENT;
        globalLayoutParams.width = 200;
        globalLayoutParams.height = 100;
        globalLayoutParams.gravity = Gravity.CENTER;
        globalWindowManager.addView(view, globalLayoutParams);
    }

    public void hideGlobalWindow(){
        if (globalWindowManager != null){
            globalWindowManager.removeViewImmediate(globalView);
        }
    }
}
