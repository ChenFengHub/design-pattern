package com.opensource.demo.subject;

import com.opensource.demo.observer.Observer;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-10 21:21:29
 */
public interface AbstractSubject {

    /** 注册观察者 **/
    void addObserver(Observer observer);

    /** 移除观察者 **/
    void removeObserver(Observer observer);

    /** 通知消息给观察者 **/
    void notifyObservers(String message);
}
