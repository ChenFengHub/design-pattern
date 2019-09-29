package com.opensource.decorator.simple.impl;

import com.opensource.decorator.simple.AbstractDecorator;
import com.opensource.decorator.simple.GatewayComponent;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-10 08:08:07
 */
public class LogDecorator extends AbstractDecorator {

    private GatewayComponent gatewayComponent;

    public GatewayComponent getGatewayComponent() {
        return gatewayComponent;
    }

    public void setGatewayComponent(GatewayComponent gatewayComponent) {
        this.gatewayComponent = gatewayComponent;
    }

    @Override
    public void service() {
        if(gatewayComponent != null) {
            gatewayComponent.service();
        }
        System.out.println(">>> 第二步 网关中新增日志收集。。");
    }
}
