package com.sihui.mybatis.queue;

import java.util.Objects;
import java.util.concurrent.DelayQueue;

/**
 * @ProjectName: mybatis
 * @Package: com.sihui.mybatis.queue
 * @ClassName: DelayedQueueThread
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2019-12-10  15:10
 * @Version: 1.0
 */
public class DelayedQueueThread implements Runnable {

    private DelayQueue<DelayedQueueObj> delayQueue;

    public DelayedQueueThread(DelayQueue<DelayedQueueObj> delayQueue) {
        this.delayQueue = delayQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                DelayedQueueObj take = delayQueue.take();
                if (Objects.nonNull(take)) {
                    System.out.println("任务执行时间为：" + take.getExecteTime());
                    System.out.println("执行：" + System.currentTimeMillis() + "，auctionId:" + take.getAuctionId());
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
