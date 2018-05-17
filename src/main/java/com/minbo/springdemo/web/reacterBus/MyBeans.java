package com.minbo.springdemo.web.reacterBus;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.Environment;
import reactor.bus.EventBus;

/**
 *  实例化 EventBus Bean，这里采用内部 Bean 方式实现
 * @author 张同情
 * @date 2018/5/17.
 */
@Component
public class MyBeans {
    @Bean
    Environment env() {
        return Environment.initializeIfEmpty()
                .assignErrorJournal();
    }

    @Bean
    EventBus createEventBus(Environment env) {
        return EventBus.create(env, Environment.THREAD_POOL);
    }
}
