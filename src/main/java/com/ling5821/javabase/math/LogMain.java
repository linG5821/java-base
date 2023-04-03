package com.ling5821.javabase.math;

import java.math.BigDecimal;

/**
 * @author linG
 * @date 2023-03-08 22:19
 */
public class LogMain {

    public static void main(String[] args) {
        System.out.println(logn(2, 1001));
    }

    public static double logn(double base, double value) {
        return Math.log(value) / Math.log(base);
    }


}
