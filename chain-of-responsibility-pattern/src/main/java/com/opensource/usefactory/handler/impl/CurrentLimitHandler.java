package com.opensource.usefactory.handler.impl;

import com.opensource.usefactory.handler.GatewayHandler;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-07 21:21:55
 */
public class CurrentLimitHandler extends GatewayHandler {
    @Override
    public void service() {
        System.out.println("第一关 。。。 API 接口限流");
        nextService();
    }
}
