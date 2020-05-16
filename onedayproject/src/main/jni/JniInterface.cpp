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
#include "com_oneday_videodemo_jni_JniInterface.h"
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

/*
 * Class:     com_oneday_videodemo_jni_JniInterface
 * Method:    accessStringMethodOne
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_oneday_videodemo_jni_JniInterface_accessStringMethodOne
        (JNIEnv *env, jobject obj, jstring value){
    char buf[128];
    const jchar *str;
    //allocate memory to hold the utf-8, if allocate fail, OutMemoryErr will thrown
    str = env->GetStringChars(value, JNI_FALSE);
    if(NULL == str){
        LOGE("not read the string!!!!!!!!!!!");
        return NULL;
    }
    printf("%s", str);
    //需要释放掉
    env->ReleaseStringChars(value, str);

    scanf("%s", buf);
    return env->NewStringUTF(buf);
}

/*
 * Class:     com_oneday_videodemo_jni_JniInterface
 * Method:    accessStringMethodTwo
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_oneday_videodemo_jni_JniInterface_accessStringMethodTwo
        (JNIEnv *env, jobject obj, jstring value){

}

/*
 * Class:     com_oneday_videodemo_jni_JniInterface
 * Method:    accessStringMethodThree
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_oneday_videodemo_jni_JniInterface_accessStringMethodThree
        (JNIEnv *env, jobject obj, jstring value){

}
#ifdef __cplusplus
}
#endif