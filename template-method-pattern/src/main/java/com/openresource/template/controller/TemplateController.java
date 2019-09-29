package com.openresource.template.controller;


import com.openresource.template.factory.TemplateFactory;
import com.openresource.template.pay.AbstractPayCallbackTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-08 19:19:39
 */
@RestController
public class TemplateController {

    @RequestMapping("/asyncCallBack")
    public String asyncCallback(String templateId) {
        AbstractPayCallbackTemplate payCallbackTemplate = TemplateFactory.getPayCallbackTemplate(templateId);
        if(payCallbackTemplate == null) {
            return "fail";
        }
        return payCallbackTemplate.asyncCallBack();
    }

}
