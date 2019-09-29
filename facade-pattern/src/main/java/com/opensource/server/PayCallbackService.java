package com.opensource.server;

import com.opensource.facade.PayFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-11 14:14:25
 */
@Service
public class PayCallbackService {
    @Autowired
    private PayFacade payFacade;

    public void callback() {payFacade.facadecallback();}
}
