package com.sihui.demo.localThread;

/**
 * @ProjectName: io
 * @Package: com.sihui.demo.localThread
 * @ClassName: MyThread
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-05-18  11:34
 * @Version: 1.0
 */
public class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "执行。。。");
    }
}
