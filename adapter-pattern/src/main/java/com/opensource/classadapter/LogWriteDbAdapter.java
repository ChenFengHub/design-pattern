package com.opensource.classadapter;

import com.opensource.collectlog.LogWriteDbService;
import com.opensource.collectlog.impl.LogWriteFileServiceImpl;

/**
 * @program: designpattern
 * @description: 类适配器模式：通过实现需要适配的类来扩展功能
 * @author: Mr.CF
 * @create: 2019-09-11 10:10:47
 */
public class LogWriteDbAdapter extends LogWriteFileServiceImpl implements LogWriteDbService {

    public void logWriteDb(String logMsg) {
        // 1.将数据写入到数据库。。。。实现了功能的扩展
        System.out.println(">>> 将数据写入数据库中。。。" + logMsg);
        // 2.将数据写入本地（这一步，可实现，可不实现）
        this.logWriteFile(logMsg);
    }

    public static void main(String[] args) {
        LogWriteDbService logWriteDbService = new LogWriteDbAdapter();
        logWriteDbService.logWriteDb("类装饰者模式实现日志");
    }
}
