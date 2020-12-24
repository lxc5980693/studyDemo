package com.example.demo.cache;


/**
 * @ProjectName: platform-auction-core
 * @Package: com.souche.auction.core.cache
 * @ClassName: CacheService
 * @Author: lixuanchen
 * @Description: 缓存的接口类
 * @Date: 2020-10-26  15:22
 * @Version: 1.0
 */
public interface CacheService {

    /**
     * @param key
     * @param value
     * @Author lixuanchen
     * @Version 1.0
     * @Description 直接设置缓存
     * @Return boolean
     * @Exception
     * @Date 2020-10-26  15:33
     */
    boolean setCache(String key, Object value);

    /**
     * @param key
     * @param cacheCallBack
     * @Author lixuanchen
     * @Version 1.0
     * @Description 直接缓存业务执行返回的实体对象
     * @Return boolean
     * @Exception
     * @Date 2020-10-26  15:33
     */
    boolean setCache(String key, AuctionCacheCallBack<Object, String> cacheCallBack);

    /**
     * @param key
     * @param cacheCallBack
     * @Author lixuanchen
     * @Version 1.0
     * @Description 设置有效期缓存业务执行返回的实体对象
     * @Return boolean
     * @Exception
     * @Date 2020-10-26  15:33
     */
    boolean setCache(String key, Integer expireTime, AuctionCacheCallBack<Object, String> cacheCallBack);

    /**
     * @param key
     * @param value
     * @param expireTime
     * @Author lixuanchen
     * @Version 1.0
     * @Description 设置缓存并设置过期时间
     * @Return boolean
     * @Exception
     * @Date 2020-10-26  15:33
     */
    boolean setCacheExpire(String key, Object value, Integer expireTime);

    /**
     * @param key
     * @param clazz
     * @Author lixuanchen
     * @Version 1.0
     * @Description 不设置回调返回的获取方法
     * @Return T
     * @Exception
     * @Date 2020-10-26  15:33
     */
    <T> T getCache(String key, Class<T> clazz);


    /**
     * @param key
     * @param clazz
     * @param expireTime
     * @param callBack
     * @Author lixuanchen
     * @Version 1.0
     * @Description 传递回调方法，重设缓存时设置过期时间
     * @Return T
     * @Exception
     * @Date 2020-10-26  15:34
     */
    <T> T getCache(String key, Class<T> clazz, Integer expireTime, AuctionCacheCallBack<T, String> callBack);


    /**
     * @param key
     * @param clazz
     * @param callBack
     * @Author lixuanchen
     * @Version 1.0
     * @Description 传递回调方法，直接重设缓存
     * @Return T
     * @Exception
     * @Date 2020-10-26  15:35
     */
    <T> T getCache(String key, Class<T> clazz, AuctionCacheCallBack<T, String> callBack);


    /**
     * @param key
     * @Author lixuanchen
     * @Version 1.0
     * @Description 删除缓存
     * @Return boolean
     * @Exception
     * @Date 2020-10-26  15:36
     */
    boolean deleteCache(String key);

}
