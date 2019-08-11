package com.thunisoft.summer.component.about;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.BeanFactory;

import com.thunisoft.summer.component.about.dao.AboutDao;
import com.thunisoft.summer.component.about.report.TemplateHandler;

/**
 * 关于工具项 AboutUtils
 * 
 * @author guof
 * @version 1.0
 * 
 */
public class AboutUtils {

    /**
     * 关于数据库dao
     */
    public final static String ABOUT_DAO_BEAN = "cmpt.about.dao";

    /**
     * 关于处理bean
     */
    public final static String ABOUT_HANDLER_BEAN = "cmpt.about.handler";

    /**
     * spring bean管理器
     */
    private static BeanFactory beanFactory = null;

    /**
     * 模板处理器
     */
    public static TemplateHandler tplHandler = new TemplateHandler();

    /**
     * 设置spring bean管理器
     * 
     * @param beanFactory
     *            bean管理器
     */
    public static void setBeanFactory(BeanFactory bf) {
        beanFactory = bf;
    }

    /**
     * 从Spring容器中获取bean
     * 
     * @param name
     *            bean的名称
     * @return 对应的bean对象
     */
    public static Object getBean(String name) {
        if (beanFactory == null) {
            return null;
        }
        return beanFactory.getBean(name);
    }

    /**
     * 获取一个关于的上下文
     * 
     * @return 关于的上下文
     */
    public static AboutContext getContext() {
        AboutContext actx = new AboutContext();
        AboutDao dao = (AboutDao) getBean(ABOUT_DAO_BEAN);
        actx.setDao(dao);
        IAbout mainAbout = (IAbout) getBean(ABOUT_HANDLER_BEAN);
        if (mainAbout != null) {
            mainAbout.handle(actx);
        }

        return actx;
    }

    /**
     * 获取报告信息流
     * 
     * @param actx
     *            关于信息上下文
     * @return 报告信息流
     */
    public static InputStream getReportInputStream(AboutContext actx) {
        return tplHandler.ExecuteTemplate(actx);
    }

    private static String VERSION_SQL = null;

    /**
     * 从配置文件中获取版本号的查询SQL
     * 
     * @return
     */
    public static String getVersionQuerySql() {
        if (VERSION_SQL != null) {
//            return VERSION_SQL;
        }
        Properties prop = new Properties();
        try {
            prop.load(AboutUtils.class
                    .getResourceAsStream("/props/config.properties"));
            VERSION_SQL = prop.getProperty("sql.version.query");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (VERSION_SQL == null) {
            VERSION_SQL = "SELECT C_Version, C_ModuleName, D_UpdateDate FROM JCSZ.dbo.T_Version ORDER BY D_UpdateDate DESC";
        }
        return VERSION_SQL;
    }
}
