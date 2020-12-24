package com.example.demo.cache;

import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @ProjectName: platform-auction-core
 * @Package: com.souche.auction.core.cache.impl
 * @ClassName: CacheService
 * @Author: lixuanchen
 * @Description: 缓存的接口实现类
 * @Date: 2020-10-26  15:22
 * @Version: 1.0
 */
@Slf4j
@Service("cacheService")
public class CacheServiceImpl implements CacheService {

    @Autowired
    private RedisTemplate redisTemplate;

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
    @Override
    public boolean setCache(String key, Object value) {
        try {
            ValueOperations valueOperations = redisTemplate.opsForValue();
            valueOperations.set(key, value);
            return true;
        } catch (Exception e) {
            log.error("CacheService -> setCache error: ", e);
            this.deleteCache(key);
        }
        return false;
    }

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
    @Override
    public boolean setCache(String key, AuctionCacheCallBack<Object,String> cacheCallBack) {
        if (Objects.isNull(cacheCallBack)){
            return false;
        }
        try {
            Object out = cacheCallBack.execte(key);
            if (Objects.nonNull(out)){
                this.setCache(key,out);
            }
            return true;
        } catch (Exception e) {
            log.error("CacheService -> setCache error: ", e);
        }
        return false;
    }

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
    @Override
    public boolean setCache(String key, Integer expireTime, AuctionCacheCallBack<Object,String> cacheCallBack) {
        if (Objects.isNull(cacheCallBack)){
            return false;
        }
        try {
            Object out = cacheCallBack.execte(key);
            if (Objects.nonNull(out)){
                this.setCacheExpire(key,out,expireTime);
            }
            return true;
        } catch (Exception e) {
            log.error("CacheService -> setCache error: ", e);
        }
        return false;
    }

    /**
     * @param key
     * @param value
     * @param expireTime 过期时间（单位：s）
     * @Author lixuanchen
     * @Version 1.0
     * @Description 设置缓存并设置过期时间
     * @Return boolean
     * @Exception
     * @Date 2020-10-26  15:33
     */
    @Override
    public boolean setCacheExpire(String key, Object value, Integer expireTime) {
        try {
            ValueOperations valueOperations = redisTemplate.opsForValue();
            valueOperations.set(key, value, expireTime);
            return true;
        } catch (Exception e) {
            log.error("CacheService -> setCacheExpire error: ", e);
        }
        return false;
    }

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
    @Override
    public <T> T getCache(String key, Class<T> clazz) {
        if (StringUtil.isNullOrEmpty(key)) {
            return null;
        }
        try {
            ValueOperations valueOperations = redisTemplate.opsForValue();
            Object value = valueOperations.get(key);
            if (Objects.nonNull(value)) {
                return (T) value;
            }
        } catch (Exception e) {
            log.error("CacheService -> getCache error: ", e);
        }
        return null;
    }

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
    @Override
    public <T> T getCache(String key, Class<T> clazz, Integer expireTime, AuctionCacheCallBack<T, String> callBack) {
        try {
            T cache = this.getCache(key, clazz);
            if (Objects.isNull(cache)) {
                log.info("CacheService -> getCache key:{} return is null", key);
                cache = callBack.execte(key);
                if (Objects.nonNull(cache)) {
                    this.setCacheExpire(key, cache, expireTime);
                }
            }
            return cache;
        } catch (Exception e) {
            log.error("CacheService -> getCache error: ", e);
        }
        return null;
    }

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
    @Override
    public <T> T getCache(String key, Class<T> clazz, AuctionCacheCallBack<T, String> callBack) {
        try {
            T cache = this.getCache(key, clazz);
            if (Objects.isNull(cache)) {
                log.info("CacheService -> getCache key:{} return is null", key);
                cache = callBack.execte(key);
                if (Objects.nonNull(cache)) {
                    this.setCache(key, cache);
                }
            }
            return cache;
        } catch (Exception e) {
            log.error("CacheService -> getCache error: ", e);
        }
        return null;
    }

    /**
     * @param key
     * @Author lixuanchen
     * @Version 1.0
     * @Description 删除缓存
     * @Return boolean
     * @Exception
     * @Date 2020-10-26  15:36
     */
    @Override
    public boolean deleteCache(String key) {
        try {
            redisTemplate.delete(key);
            return true;
        } catch (Exception e) {
            log.error("CacheService -> deleteCache error: ", e);
        }
        return false;
    }
}
