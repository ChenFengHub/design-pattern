package com.opensource.controller;

import com.opensource.dynamicproxy.JdkInvocationHandler;
import com.opensource.service.OrderService;
import com.opensource.service.impl.OrderServiceImpl;
import com.opensource.staticproxy.OrderServcieProxyByInterface;
import com.opensource.staticproxy.OrderServiceProxyByClass;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-09 10:10:56
 */
@RestController
public class ProxyController {

    @RequestMapping("/static/interface")
    public String staticByInterface() {
        OrderService orderService = new OrderServcieProxyByInterface(new OrderServiceImpl());
        orderService.order();
        return "实现接口方式创建代理类成功！";
    }

    @RequestMapping("/static/class")
    public String staticByClass() {
        OrderService orderService = new OrderServiceProxyByClass();
        orderService.order();
        return "继承类方式创建代理类成功！";
    }

    @RequestMapping("/dynamic/jdk")
    public String dynamicSimple() {
        OrderService orderService = new JdkInvocationHandler(new OrderServiceImpl()).getProxy();
        if(orderService == null) {
            return "动态代理创建代理类失败！";
        }
        orderService.order();
        return "动态代理创建代理类成功！";
    }


}
