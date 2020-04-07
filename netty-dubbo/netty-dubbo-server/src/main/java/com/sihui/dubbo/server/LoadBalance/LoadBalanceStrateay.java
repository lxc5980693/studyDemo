package com.sihui.dubbo.server.LoadBalance;

import java.util.List;

/**
 * @ProjectName: netty-dubbo
 * @Package: com.sihui.dubbo.server.LoadBalance
 * @ClassName: RouteStrateay
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-04-06  18:19
 * @Version: 1.0
 */
public interface LoadBalanceStrateay {

    /**
     * 实现dubbo的负载均衡器
     * @param list
     * @return
     */
    String select(List<String> list);
}
