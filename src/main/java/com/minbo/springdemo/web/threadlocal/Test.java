package com.minbo.springdemo.web.threadlocal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

/**
 * @author Andy.zhang
 * @date 2018/5/28.
 */
public class Test {
    private static final Logger log = LoggerFactory.getLogger(redisManager.class);
    /**
     * 手机注册139邮箱记录-保存数据
     *
     * @param phone
     * @return
     */
    public static boolean setReg139(String phone) {
        try {
            Pipeline pipeline = redisManager.getCachePipeline();
            pipeline.sadd("xxxxxx", phone);// 使用set，redis不重启不会过期
            return true;
        } catch (Exception e) {
            log.error("setReg139 error", e);
            return false;
        }
    }

}
