package com.thunisoft.summer.component.about.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 关于DAO层
 * 
 * @author guof
 * 
 */
public class AboutDao extends HibernateDaoSupport {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 查询数据
     * 
     * @param <T>
     * @param sql
     * @param cls
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> find(final String sql, final Class<T> cls) {
        HibernateTemplate ht = this.getHibernateTemplate();
        List<?> list = ht.executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                SQLQuery sq = session.createSQLQuery(sql);
                sq.setResultTransformer(Transformers.aliasToBean(cls));
                return sq.list();
            }
        });
        return (List<T>) list;
    }

    /**
     * 查询数据
     * 
     * @param <T>
     * @param sql
     * @param cls
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Map<?, ?>> find(final String sql) {
        List<?> list = getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                SQLQuery sq = session.createSQLQuery(sql);
                sq.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
                return sq.list();
            }
        });
        return (List<Map<?, ?>>) list;
    }
}
