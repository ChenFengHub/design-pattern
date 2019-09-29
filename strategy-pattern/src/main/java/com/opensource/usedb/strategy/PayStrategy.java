package com.opensource.usedb.strategy;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-06 10:10:04
 */
public interface PayStrategy {

    /**
     * 支付操作：不管何种操作，都是跳转到对应支付页面，最终提交 form 表达进行支付
     * @return
     */
    String toPayHtml();
}
