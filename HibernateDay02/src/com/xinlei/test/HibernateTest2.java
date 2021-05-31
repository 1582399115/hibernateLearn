package com.xinlei.test;

import com.xinlei.entity.UserDay02;
import com.xinlei.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


public class HibernateTest2 {
    @Test
    //一级缓存验证  默认开启, 若第二次查询,则在缓存中取数据
    public void testGet() {
        //创建sessionFactory
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        //获得session
        Session session = sessionFactory.openSession();
        //开启事务
        Transaction transaction = session.beginTransaction();
        //根据id 查询
        //调用session里面的get方法
        UserDay02 userDay02 = session.get(UserDay02.class, 1);
        System.out.println(userDay02);

        UserDay02 user = session.get(UserDay02.class, 1);
        System.out.println(user);
        //提交事务
        transaction.commit();
        //关闭链接
        session.close();
        sessionFactory.close();
    }
    @Test
    //一级缓存特性
    public void testDemo(){
        Configuration cfg=new Configuration();
        cfg.configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //1. 根据id查询
        UserDay02 userDay02 = session.get(UserDay02.class, 5);
        //2. 设置返回对象值
        userDay02.setUserName("小肥羊");

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
