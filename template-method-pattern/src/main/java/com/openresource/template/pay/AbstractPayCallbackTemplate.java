package com.openresource.template.pay;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-08 19:19:05
 */
@Slf4j
public abstract class AbstractPayCallbackTemplate {

    /**
     * 使用多线程异步写入日志。写入日志并发量高，要求高效率，使用异步方式，多线程写入
     * @param verifySignature
     */
    private void paylog(Map<String, String> verifySignature) {
        // 为了提高写入效率，要使用异步方法（启动类要添加 @Sync 注解）
        // 使用异步方法，防止写入失败，可以先写到 MQ 中，通过 MQ 实现补偿机制，即不断重复入库，直到成功
        log.info(">>>第二步将支付日志写入数据库");
    }

    /**
     * 定义同步行为的骨架
     * @return
     */
    public String asyncCallBack() {
        // 1.验证参数和验证签名  -- 抽象方法
        Map<String, String> verifySignature = verifySignature();
        // 2.日志手机。直接入库。一般日志通过 aop 入库，重要日志，直接入库 -- 具体方法
        paylog(verifySignature);
        // 3.更改数据库状态，同时返回支付结果给对应的支付方式 -- 抽象方法
        return asyncService(verifySignature);
    }

    /**
     * 验证参数和验证签名
     * @return
     */
    protected abstract Map<String,String> verifySignature();

    /**
     * 更改数据库状态，同时返回支付结果给对应的支付方式
     * @param verifySignature
     * @return
     */
    protected abstract String asyncService(Map<String, String> verifySignature);

    /**
     * 返回失败结果
     * @return
     */
    protected abstract String resultFail();

    /**
     * 返回成功结果
     * @return
     */
    protected abstract String resultSuccess();

}
