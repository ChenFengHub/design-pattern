package com.opensource.usefactory.factory;

import com.opensource.usefactory.enumtype.PayEnum;
import com.opensource.usefactory.strategy.PayStrategy;

/**
 * @program: designpattern
 * @description: 使用静态工厂方法，创建支付对象
 * @author: Mr.CF
 * @create: 2019-09-06 10:10:09
 */
public class StrategyFactory {

    public static PayStrategy getPayStrategy(String payCode) {
        try {
            String className = PayEnum.valueOf(payCode).getClassName();
            return (PayStrategy) Class.forName(className).newInstance();
        } catch (Exception e) {
            return null;
        }
    }

}
