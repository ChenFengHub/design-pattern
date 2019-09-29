package com.opensource.decorator.simple.factory;

import com.opensource.decorator.simple.GatewayComponent;
import com.opensource.decorator.simple.impl.ConcreteGatewayComponent;
import com.opensource.decorator.simple.impl.LimitDecorator;
import com.opensource.decorator.simple.impl.LogDecorator;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-10 08:08:13
 */
public class GatewayFactory {

    public static GatewayComponent getGatewayComponent() {
        // 1.创建日志装饰者类
        LogDecorator logDecorator = new LogDecorator();
        // 2.创建 api 接口限流装饰者类
        LimitDecorator limitDecorator = new LimitDecorator();
        // 3.创建被装饰者对象
        ConcreteGatewayComponent concreteGatewayComponent = new ConcreteGatewayComponent();
        // 4.根据执行顺序的逆序组装
        logDecorator.setGatewayComponent(concreteGatewayComponent);
        limitDecorator.setGatewayComponent(logDecorator);
        return limitDecorator;
    }

    public static void main(String[] args) {
        GatewayComponent gatewayComponent = getGatewayComponent();
        gatewayComponent.service();
    }

}
