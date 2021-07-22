package com.ling5821.javabase.classloader;

/**
 * @author lsj
 * @date 2021/7/22 9:50
 * 静态语句块只能访问到定义在他之前的类变量, 定义在他之后的类变量,只能赋值,不能访问
 */
public class InitTest {
    static {
        i = 0;
        i = 3;
        /* 非法向前引用 */
        /*System.out.println(i);*/
    }
    static int i = 1;

    public static void main(String[] args) {
        System.out.println(i);
    }
}
