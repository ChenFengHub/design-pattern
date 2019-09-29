package com.opensource.service.impl;

import com.opensource.service.OrderService;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-09 10:10:03
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public void order() {
        System.out.println("修改数据库订单");
    }
}
