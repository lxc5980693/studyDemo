package com.sihui.mybatis.queue;

import lombok.Data;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: mybatis
 * @Package: com.sihui.mybatis.queue
 * @ClassName: DelayedQueueObj
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2019-12-10  15:01
 * @Version: 1.0
 */
@Data
public class DelayedQueueObj implements Delayed {

    private String auctionId;
    private long execteTime;

    public DelayedQueueObj(String auctionId, long execteTime) {
        this.auctionId = auctionId;
        this.execteTime = execteTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return execteTime - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.valueOf(this.execteTime).compareTo(Long.valueOf(((DelayedQueueObj) o).execteTime));
    }
}
