package com.thunisoft.summer.component.about.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.thunisoft.summer.component.about.AboutContext;
import com.thunisoft.summer.component.about.IAbout;

/**
 * 关于信息主收集器
 * @author guof
 *
 */
public class MainAbout extends AbstractAbout {

    /**
     * 子收集器列表
     */
    private List<IAbout> about = new ArrayList<IAbout>();

    /**
     * 构造函数
     */
    public MainAbout() {
        this.addHandler(new VersionAbout());
        this.addHandler(new DBAbout());
        this.addHandler(new JVMAbout());
        this.addHandler(new MiddleWareAbout());
        this.addHandler(new NetAbout());

    }

    /**
     * 添加关于信息收集器
     * @param abt 关于信息收集器
     */
    public void addHandler(IAbout abt) {
        this.about.add(abt);
    }
    
    /**
     * 初始化关于信息收集器
     * @param abs 关于信息收集器集合
     */
    public void initHandler(Collection<IAbout> abs){
        if(abs==null){
            return;
        }
        List<IAbout> tmp = new ArrayList<IAbout>();
        tmp.addAll(abs);
        this.about=tmp;
    }

    /**
     * 追加关于信息
     */
    @Override
    protected void append(AboutContext actx) {
        for (IAbout abt : about) {
            abt.handle(actx);
        }

    }

}
