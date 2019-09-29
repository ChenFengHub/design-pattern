package com.opensource.order;

import com.opensource.state.OrderState;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.stereotype.Component;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-11 15:15:52
 */
@Component
public class StateContext {

    private OrderState orderState = null;

    public StateContext(OrderState orderState) {
        this.orderState = orderState;
    }
    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }
    public void switchStateOrder() {
        orderState.orderService();
    }

}
