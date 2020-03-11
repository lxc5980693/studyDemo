package com.sihui.collection.hashMap;

/**
 * @ProjectName: collection-demo
 * @Package: com.sihui.collection.hashMap
 * @ClassName: BThread
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-09  20:49
 * @Version: 1.0
 */
public class BThread extends Thread {
    public BThread() {
        super("[BThread] Thread");
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(threadName + " loop at " + i);
                Thread.sleep(1000);
            }
            System.out.println(threadName + " end.");
        } catch (Exception e) {
            System.out.println("Exception from " + threadName + ".run");
        }
    }
}
