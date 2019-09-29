package com.opensource.hw_proxy.impl;

import com.opensource.hw_proxy.MyJdkInvocationHandler;
import com.opensource.service.OrderService;

import java.lang.reflect.Method;

/**
 * @program: designpattern
 * @description: 模拟创建的代理类
 * @author: Mr.CF
 * @create: 2019-09-09 13:13:46
 */
public class $ProxyHW0 implements OrderService {

    private MyJdkInvocationHandler h;

    public $ProxyHW0(MyJdkInvocationHandler h) {
        this.h = h;
    }

    @Override
    public void order() {
        try {
            Method orderMethod = OrderService.class.getMethod("order", new Class[]{});
            this.h.invoke(this, orderMethod, null);
        } catch (Throwable e) {

        }
    }
}
