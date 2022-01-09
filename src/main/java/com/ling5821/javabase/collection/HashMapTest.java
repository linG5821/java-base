package com.ling5821.javabase.collection;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author linG
 * @date 2021-05-28 23:45
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(null, null);
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("1", null);
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("1", "1");

    }
}
