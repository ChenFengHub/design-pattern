package com.opensource.controller;

import com.opensource.order.StateContext;
import com.opensource.state.OrderState;
import com.opensource.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-11 15:15:54
 */
@Slf4j
@RestController
public class OrderController {

    @Autowired
    private StateContext stateContext;

    @RequestMapping("/order")
    public String order(String stateBeanId) {
        // 1.使用 Spring 上下文获取 bean  中的对象
        OrderState orderState = SpringUtils.getBean(stateBeanId, OrderState.class);
        if(orderState == null) {
            return "状态对象不存在！";
        }
        // 2.使用上下文切换到新的状态
        stateContext.setOrderState(orderState);
        stateContext.switchStateOrder();
        return "success";
    }

    public static void main(String[] args) {
        Test test = new Test<String>();
        if(test instanceof Test) {
            System.out.println("success");
        }

//        if(test instanceof Test<String>) {
//            System.out.println("success");
//        }
//        List arrayList = new ArrayList();
//        arrayList.add("aaaa");
//        arrayList.add(new Integer(100));
//
//        for(int i = 0; i< arrayList.size();i++){
//            String item = (String)arrayList.get(i);
//            log.info("泛型测试","item = " + item);
//        }
    }

}
