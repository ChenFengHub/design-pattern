package com.opensource.hw_proxy;

import com.opensource.hw_proxy.impl.JavaClassLoader;
import com.opensource.service.OrderService;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-09 14:14:11
 */
public class MyProxy {
    static String rt = "\r\t";

    public static Object newProxyInstance(JavaClassLoader javaClassLoader,
                                          Class<?> classInfo,
                                          MyJdkInvocationHandler h) {
        //1.拼接代理类的源代码
        try {

            // 1.创建代理类java源码文件,写入到硬盘中..
            Method[] methods = classInfo.getMethods();
            String proxyClass = "package com.opensource.hw_proxy.impl;" + rt
                    + "import java.lang.reflect.Method;" + rt
                    + "import com.opensource.hw_proxy.MyJdkInvocationHandler;" + rt
                    + "public class $Proxy0 implements " + classInfo.getName() + "{" + rt
                    + "MyJdkInvocationHandler h;" + rt
                    + "public $Proxy0(MyJdkInvocationHandler h)" + "{" + rt
                    + "this.h= h;" + rt + "}" + rt
                    + getMethodString(methods, classInfo) + rt + "}";
            String filename = "d:/code/$Proxy0.java";
            File f = new File(filename);
            FileWriter fw = new FileWriter(f);
            fw.write(proxyClass);
            fw.flush();
            fw.close();
            // 3. 将源代码编译成class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
            Iterable units = fileMgr.getJavaFileObjects(filename);
            JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
            t.call();
            fileMgr.close();
            // 4.使用classLoader 加载到内存中..
            Class<?> $Proxy0 = javaClassLoader.findClass("$Proxy0");
            // 5.指明初始化有参数构造函数
            Constructor<?> constructor = $Proxy0.getConstructor(MyJdkInvocationHandler.class);
            Object o = constructor.newInstance(h);
            return o;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getMethodString(Method[] methods, Class intf) {
        String proxyMe = "";
        for (Method method : methods) {
            proxyMe += "public void " + method.getName() + "()  {" + rt
                    + "try {" + rt
                    + "Method md= " + intf.getName() + ".class.getMethod(\"" + method.getName()
                    + "\",new Class[]{});" + rt
                    + "this.h.invoke(this,md,null);"
                    + "} catch(Throwable e) {}"
                    + rt + "}" + rt;

        }
        return proxyMe;
    }

    public static void main(String[] args) {
        newProxyInstance(new JavaClassLoader(), OrderService.class, null);
    }
}
