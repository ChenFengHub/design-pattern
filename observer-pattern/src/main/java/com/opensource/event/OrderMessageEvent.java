package com.opensource.event;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.ApplicationEvent;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-10 22:22:05
 */
public class OrderMessageEvent extends ApplicationEvent {

    /** 群发消息内容 **/
    private JSONObject msgJson;

    /**
     * Create a new ApplicationEvent.
     * @param source the object on which the com.opensource.event initially occurred (never {@code null})
     */
    public OrderMessageEvent(Object source, JSONObject msgJson) {
        super(source);
        this.msgJson = msgJson;
    }

    public JSONObject getMsgJson() {
        return msgJson;
    }

    public void setMsgJson(JSONObject msgJson) {
        this.msgJson = msgJson;
    }
}
