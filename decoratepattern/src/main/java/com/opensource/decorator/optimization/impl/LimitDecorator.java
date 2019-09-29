package com.opensource.decorator.optimization.impl;

import com.opensource.decorator.optimization.AbstractDecorator;
import com.opensource.decorator.optimization.GatewayComponent;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-10 08:08:12
 */
public class LimitDecorator extends AbstractDecorator {

    public LimitDecorator(GatewayComponent gatewayComponent) {
        this.gatewayComponent = gatewayComponent;
    }

    @Override
    public void service() {
        if(gatewayComponent != null) {
            gatewayComponent.service();
        }
        System.out.println(">>> 第三步 网关中新增 API 接口的限流。。");
    }
}
