package com.oneday.videodemo.video;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

public class TestGlSurfaceView extends GLSurfaceView {
    private TestRender testRender;

    public TestGlSurfaceView(Context context) {
        super(context);
        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);
        testRender = new TestRender();

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(testRender);
    }

    public TestGlSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
