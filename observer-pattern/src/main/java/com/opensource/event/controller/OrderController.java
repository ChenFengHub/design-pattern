package com.opensource.event.controller;

import com.alibaba.fastjson.JSONObject;
import com.opensource.event.OrderMessageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-10 22:22:16
 */
@RestController
public class OrderController {

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/sendMsg")
    public String sendMsg() {
        // 1.定义发送的消息
        JSONObject msgJson = new JSONObject();
        msgJson.put("email", "3434434@qq.com");
        msgJson.put("phone", "1231231333");
        msgJson.put("text", "喜提雷克萨斯一辆！");

        OrderMessageEvent orderMessageEvent = new OrderMessageEvent(this, msgJson);
        applicationContext.publishEvent(orderMessageEvent);
        return "success";
    }

}
