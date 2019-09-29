package com.opensource.usedb.service;

import com.opensource.usedb.dao.GatewayHandlerEntityMapper;
import com.opensource.usedb.entity.GatewayHandlerEntity;
import com.opensource.usedb.handler.GatewayHandler;
import com.opensource.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-07 22:22:41
 */
@Component
public class HandlerService {

    @Autowired
    private GatewayHandlerEntityMapper gatewayHandlerMapper;

    public GatewayHandler getDbFirstGatewayHandler() {
        // 1.从数据库中查询第一个 GatewayHandler
        GatewayHandlerEntity firstGatewayHandlerEntity = gatewayHandlerMapper.getFirstGatewayHandler();
        if(firstGatewayHandlerEntity == null) {
            return null;
        }

        // 2. 从 ioc 容器中获取第一个 handler 对象
        String firstBeanHandlerId = firstGatewayHandlerEntity.getHandlerId();
        if(StringUtils.isEmpty(firstBeanHandlerId)) {
            return null;
        }
        GatewayHandler firstGatewayHandler = SpringUtils.getBean(firstBeanHandlerId, GatewayHandler.class);
        if(firstGatewayHandler == null) {
            return null;
        }

        // 3.循环获取下一个职责对象并设置到职责对象中
        String nextBeanHandlerId = firstGatewayHandlerEntity.getNextHandlerId();
        GatewayHandler tempNextGatewayHandler = firstGatewayHandler;
        while (!StringUtils.isEmpty(nextBeanHandlerId)) {
            GatewayHandler nextGatewayHandler = SpringUtils.getBean(nextBeanHandlerId, GatewayHandler.class);
            if(nextGatewayHandler == null) {
                break;
            }
            // 5.从数据库查询 nextGatewayHandler 对应的信息
            GatewayHandlerEntity nextGatewayHandlerEntity = gatewayHandlerMapper.getByHandlerId(nextBeanHandlerId);
            if(nextGatewayHandlerEntity == null) {
                break;
            }
            // 6.关联下一个职责对象
            tempNextGatewayHandler.setNextGatewayHandler(nextGatewayHandler);
            nextBeanHandlerId = nextGatewayHandlerEntity.getNextHandlerId();
            tempNextGatewayHandler = nextGatewayHandler;
        }
        return firstGatewayHandler;
    }

}
