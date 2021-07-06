package com.ling5821.javabase.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author lsj
 * @date 2021/7/6 11:49
 */
public class CollectionDetail {
    public static void main(String[] args) {
        /* 默认创建的 Vector capacityIncrement 传入为 0 扩容时每次都会增长为原来的两倍 */
        Vector<String> vector = new Vector<>();
        /* 可以通过此方法扩容 */
        vector.ensureCapacity( 20);


        /* Vector的替代方案 */
        List<String> list1 = new ArrayList<>();
        List<String> sync1 = Collections.synchronizedList(list1);

        /* 读写分离 适合读多写少的情况 缺点 内存占用两倍于原来的内存(内部维护了两个数组) 数据不一致 读操作不能读取实时性的数据 */
        List<String> list2 = new CopyOnWriteArrayList<>();
    }
}
