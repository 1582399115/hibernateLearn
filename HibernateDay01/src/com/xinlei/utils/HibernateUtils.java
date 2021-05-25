package com.xinlei.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    //静态代码块实现
    static Configuration cfg = null;
    static SessionFactory sessionFactory = null;

    static {
        //加载核心配置
        cfg = new Configuration();
        cfg.configure();
        sessionFactory = cfg.buildSessionFactory();
    }

    //提供方法返回sessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
