package com.oneday.videodemo.jni;

import android.util.Log;

public class JniDemo {

    static {
        Log.d("JniDemo", "###########I`m here##########");
        System.loadLibrary("Hello");
        Log.d("JniDemo", "###########I`m there##########");
    }

    public native String sayHelloWorld();

    public native String printWord(String str);
}
