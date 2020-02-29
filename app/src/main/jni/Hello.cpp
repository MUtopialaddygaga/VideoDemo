//
// Created by hysyb-wujianfeng on 20-2-28.
//
#include "com_oneday_videodemo_jni_JniDemo.h"
#include "stdio.h"
#include "android/log.h"
#include "android_log.h"

#define TAG "Jni-demo"

#ifdef __cplusplus
extern "C" {
#endif
/*
* Class:     com_oneday_videodemo_jni_nativedemo
* Method:    sayHelloWorld
* Signature: ()Ljava/lang/String;
*/
JNIEXPORT jstring JNICALL Java_com_oneday_videodemo_jni_JniDemo_sayHelloWorld
        (JNIEnv *env, jobject obj)
{
    LOGI("welcome to jni world!!!!!!!");
    return (*env).NewStringUTF("hello world!!!!!!!!!");
}

/*
 * Class:     com_oneday_videodemo_jni_nativedemo
 * Method:    printWord
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_oneday_videodemo_jni_JniDemo_printWord
        (JNIEnv *env, jobject obj, jstring strValue)
{

    char buf[128];
    const char *str;
    str = (*env).GetStringUTFChars(strValue,JNI_FALSE);

    if(str == NULL)
    {
        return NULL;
    }

    printf("read %s", str);

    (*env).ReleaseStringUTFChars(strValue, str);
    return (*env).NewStringUTF("welcome to jni world");
}

/*
 * Class:     com_oneday_videodemo_jni_JniDemo
 * Method:    sumArray
 * Signature: ([I)I
 */
JNIEXPORT jint JNICALL Java_com_oneday_videodemo_jni_JniDemo_sumArray
        (JNIEnv *env, jobject obj, jintArray arr)
{
    int sum = 0;
    int len = (*env).GetArrayLength(arr);
    jint buf[len];
    (*env).GetIntArrayRegion(arr, 0, len, buf);
    for (int i = 0; i < len; ++i) {
        sum += buf[i];
    }
    return sum;
}
#ifdef __cplusplus
}
#endif
