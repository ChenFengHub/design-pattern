package com.opensource.state.impl;

import com.opensource.state.OrderState;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-11 15:15:48
 */
@Primary
@Component("alreadySignedOrderState")
public class AlreadySignedOrderState implements OrderState {
    public Object orderService() {
        System.out.println(">>> 切换为已经签收状态");
        return "切换为已经签收状态";
    }
}
