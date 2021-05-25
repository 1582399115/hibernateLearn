package com.xinlei.utils;

import com.xinlei.entity.UserDay02;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        UserDay02 userDay02=new UserDay02();
        userDay02.setUserName("邓丽君");
        userDay02.setUserPassword("123");
        userDay02.setGender("女");
        userDay02.setAge(22);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(userDay02);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
