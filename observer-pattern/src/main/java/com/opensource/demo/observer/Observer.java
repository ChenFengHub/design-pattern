package com.opensource.demo.observer;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-10 21:21:30
 */
public interface Observer {

    /** 通知观察者消息 **/
    void update(String message);
}
