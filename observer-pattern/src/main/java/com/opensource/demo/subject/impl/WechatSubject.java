package com.opensource.demo.subject.impl;

import com.opensource.demo.observer.Observer;
import com.opensource.demo.subject.AbstractSubject;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-10 21:21:35
 */
public class WechatSubject implements AbstractSubject {

    private List<Observer> observerList = new ArrayList<Observer>();

    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    public void notifyObservers(String message) {
        for(Observer observer : this.observerList) {
            observer.update(message);
        }
    }
}
