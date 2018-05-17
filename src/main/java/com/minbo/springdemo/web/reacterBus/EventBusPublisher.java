package com.minbo.springdemo.web.reacterBus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.bus.Event;
import reactor.bus.EventBus;

/**https://blog.csdn.net/shida_csdn/article/details/78194965?locationNum=10&fps=1
 *编写事件发送程序，发送程序发送事件时需要指定标签，用以区分不同事件，以便交给不同的处理程序处理
 * @author 张同情
 * @date 2018/5/17.
 */
@Controller
public class EventBusPublisher {
    @Autowired
    EventBus eventBus;

    @RequestMapping("reactor/demo")
    @ResponseBody
    public void publish() throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            eventBus.notify("number", Event.wrap(i));
        }
    }
}
