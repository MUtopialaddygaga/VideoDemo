//
// Created by hysyb-wujianfeng on 20-2-28.
//
#include "com_oneday_videodemo_jni_JniDemo.h"
#include "stdio.h"

/*
 * Class:     com_oneday_videodemo_jni_nativedemo
 * Method:    sayHelloWorld
 * Signature: ()Ljava/lang/String;
 */
extern "C" JNIEXPORT jstring JNICALL Java_com_oneday_videodemo_jni_JniDemo_sayHelloWorld
        (JNIEnv *env, jobject obj)
{
    printf("###########welcome to jni#############");
    return (*env).NewStringUTF("hello world!!!!!!!!!");
}

/*
 * Class:     com_oneday_videodemo_jni_nativedemo
 * Method:    printWord
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
extern "C" JNIEXPORT jstring JNICALL Java_com_oneday_videodemo_jni_JniDemo_printWord
        (JNIEnv *env, jobject obj, jstring strValue)
{
    printf("*****************welcome, my baby**********************");

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
