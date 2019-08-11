package com.thunisoft.summer.component.about.handler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.CaseInsensitiveMap;

import com.thunisoft.summer.component.about.AboutContext;
import com.thunisoft.summer.component.about.AboutItem;
import com.thunisoft.summer.component.about.AboutSet;
import com.thunisoft.summer.component.about.AboutType;
import com.thunisoft.summer.component.about.AboutUtils;
import com.thunisoft.summer.component.about.dao.AboutDao;

/**
 * 关于版本信息
 * VersionAbout
 * @author guof
 * @version 1.0
 *
 */
public class VersionAbout extends AbstractAbout {
    /**
     * 添加关于信息
     * @param actx 关于上下文
     */
    protected void append(AboutContext actx) {
        AboutSet as = new AboutSet();
        as.setName("版本更新信息");
        as.setType(AboutType.VERSION_ABOUT.toString());

        as.add("版本");
        as.add("更新描述");
        as.add("更新时间");

        AboutDao dao = actx.getDao();
        String sql = AboutUtils.getVersionQuerySql();
        List<Map<?, ?>> list = dao.find(sql);
        for (Map<?, ?> map : list) {
            map = new CaseInsensitiveMap(map);
            AboutItem ai = new AboutItem();
            ai.put("VERSION", this.getString(map,"C_Version"));
            String mn=this.getString(map,"C_ModuleName");
            mn=mn.replace(",", "</br>");
            mn=mn.replace("，", "</br>");
            ai.put("MODULE_NAME", mn);
            ai.put("DATE", this.getString(map,"D_UpdateDate"));
            as.addItem(ai);
        }
        actx.put(as);

    }
    /**
     * 获取字符串类型
     * @param map map
     * @param key 标识
     * @return 对应的值
     */
    protected String getString(Map<?,?> map,String key){
        Object obj=map.get(key);
        if(obj instanceof Date){
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return format.format((Date)obj);            
        }
        if(obj==null){
            return "";
        }else{
            return obj.toString();
        }
    }
}
