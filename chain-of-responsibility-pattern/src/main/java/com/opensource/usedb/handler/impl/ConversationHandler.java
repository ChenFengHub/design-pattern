package com.opensource.usedb.handler.impl;

import com.opensource.usedb.handler.GatewayHandler;
import org.springframework.stereotype.Component;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-07 21:21:53
 */
@Component
public class ConversationHandler extends GatewayHandler {
    @Override
    public void service() {
        System.out.println("第三关。。。会话拦截！");
        nextService();
    }
}
