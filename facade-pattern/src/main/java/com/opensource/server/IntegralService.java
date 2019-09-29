package com.opensource.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-11 14:14:17
 */
@Service
@Slf4j
public class IntegralService {
    public void addIntegral() {System.out.println(">>> 第三个模块：调用增加积分模块");}
}
