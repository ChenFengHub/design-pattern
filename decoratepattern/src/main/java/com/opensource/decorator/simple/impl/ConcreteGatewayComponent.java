package com.opensource.decorator.simple.impl;

import com.opensource.decorator.simple.GatewayComponent;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-10 08:08:02
 */
public class ConcreteGatewayComponent extends GatewayComponent {

    @Override
    public void service() {
        System.out.println(">>> 第一步 网关中获取基本基本参数");
    }
}
