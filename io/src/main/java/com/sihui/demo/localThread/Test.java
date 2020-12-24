package com.sihui.demo.localThread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ProjectName: io
 * @Package: com.sihui.demo.localThread
 * @ClassName: Test
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-05-18  11:34
 * @Version: 1.0
 */
public class Test {
    private static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
//        local.set("aaa");
//        new Thread(new MyThread()).start();
        AtomicInteger atomicInteger = new AtomicInteger();
        int HASH_INCREMENT = 0x61c88647;
        int andAdd = atomicInteger.getAndAdd(HASH_INCREMENT);
        System.out.println(atomicInteger.get());
    }
}
