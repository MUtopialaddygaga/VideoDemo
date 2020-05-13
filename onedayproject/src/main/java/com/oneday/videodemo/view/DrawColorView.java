package com.oneday.videodemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.oneday.videodemo.R;

public class DrawColorView extends View implements View.OnClickListener {
    private static final String TAG = "DrawColorView";
    private Paint colorPaint;
    private Canvas localCanvas;
    private int cnt = 0;

    private int[] testId = new int[]{
            R.color.black, R.color.red, R.color.blue, R.color.yellow
    };

    public DrawColorView(Context context) {
        super(context);
        init();
    }

    public DrawColorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawColorView(Context context, @Nullable AttributeSet attrs,
                         int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        colorPaint = new Paint();
        colorPaint.setColor(getResources().getColor(R.color.yellow));
        setOnClickListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        localCanvas = canvas;
        canvas.drawColor(getResources().getColor(R.color.yellow));
    }

    @Override
    public void onClick(View v) {
        Log.e(TAG, "############onClick##############");
        if (localCanvas == null){
            Log.e(TAG, "err, localCanvas == null");
            return;
        }

        if (cnt >= testId.length){
            cnt = 0;
        }

        //localCanvas.drawColor(getResources().getColor(R.color.black));
    }
}
