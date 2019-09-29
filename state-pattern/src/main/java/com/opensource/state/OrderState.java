package com.opensource.state;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-11 15:15:32
 */
public interface OrderState {

    /** 状态模式：由于没有共同行为，所以返回值不应该相同，输入值也不应该相同。后续使用泛型进行优化 **/
    Object orderService();

}
