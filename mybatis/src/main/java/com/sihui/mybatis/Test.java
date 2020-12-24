package com.sihui.mybatis;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @ProjectName: mybatis
 * @Package: com.sihui.mybatis
 * @ClassName: Test
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2019-12-10  15:30
 * @Version: 1.0
 */
public class Test {

    private static AtomicLong atomicLong = new AtomicLong(0);

    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    private static LongAdder longAdder = new LongAdder();

    public static void main(String[] args) {
//        DelayQueue<DelayedQueueObj> queue = new DelayQueue<DelayedQueueObj>();
//        long l = System.currentTimeMillis();
//        System.out.println("当前时间：" + l);
//        Thread thread = new Thread(new DelayedQueueThread(queue));
//        thread.start();
//        for (int i = 0; i < 3; i++) {
//            Thread.sleep(2000);
//            Integer integer = Integer.valueOf(i);
//            String auctionId = integer.toString() + integer.toString() + integer.toString();
//            l += 3000;
//            queue.add(new DelayedQueueObj(auctionId, l));
//        }
//        System.out.println(19 >>> 1);
//        long l = System.currentTimeMillis();
//        System.out.println(l);
//        long l1 = System.nanoTime();
//        System.out.println(l1);
//        long l2 = TimeUnit.MILLISECONDS.toNanos(l);
//        System.out.println(l2);
//        long convert = TimeUnit.NANOSECONDS.convert(l, TimeUnit.MILLISECONDS);
//        long convert1 = TimeUnit.MILLISECONDS.convert(convert, TimeUnit.NANOSECONDS);
//        System.out.println(convert);
//        System.out.println(convert1);
//        System.out.println(Long.MAX_VALUE);
//        System.out.println("主线程开始执行。。。");
//        long startTime = System.currentTimeMillis();
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                longAdder.increment();
//                System.out.println(Thread.currentThread().getName() + ": " + longAdder.longValue());
//                countDownLatch.countDown();
//            }).start();
//        }
//        try {
//            countDownLatch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("子线程全部执行完毕，主线程继续执行。。。耗时:" + (System.currentTimeMillis() - startTime));
    }

}