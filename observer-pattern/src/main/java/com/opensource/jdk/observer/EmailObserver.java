package com.opensource.jdk.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-10 21:21:56
 */
public class EmailObserver implements Observer {
    /** 最好另起一个线程通知，否则会导致通知效率很慢，影响程序性能 **/
    public void update(Observable o, Object arg) {
        System.out.println("用户下单成功，发送邮件提醒内容：" + arg);
    }
}
