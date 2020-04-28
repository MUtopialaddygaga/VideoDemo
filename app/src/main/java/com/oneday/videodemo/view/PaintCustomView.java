package com.oneday.videodemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Paint 设置颜色的方法有两种：一种是直接用 Paint.setColor/ARGB() 来设置颜色，另一种是使用 Shader(着色器) 来指定着色方案。
 * 常用类:LinearGradient(线性渐变) RadialGradient(辐射渐变) SweepGradient(扫描渐变) BitmapShader(通过bitmap着色) ComposeShader(混合着色器)
 * 在设置了 Shader 的情况下， Paint.setColor/ARGB() 所设置的颜色就不再起作用。
 */
public class PaintCustomView extends View {


    public PaintCustomView(Context context) {
        super(context);
    }

    public PaintCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PaintCustomView(Context context, @Nullable AttributeSet attrs,
                           int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
