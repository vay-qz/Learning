package com.thunisoft.summer.component.about.report;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import com.thunisoft.summer.component.about.AboutContext;

/**
 * 模板处理器 TemplateHandler
 * 
 * @author guof
 * @version 1.0
 * 
 */
public class TemplateHandler {
    /**
     * 默认模板资源加载类型
     */
    private final static String DEFAULT_LODER_TYPE = "class";

    /**
     * 默认资源加载器类
     */
    private final static String CLS_LODER_CLS = "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader";

    /**
     * 默认模板资源加载类型
     */
    private final static String DEFAULT_CODE = "UTF-8";

    /**
     * 构造函数
     */
    public TemplateHandler() {

    }

    public Properties getClsLoaderProperties() {
        Properties properties = new Properties();
        properties.setProperty("resource.loader", DEFAULT_LODER_TYPE);
        properties.setProperty("class.resource.loader.class", CLS_LODER_CLS);
        properties.setProperty(Velocity.ENCODING_DEFAULT, DEFAULT_CODE);
        properties.setProperty(Velocity.INPUT_ENCODING, DEFAULT_CODE);
        properties.setProperty(Velocity.OUTPUT_ENCODING, DEFAULT_CODE);
        return properties;
    }

    /**
     * 执行模板
     * 
     * @param act
     *            关于上下文
     * @return 模板执行后的数据流
     */
    public InputStream ExecuteTemplate(AboutContext actx) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            OutputStreamWriter sw = new OutputStreamWriter(bos, DEFAULT_CODE);
            Properties properties = this.getClsLoaderProperties();
            VelocityEngine velocityEngine = new VelocityEngine(properties);
            VelocityContext context = new VelocityContext();
            context.put("context", actx);
            String tpl = actx.getReportTpl();
            velocityEngine.mergeTemplate(tpl, DEFAULT_CODE, context, sw);
            sw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ByteArrayInputStream(bos.toByteArray());
    }

}
