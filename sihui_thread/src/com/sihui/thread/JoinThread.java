package com.sihui.thread;

import java.util.Random;

/**
 * @ProjectName: sihui_thread
 * @Package: com.sihui.thread
 * @ClassName: joinThread
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-07-01  10:33
 * @Version: 1.0
 */
public class JoinThread {

    static class MyThread implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(new Random().nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "running...");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyThread(), "t1");
        Thread thread2 = new Thread(new MyThread(), "t2");
        Thread thread3 = new Thread(new MyThread(), "t3");
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
    }
}
