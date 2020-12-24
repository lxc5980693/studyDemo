package com.example.demo.cache;

/**
 * @ProjectName: platform-auction-core
 * @Package: com.souche.auction.core.cache
 * @ClassName: AuctionCacheCallBack
 * @Author: lixuanchen
 * @Description: 缓存的回调函数
 * @Date: 2020-10-26  15:27
 * @Version: 1.0
 */
@FunctionalInterface
public interface AuctionCacheCallBack<O,I> {

    O execte(I input);
}
