package com.opensource.event.listener;

import com.opensource.event.OrderMessageEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-10 22:22:04
 */
@Component
public class EmailListener implements ApplicationListener<OrderMessageEvent> {

    /** 采用异步执行消息通知 **/
    @Async
    public void onApplicationEvent(OrderMessageEvent event) {
        // 如何获取当前容器下面所有的观察者？遍历容器的所有对象，通过反射机制，获取所有对象的实现类，
        // 类实现有 ApplicationListener 且泛型为 OrderMessageEvent 的对象
        System.out.println(Thread.currentThread().getName() + "开始邮件消息通知，内容：" + event.getMsgJson().toJSONString());
    }
}
