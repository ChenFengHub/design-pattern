package com.opensource.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-11 14:14:18
 */
@Slf4j
@Service
public class MsgService {
    public void sendMsg() {System.out.println(">>> 第四个模块：调用消息服务平台模块");}
}
