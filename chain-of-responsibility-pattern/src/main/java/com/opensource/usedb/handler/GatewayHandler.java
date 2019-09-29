package com.opensource.usedb.handler;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-07 21:21:47
 */
public abstract class GatewayHandler {

    /**
     * 存储下一个处理者
     * proteted 只可被子类继承以及自己使用
     */
    protected GatewayHandler nextGatewayHandler;

    /**
     * 对执行下一个职责对象的方法。只能被本身类及子类使用
     */
    protected void nextService() {
        if(nextGatewayHandler != null) {
            nextGatewayHandler.service();
        }
    }

    /**
     * 抽象类定义共同的行为方法
     */
    public abstract void service();

    /**
     * 子类创建对象，可以通过该方法设置下一个对象
     */
    public void setNextGatewayHandler(GatewayHandler nextGatewayHandler) {
        this.nextGatewayHandler = nextGatewayHandler;
    }

}
