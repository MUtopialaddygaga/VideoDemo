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
        (JNIEnv *env, jobject obj) {
    LOGI("welcome to jni world!!!!!!!");
    return (*env).NewStringUTF("hello world!!!!!!!!!");
}

/*
 * Class:     com_oneday_videodemo_jni_nativedemo
 * Method:    printWord
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_oneday_videodemo_jni_JniDemo_printWord
        (JNIEnv *env, jobject obj, jstring strValue) {

    char buf[128];
    const char *str;
    str = (*env).GetStringUTFChars(strValue, JNI_FALSE);

    if (str == NULL) {
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
 * 获取数组方式有如下几种方式:
 * 1.GetIntArrayRegion
 * 2.Get/ReleasePrimitiveArrayCritical（谨记需配对，会导致垃圾回收器失效）：在调用该方法间，切忌调用jni接口/调用阻塞的方法，否则会产生死锁。
 * 3.Get/Release<Type>ArrayElements
 */
JNIEXPORT jint JNICALL Java_com_oneday_videodemo_jni_JniDemo_sumArray
        (JNIEnv *env, jobject obj, jintArray arr) {
    int sum = 0;
    int len = (*env).GetArrayLength(arr);
    jint buf[len];
    (*env).GetIntArrayRegion(arr, 0, len, buf);
    for (int i = 0; i < len; ++i) {
        sum += buf[i];
    }
    return sum;
}

/*
 * Class:     com_oneday_videodemo_jni_JniDemo
 * Method:    create2DArray
 * Signature: (I)[[I
 */
JNIEXPORT jobjectArray JNICALL
Java_com_oneday_videodemo_jni_JniDemo_create2DArray
        (JNIEnv *env, jobject obj, jint size) {
    LOGI("#########学习 JNI 非原始数据类型二维数组##########");
    jobjectArray result;
    int i = 0;
    const char *mClass = "[I";
    jclass intArrCls = (*env).FindClass(mClass);
    if (NULL == intArrCls) {
        return NULL;//exception thrown
    }

    result = (*env).NewObjectArray(size, intArrCls, NULL);

    if (NULL == result) {
        return NULL;//out of memory err thrown
    }
    for (int i = 0; i < size; ++i) {
        jint tmp[256];//make sure it is large enough
        int j;
        jintArray iarr = (*env).NewIntArray(size);
        if (NULL == iarr) {
            return NULL;//out of memory err thrown
        }
        for (int j = 0; j < size; ++j) {
            tmp[j] = i + j;
        }
        (*env).SetIntArrayRegion(iarr, 0, size, tmp);
        (*env).SetObjectArrayElement(result, i, iarr);
        (*env).DeleteLocalRef(iarr);
    }
    return result;
}

/*
 * Class:     com_oneday_videodemo_jni_JniDemo
 * Method:    accessField
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_oneday_videodemo_jni_JniDemo_accessField
        (JNIEnv *env, jobject jobj) {

    jfieldID fid; /* store the field ID */
    jstring jstr;
    jint  si;
    const char *str;

    /* Get a reference to obj’s class */
    jclass cls = (*env).GetObjectClass(jobj);

    //printf("In C:\n");

    /* Look for the instance field s in cls */
    fid = (*env).GetFieldID(cls, "s", "Ljava/lang/String;");

    if (fid == NULL) {
        return 0; /* failed to find the field */
    }

    /* Read the instance field s */
    jstr = (jstring)(*env).GetObjectField(jobj, fid);
    str = (*env).GetStringUTFChars(jstr, NULL);
    if (str == NULL) {
        return 0; /* out of memory */
    }
    //printf(" c.s = \"%s\"\n", str);

    (*env).ReleaseStringUTFChars(jstr, str);

    /* Create a new string and overwrite the instance field */
    jstr = (*env).NewStringUTF("123");
    if (jstr == NULL) {
        return 0; /* out of memory */
    }
    (*env).SetObjectField(jobj, fid, jstr);

    //访问java静态变量
    fid = (*env).GetStaticFieldID(cls, "si", "I");
    if(NULL == fid)
    {
        return 0;//field not find
    }

    //access the static field
    si = (*env).GetStaticIntField(cls, fid);

    (*env).SetStaticIntField(cls, fid, 888888);

    return 1;
}

/*
 * Class:     com_oneday_videodemo_jni_JniDemo
 * Method:    accessMethod
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_oneday_videodemo_jni_JniDemo_accessMethod
        (JNIEnv *env, jobject jobj)
{
    jclass cls = (*env).GetObjectClass(jobj);
    jmethodID methodId = (*env).GetMethodID(cls, "callBack", "()V");
    if(NULL == methodId)
    {
        return;
    }

    (*env).CallVoidMethod(jobj, methodId);
}
#ifdef __cplusplus
}
#endif
