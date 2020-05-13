package com.oneday.videodemo.jni;

import android.util.Log;

import java.util.NavigableMap;

public class JniDemo {
    private String s;
    public static int si = 123;

    static
    {
        System.loadLibrary("Hello");
    }

    public void setS(String str)
    {
        this.s = str;
    }

    public String getS()
    {
        return s;
    }

    public native String sayHelloWorld();

    public native String printWord(String str);

    public native int sumArray(int[] arr);

    public native int[][] create2DArray(int size);

    /**
     * java工程支持两个变量，一个是每个类实例都保存有变量的副本，另外一个是所有类实例共享静态变量
     * @return
     */
    public native int accessField();

    /**
     * jni访问java中的方法
     */
    public native void accessMethod();

    public void callBack(){
        Log.d("JniDemo", "the callback was invoked by jni!!!!!!!!!!");
    }
}
