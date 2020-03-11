package com.sihui.collection.hashMap;

import com.sun.xml.internal.ws.api.pipe.Fiber;

/**
 * @ProjectName: collection-demo
 * @Package: com.sihui.collection.hashMap
 * @ClassName: Test
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-09  20:32
 * @Version: 1.0
 */
public class Test {
    private static int a = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    a++;
                    System.out.println("a = " + a);
                }
            });
            thread.start();
            thread.join();
            System.out.println("i =" + i);
        }
    }
}
