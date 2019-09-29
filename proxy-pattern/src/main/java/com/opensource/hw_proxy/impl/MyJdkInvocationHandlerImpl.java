package com.opensource.hw_proxy.impl;

import com.opensource.hw_proxy.MyJdkInvocationHandler;

import java.lang.reflect.Method;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-09 13:13:43
 */
public class MyJdkInvocationHandlerImpl implements MyJdkInvocationHandler {

    /**
     * 目标对象，实际执行目标方法的对象
     */
    private Object target;

    public MyJdkInvocationHandlerImpl(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("纯手写 jdk 动态代理：日志采集开始");
        Object result = method.invoke(target, args);
        System.out.println("纯手写 jdk 动态代理：日志采集结束");
        return result;
    }
}
