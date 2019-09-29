package com.opensource.state.impl;

import com.opensource.state.OrderState;
import org.springframework.stereotype.Component;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-11 15:15:51
 */
@Component("shippedAlreadyOrderState")
public class ShippedAlreadyOrderState implements OrderState {
    public Object orderService() {
        System.out.println(">>>切换为已经发货状态");
        return "切换为已经发货状态";
    }
}
