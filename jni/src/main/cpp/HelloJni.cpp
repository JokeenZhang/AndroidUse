#include <cstring>
#include <jni.h>

//
// Created by Administrator on 2021/05/11.
//

extern "C" jstring
Java_com_zzq_jni_model_HelloJni_helloJniAndMsg(JNIEnv *env, jclass clazz) {

    return env->NewStringUTF("Hello from JNI !");
}