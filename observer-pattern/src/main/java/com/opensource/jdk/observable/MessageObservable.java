package com.opensource.jdk.observable;

import java.util.Observable;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-10 21:21:42
 */
public class MessageObservable extends Observable{

    @Override
    public void notifyObservers(Object arg) {
        // 1.启动群发功能
        setChanged();
        // 2.群发消息
        super.notifyObservers(arg);
    }
}
