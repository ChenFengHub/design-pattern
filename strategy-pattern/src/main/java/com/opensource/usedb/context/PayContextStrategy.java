package com.opensource.usedb.context;

import com.opensource.usedb.dao.PaymentChannelMapper;
import com.opensource.usedb.entity.PaymentChannel;
import com.opensource.usedb.strategy.PayStrategy;
import com.opensource.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @program: designpattern
 * @description: 上下文中获取具体的策略实现
 * @author: Mr.CF
 * @create: 2019-09-06 09:09:58
 */
@Component("useDbPayContextStrategy")
public class PayContextStrategy {

    @Autowired
    private PaymentChannelMapper paymentChannelMapper;

    @Autowired
    @Qualifier("aliPayStrategy")
    private PayStrategy payStrategy;

    public String toPayHtml(String payCode) {
        if(StringUtils.isEmpty(payCode)) {
            return "payCode 不能为空！";
        }

        // 1.通过数据库查询当前通道信息
        PaymentChannel paymentChannel = paymentChannelMapper.getChannelByPaycode(payCode);
        if(paymentChannel == null) {
            return payCode + " 支付通道不存在！";
        }
        if("0".equals(paymentChannel.getEnable())) {
            return "当前支付通道被禁用！";
        }

        // 2.使用静态工厂方法，获取策略的具体实现
        String beanName = paymentChannel.getStrategyBeanId();
        PayStrategy payStrategy = SpringUtils.getBean(beanName, PayStrategy.class);
        if(payStrategy == null) {
            return "没有找到具体策略的实现。。。";
        }

        return payStrategy.toPayHtml();
    }

}
