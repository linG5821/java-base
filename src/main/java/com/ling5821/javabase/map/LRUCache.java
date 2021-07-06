package com.ling5821.javabase.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lsj
 * @date 2021/7/6 11:07
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    public static final int MAX_ENTRIES = 3;

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_ENTRIES;
    }

    public LRUCache() {
        super(MAX_ENTRIES, 0.75f, true);
    }

    public static void main(String[] args) {
        LRUCache<Integer,String> cache = new LRUCache<>();
        cache.put(1, "小白");
        cache.put(2, "小黑");
        cache.put(3, "小红");
        cache.get(1);
        cache.put(4, "小蓝");
        System.out.println(cache.keySet());
    }
}
