package com.opensource.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-11 14:14:15
 */
@Slf4j
@Service
public class PaymentService {
    public void updatePaymentStatus() {System.out.println(">>> 第二个模块：修改订单状态为已支付");}
}
