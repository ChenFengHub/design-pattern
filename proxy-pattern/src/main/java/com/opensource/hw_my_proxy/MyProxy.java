package com.opensource.hw_my_proxy;

import sun.misc.ProxyGenerator;
import sun.reflect.misc.ReflectUtil;

import java.lang.reflect.Modifier;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiFunction;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-10 17:17:34
 */
public class MyProxy {

    private static final class ProxyClassFactory
            implements BiFunction<ClassLoader, Class<?>[], Class<?>> {

        /**
         * prefix for all proxy class names
         **/
        private static final String proxyClassNamePrefix = "$Proxy";

        /**
         * next number to use for generation of unique proxy class names
         **/
        private static final AtomicLong nextUniqueNumber = new AtomicLong();

        /** 获取组装后的字节码 **/
        @Override
        public Class<?> apply(ClassLoader loader, Class<?>[] interfaces) {

            int accessFlags = Modifier.PUBLIC | Modifier.FINAL;
            String proxyPkg = ReflectUtil.PROXY_PACKAGE + ".";

            // 1.生成代理类名。前缀 + 原子类型 nextUniqueNumber 自增前的值，保证多线程下，nextUniqueNumber 不会重复
            long num = nextUniqueNumber.getAndIncrement();
            String proxyName = proxyPkg + proxyClassNamePrefix + num;

            // 2.根据：代理类名+需要实现的接口 组成创建代理类对象
            byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                    proxyName, interfaces, accessFlags);
            try {
                // 3.将创建的代理类编译为字节码
                return defineClass0(loader, proxyName,
                        proxyClassFile, 0, proxyClassFile.length);
            } catch (ClassFormatError e) {
                throw new IllegalArgumentException(e.toString());
            }
        }
    }

    private static native Class<?> defineClass0(ClassLoader loader, String name,
                                                byte[] b, int off, int len);

    public static Object newInstance() {
    }

}
