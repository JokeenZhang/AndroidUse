package com.zzq.jni.model;

public class HelloJni {

    static {
        System.loadLibrary("helloJni");
    }

    public static native String helloJniAndMsg();

}
