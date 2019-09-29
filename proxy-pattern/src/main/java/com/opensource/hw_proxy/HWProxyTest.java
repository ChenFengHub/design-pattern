package com.opensource.hw_proxy;

import com.opensource.hw_proxy.impl.JavaClassLoader;
import com.opensource.hw_proxy.impl.MyJdkInvocationHandlerImpl;
import com.opensource.service.OrderService;
import com.opensource.service.impl.OrderServiceImpl;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-09 13:13:49
 */
public class HWProxyTest {

    public static void main(String[] args) throws Throwable {
//        OrderService orderService = new $ProxyHW0(new MyJdkInvocationHandlerImpl(new OrderServiceImpl()));
//        orderService.order();
        OrderService orderService = (OrderService) MyProxy.newProxyInstance(new JavaClassLoader(), OrderService.class, new MyJdkInvocationHandlerImpl(new OrderServiceImpl()));
        orderService.order();
    }
}
