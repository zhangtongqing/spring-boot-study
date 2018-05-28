package com.minbo.springdemo.web.threadlocal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.net.SocketTimeoutException;

/**
 * @author Andy.zhang
 * @date 2018/5/28.
 */
public class JedisManager {
    private static final Logger log = LoggerFactory.getLogger(JedisManager.class);

    /**
     * 获取redis缓存连接
     *
     * @return
     */
    public static Jedis getCacheJedis()
    {
        Jedis jedis = null;
        int timeoutCount = 0;
        while (true) // 如果是网络超时则多试几次
        {
            try
            {
                jedis = RedisPool.getCachePool().getResource();
                break;
            } catch (Exception e)
            {
                if (e instanceof JedisConnectionException || e instanceof SocketTimeoutException)
                {
                    timeoutCount++;
                    log.warn("getCacheJedis timeoutCount={}", timeoutCount);
                    if (timeoutCount > 5)//网络超时的最大次数
                    {
                        log.warn("jedisInfo。NumActive=" + RedisPool.getCachePool().getNumActive() + ", NumIdle="
                                + RedisPool.getCachePool().getNumIdle() + ", NumWaiters="
                                + RedisPool.getCachePool().getNumWaiters() + ", isClosed="
                                + RedisPool.getCachePool().isClosed());
                        log.error("getCacheJedis error", e);
                        break;
                    }
                }else
                {
                    log.warn("jedisInfo。NumActive=" + RedisPool.getCachePool().getNumActive() + ", NumIdle="
                            + RedisPool.getCachePool().getNumIdle() + ", NumWaiters="
                            + RedisPool.getCachePool().getNumWaiters() + ", isClosed="
                            + RedisPool.getCachePool().isClosed());
                    log.error("getCacheJedis error", e);
                    break;
                }
            }
        }
        return jedis;
    }
}
