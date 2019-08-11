package com.thunisoft.summer.component.about;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 关于项
 * AboutItem
 * @author guof
 * @version 1.0
 * 
 */
public class AboutItem {

    /**
     * 关于集合映射表
     */
    private Map<String, String> values = new LinkedHashMap<String, String>();

    /**
     * 获取所有关于集合
     * @return 关于集合
     */
    public List<String> getValues() {
        List<String> lst = new ArrayList<String>();
        lst.addAll(this.values.values());
        return lst;
    }

    /**
     * 获取属性值
     * @param key 属性标记
     * @return 属性值
     */
    public String get(String key) {
        return values.get(key);
    }

    /**
     * 添加属性值
     * @param key 标识
     * @param value 属性值
     */
    public void put(String key, String value) {
        values.put(key, value);
    }

}
