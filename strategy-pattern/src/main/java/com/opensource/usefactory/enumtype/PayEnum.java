package com.opensource.usefactory.enumtype;

/**
 * @program: designpattern
 * @description: 策略模式枚举 标识所有支付方式的类型（usefactory 中使用枚举方式不太灵活，后期会改为通过数据库获取）
 * @author: Mr.CF
 * @create: 2019-09-06 09:09:59
 */
public enum PayEnum {

    /**
     * 支付宝支付
     */
    ali_pay("com.opensource.usefactory.strategy.impl.AliPayStrategy"),
    /**
     * 微信支付
     */
    wechat_pay("com.opensource.usefactory.strategy.impl.WechatPayStrategy");


    private String className;

    PayEnum(String className) {
        this.className = className;
    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
