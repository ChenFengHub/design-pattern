package com.opensource.demo;

import com.opensource.demo.observer.impl.UserObserver;
import com.opensource.demo.subject.AbstractSubject;
import com.opensource.demo.subject.impl.WechatSubject;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-10 21:21:39
 */
public class TestUserNotify {
    public static void main(String[] args) {
        // 1.创建具体主题
        AbstractSubject subject = new WechatSubject();
        // 2.注册观察者
        subject.addObserver(new UserObserver("cf"));
        subject.addObserver(new UserObserver("ccc"));
        // 3.群发消息
        subject.notifyObservers("测试通知用户的消息群发功能！");
    }
}
