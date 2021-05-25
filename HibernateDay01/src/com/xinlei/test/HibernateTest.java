package com.xinlei.test;

import com.xinlei.entity.User;
import com.xinlei.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class HibernateTest {
    @Test
    public void testAdd(){
        //第一步 加载hibernate核心配置文件
          //在hibernate里面封装对象
        Configuration cfg = new Configuration();
        cfg.configure();
        //第二步 创建SessionFactory对象
          //读取hibernate核心配置文件内容,创建sessionFactory
          //在过程中,根据映射关系,在配置数据库里面把表创建
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        //第三步 使用SessionFactory创建session的对象
        Session session = sessionFactory.openSession();
        //第四步 开启事务
        Transaction transaction = session.beginTransaction();
        //第五步 写具体逻辑crud操作
        User user = new User();
        user.setUserName("张学友");
        user.setUserPassword("123456");
        user.setAge(23);
        user.setGender("男");
          //调用session的方法实现添加
        session.save(user);
        //第六步 提交事务
        transaction.commit();
        //第七步 关闭资源
        session.close();
        sessionFactory.close();
    }
    @Test
    public void testAdd2(){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        //第三步 使用SessionFactory创建session的对象
        Session session = sessionFactory.openSession();
        //第四步 开启事务
        Transaction transaction = session.beginTransaction();
        //第五步 写具体逻辑crud操作
        User user = new User();
        user.setUserName("刘德华");
        user.setUserPassword("123456");
        user.setAge(24);
        user.setGender("男");
          //调用session的方法实现添加
        session.save(user);
        //第六步 提交事务
        transaction.commit();
        //第七步 关闭资源
        session.close();
        sessionFactory.close();
    }
}
