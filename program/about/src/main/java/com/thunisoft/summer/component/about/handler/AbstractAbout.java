package com.thunisoft.summer.component.about.handler;

import com.thunisoft.summer.component.about.AboutContext;
import com.thunisoft.summer.component.about.AboutItem;
import com.thunisoft.summer.component.about.AboutSet;
import com.thunisoft.summer.component.about.IAbout;

/**
 * 构造函数
 * AbstractAbout
 * @author guof
 * @version 1.0
 *
 */
public abstract class AbstractAbout implements IAbout {

    /**
     * 处理
     * @param actx 关于上下文
     */
    public void handle(AboutContext actx) {
        this.append(actx);
    }
    /**
     * 设置状态
     * @param as 状态集合
     * @param name 状态名称
     * @param value 状态值
     */
    protected void setStatus(AboutSet as,String name,Object value){
        AboutItem ai = new AboutItem();
        ai.put(name, name);
        String v="";
        if(value!=null){
            v=value.toString();
        }        
        ai.put(v, v);
        as.addItem(ai);
    }

    /**
     * 添加关于信息
     * @param actx 关于上下文
     */
    protected abstract void append(AboutContext actx);
}
