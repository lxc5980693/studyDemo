package com.sihui.proxy.test;

import java.util.concurrent.CountDownLatch;

/**
 * @ProjectName: proxy
 * @Package: com.sihui.proxy.test
 * @ClassName: Demo056
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-04  22:24
 * @Version: 1.0
 */
public class Demo056 {

    public static CountDownLatch countDownLatch = new CountDownLatch(10);

    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final Demo056 test = new Demo056();
        for(int i=0;i<10;i++){
            new Thread(){
                @Override
                public void run() {
                    for(int j=0;j<1000;j++){
                        test.increase();
                    }
                    countDownLatch.countDown();
                };
            }.start();
        }

        //保证前面的线程都执行完
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(test.inc);
    }
}
