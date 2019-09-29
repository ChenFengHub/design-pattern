package com.opensource.server;

import org.springframework.stereotype.Service;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-11 14:14:14
 */
@Service
public class LogService {
    public void logService() {
        System.out.println(">>> 第一个模块：日志的收集和打印");
    }
}
