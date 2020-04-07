package com.sihui.dubbo.server.LoadBalance.impl;

import com.sihui.dubbo.server.LoadBalance.LoadBalanceStrateay;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ProjectName: netty-dubbo
 * @Package: com.sihui.dubbo.server.LoadBalance.impl
 * @ClassName: LoopLoadBalance
 * @Author: lixuanchen
 * @Description: 轮询算法
 * @Date: 2020-04-06  18:21
 * @Version: 1.0
 */
public class LoopLoadBalance implements LoadBalanceStrateay {

    private AtomicInteger index = new AtomicInteger(0);

    /**
     * 实现dubbo的负载均衡器
     *
     * @param list
     * @return
     */
    @Override
    public String select(List<String> list) {
        int size = list.size();
        int i = index.get();
        if (i >= size) {
            index.set(0);
        }
        return list.get(index.getAndIncrement());
    }
}
