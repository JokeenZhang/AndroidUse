package com.zzq.jni.password;

import com.zzq.jni.utils.CipherUtil;

import java.security.NoSuchAlgorithmException;

/**
 * AndroidUse\jni\build\intermediates\javac\debug\classes> javah -classpath . -jni com.zzq.jni.password.CipherParamsKeeper
 */
public class CipherParamsKeeper {
    static {
        System.loadLibrary("pwdkeeper");
    }

    public static native byte[] getIv();

    public static native byte[] getSalt();

    public static byte[] getKey(String password) throws NoSuchAlgorithmException {
        return CipherUtil.md5Bytes(password, getSalt());
    }
}
