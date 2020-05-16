package com.oneday.videodemo.jni;

public class JniInterface {

    static {
        System.loadLibrary("JniInterface");
    }

    public native void sayHelloToJniWorld();

    public native static void testMethodWithStatic(int value);

    public native void testMethodWithoutStatic(int value);

    public native int getVersion();

    public native String accessStringMethodOne(String value);

    public native String accessStringMethodTwo(String value);

    public native String accessStringMethodThree(String value);
}
