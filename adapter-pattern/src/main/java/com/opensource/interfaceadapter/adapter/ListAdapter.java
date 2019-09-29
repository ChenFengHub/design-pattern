package com.opensource.interfaceadapter.adapter;

import java.util.HashMap;
import java.util.List;

/**
 * @program: designpattern
 * @description: 这个更像接口适配器
 * @author: Mr.CF
 * @create: 2019-09-11 10:10:01
 */
public class ListAdapter extends HashMap{
    /** 新版本的源对象 **/
    private List list;

    public ListAdapter(List list) {
        this.list = list;
    }

    /** 旧版本中只使用到 size() 和 get() 两个方法，仅实现这两个方法即可 **/
    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Object get(Object key) {
        return list.get(Integer.valueOf(key.toString()).intValue());
    }
}
