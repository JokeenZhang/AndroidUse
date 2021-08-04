package com.zzq.test.utils;

import java.util.Random;

/**
 * 字节相关工具类
 */
public class ByteUtil {

    /**
     * 将字节数组转化转换为十六进制数字后再拼接成字符串
     *
     * @param bArray 要转换的字节数组
     * @return 十六进制数字拼接成的字符串
     */
    public static String bytesToHexString(byte[] bArray) {
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2) {
                sb.append(0);
            }
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 反转数组
     *
     * @param data
     */
    public static void reverse(byte[] data) {
        for (int i = 0; i < data.length / 2; i++) {
            byte temp = data[i];
            data[i] = data[data.length - 1 - i];
            data[data.length - 1 - i] = temp;
        }
    }

    /**
     * 将长度用长度为{@param arrayLength}的字节数组表示，使用小端传输
     *
     * @param value       用arrayLength个字节表示长度，即长度的大小不能超过arrayLength个字节所能表示的最大的值，在这里未做判断
     * @param arrayLength 生成的字节数组长度
     * @return 返回字节数组
     */
    public static byte[] toLengthByteArray(int value, int arrayLength) {
        String lengthStrHex = Integer.toHexString(value);
        byte[] lengthByteArr = new byte[arrayLength];
        if (lengthStrHex.length() % 2 != 0) {
            lengthStrHex = 0 + lengthStrHex;
        }

        int temp = (arrayLength * 2 - lengthStrHex.length()) / 2;
        for (int i = 0; i < temp; i++) {
            lengthStrHex = "00" + lengthStrHex;
        }

        for (int i = 0; i <= lengthStrHex.length() - 2; i += 2) {
            lengthByteArr[i / 2] = (byte) Integer.parseInt(lengthStrHex.substring(i, i + 2), 16);
        }
        //倒序，变成小端
        reverse(lengthByteArr);
        return lengthByteArr;
    }

    public static byte[] moveChar(byte[] data) {
        if (data == null || data.length % 2 != 0) {
            return null;
        }

        byte temp;
        int length = data.length;

        for (int i = 0; i < data.length / 2; i += 2) {
            temp = data[i];
            data[i] = data[length - i - 1];
            data[length - i - 1] = temp;
        }
        return data;
    }

    /**
     * 根据给定长度，生成指定数量的随机数字，并将它们保存到数组中
     */
    public static byte[] ranDomBytes(int length) {
        Random random = new Random();
        byte[] randomBytes = new byte[length];
        random.nextBytes(randomBytes);
        return randomBytes;
    }
}
