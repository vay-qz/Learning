package com.thunisoft.summer.component.about;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * 关于组件的spring框架服务
 * AboutFrameworkService
 * @author guof
 * @version 1.0
 *
 */
public class AboutFrameworkService implements BeanFactoryAware {

    /**
     * 设置bean工厂
     */
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        AboutUtils.setBeanFactory(beanFactory);

    }

}
