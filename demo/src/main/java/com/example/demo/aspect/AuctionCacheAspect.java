package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.aspect
 * @ClassName: AuctionCacheAspect
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-11-03  11:24
 * @Version: 1.0
 */
@Aspect
public class AuctionCacheAspect {

    @Pointcut("@annotation(com.souche.auction.core.aspect.AuctionCoreLog)")
    public void logAnnoationPointCut() {
    }
}
