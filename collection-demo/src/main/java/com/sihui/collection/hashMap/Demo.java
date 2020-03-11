package com.sihui.collection.hashMap;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @ProjectName: collection-demo
 * @Package: com.sihui.collection.hashMap
 * @ClassName: Demo
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-08  22:40
 * @Version: 1.0
 */
public class Demo {

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        Map<String, String> stringStringHashMap = new HashMap<String, String>();
        Hashtable<String, String> stringStringHashtable = new Hashtable<String, String>();
        stringStringHashtable.put("aaa", "bbb");
        System.out.println(tableSizeFor(1000));
       System.out.println(2^1024);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
