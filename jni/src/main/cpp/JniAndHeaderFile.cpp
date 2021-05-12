//
// Created by Administrator on 2021/05/12.
//
#include "com_zzq_jni_model_JniAndHeaderFile.h"

extern "C"
JNIEXPORT jstring JNICALL
Java_com_zzq_jni_model_JniAndHeaderFile_fromJniAndHeaderFile(JNIEnv *env, jclass clazz,
                                                             jstring msg) {
    return env->NewStringUTF("Hello from Java_com_zzq_jni_model_JniAndHeaderFile_fromJniAndHeaderFile !" );
}