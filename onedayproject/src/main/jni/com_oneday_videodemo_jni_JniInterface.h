/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_oneday_videodemo_jni_JniInterface */

#ifndef _Included_com_oneday_videodemo_jni_JniInterface
#define _Included_com_oneday_videodemo_jni_JniInterface
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_oneday_videodemo_jni_JniInterface
 * Method:    initID
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_oneday_videodemo_jni_JniInterface_initID
  (JNIEnv *, jclass);

/*
 * Class:     com_oneday_videodemo_jni_JniInterface
 * Method:    sayHelloToJniWorld
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_oneday_videodemo_jni_JniInterface_sayHelloToJniWorld
  (JNIEnv *, jobject);

/*
 * Class:     com_oneday_videodemo_jni_JniInterface
 * Method:    testMethodWithStatic
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_oneday_videodemo_jni_JniInterface_testMethodWithStatic
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_oneday_videodemo_jni_JniInterface
 * Method:    testMethodWithoutStatic
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_oneday_videodemo_jni_JniInterface_testMethodWithoutStatic
  (JNIEnv *, jobject, jint);

/*
 * Class:     com_oneday_videodemo_jni_JniInterface
 * Method:    getVersion
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_oneday_videodemo_jni_JniInterface_getVersion
  (JNIEnv *, jobject);

/*
 * Class:     com_oneday_videodemo_jni_JniInterface
 * Method:    accessStringMethodOne
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_oneday_videodemo_jni_JniInterface_accessStringMethodOne
  (JNIEnv *, jobject, jstring);

/*
 * Class:     com_oneday_videodemo_jni_JniInterface
 * Method:    accessStringMethodTwo
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_oneday_videodemo_jni_JniInterface_accessStringMethodTwo
  (JNIEnv *, jobject, jstring);

/*
 * Class:     com_oneday_videodemo_jni_JniInterface
 * Method:    accessStringMethodThree
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_oneday_videodemo_jni_JniInterface_accessStringMethodThree
  (JNIEnv *, jobject, jstring);

/*
 * Class:     com_oneday_videodemo_jni_JniInterface
 * Method:    accessPrimitiveArray
 * Signature: ([I)I
 */
JNIEXPORT jint JNICALL Java_com_oneday_videodemo_jni_JniInterface_accessPrimitiveArray
  (JNIEnv *, jobject, jintArray);

/*
 * Class:     com_oneday_videodemo_jni_JniInterface
 * Method:    accessObjectArray
 * Signature: (I)[[I
 */
JNIEXPORT jobjectArray JNICALL Java_com_oneday_videodemo_jni_JniInterface_accessObjectArray
  (JNIEnv *, jobject, jint);

/*
 * Class:     com_oneday_videodemo_jni_JniInterface
 * Method:    accessJavaFiled
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_oneday_videodemo_jni_JniInterface_accessJavaFiled
  (JNIEnv *, jobject);

/*
 * Class:     com_oneday_videodemo_jni_JniInterface
 * Method:    accessJavaStaticField
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_oneday_videodemo_jni_JniInterface_accessJavaStaticField
  (JNIEnv *, jobject);

/*
 * Class:     com_oneday_videodemo_jni_JniInterface
 * Method:    invokeCallbackBynative
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_oneday_videodemo_jni_JniInterface_invokeCallbackBynative
  (JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif
