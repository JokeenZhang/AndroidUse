package com.zzq.jni.model;

public class JniAndHeaderFile {

    static {
        System.loadLibrary("JniAndHeaderFile");
    }

    public static native String fromJniAndHeaderFile(String msg);
}
