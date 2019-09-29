package com.opensource.facade;

import com.opensource.server.IntegralService;
import com.opensource.server.LogService;
import com.opensource.server.MsgService;
import com.opensource.server.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-11 14:14:21
 */
@Component
public class PayFacade {

    @Autowired
    private IntegralService integralService;

    @Autowired
    private LogService logService;

    @Autowired
    private MsgService msgService;

    @Autowired
    private PaymentService paymentService;

    public void facadecallback() {
        // 1. 第一步 日志收集
        logService.logService();
        // 2. 第二步 修改订单状态
        paymentService.updatePaymentStatus();
        // 3. 第三步 调用积分服务接口
        integralService.addIntegral();
        // 4. 第四步 调用消息服务平台
        msgService.sendMsg();
    }
}
