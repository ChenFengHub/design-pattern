package com.opensource.usefactory.strategy.impl;

import com.opensource.usefactory.strategy.PayStrategy;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-06 10:10:06
 */
public class WechatPayStrategy implements PayStrategy {
    public String toPayHtml() {
        return "跳转微信支付界面。。。";
    }
}
