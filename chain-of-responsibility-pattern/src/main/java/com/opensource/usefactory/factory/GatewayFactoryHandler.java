package com.opensource.usefactory.factory;

import com.opensource.usefactory.handler.GatewayHandler;
import com.opensource.usefactory.handler.impl.BlacklistHandler;
import com.opensource.usefactory.handler.impl.ConversationHandler;
import com.opensource.usefactory.handler.impl.CurrentLimitHandler;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-07 21:21:57
 */
public class GatewayFactoryHandler {

    /**
     * 通过静态工厂方法，获取第一个职责对象
     */
    public static GatewayHandler getFirestGateWayHandler() {
        // 1.第一关
        GatewayHandler currentLimitHandler = new CurrentLimitHandler();
        // 2.第二关
        GatewayHandler blacklistHandler = new BlacklistHandler();
        // 3.第三关
        GatewayHandler conversationHandler = new ConversationHandler();
        // 4.设置每个职责对象的后继职责对象
        currentLimitHandler.setNextGatewayHandler(blacklistHandler);
        blacklistHandler.setNextGatewayHandler(conversationHandler);
        // 5.返回责任链中第一个职责对象
        return currentLimitHandler;
    }

}
