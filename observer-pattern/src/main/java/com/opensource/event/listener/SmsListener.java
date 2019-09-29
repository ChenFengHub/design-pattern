package com.opensource.event.listener;

import com.opensource.event.OrderMessageEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-10 22:22:15
 */
@Component
public class SmsListener implements ApplicationListener<OrderMessageEvent> {

    @Async
    public void onApplicationEvent(OrderMessageEvent event) {
        System.out.println(Thread.currentThread().getName() + "开始短信消息通知，内容：" + event.getMsgJson().toJSONString());
    }
}
