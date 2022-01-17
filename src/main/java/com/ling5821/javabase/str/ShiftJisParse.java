package com.ling5821.javabase.str;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author lsj
 * @date 2022/1/17 10:35
 */
public class ShiftJisParse {

    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] bytes = new byte[]{
            40,
            90,
            41,
            (byte) 213,
            (byte) 253,
            (byte) 207,
            (byte) 242,
            (byte) 179,
            (byte) 172,
            (byte) 179,
            (byte) 204,
            32,
            40,
            (byte) 200,
            (byte) 237,
            (byte) 207,
            (byte) 222,
            (byte) 206,
            (byte) 187,
            49,
            41
        };
        System.out.println(new String(bytes, "SHIFT-JIS"));

        bytes = new byte[]{
            40,
            89,
            41,
            (byte) 184,
            (byte) 186,
            (byte) 207,
            (byte) 242,
            (byte) 179,
            (byte) 172,
            (byte) 179,
            (byte) 204,
            32,
            40,
            (byte) 200,
            (byte) 237,
            (byte) 207,
            (byte) 222,
            (byte) 206,
            (byte) 187,
            50,
            41
        };
        System.out.println(new String(bytes, "GBK"));
        System.out.println("最初にお読みください");
    }

}
