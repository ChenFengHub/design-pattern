package com.opensource.staticproxy;

import com.opensource.service.impl.OrderServiceImpl;

/**
 * @program: designpattern
 * @description: 通过继承对象方式创建代理类
 * @author: Mr.CF
 * @create: 2019-09-09 09:09:56
 */
public class OrderServiceProxyByClass extends OrderServiceImpl{

    @Override
    public void order() {
        System.out.println("继承类方式创建代理类：采集日志开始");
        super.order();
        System.out.println("继承类方式创建代理类：采集日志结束");
    }
}
