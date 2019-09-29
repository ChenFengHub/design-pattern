package com.opensource.decorator.optimization.impl;

import com.opensource.decorator.optimization.AbstractDecorator;
import com.opensource.decorator.optimization.GatewayComponent;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-10 08:08:07
 */
public class LogDecorator extends AbstractDecorator {

    public LogDecorator(GatewayComponent gatewayComponent) {
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
