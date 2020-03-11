package com.sihui.collection.hashMap;

/**
 * @ProjectName: collection-demo
 * @Package: com.sihui.collection.hashMap
 * @ClassName: Test2
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-09  20:38
 * @Version: 1.0
 */
public class JoinDemo extends Thread {
    int i;
    Thread previousThread; //上一个线程

    public JoinDemo(Thread previousThread, int i) {
        this.previousThread = previousThread;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            //调用上一个线程的join方法，大家可以自己演示的时候可以把这行代码注释掉
            previousThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("num:" + i);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread previousThread = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            JoinDemo joinDemo = new JoinDemo(previousThread, i);
            joinDemo.start();
            Thread.sleep(3000);
            previousThread = joinDemo;
        }

    }
}