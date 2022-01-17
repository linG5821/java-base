package com.ling5821.javabase.string;

/**
 * @author linG
 * @date 2021-05-28 22:34
 */
public class StringBufferTest {
    /*StringBuffer的初始容量是16
    默认最大容量是 Integer.MAX_VALUE - 8
    最大值可以是  Integer.MAX_VALUE - 1 本地测试 16G内存
    扩容使用 ensureCapacity
    */
    public static void main(String[] args) {
        StringBuffer buffer =  new StringBuffer();
//        buffer.ensureCapacity(Integer.MAX_VALUE - 16);
        buffer.ensureCapacity(Integer.MAX_VALUE - 1);
        Runtime   runtime = Runtime.getRuntime();
        System.out.println(runtime.freeMemory());
        System.out.println(runtime.maxMemory());
        System.out.println(runtime.totalMemory());

        System.out.println(buffer.capacity());
    }
}
