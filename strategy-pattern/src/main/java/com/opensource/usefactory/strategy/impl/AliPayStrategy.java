package com.opensource.usefactory.strategy.impl;

import com.opensource.usefactory.strategy.PayStrategy;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-06 10:10:06
 */
public class AliPayStrategy implements PayStrategy {
    public String toPayHtml() {
        return "跳转支付宝支付界面。。。。";
    }
}
