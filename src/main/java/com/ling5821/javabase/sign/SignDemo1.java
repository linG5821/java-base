package com.ling5821.javabase.sign;

import cn.hutool.crypto.digest.DigestUtil;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author linG
 * @date 2022-05-13 20:50
 */
public class SignDemo1 {

    public static String md5$1(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] bytes = digest.digest(str.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                int i = Byte.toUnsignedInt(aByte);
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            System.out.println(Arrays.toString(bytes));
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public static String md5$2(String str) {
        return DigestUtil.md5Hex(str);
    }

    public static void main(String[] args) {
        String s1 = md5$1("中国");
        String s2 = md5$2("中国");
        System.out.printf("s1 %s s2 %s equal %b\n", s1, s2, s1.equals(s2));

    }

}
