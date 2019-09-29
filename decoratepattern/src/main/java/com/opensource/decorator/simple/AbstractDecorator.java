package com.opensource.decorator.simple;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-10 08:08:05
 */
public abstract class AbstractDecorator extends GatewayComponent {
    // 抽象装饰者中如果不添加对具体组件的引用，这个类是可以与 GatewayComponent 合并的。
    // 实际上具体组件和具体装饰者的区别比较小，就是是否含有具体组件的引用
    // 在 Java 的 io 流中对文件的操作，抽象组件类和抽象装饰者类合并，具体组件和具体装饰者类都是实现相同的抽象类，唯一区别就是内部是否掌控被修饰者对象的引用
}
