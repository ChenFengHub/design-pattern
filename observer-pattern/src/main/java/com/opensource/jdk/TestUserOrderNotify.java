package com.opensource.jdk;

import com.opensource.jdk.observable.MessageObservable;
import com.opensource.jdk.observer.EmailObserver;
import com.opensource.jdk.observer.SmsObserver;
import com.opensource.jdk.observer.WechatObserver;

import java.util.Observable;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-10 21:21:57
 */
public class TestUserOrderNotify {
    public static void main(String[] args) {
        // 模拟用户下单成功，推送短信、邮件、微信模板通知

        // 1.创建具体主题
        Observable observable = new MessageObservable();
        // 2.注册观察者
        observable.addObserver(new EmailObserver());
        observable.addObserver(new SmsObserver());
        observable.addObserver(new WechatObserver());
        // 3.群发消息
        observable.notifyObservers("恭喜用户下单成功，提得劳斯莱斯一辆！");
    }
}
