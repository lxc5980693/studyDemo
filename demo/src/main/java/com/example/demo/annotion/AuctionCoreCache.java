package com.example.demo.annotion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.annotion
 * @ClassName: AuctionCoreCache
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-11-03  11:26
 * @Version: 1.0
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuctionCoreCache {

    String cacheKey();

    int maxRetry() default 0;

    int maxWaitTime() default 86400;

}
