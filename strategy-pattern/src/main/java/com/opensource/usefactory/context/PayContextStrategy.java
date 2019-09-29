package com.opensource.usefactory.context;

import com.opensource.usefactory.factory.StrategyFactory;
import com.opensource.usefactory.strategy.PayStrategy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @program: designpattern
 * @description: 上下文中获取具体的策略实现
 * @author: Mr.CF
 * @create: 2019-09-06 09:09:58
 */
@Component("payContextStrategy")
public class PayContextStrategy {

    public String toPayHtml(String payCode) {
        if(StringUtils.isEmpty(payCode)) {
            return "payCode 不能为空！";
        }

        // 1.使用静态工厂方法，获取策略的具体实现
        PayStrategy payStrategy = StrategyFactory.getPayStrategy(payCode);
        if(payStrategy == null) {
            return "没有找到具体策略的实现。。。";
        }

        return payStrategy.toPayHtml();
    }

}
