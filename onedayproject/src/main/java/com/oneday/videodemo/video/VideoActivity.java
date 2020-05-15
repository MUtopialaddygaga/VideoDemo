package com.oneday.videodemo.video;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.Nullable;

import com.oneday.videodemo.R;

public class VideoActivity extends Activity {
    private static final String TAG = VideoActivity.class.getSimpleName();
    private GLSurfaceView mGLSurfaceView;
    //private SurfaceView testSurfaceView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //testSurfaceView = new SurfaceView(this);
        mGLSurfaceView = new TestGlSurfaceView(this);
        setContentView(mGLSurfaceView);
        //GLSurfaceView无法通过以下方式设置
//        testSurfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
//            @Override
//            public void surfaceCreated(SurfaceHolder holder) {
//                Log.d("test-tag", "############surfaceCreated##########");
//                Paint mPaint = new Paint();
//                mPaint.setColor(getResources().getColor(R.color.red));
//
//                Canvas canvas = holder.lockCanvas();
//                canvas.drawCircle(100, 100, 100, mPaint);
//                holder.unlockCanvasAndPost(canvas);
//            }
//
//            @Override
//            public void surfaceChanged(SurfaceHolder holder, int format,
//                                       int width, int height) {
//
//            }
//
//            @Override
//            public void surfaceDestroyed(SurfaceHolder holder) {
//
//            }
//        });
        Log.d("test-tag", "############onCreate##########");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
