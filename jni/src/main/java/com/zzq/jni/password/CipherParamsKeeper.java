package com.zzq.jni.password;

import com.zzq.jni.utils.CipherUtil;

import java.security.NoSuchAlgorithmException;

public class CipherParamsKeeper {
    static {
        System.loadLibrary("pwdKeeper");
    }

    public static native byte[] getIv();

    public static native byte[] getSalt();

    public static byte[] getKey(String password) throws NoSuchAlgorithmException {
        return CipherUtil.md5Bytes(password, getSalt());
    }
}
