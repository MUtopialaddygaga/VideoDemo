/**
 * native type has two kind: primitive type and reference type(class/instance/arrays)
 * 以下为java jvm中的类型和java类型相对应
 * type signature     java type
 *    Z                boolean
 *    C                  char
 *    S                  short
 *    I                   int
 *    J                  long
 *    F                  float
 *    D                  doule
 *    [type              type[](例:int[]->[I)
 * Lfully-qulified-class fully-qulified-class(例:Ljava/lang/String)
 *  (arg-type)ret-type   method type
 */

/**
 * java类型对应jni类型的长度
 * java-type   native-type  Description
 *  boolean     jboolean       8bit
 *  byte         jbte          8bit
 *  char         jchar         unsigned16bit
 * short        jshort         16bit
 * int          jint           32bit
 * long         jlong          64bit
 * float        jfloat         32bit
 * double       jdouble        64bit
 * void         void           N/A
 */
#include <string.h>
#include "com_oneday_testlibrary_cpp_JniInterface.h"
#include "stdio.h"
#include "android/log.h"
#include "android_log.h"
#define TAG "Jni-demo"

#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_oneday_videodemo_jni_JniInterface
 * Method:    sayHelloToJniWorld
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_oneday_videodemo_jni_JniInterface_sayHelloToJniWorld
        (JNIEnv *, jobject){
    LOGI("Hello, the Jni world!!! I`m coming!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
}

/*************************************对比有static和无static修饰的native方法参数差异***********************************************/
/**
 * 通过以下两个方法的参数对比可知：static修饰的方法第二个参数是jclass,而未被static 修饰的第二个参数jobject
 */
/*
 * Class:     com_oneday_videodemo_jni_JniInterface
 * Method:    testMethodWithStatic
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_oneday_videodemo_jni_JniInterface_testMethodWithStatic
        (JNIEnv *, jclass, jint){

}

/*
 * Class:     com_oneday_videodemo_jni_JniInterface
 * Method:    testMethodWithoutStatic
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_oneday_videodemo_jni_JniInterface_testMethodWithoutStatic
        (JNIEnv *env, jobject obj, jint value){
}
/************************************************************************************/

/*
 * Class:     com_oneday_videodemo_jni_JniInterface
 * Method:    getVersion
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_oneday_videodemo_jni_JniInterface_getVersion
        (JNIEnv *env, jobject obj){
    //LOGI("version :" + env->GetVersion());
    jint version = env->GetVersion();
    return version;
}
/************************************************************************************/
/**
 *  if small fix-size strings or small substring-------> yes----> GetStringRegion/setStringRegion GetStringUTFRegion/setStringUTFRegion
 *                      |
 *                      |
 *                      V
 *                      no
 *         Any blocking orJNI calls while accessing string contents?---->no--->GetStringCritical/ReleaseStringCritical
 *                      |
 *                      |
 *                      V
 *                GetStringChars
 *                ReleaseStringChars
 *                GetStringUTFChars
 *               ReleaseStringUTFChars
 *
 */

/**
 * String格式
 * GetStringChars/ReleaseStringChars/NewString(Unicode format) GetStringUTFChars/ReleaseStringUTFChars/NewStringUTF(utf-8)
 * @param env
 * @param obj
 * @param value
 * @return
 */
/**
 * Class:     com_oneday_videodemo_jni_JniInterface
 * Method:    accessStringMethodOne
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 * 知识点一:
 * 获取jstring的长度方法:
 * 1.GetStringUTFLength
 * 2.strlen()
 */
JNIEXPORT jstring JNICALL Java_com_oneday_videodemo_jni_JniInterface_accessStringMethodOne
        (JNIEnv *env, jobject obj, jstring value){
    char buf[128];
    const char *str;
    jsize mSize;
    int length = 0;
    //allocate memory to hold the utf-8, if allocate fail, OutMemoryErr will thrown
    str = env->GetStringUTFChars(value, JNI_FALSE);//Unicode format
    mSize = env->GetStringUTFLength(value);//获取字符串长度
    LOGI("length of string :" + mSize);
    length = strlen(str);
    LOGI("length from strlen :" + length);
    printf("############%d", length);

    if(NULL == str){
        LOGE("not read the string!!!!!!!!!!!");
        return NULL;
    }
    printf("%s", str);
    //需要释放掉
    env->ReleaseStringUTFChars(value, str);

    scanf("%s", buf);
    return env->NewStringUTF(buf);
}

/*
 * Class:     com_oneday_videodemo_jni_JniInterface
 * Method:    accessStringMethodTwo
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
/**
 * GetStringChars/ReleaseStringChars/NewString(Unicode format)
 * @param env
 * @param obj
 * @param value
 * @return
 */
JNIEXPORT jstring JNICALL Java_com_oneday_videodemo_jni_JniInterface_accessStringMethodTwo
        (JNIEnv *env, jobject obj, jstring value){

}

/*
 * Class:     com_oneday_videodemo_jni_JniInterface
 * Method:    accessStringMethodThree
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
/**
 *
 * @param env
 * @param obj
 * @param value
 * @return
 */
JNIEXPORT jstring JNICALL Java_com_oneday_videodemo_jni_JniInterface_accessStringMethodThree
        (JNIEnv *env, jobject obj, jstring value){

}

/*
 * Class:     com_oneday_testlibrary_cpp_JniInterface
 * Method:    accessArray
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jint JNICALL Java_com_oneday_testlibrary_cpp_JniInterface_accessArray___3I
        (JNIEnv *env, jobject obj, jintArray intArray){
    jint buf[10];
    int sum = 0;

    env->GetIntArrayRegion(intArray, 0, 10, buf);
    for (int i = 0; i < 10; ++i) {
        sum += buf[i];
    }
    return sum;
}
#ifdef __cplusplus
}
#endif