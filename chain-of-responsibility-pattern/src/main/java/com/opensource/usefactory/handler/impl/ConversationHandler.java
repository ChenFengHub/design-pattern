package com.opensource.usefactory.handler.impl;

import com.opensource.usefactory.handler.GatewayHandler;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-07 21:21:53
 */
public class ConversationHandler extends GatewayHandler {
    @Override
    public void service() {
        System.out.println("第三关。。。会话拦截！");
        nextService();
    }
}
