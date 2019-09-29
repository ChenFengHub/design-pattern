package com.openresource.template.factory;

import com.openresource.template.pay.AbstractPayCallbackTemplate;
import com.openresource.template.utils.SpringUtils;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-08 19:19:41
 */
public class TemplateFactory {

    public static AbstractPayCallbackTemplate getPayCallbackTemplate(String templateId) {
        AbstractPayCallbackTemplate payCallbackTemplate = SpringUtils.getBean(templateId, AbstractPayCallbackTemplate.class);
        return payCallbackTemplate;
    }

}
