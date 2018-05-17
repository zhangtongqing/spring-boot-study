package com.minbo.springdemo.web.reacterBus;

import org.springframework.stereotype.Service;
import reactor.bus.Event;
import reactor.fn.Consumer;

/**
 * 编写事件处理程序，需要实现 Consumer<Event<T>> 接口，其中 T 是处理程序接收的数据类型，要根据具体业务设置，这里使用 Integer
 * @author 张同情
 * @date 2018/5/17.
 */
@Service
public class EventBusReceiver implements Consumer<Event<Integer>> {
    @Override
    public void accept(Event<Integer> ev) {
        System.out.println("Process number " + ev.getData());
    }
}
