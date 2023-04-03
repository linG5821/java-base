package com.ling5821.javabase.str;

import java.util.Arrays;

/**
 * @author lsj
 * @date 2023-03-22 15:53
 */
public class Test1 {
    public static void main(String[] args) {
        String a = null;
        String b = "Hello";
        String c = a + b;
        System.out.println(c);

        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i]++;
        }
        System.out.println(Arrays.toString(arr));

    }
}
