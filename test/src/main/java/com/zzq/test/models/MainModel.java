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

    /**
     * 将字符串的length转换成十六进制字符串。用5个字节长度的字节数组表示字符串长度并将这个数组转成十六进制字符串
     *
     * @param data 需要获取该参数的长度
     * @return 最终长度表示的十六进制字符串
     */
    public String createHexStringWithLength(String data) {
        int length = data.length();
        if (length == 0) {
            return "00";
        }
        return ByteUtil.bytesToHexString(ByteUtil.toLengthByteArray(length, 5));
    }
}
