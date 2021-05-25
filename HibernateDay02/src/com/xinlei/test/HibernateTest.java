package com.xinlei.test;


import com.xinlei.entity.UserDay02;
import com.xinlei.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

public class HibernateTest {
    @Test
    //根据id查询
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
        //提交事务
        transaction.commit();
        //关闭链接
        session.close();
        sessionFactory.close();
    }

    @Test
    //修改
    public void testUpdate() {
        //创建sessionFactory
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        //获得Session
        Session session = sessionFactory.openSession();
        //开启事务
        Transaction transaction = session.beginTransaction();
        //修改数据 id=2
        //根据id查询
        UserDay02 userDay02 = session.get(UserDay02.class, 3);
        userDay02.setUserName("卖火柴的小女孩");
        session.save(userDay02);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testDelete() {
        //创建sessionFactory
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        //获得Session
        Session session = sessionFactory.openSession();
        //开启事务
        Transaction transaction = session.beginTransaction();
        //修改数据 id=2
        //根据id查询
        //方法一:
        UserDay02 userDay02 = session.get(UserDay02.class, 4);
        session.delete(userDay02);
        //方法二:
        UserDay02 user=new UserDay02();
        user.setId(3);
        session.delete(user);
        //提交事务
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    @Test
    //修改
    public void testSaveOrUpdate() {
        //创建sessionFactory
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        //获得Session
        Session session = sessionFactory.openSession();
        //开启事务
        Transaction transaction = session.beginTransaction();
        //修改数据 id=2
        //根据id查询
        //瞬时态,与id无关 执行的是insert操作
/*        UserDay02 userDay02=new UserDay02();
        userDay02.setUserName("卖火柴的小女孩");
        userDay02.setUserPassword("520");
        userDay02.setGender("女");*/

        //实体类对象状态是托管态,做修改
/*        UserDay02 userDay02=new UserDay02();
        userDay02.setId(5);
        userDay02.setUserName("海绵宝宝");
        userDay02.setUserPassword("520");
        userDay02.setGender("女");*/

        //实体类对象状态是持久态,做修改
        UserDay02 userDay02 = session.get(UserDay02.class, 6);
        userDay02.setAge(14);
        session.saveOrUpdate(userDay02);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
