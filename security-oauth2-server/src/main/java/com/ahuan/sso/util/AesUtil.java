/**
 * Project Name:4a-cas-server File Name:AesUtil.java Package Name:com.iwhalecloud.cas.encoder Date:2018年12月5日下午12:16:49
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 */

package com.ahuan.sso.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * ClassName:AesUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年12月5日 下午12:16:49 <br/>
 * 
 * @author liang
 * @version
 * @since JDK 1.8
 * @see
 */
public class AesUtil {

    /**
     * 偏移量字符串必须是16位 当模式是CBC的时候必须设置偏移量
     */
    public static final String KEY = "8QONwyJtHesysWpN";

    private static String Algorithm = "AES";
    /**
     * 算法/模式/补码方式
     */
    private static String AlgorithmProvider = "AES/ECB/PKCS5Padding";

    /**
     * aes解密
     * 
     * @param content
     * @param key
     * @return
     */
    public static String decryptAES(String content, String key) {
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), Algorithm);
            // "算法/模式/补码方式"
            Cipher cipher = Cipher.getInstance(AlgorithmProvider);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            return new String(cipher.doFinal(parseHexStr2Byte(content)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * aes加密
     */
    public static String encryptAes(String content, String key) {
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), Algorithm);
            // "算法/模式/补码方式"
            Cipher cipher = Cipher.getInstance(AlgorithmProvider);
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] bytes = cipher.doFinal(content.getBytes("UTF-8"));
            return parseByte2HexStr(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 将16进制String转换为byte数组
     * 
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte)(high * 16 + low);
        }
        return result;
    }

    /**
     * 将byte数组转换成16进制String
     * 
     * @param buf
     * @return
     */

    public static String parseByte2HexStr(byte buf[]) {

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < buf.length; i++) {

            String hex = Integer.toHexString(buf[i] & 0xFF);

            if (hex.length() == 1) {

                hex = '0' + hex;

            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = new String(encryptAes("Test@123456", KEY));
        System.out.println("加密：" + str);
        String jie = decryptAES(str, KEY);
        System.out.println("解密：" + jie);

    }

}
