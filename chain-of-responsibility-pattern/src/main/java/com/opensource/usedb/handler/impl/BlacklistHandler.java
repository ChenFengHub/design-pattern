package com.opensource.usedb.handler.impl;

import com.opensource.usedb.handler.GatewayHandler;
import org.springframework.stereotype.Component;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-07 21:21:54
 */
@Component
public class BlacklistHandler extends GatewayHandler {
    @Override
    public void service() {
        System.out.println("第二关 。。。 黑名单拦截");
        nextService();
    }
}
