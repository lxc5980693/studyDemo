package com.sihui.dubbo.server.LoadBalance;

import com.sihui.dubbo.server.LoadBalance.impl.RandomLoadBalance;

import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: netty-dubbo
 * @Package: com.sihui.dubbo.server.LoadBalance
 * @ClassName: Test
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-04-06  18:30
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("8080", "8081");
        LoadBalanceStrateay loadBalanceStrateay = new RandomLoadBalance();
        for (int i = 0; i < 10; i++) {
            System.out.println(loadBalanceStrateay.select(str));
        }
    }
}
