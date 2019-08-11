package com.thunisoft.summer.component.about;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.thunisoft.summer.component.about.dao.AboutDao;

/**
 * 关于上下文
 * AboutContext
 * @author guof
 * @version 1.0
 *
 */
public class AboutContext {

    /**
     * 关于集合映射表
     */
    private Map<String, AboutSet> aboutSetMap = new LinkedHashMap<String, AboutSet>();

    /**
     * 报告下载的地址
     */
    private String reportUrl;

    /**
     * 报告的模板地址
     */
    private String reportTpl = "report_tpl/about_report_tpl.vm";

    /**
     * 关于dao
     */
    private AboutDao dao;

    /**
     * 获取报告下载的地址
     * @return 报告下载的地址
     */
    public String getReportUrl() {
        return reportUrl;
    }

    /**
     * 设置报告下载的地址
     * @param reportUrl 报告下载的地址
     */
    public void setReportUrl(String reportUrl) {
        this.reportUrl = reportUrl;
    }

    /**
     * 获取报告的模板
     * @return 报告的模板
     */
    public String getReportTpl() {
        return reportTpl;
    }

    /**
     * 设置报告的模板
     * @param reportTpl 设置报告模板
     */
    public void setReportTpl(String reportTpl) {
        this.reportTpl = reportTpl;
    }

    /**
     * 获取关于信息
     * @param type 信息类型 
     * @return 关于信息集合
     */
    public AboutSet get(String type) {
        return this.aboutSetMap.get(type);
    }

    /**
     * 获取关于信息
     * @param type 类型
     * @return 关于信息集合
     */
    public AboutSet get(AboutType type) {
        return this.get(type.toString());
    }

    /**
     * 获取所有关于集合
     * @return 关于集合
     */
    public List<AboutSet> getAboutSets() {
        List<AboutSet> lst = new ArrayList<AboutSet>();
        lst.addAll(this.aboutSetMap.values());
        return lst;
    }

    /**
     * 添加关于集合
     * @param set 关于集合
     */
    public void put(AboutSet set) {
        aboutSetMap.put(set.getType(), set);
    }

    /**
     * 关于信息DAO
     * @return dao
     */
    public AboutDao getDao() {
        return dao;
    }

    /**
     * 设置关于信息DAO
     * @param dao 关于信息DAO
     */
    public void setDao(AboutDao dao) {
        this.dao = dao;
    }

}
