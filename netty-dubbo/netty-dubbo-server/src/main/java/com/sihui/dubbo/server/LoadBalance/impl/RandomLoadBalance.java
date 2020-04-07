package com.sihui.dubbo.server.LoadBalance.impl;

import com.sihui.dubbo.server.LoadBalance.LoadBalanceStrateay;

import java.util.List;
import java.util.Random;

/**
 * @ProjectName: netty-dubbo
 * @Package: com.sihui.dubbo.server.LoadBalance.impl
 * @ClassName: RandomLoadBalance
 * @Author: lixuanchen
 * @Description: 随机算法
 * @Date: 2020-04-06  18:28
 * @Version: 1.0
 */
public class RandomLoadBalance implements LoadBalanceStrateay {
    /**
     * 实现dubbo的负载均衡器
     *
     * @param list
     * @return
     */
    @Override
    public String select(List<String> list) {
        int size = list.size();
        return list.get(new Random().nextInt(size));
    }
}
