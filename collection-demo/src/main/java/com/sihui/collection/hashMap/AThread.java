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
public class AThread extends Thread {
    BThread bt;

    public AThread(BThread bt) {
        super("[AThread] Thread");
        this.bt = bt;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        try {
            bt.join();
            System.out.println(threadName + " end.");
        } catch (Exception e) {
            System.out.println("Exception from " + threadName + ".run");
        }
    }
}
