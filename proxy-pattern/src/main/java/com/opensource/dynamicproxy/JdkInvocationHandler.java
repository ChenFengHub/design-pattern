package com.opensource.dynamicproxy;

import com.opensource.service.OrderService;
import com.opensource.service.impl.OrderServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-09 11:11:10
 */
public class JdkInvocationHandler implements InvocationHandler {

    /**
     * 目标代理对象
     */
    public Object target;
    public JdkInvocationHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(">>>动态创建代理对象：日志收集开始>>>>");
        // 执行代理对象方法 invoke 中需要知道执行的目标对象 target
        Object reuslt = method.invoke(target, args);
        System.out.println(">>>动态创建代理对象：日志收集结束>>>>");
        return reuslt;
    }

    /**
     * 获取代理对象接口
     * @param <T>
     * @return
     */
    public <T> T getProxy() {
        if(target == null){
            return null;
        } else {
            return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                    target.getClass().getInterfaces(),
                    this);
        }
    }

    public static void main(String[] args) {
        // 在控制层中执行这个无效，需要在这里才能执行生成动态生成类的字节码
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        // 只能使用 接口接收代理对象，而不能使用子类对象。因为代理类实现了接口与继承 Proxy 类，所以不能强转为子类对象
        OrderService orderService = new JdkInvocationHandler(new OrderServiceImpl()).getProxy();
        orderService.order();
    }

}
