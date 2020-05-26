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
 *  (参数类型)ret-type   method type (例：int test(int value)-->(I)I)
 *  Ljava/lang/String;    String
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
#include "string.h"
#include "com_oneday_videodemo_jni_JniInterface.h"
#include "stdio.h"
#include "android/log.h"
#include "android_log.h"
#include "stdlib.h"

#define TAG "Jni-demo"

jmethodID cache_method_id_callback;

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

JNIEXPORT void JNICALL Java_com_oneday_videodemo_jni_JniInterface_initID
        (JNIEnv *env, jclass cls){
    LOGD("####################initID#########################");
    cache_method_id_callback = env->GetMethodID(cls, "callBack", "()V");
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
/**
 * Preallocated C array buffer,small fixed-size arrays, or small subarrays--->yes--->Get<type>ArrayRegion/Set<type>ArrayRegion
 *                            |
 *                            |
 *                            v
 *                Targeting release 1.1 or 1.2?----->1.2 or beyond --->Any blocking or JNI calls while accessing array contents?--->no--->GetPrimitiveArrayCritical/ReleasePrimitiveArrayCritical
 *                            |                                                                                                                 |
 *                            |                                                                                                                 |
 *                                                         Get<type>ArrayElements\Release<Type>ArrayElements
 *
 */
/**
 * Get/Release<Type>ArrayElements
 * @param env
 * @param obj
 * @param arr
 * @return
 */
JNIEXPORT jint JNICALL Java_com_oneday_videodemo_jni_JniInterface_accessPrimitiveArray
        (JNIEnv *env, jobject obj, jintArray arr){
    jint buf[10];
    int sum = 0;
    env->GetIntArrayRegion(arr, 0, 10, buf);
    for (int i = 0; i < 10; ++i) {
        sum += buf[i];
    }

    return sum;
}

JNIEXPORT jobjectArray JNICALL Java_com_oneday_videodemo_jni_JniInterface_accessObjectArray
        (JNIEnv *env, jobject obj, jint size){
        jobjectArray  result;
        int i;
        char* clsName = "[I";
        jclass intArrCls = env->FindClass(clsName);
        if(NULL==intArrCls){
            return NULL;
        }

        result = env->NewObjectArray(size,intArrCls,NULL);
        if(NULL == result){
            return NULL;
        }

    for (int i = 0; i < size; ++i) {
        /* make sure it is large enough! */
        jint tmp[256];
        int j;
        jintArray iarr = env->NewIntArray(size);

        if (iarr == NULL) {
            return NULL; /* out of memory error thrown */
        }
        for (j = 0; j < size; j++) {
            tmp[j] = i + j;
        }
        env->SetIntArrayRegion(iarr, 0, size, tmp);
        env->SetObjectArrayElement(result, i, iarr);
        //free local reference
        env->DeleteLocalRef(iarr);
        env->DeleteLocalRef(intArrCls);
    }

    return result;
}
/***************************************************************************************************/
/**
 * native层访问java实例中的field以及回调方法知识点:
 * 1.两种方法缓存fieldID或methodID，一种是在调用native方法时缓存；
 *   另外一种是定义一个native初始化静态方法，在加载系统库的时候调用该初始化方法，在该初始化方法中缓存相关ID；
 * 2.可缓存fieldID或methodID，如此避免每次访问的时候重复获取fieldID的消耗
 */
/**
 * 访问java field的步骤:
 * 1.先获取对象的class对象；
 * 2.然后通过class对象获取field id号
 * 3.最后根据obj对象
 * 4.可通过静态变量在缓存fieldID，以便下次调用的时候使用
 * @param env
 * @param obj
 */
JNIEXPORT void JNICALL Java_com_oneday_videodemo_jni_JniInterface_accessJavaFiled
        (JNIEnv *env, jobject obj){
    /* cached field ID for s */
    static jfieldID readFiledId = NULL;

    /* Get a reference to obj’s class */
    jclass readCls = env->GetObjectClass(obj);

    /* failed to find the field */
    if(NULL == readFiledId){
        /* Look for the instance field s in cls */
        readFiledId = env->GetFieldID(readCls, "localStr", "Ljava/lang/String;");

        if(NULL == readFiledId){
            return;
        }
    }

    jstring javaParam;
    const char* jStr;
    javaParam = (jstring)(env->GetObjectField(obj, readFiledId));
    jStr = env->GetStringUTFChars(javaParam, JNI_FALSE);
    /* out of memory */
    if(NULL == jStr){
        return ;
    }
    LOGD(jStr);
    //记住要释放，否则可能导致内存溢出
    env->ReleaseStringUTFChars(javaParam, jStr);
    /* Create a new string and overwrite the instance field */
    jstring changeStr = env->NewStringUTF("789");
    /*out of memory*/
    if(NULL == changeStr){
        return ;
    }

    //通过native方法来改变java层的变量值
    env->SetObjectField(obj, readFiledId, changeStr);
}

JNIEXPORT jint JNICALL Java_com_oneday_videodemo_jni_JniInterface_accessJavaStaticField
        (JNIEnv *env, jobject obj){
    LOGI("##################accessJavaStaticField#####################");
    /* store the field ID */
    jfieldID staticFiledId;
    jint localData;

    /* Get a reference to obj’s class */
    jclass mCls = env->GetObjectClass(obj);

    staticFiledId = env->GetStaticFieldID(mCls, "mStaticValue", "I");
    /* field not found */
    if(NULL == staticFiledId){
        return NULL;
    }

    /* Access the static field si */
    localData = env->GetStaticIntField(mCls, staticFiledId);
    printf(" StaticFieldAccess.si = %d\n", localData);
    env->SetStaticIntField(mCls, staticFiledId, 66666);
    return localData;
}
/**
 * Call<Type>Method--->根据回调函数的返回类型(type)
 * @param env
 * @param obj
 */
JNIEXPORT void JNICALL Java_com_oneday_videodemo_jni_JniInterface_invokeCallbackBynative
        (JNIEnv *env, jobject obj){
    jclass mCls = env->GetObjectClass(obj);

    jmethodID jmId =  env->GetMethodID(mCls, "callBack", "()V");
    /* method not found */
    if(NULL == jmId){
        return ;
    }

    env->CallVoidMethod(obj, jmId);

    jthrowable mExcep = env->ExceptionOccurred();
    if(mExcep){

    }
}
/***************************************************************************************************/

/*************************************************local and global reference***************************************************/
/**
 * 知识点:
 * 1.实例以及数组对于native而言是不透明的参数，需要通过native函数取访问
 * 2.native支持三种不同不透明参数:local references(automatically freed/no garbage collected), global references(freed by programmer/no garbage collected), and weak global references(freed by programmer/garbage collected)
 */

/****************************************************************************************************/
#ifdef __cplusplus
}
#endif