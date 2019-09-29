package com.opensource.interfaceadapter;

import com.opensource.interfaceadapter.adapter.ListAdapter;
import com.opensource.interfaceadapter.service.OrderService;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: designpattern
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2019-09-11 10:10:20
 */
public class Test0 {

    public static void main(String[] args) {
        // 1. 定义源数据
        List<String> list = new ArrayList<String>();
        list.add("ccc");
        list.add("cf");
        // 2. 使用适配器，兼容老版本
        ListAdapter listAdapter = new ListAdapter(list);
        // 3. 成功调用旧版本接口
        new OrderService().forMap(listAdapter);
    }

}
