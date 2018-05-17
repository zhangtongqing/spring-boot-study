package com.minbo.springdemo.web.reacterBus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import reactor.bus.EventBus;
import static reactor.bus.selector.Selectors.$;

/**
 * 关联事件类型与事件处理程序，通过事件标签进行绑定，借助实现 SpringBoot CommandLineRunner 接口，实现启动自动绑定
 * @author 张同情
 * @date 2018/5/17.
 */
@Component
@Order(value = 1)
public class ReactorLauncher implements CommandLineRunner {
    @Autowired
    private EventBus eventBus;

    @Autowired
    private EventBusReceiver receiver;

    @Override
    public void run(String... args) throws Exception {
        eventBus.on($("number"), receiver);
    }

}
