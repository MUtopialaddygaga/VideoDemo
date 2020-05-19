package com.oneday.videodemo.jni;

public class JniInterface {
    private String localStr = "welcome to java world!!!!";
    public static int mStaticValue = 888888;

    static {
        System.loadLibrary("JniInterface");
    }

    public String getLocalStr(){
        return localStr;
    }

    public native void sayHelloToJniWorld();

    public native static void testMethodWithStatic(int value);

    public native void testMethodWithoutStatic(int value);

    public native int getVersion();

    public native String accessStringMethodOne(String value);

    public native String accessStringMethodTwo(String value);

    public native String accessStringMethodThree(String value);

    /**
     * 可以把数组内部的数据一次性复制出来
     * @param arr
     * @return
     */
    public native int accessPrimitiveArray(int[] arr);

    /**
     * 不可以一次性复制二维数组的内容
     * @param size
     * @return
     */
    public native int[][] accessObjectArray(int size);

    /**
     * native层可访问java层类的field参数，并且可以修改其值
     */
    public native void accessJavaFiled();

    /**
     * 访问静态field
     * @return
     */
    public native int accessJavaStaticField();
}
