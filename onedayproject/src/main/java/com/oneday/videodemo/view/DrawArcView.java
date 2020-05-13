package com.oneday.videodemo.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.oneday.videodemo.R;

public class DrawArcView extends View {
    private Paint arcPaint;
    private Path heartPath = new Path();

    public DrawArcView(Context context) {
        super(context);
        init();
    }

    public DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawArcView(Context context, @Nullable AttributeSet attrs,
                       int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        arcPaint = new Paint();
        arcPaint.setStyle(Paint.Style.FILL);
        arcPaint.setColor(getResources().getColor(R.color.blue));

        // 使用 path 对图形进行描述（这段描述代码不必看懂）
        //Path 有两类方法，一类是直接描述路径的，另一类是辅助的设置或计算
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            heartPath.addArc(200, 200, 400, 400, -225, 225);
            heartPath.arcTo(400, 200, 600, 400, -180, 225, false);
        }
        heartPath.lineTo(400, 542);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制带圆角的矩形
        canvas.drawRoundRect(10, 10, 100, 100, 8, 8, arcPaint);

        canvas.drawArc(200, 100, 800, 500, -110, 100, true, arcPaint); // 绘制扇形
        canvas.drawArc(200, 100, 800, 500, 20, 140, false, arcPaint); // 绘制弧形
        arcPaint.setStyle(Paint.Style.STROKE); // 画线模式
        canvas.drawArc(200, 100, 800, 500, 180, 60, false, arcPaint); // 绘制不封口的弧形

        canvas.drawPath(heartPath, arcPaint);

    }
}
