package com.opensource.objectadapter;

import com.opensource.collectlog.LogWriteDbService;
import com.opensource.collectlog.LogWriteFileService;
import com.opensource.collectlog.impl.LogWriteFileServiceImpl;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-11 10:10:56
 */
public class LogWriteDbAdapter implements LogWriteDbService {
    private LogWriteFileService logWriteFileService;

    public LogWriteDbAdapter(LogWriteFileService logWriteFileService) {
        this.logWriteFileService = logWriteFileService;
    }

    public void logWriteDb(String logMsg) {
        // 1.写入到数据库中
        System.out.println(">>> 将数据写入到数据库中。。。" + logMsg);
        // 2.写入到本地文件中
        logWriteFileService.logWriteFile(logMsg);
    }

    public static void main(String[] args) {
        LogWriteDbService logWriteDbService = new LogWriteDbAdapter(new LogWriteFileServiceImpl());
        logWriteDbService.logWriteDb("对象装饰者模式实现日志");
    }
}
