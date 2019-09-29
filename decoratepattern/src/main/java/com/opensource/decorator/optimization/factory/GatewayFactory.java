package com.opensource.decorator.optimization.factory;

import com.opensource.decorator.optimization.GatewayComponent;
import com.opensource.decorator.optimization.impl.ConcreteGatewayComponent;
import com.opensource.decorator.optimization.impl.LimitDecorator;
import com.opensource.decorator.optimization.impl.LogDecorator;

/**
 * @program: designpattern
 * @description: 优化后的装饰者模式
 * @author: Mr.CF
 * @create: 2019-09-10 08:08:13
 */
public class GatewayFactory {

    public static GatewayComponent getGatewayComponent() {
        return new LimitDecorator(new LogDecorator(new ConcreteGatewayComponent()));
    }

    public static void main(String[] args) {
        GatewayComponent gatewayComponent = getGatewayComponent();
        gatewayComponent.service();
    }

}
