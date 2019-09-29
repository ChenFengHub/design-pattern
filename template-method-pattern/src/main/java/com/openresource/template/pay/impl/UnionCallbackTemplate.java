package com.openresource.template.pay.impl;

import com.openresource.template.pay.AbstractPayCallbackTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-08 19:19:25
 */
@Slf4j
@Component
public class UnionCallbackTemplate extends AbstractPayCallbackTemplate {

    protected Map<String, String> verifySignature() {
        // 假数据，模拟银联回调报文 begin
        log.info(">>>第一步  解析银联报文 。。。 verifySignature()");
        Map<String, String> verifySignature = new HashMap<String, String>();
        verifySignature.put("price", "1999");
        verifySignature.put("orderDes", "订单描述");
        // 银联支付状态：0-失败；1-成功
        verifySignature.put("unionPayMentStatus", "1");
        // 银联支付订单号
        verifySignature.put("unionPayOrderNumber", "20000000001");
        // 假数据，模拟银联回调报文 end

        // 我们自己的参数，不管哪种支付，都一样。200-成功；其他-失败
        verifySignature.put("analysisCode", "200");
        return verifySignature;
    }

    protected String asyncService(Map<String, String> verifySignature) {
        log.info(">>>第三步 银联 asyncService，verifySignature：{}", verifySignature);
        String paymentStatus = verifySignature.get("unionPayMentStatus");
        if ("1".equals(paymentStatus)) {
            String unionPayOrderNumber = verifySignature.get("unionPayOrderNumber");
            log.info(">>> orderNum:{}，银联已经支付成功，修改订单的状态为已支付。。。", unionPayOrderNumber);
            return resultSuccess();
        } else {
            return resultFail();
        }
    }

    protected String resultFail() {
        return "Union fail";
    }

    protected String resultSuccess() {
        return "Union success";
    }
}
