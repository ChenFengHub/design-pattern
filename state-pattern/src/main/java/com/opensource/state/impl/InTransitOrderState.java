package com.opensource.state.impl;

import com.opensource.state.OrderState;
import org.springframework.stereotype.Component;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-11 15:15:50
 */
@Component("inTransitOrderState")
public class InTransitOrderState implements OrderState {
    public Object orderService() {
        System.out.println(">>> 切换为正在运行状态");
        return "切换为正在运行状态";
    }
}
