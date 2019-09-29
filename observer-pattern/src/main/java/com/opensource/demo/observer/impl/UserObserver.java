package com.opensource.demo.observer.impl;

import com.opensource.demo.observer.Observer;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-10 21:21:33
 */
public class UserObserver implements Observer {

    private String name;

    public UserObserver(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(this.name + "，收到微信通消息：" + message);
    }
}
