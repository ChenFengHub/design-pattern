package com.opensource.dynamicproxy;

import com.opensource.service.impl.OrderServiceImpl;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-09 12:12:45
 */
public class CglibMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("<<<<<cglib动态代理：日志收集开始...>>>>>>>");
        Object reuslt = proxy.invokeSuper(obj, args);
        System.out.println("<<<<<cglib动态代理：日志收集结束...>>>>>>>");
        return reuslt;
    }

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./");
        CglibMethodInterceptor cglibMethodInterceptor = new CglibMethodInterceptor();
        Enhancer enhancer = new Enhancer();
        // 设置代理类的父类
        enhancer.setSuperclass(OrderServiceImpl.class);
        // 设置回调对象
        enhancer.setCallback(cglibMethodInterceptor);
        // 创建代理对象。目标对象不一定要实现接口，使用 cglib 一般目标对象不需要实现接口
        OrderServiceImpl orderServiceImpl = (OrderServiceImpl) enhancer.create();
        orderServiceImpl.order();
    }
}
