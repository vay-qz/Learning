package com.thunisoft.summer.component.about.handler;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.thunisoft.summer.component.about.AboutContext;
import com.thunisoft.summer.component.about.AboutSet;
import com.thunisoft.summer.component.about.AboutType;
import com.thunisoft.summer.component.about.AboutUtils;

/**
 * 关于数据库
 * DBAbout
 * @author guof
 * @version 1.0
 *
 */
public class DBAbout extends AbstractAbout {

    /**
     * 反射参数映射表
     */
    private Map<String, String> methodMap = new HashMap<String, String>();

    /**
     * 构造函数
     */
    public DBAbout() {
        this.putMethod("getAcquireIncrement", "获得连接数增长量");
        this.putMethod("getAcquireRetryAttempts", "获得连接数尝试次数");
        this.putMethod("getAcquireRetryDelay", "获得连接数尝试间隔");
        this.putMethod("getCheckoutTimeout", "检查超时时间");
        this.putMethod("getDriverClass", "数据库驱动");
        this.putMethod("getIdleConnectionTestPeriod", "空闲连接测试间隔");
        this.putMethod("getInitialPoolSize", "连接池初始化大小");
        this.putMethod("getLoginTimeout", "登录超时时间");
        this.putMethod("getMaxIdleTime", "连接最大空闲时间");
        this.putMethod("getMaxPoolSize", "连接池最大连接数");
        this.putMethod("getMinPoolSize", "连接池最小连接数");
        this.putMethod("getNumBusyConnections", "当前忙碌的连接数");
        this.putMethod("getNumBusyConnectionsAllUsers", "当前所有用户忙碌的连接数");
        this.putMethod("getNumConnections", "当前所有连接数");
        this.putMethod("getNumConnectionsAllUsers", "当前所有用户的所有连接数");
        this.putMethod("getNumIdleConnections", "当前空闲的连接数");
        this.putMethod("getNumIdleConnectionsAllUsers", "当前所有用户空闲的连接数");
        this.putMethod("isAutoCommitOnClose", "在关闭时是否自动提交");
        this.putMethod("isBreakAfterAcquireFailure", "获取连接失败时是否中断");
        this.putMethod("isForceIgnoreUnresolvedTransactions", "是否强制忽略未解决的事务");
        this.putMethod("isBreakAfterAcquireFailure", "获取连接失败时是否中断");
    }

    /**
     * 添加方法
     * @param name 方法
     * @param describe
     */
    private void putMethod(String name, String describe) {
        this.methodMap.put(name, describe);
    }

    /**
     * 添加关于信息
     * @param actx 关于上下文
     */
    protected void append(AboutContext actx) {
        AboutSet as = new AboutSet();
        as.setName("数据库连接池信息");
        as.setType(AboutType.DB_ABOUT.toString());

        as.add("属性名称");
        as.add("属性值");
        actx.put(as);
        try {
            Object obj = AboutUtils.getBean("dataSource");
            if (obj == null) {
                return;
            }
            Class<?> cls = obj.getClass();
            this.setStatus(as, "连接池类型", cls.getName());
            Method[] ms = cls.getMethods();
            for (Method m : ms) {
                String name = m.getName();
                if (!methodMap.containsKey(name)) {
                    continue;
                }
                if (m.getParameterTypes() != null
                        && m.getParameterTypes().length > 0) {
                    continue;
                }
                try {
                    Object result = m.invoke(obj, new Object[0]);
                    this.setStatus(as, methodMap.get(name), result);
                } catch (Exception e) {
                    this.setStatus(as, methodMap.get(name), e.getMessage());
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        

    }

}
