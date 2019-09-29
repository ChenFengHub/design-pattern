package com.opensource.collectlog.impl;

import com.opensource.collectlog.LogWriteFileService;

import java.util.List;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-11 10:10:45
 */
public class LogWriteFileServiceImpl implements LogWriteFileService {
    public void logWriteFile(String logMsg) {
        System.out.println(">>> 将日志写入本地文件中。。。" + logMsg);
    }
}
