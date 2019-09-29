package com.opensource.controller;

import com.opensource.usedb.service.HandlerService;
import com.opensource.usefactory.factory.GatewayFactoryHandler;
import com.opensource.usefactory.handler.GatewayHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-07 22:22:02
 */
@RestController
public class GatewayController {

    @Autowired
    private HandlerService handlerService;

    @RequestMapping("/factory")
    public void factoryGatewayInterceptor() {
        GatewayHandler gatewayHandler = GatewayFactoryHandler.getFirestGateWayHandler();
        gatewayHandler.service();
    }

    @RequestMapping("/db")
    public void dbGatewayInterceptor() {
        com.opensource.usedb.handler.GatewayHandler gatewayHandler = handlerService.getDbFirstGatewayHandler();
        if(gatewayHandler == null) {
            System.out.println("null");
            return;
        }
        gatewayHandler.service();
    }

}
