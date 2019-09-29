package com.opensource.controller;

import com.opensource.facade.PayFacade;
import com.opensource.server.PayCallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-11 14:14:24
 */
@RestController
public class PayController {

    @Autowired
    private PayCallbackService payCallbackService;

    @RequestMapping("/pay/callback")
    public String callback() {
        payCallbackService.callback();
        return "success";
    }

}
