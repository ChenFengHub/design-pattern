package com.opensource.hw_proxy;

import java.lang.reflect.Method;

/**
 * @program: designpattern
 * @description: 手写 JdkINvocationHandler 接口
 * @author: Mr.CF
 * @create: 2019-09-09 13:13:39
 */
public interface MyJdkInvocationHandler {

    /**
     * 代理类会调用该方法，方法内部会调用目标方法，在目标方法前后会加上切面方法（前后置方法）
     * @param proxy 代理类对象
     * @param method 执行的目标方法
     * @param args 执行方法的参数
     * @return
     */
    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;

}
