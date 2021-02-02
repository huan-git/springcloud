package com.ahuan.common.util;

/**
 * @author huan
 * @version 创建时间：2019年8月13日 下午5:18:45
 */
public class UnicodeUtils {
    // 中文转Unicode
    public static String gbEncoding(final String gbString) {
        char[] utfBytes = gbString.toCharArray();
        String unicodeBytes = "";
        for (int byteIndex = 0; byteIndex < utfBytes.length; byteIndex++) {
            String hexB = Integer.toHexString(utfBytes[byteIndex]);
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }
            unicodeBytes = unicodeBytes + "\\u" + hexB;
        }
        System.out.println("unicodeBytes is: " + unicodeBytes);
        return unicodeBytes;
    }

    // Unicode转中文
    public static String decodeUnicode(final String dataStr) {
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = dataStr.substring(start + 2, dataStr.length());
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        gbEncoding("智慧时空分析系统");
        System.out.println(decodeUnicode("\\u667a\\u6167\\u65f6\\u7a7a\\u5206\\u6790\\u7cfb\\u7edf"));
        ;
    }
}
