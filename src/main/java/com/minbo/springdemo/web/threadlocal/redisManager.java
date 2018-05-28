package com.minbo.springdemo.web.threadlocal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

/**
 * @author Andy.zhang
 * @date 2018/5/28.
 */
public class redisManager {
    private static final Logger log = LoggerFactory.getLogger(redisManager.class);
    private static final ThreadLocal<Jedis> cacheJedis = new ThreadLocal<Jedis>();
    private static final ThreadLocal<Pipeline> cachePipeline = new ThreadLocal<Pipeline>();


    public static Pipeline getCachePipeline()
    {
        Pipeline pipeline = cachePipeline.get();
        if (pipeline == null)
        {
            pipeline = getCacheJedis().pipelined();
            cachePipeline.set(pipeline);
        }
        return pipeline;
    }

    /**
     * 获取redis缓存连接
     *
     * @return
     */
    private static Jedis getCacheJedis()
    {
        Jedis jedis = cacheJedis.get();
        if (jedis == null || !jedis.isConnected())
        {
            jedis = JedisManager.getCacheJedis();
            cacheJedis.set(jedis);
        }
        return jedis;
    }


    /**
     * 关闭redis缓存连接
     */
    private static void closeCacheJedis()
    {
        try
        {
            Jedis jedis = cacheJedis.get();
            cacheJedis.set(null);
            if (jedis != null && jedis.isConnected())
            {
                jedis.close();
            }
        } catch (Exception e)
        {
            log.error("closeCacheJedis error", e);
        }
    }

    /**
     * 关闭所有连接
     */
    public static void closeAll()
    {
        closeCacheJedis();
    }

}
