package com.oneday.videodemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.oneday.videodemo.R;

public class DrawCircleView extends View {

    private Paint strokePaint;
    private Paint fillPaint;
    private Paint fillAndStrokePaint;


    public DrawCircleView(Context context) {
        super(context);
        init();
    }

    public DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawCircleView(Context context, @Nullable AttributeSet attrs,
                          int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        //Paint.ANTI_ALIAS_FLAG打开抗锯齿->边缘更平滑
        strokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        //设置线宽
        strokePaint.setStrokeWidth(getResources().getDimension(R.dimen.w12dp));
        //绘制模式 Paint.Style.STROKE->画线模式(勾边模式)  Paint.Style.FILL->填充 Paint.Style.FILL_AND_STROKE->既画线又填充
        strokePaint.setStyle(Paint.Style.STROKE);
        strokePaint.setColor(getResources().getColor(R.color.yellow));

        fillPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        fillPaint.setStyle(Paint.Style.FILL);
        fillPaint.setColor(getResources().getColor(R.color.blue));

        fillAndStrokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        fillAndStrokePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        fillAndStrokePaint.setColor(getResources().getColor(R.color.red));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(100, 100, 50, strokePaint);
        canvas.drawCircle(150, 150, 50, fillPaint);

        canvas.drawCircle(300, 200, 50, fillAndStrokePaint);
    }
}
