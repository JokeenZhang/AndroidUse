package com.zzq.test.models;

import com.zzq.test.utils.ByteUtil;

import java.util.Random;

public class MainModel {

    public String createTestString(int length) {
        if (length <= 0) {
            length = 1;
        }
        Random random = new Random();
        byte[] dataBytes = new byte[length];
        random.nextBytes(dataBytes);
        return ByteUtil.bytesToHexString(dataBytes);
    }
}
