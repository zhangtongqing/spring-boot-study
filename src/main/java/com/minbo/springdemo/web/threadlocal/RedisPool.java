package com.minbo.springdemo.web.threadlocal;

import redis.clients.jedis.JedisPool;

/**
 * @author Andy.zhang
 * @date 2018/5/28.
 */
public class RedisPool {
    public static JedisPool getCachePool() {
        return cachePool;
    }

    public static void setCachePool(JedisPool cachePool) {
        RedisPool.cachePool = cachePool;
    }

    private static JedisPool cachePool; // 缓存池
}
