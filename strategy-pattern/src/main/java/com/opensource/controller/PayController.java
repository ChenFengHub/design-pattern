package com.opensource.controller;

import com.opensource.usefactory.context.PayContextStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-06 09:09:55
 */
@RestController
public class PayController {

    @Autowired
    @Qualifier("payContextStrategy")
    private PayContextStrategy payContextStrategy;

    @Autowired
    @Qualifier("useDbPayContextStrategy")
    private com.opensource.usedb.context.PayContextStrategy useDbPayContextStrategy;

    /**
     * 通过枚举来控制所要创建的支付策略对象-----该方法不推荐，后续推荐用数据库替换枚举
     * @param payCode
     * @return
     */
    @RequestMapping("/simple/toPayHtml")
    public String simpleToPayHtml(String payCode) {
        return payContextStrategy.toPayHtml(payCode);
    }

    @RequestMapping("/db/toPayHtml")
    public String dbToPayHtml(String payCode) {
        return useDbPayContextStrategy.toPayHtml(payCode);
    }

}
