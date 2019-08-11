package com.thunisoft.summer.component.about;

import java.util.ArrayList;
import java.util.List;

/**
 * 关于集合
 * AboutSet
 * @author guof
 * @version 1.0
 *
 */
public class AboutSet {
    /**
     * 关于集合
     */
    private String type;

    /**
     * 名称
     */
    private String name;

    /**
     * 关于项列表
     */
    private List<AboutItem> items = new ArrayList<AboutItem>();

    /**
     * 结果集头部
     */
    private List<String> head = new ArrayList<String>();

    /**
     * 获取关于集合名称
     * @return 关于集合名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置关于集合名称
     * @param name 关于集合名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取关于集合的类型
     * @return 关于集合的类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置关于集合的类型
     * @param name 关于集合的类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取关于集合的项
     * @return 集合项
     */
    public List<AboutItem> getItems() {
        return items;
    }

    /**
     * 添加集合项
     * @param item 集合项
     */
    public void addItem(AboutItem item) {
        this.items.add(item);
    }

    /**
     * 表头
     * @return
     */
    public List<String> getHead() {
        return head;
    }

    /**
     * 添加列
     * @param cm 列名
     */
    public void add(String cm) {
        head.add(cm);
    }
}
