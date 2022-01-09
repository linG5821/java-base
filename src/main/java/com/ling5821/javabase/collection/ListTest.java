package com.ling5821.javabase.collection;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author linG
 * @date 2022-01-09 15:51
 */
public class ListTest {

    public static void main(String[] args)
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> list = new ArrayList<>();
        list.add("ABC");
        list.getClass().getMethod("add", Object.class).invoke(list, "123");
        System.out.println(list);
        String s1 = new String(" 程序员 ");
        String s2 = s1.intern();
        String s3 = " 程序员 ";
        System.out.println(s1 == s2);
        System.out.println(s3 == s2);

        String st1 = "str";
        String st2 = "ing";
        String st3 = "str" + "ing";
        String st4 = st1 + st2;
        String st5 = "string";
        System.out.println(st3 == st4);
        System.out.println(st3 == st5);
        System.out.println(st4 == st5);

        System.out.println(~1);


    }

}
