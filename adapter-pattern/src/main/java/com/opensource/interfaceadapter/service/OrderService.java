package com.opensource.interfaceadapter.service;

import java.util.Map;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-11 09:09:57
 */
public class OrderService {
    /** V1 旧版本，版本提供接口的参数只能是 Map 类型；
     * 而新版本中，参数有可能是 List 类似，使得新版本能够兼容旧版本，需要对 List 类型 参数进行适配。 **/
    public void forMap(Map map) {
        if(map != null) {
           for(int i = 0; i < map.size(); i++) {
               String value = (String) map.get(i);
               System.out.println("value:" + value);
           }
        }
    }
}
