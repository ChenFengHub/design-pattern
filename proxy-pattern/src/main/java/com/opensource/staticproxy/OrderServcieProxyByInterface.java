package com.opensource.staticproxy;

import com.opensource.service.OrderService;

/**
 * @program: designpattern
 * @description: 通过实现接口方式，创建代理类
 * @author: Mr.CF
 * @create: 2019-09-09 10:10:47
 */
public class OrderServcieProxyByInterface implements OrderService {

    private OrderService orderService;

    public OrderServcieProxyByInterface(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void order() {
        System.out.println("实现接口方式创建代理类：采集日志开始");
        this.orderService.order();
        System.out.println("实现接口方式创建代理类：采集日志结束");
    }
}
